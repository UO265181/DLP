/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.sentences;

import java.util.*;

import ast.expressions.Expression;
import visitor.*;

//	sentenceDestructuringAssignment:sentence -> left:expression*  right:expression

public class SentenceDestructuringAssignment extends AbstractSentence {

	public SentenceDestructuringAssignment(List<Expression> left, Expression right) {
		this.left = left;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public SentenceDestructuringAssignment(Object left, Object right) {
		this.left = this.<Expression>getAstFromContexts(left);
		this.right = (Expression) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public List<Expression> getLeft() {
		return left;
	}
	public void setLeft(List<Expression> left) {
		this.left = left;
	}

	public Expression getRight() {
		return right;
	}
	public void setRight(Expression right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Expression> left;
	private Expression right;

	public String toString() {
       return "{left:" + getLeft() + ", right:" + getRight() + "}";
   }
}
