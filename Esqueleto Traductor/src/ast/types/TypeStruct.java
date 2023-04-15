/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;

import org.antlr.v4.runtime.*;

import ast.definitions.DefinitionStruct;
import visitor.*;

//	typeStruct:type -> name:String

public class TypeStruct extends AbstractType {

	public TypeStruct(String name) {
		this.name = name;
	}

	public TypeStruct(Object name) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

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

	private DefinitionStruct definition;

	public DefinitionStruct getDefinition() {
		return definition;
	}

	public void setDefinition(DefinitionStruct definition) {
		this.definition = definition;
	}

	@Override
	public boolean isSameType(Type type) {
		return type.getDefinitionStruct() == null ? false : type.getDefinitionStruct().getName().equals(getName());
	}

	@Override
	public DefinitionStruct getDefinitionStruct() {
		return getDefinition();
	}
}
