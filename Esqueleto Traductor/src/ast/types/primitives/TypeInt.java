/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types.primitives;


import visitor.*;

//	typeInt:type -> 

public class TypeInt extends AbstractTypePrimitive {

	private static TypeInt typeInt;
	
	private TypeInt() {}
	
	public static TypeInt getInstance() {
		if (typeInt == null){
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
}
