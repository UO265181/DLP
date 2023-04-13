/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types.primitives;


import visitor.*;

//	typeChar:type -> 

public class TypeChar extends AbstractTypePrimitive {

	private static TypeChar typeChar;
	
	private TypeChar() {}
	
	public static TypeChar getInstance() {
		if (typeChar == null){
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
}
