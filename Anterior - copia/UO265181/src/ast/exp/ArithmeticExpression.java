/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp;

import org.antlr.v4.runtime.*;

import visitor.*;

//	arithmeticExpression:exp -> left:exp  operator:String  right:exp

public class ArithmeticExpression extends AbstractExp {

	public ArithmeticExpression(Exp left, String operator, Exp right) {
		this.left = left;
		this.operator = operator;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public ArithmeticExpression(Object left, Object operator, Object right) {
		this.left = (Exp) getAST(left);
		this.operator = (operator instanceof Token) ? ((Token)operator).getText() : (String) operator;
		this.right = (Exp) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, operator, right);
	}

	public Exp getLeft() {
		return left;
	}
	public void setLeft(Exp left) {
		this.left = left;
	}

	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Exp getRight() {
		return right;
	}
	public void setRight(Exp right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Exp left;
	private String operator;
	private Exp right;

	public String toString() {
       return "{left:" + getLeft() + ", operator:" + getOperator() + ", right:" + getRight() + "}";
   }
}
