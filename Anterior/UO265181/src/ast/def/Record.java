/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.def;

import org.antlr.v4.runtime.*;

import ast.AbstractAST;
import ast.type.Type;
import visitor.*;

//	record -> name:String  type:type

public class Record extends AbstractAST  {

	public Record(String name, Type type) {
		this.name = name;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public Record(Object name, Object type) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, type);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private Type type;
	private int address;

	public String toString() {
       return "{name:" + getName() + ", type:" + getType() + "}";
   }
	
	public String toStringMAPL() {
		return name + ":" + type.toStringMAPL();
	}

	public void setAddress(int address) {
		this.address=address;
	}
	
	public int getAddress() {
		return address;
	}
}
