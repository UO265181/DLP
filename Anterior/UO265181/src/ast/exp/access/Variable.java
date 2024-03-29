/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp.access;

import org.antlr.v4.runtime.*;

import ast.def.VarDef;
import ast.exp.AbstractExp;
import visitor.*;

//	variable:exp -> name:String

public class Variable extends AbstractExp {
	
	private VarDef definition;

	public Variable(String name) {
		this.name = name;
	}

	public Variable(Object name) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name);
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

	private String name;

	public String toString() {
       return "{name:" + getName() + "}";
   }

	public VarDef getDefinition() {
		return definition;
	}

	public void setDefinition(VarDef definition) {
		this.definition = definition;
	}
}
