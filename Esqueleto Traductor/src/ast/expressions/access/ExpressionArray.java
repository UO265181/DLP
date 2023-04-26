/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions.access;

import org.antlr.v4.runtime.*;

import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import visitor.*;

//	expressionArray:expression -> array:expression  index:expression

public class ExpressionArray extends AbstractExpression {

	public ExpressionArray(Expression array, Expression index) {
		this.array = array;
		this.index = index;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, index);
	}

	public ExpressionArray(Object array, Object index) {
		this.array = (Expression) getAST(array);
		this.index = (Expression) getAST(index);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, index);
	}

	public Expression getArray() {
		return array;
	}
	public void setArray(Expression array) {
		this.array = array;
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

	private Expression array;
	private Expression index;

	public String toString() {
       return "{array:" + getArray() + ", index:" + getIndex() + "}";
   }

   @Override
   public Integer getDefinitionAdrress() {
		return getArray().getDefinitionAdrress();
   }

}
