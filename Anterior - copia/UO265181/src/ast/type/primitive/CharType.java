/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type.primitive;

import ast.type.AbstractType;
import ast.type.Type;
import visitor.*;

//	charType:type -> 

public class CharType extends AbstractType {

	private static CharType charType;
	
	private CharType() {}
	
	public static CharType getInstance() {
		if (charType == null){
			charType = new CharType();
        }
		return charType;
	}
	
	public boolean isSameType(Type type) {
		return type==getInstance();
	}
	
	public boolean isPrimitive() {
		return true;
	}
	
	public int getSize() {
		return 1;
	}
	
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{CharType}";
   }
	
	public String toStringMAPL() {
		return "byte";
	}
	
	@Override
	public String getSuffix() {
		return "b";
	}
}
