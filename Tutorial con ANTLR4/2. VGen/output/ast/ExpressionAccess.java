/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	expressionAccess:expression -> access:access

public class ExpressionAccess extends AbstractExpression {

	public ExpressionAccess(Access access) {
		this.access = access;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(access);
	}

	public ExpressionAccess(Object access) {
		this.access = (Access) getAST(access);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(access);
	}

	public Access getAccess() {
		return access;
	}
	public void setAccess(Access access) {
		this.access = access;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Access access;

	public String toString() {
       return "{access:" + getAccess() + "}";
   }
}
