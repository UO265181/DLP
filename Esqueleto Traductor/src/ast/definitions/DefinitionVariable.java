/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.definitions;

import java.util.List;

import org.antlr.v4.runtime.*;

import ast.types.Type;
import visitor.*;

//	definitionVariable:definition -> name:String  type:type

public class DefinitionVariable extends AbstractDefinition {

	public DefinitionVariable(String name, Type type) {
		this.name = name;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type);
	}

	public DefinitionVariable(Object name, Object type) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
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

	public String toString() {
		return "{name:" + getName() + ", type:" + getType() + "}";
	}

	public int getMemorySize() {
		return type.getMemorySize();
	}

	//TODO: mejorar
	private Integer address = null;

	public void setAddress(int address) {
		this.address = address;
	}

	public int getAddress() {
		return address;
	}

}
