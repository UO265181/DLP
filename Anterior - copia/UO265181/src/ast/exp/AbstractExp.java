/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp;

import ast.AbstractAST;
import ast.type.Type;

public abstract class AbstractExp extends AbstractAST implements Exp {

	
	private Type type;
	private boolean modificable;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isModificable() {
		return modificable;
	}

	public void setModificable(boolean modificable) {
		this.modificable = modificable;
	}
}
