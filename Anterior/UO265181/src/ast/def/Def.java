/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.def;

import ast.AST;

public interface Def extends AST {
	
	int getSize();
	void setAddress(int address);
	
	String toStringMAPL();

}
