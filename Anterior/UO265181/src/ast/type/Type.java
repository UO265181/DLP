/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.type;

import ast.AST;
import ast.def.StructDef;

public interface Type extends AST {

	Type getArrayType();
	String getStructName();
	StructDef getStructDef();
	
	boolean isSameType(Type type);
	boolean isPrimitive();
	 
	int getSize();
	
	String getSuffix();
	
	String toStringMAPL();

}
