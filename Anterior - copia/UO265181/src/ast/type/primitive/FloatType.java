/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type.primitive;

import ast.type.AbstractType;
import ast.type.Type;
import visitor.*;

//	floatType:type -> 

public class FloatType extends AbstractType {

	
	private static FloatType floatType;
	
	private FloatType() {}
	
	public static FloatType getInstance() {
		if (floatType == null){
			floatType = new FloatType();
        }
		return floatType;
	}
	
	public boolean isSameType(Type type) {
		return type==getInstance();
	}
	
	public boolean isPrimitive() {
		return true;
	}
	

	public int getSize() {
		return 4;
	}
	
	
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{FloatType}";
   }
	
	public String toStringMAPL() {
		return "real";
	}
	
	@Override
	public String getSuffix() {
		return "f";
	}
}
