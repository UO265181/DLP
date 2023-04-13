/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp;

import ast.AST;
import ast.type.Type;

public interface Exp extends AST {
	
	
	Type getType();
	void setType(Type type);
	
	boolean isModificable();
	void setModificable(boolean bool);
}
