/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;

import visitor.*;

//	typeVoid:type -> 

public class TypeVoid extends AbstractType {


	private static TypeVoid typeVoid;
	
	private TypeVoid() {}
	
	public static TypeVoid getInstance() {
		if (typeVoid == null){
			typeVoid = new TypeVoid();
        }
		return typeVoid;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{TypeVoid}";
   }
}