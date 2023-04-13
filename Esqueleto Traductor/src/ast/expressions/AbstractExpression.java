/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions;

import ast.AbstractAST;
import ast.types.Type;

public abstract class AbstractExpression extends AbstractAST implements Expression {


    private Type type;
	private boolean modifiable;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isModifiable() {
		return modifiable;
	}

	public void setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
	}

}
