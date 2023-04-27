/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types.primitives;

import ast.types.Type;
import visitor.*;

//	typeInt:type -> 

public class TypeInt extends AbstractTypePrimitive {

	private static TypeInt typeInt;
	private static final int DEFAULT_INT_SIZE = 2;

	private TypeInt() {
	}

	public static TypeInt getInstance() {
		if (typeInt == null) {
			typeInt = new TypeInt();
		}
		return typeInt;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{TypeInt}";
	}

	@Override
	public boolean isSameType(Type type) {
		return type == getInstance();
	}

	

	@Override
	public int getMemorySize() {
		return DEFAULT_INT_SIZE;
	}

	@Override
	public String toStringMAPL() {
		return "int";
	}

	@Override
	public String getSuffix() {
		return "";
	}

	@Override
	public String getExplicitSuffix() {
		return "i";
	}
}
