/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.sentences;

import org.antlr.v4.runtime.*;

import ast.expressions.Expression;
import visitor.*;

//	sentencePrintln:sentence -> expression:expression

public class SentencePrintln extends AbstractSentence {

	public SentencePrintln(Expression expression) {
		this.expression = expression;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
	}

	public SentencePrintln(Object expression) {
		this.expression = (Expression) getAST(expression);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expression);
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

	private Expression expression;

	public String toString() {
       return "{expression:" + getExpression() + "}";
   }
}
