/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions;

import ast.types.Type;
import visitor.*;

//	expressionCast:expression -> newType:type  expression:expression

public class ExpressionCast extends AbstractExpression {

	public ExpressionCast(Type newType, Expression expression) {
		this.newType = newType;
		this.expression = expression;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(newType, expression);
	}

	public ExpressionCast(Object newType, Object expression) {
		this.newType = (Type) getAST(newType);
		this.expression = (Expression) getAST(expression);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(newType, expression);
	}

	public Type getNewType() {
		return newType;
	}
	public void setNewType(Type newType) {
		this.newType = newType;
	}

	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Type newType;
	private Expression expression;

	public String toString() {
       return "{newType:" + getNewType() + ", expression:" + getExpression() + "}";
   }
}
