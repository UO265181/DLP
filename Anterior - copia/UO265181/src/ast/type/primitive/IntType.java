/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type.primitive;

import ast.type.AbstractType;
import ast.type.Type;
import visitor.*;

//	intType:type -> 

public class IntType extends AbstractType {
	
	private static IntType intType;
	
	private IntType() {}
	
	public static IntType getInstance() {
		if (intType == null){
			intType = new IntType();
        }
		return intType;
	}

	public boolean isSameType(Type type) {
		return type==getInstance();
	}
	
	public boolean isPrimitive() {
		return true;
	}
	
	public int getSize() {
		return 2;
	}
	
	
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toStringMAPL() {
	       return "int";
	}
	
	public String toString() {
       return "{IntType}";
   }

	@Override
	public String getSuffix() {
		return "i";
	}
}
