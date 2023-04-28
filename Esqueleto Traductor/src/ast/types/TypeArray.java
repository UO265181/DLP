/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;


import ast.expressions.constant.ExpressionConstantInt;
import visitor.*;

//	typeArray:type -> size:expressionConstantInt  type:type

public class TypeArray extends AbstractType {

	public TypeArray(ExpressionConstantInt size, Type type) {
		this.size = size;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public TypeArray(Object size, Object type) {
		this.size = (ExpressionConstantInt) getAST(size);
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public ExpressionConstantInt getSize() {
		return size;
	}
	public void setSize(ExpressionConstantInt size) {
		this.size = size;
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

	private ExpressionConstantInt size;
	private Type type;

	public String toString() {
       return "{size:" + getSize() + ", type:" + getType() + "}";
   }

	@Override
	public boolean isSameType(Type type) {
		return getType().getTypeOfTheArray()==type;
	}

	@Override
	public int getMemorySize() {
		return getType().getMemorySize()* getSize().getIntValue();
	}

	@Override
	public String toStringMAPL() {
		return size.getValue() + "*" + type.toStringMAPL();
	}

	@Override
	public Type getTypeOfTheArray() {
		return getType().getTypeOfTheArray();
	}



}
