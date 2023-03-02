/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	accessArray:expression -> expression:expression  index:expression

public class AccessArray extends AbstractExpression {

	public AccessArray(Expression expression, Expression index) {
		this.expression = expression;
		this.index = index;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, index);
	}

	public AccessArray(Object expression, Object index) {
		this.expression = (Expression) getAST(expression);
		this.index = (Expression) getAST(index);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression, index);
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public Expression getIndex() {
		return index;
	}
	public void setIndex(Expression index) {
		this.index = index;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression expression;
	private Expression index;

	public String toString() {
       return "{expression:" + getExpression() + ", index:" + getIndex() + "}";
   }
}
