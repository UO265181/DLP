/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions;

import ast.AST;
import ast.types.Type;

public interface Expression extends AST {

    Type getType();
	void setType(Type type);
	
	boolean isModifiable();
	void setModifiable(boolean modifiable);

}
