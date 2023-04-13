/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import org.antlr.v4.runtime.*;

import ast.def.Record;
import ast.def.StructDef;
import visitor.*;

//	structType:type -> name:String

public class StructType extends AbstractType {
	
	private StructDef definition;

	public StructType(String name) {
		this.name = name;
	}

	public StructType(Object name) {
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
	
	public boolean isSameType(Type type) {
		return type.getStructName()==getName();
	}
	
	public String getStructName() {
		return getName();
	}
	
	public StructDef getStructDef() {
		return getDefinition();
	}
	
	public boolean isPrimitive() {
		return false;
	}
	
	public int getSize() {

		int size = 0;
		
		for(Record r : getStructDef().getRecord()) {
			size = size + r.getType().getSize();
		}
		
		return size;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;

	public String toString() {
       return "{name:" + getName() + "}";
   }
	
	public String toStringMAPL() {
		return name;
	}
	
	

	public StructDef getDefinition() {
		return definition;
	}

	public void setDefinition(StructDef definition) {
		this.definition = definition;
	}
}
