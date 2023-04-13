/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import org.antlr.v4.runtime.*;

import visitor.*;

//	arrayType:type -> size:String  type:type

public class ArrayType extends AbstractType {

	public ArrayType(String size, Type type) {
		this.size = size;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public ArrayType(Object size, Object type) {
		this.size = (size instanceof Token) ? ((Token)size).getText() : (String) size;
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public String getArraySize() {
		return size;
	}
	
	public int getSize() {
		return getType().getSize()*getIntegerSizeOfArray();
	}
	

	
	public void setSize(String size) {
		this.size = size;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getArrayType() {
		return getType();
	}
	
	public boolean isSameType(Type type) {
		return type.getArrayType()==getType();
	}
	
	public boolean isPrimitive() {
		return false;
	}
	

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String size;
	private int integerSizeOfArray;
	private Type type;

	public String toString() {
       return "{size:" + getArraySize() + ", type:" + getType() + "}";
   }
	
	public String toStringMAPL() {
		return size + "*" + type.toStringMAPL();
	}

	public int getIntegerSizeOfArray() {
		return integerSizeOfArray;
	}

	public void setIntegerSizeOfArray(int integerSizeOfArray) {
		this.integerSizeOfArray = integerSizeOfArray;
	}


	

}
