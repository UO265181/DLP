/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions;

import ast.AbstractAST;
import ast.types.Type;

public abstract class AbstractExpression extends AbstractAST implements Expression {


    private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
