/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types.primitives;

import ast.types.Type;
import visitor.*;

//	typeChar:type -> 

public class TypeChar extends AbstractTypePrimitive {

	private static TypeChar typeChar;

	private TypeChar() {
	}

	public static TypeChar getInstance() {
		if (typeChar == null) {
			typeChar = new TypeChar();
		}
		return typeChar;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	public String toString() {
		return "{TypeChar}";
	}

	@Override
	public boolean isSameType(Type type) {
		return type == getInstance();
	}

	private static final int DEFAULT_CHAR_SIZE = 1;

	@Override
	public int getMemorySize() {
		return DEFAULT_CHAR_SIZE;
	}

	@Override
	public String toStringMAPL() {
		return "char";
	}

	@Override
	public String getSuffix() {
		return "b";
	}
}
