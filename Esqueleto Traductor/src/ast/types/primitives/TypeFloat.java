/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types.primitives;

import ast.types.Type;
import visitor.*;

//	typeFloat:type -> 

public class TypeFloat extends AbstractTypePrimitive {

	private static TypeFloat typeFloat;

	private static final int DEFAULT_FLOAT_SIZE = 4;

	private TypeFloat() {
	}

	public static TypeFloat getInstance() {
		if (typeFloat == null) {
			typeFloat = new TypeFloat();
		}
		return typeFloat;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{TypeFloat}";
	}

	@Override
	public boolean isSameType(Type type) {
		return type == getInstance();
	}


	@Override
	public int getMemorySize() {
		return DEFAULT_FLOAT_SIZE;
	}

	@Override
	public String toStringMAPL() {
		return "float";
	}

	@Override
	public String getSuffix() {
		return "f";
	}

	@Override
	public String getExplicitSuffix() {
		return "f";
	}
}
