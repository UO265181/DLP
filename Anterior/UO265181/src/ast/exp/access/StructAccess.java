/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp.access;

import org.antlr.v4.runtime.*;

import ast.exp.AbstractExp;
import ast.exp.Exp;
import visitor.*;

//	structAccess:exp -> struct:exp  name:String

public class StructAccess extends AbstractExp {

	public StructAccess(Exp struct, String name) {
		this.struct = struct;
		this.name = name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct);
	}

	public StructAccess(Object struct, Object name) {
		this.struct = (Exp) getAST(struct);
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct, name);
	}

	public Exp getStruct() {
		return struct;
	}
	public void setStruct(Exp struct) {
		this.struct = struct;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Exp struct;
	private String name;

	public String toString() {
       return "{struct:" + getStruct() + ", name:" + getName() + "}";
   }
}
