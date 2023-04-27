/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.definitions;

import java.util.*;
import org.antlr.v4.runtime.*;

import ast.types.Type;
import ast.types.TypeError;
import visitor.*;

//	definitionStruct:definition -> name:String  structFields:structField*

public class DefinitionStruct extends AbstractDefinition {

	public DefinitionStruct(String name, List<StructField> structFields) {
		this.name = name;
		this.structFields = structFields;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(structFields);
	}

	public DefinitionStruct(Object name, Object structFields) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.structFields = this.<StructField>getAstFromContexts(structFields);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, structFields);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StructField> getStructFields() {
		return structFields;
	}

	public void setStructFields(List<StructField> structFields) {
		this.structFields = structFields;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private String name;
	private List<StructField> structFields;

	public String toString() {
		return "{name:" + getName() + ", structFields:" + getStructFields() + "}";
	}

	// TODO: añadir a la GA
	public StructField getField(String fieldName) {
		for (StructField field : getStructFields()) {
			if (field.getName().equals(fieldName))
				return field;
		}
		return null;
	}

	public int getMemorySize() {
		return getStructFields().stream().mapToInt(field -> field.getMemorySize()).sum();
	}

}
