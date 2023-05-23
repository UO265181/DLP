/**
 * @generated VGen (for ANTLR) 1.7.2
 */

 package ast.sentences;
import ast.expressions.Expression;
import ast.expressions.access.Access;
import visitor.*;
 
 //	sentenceAssignment:sentence -> left:access  right:expression
 
 public class SentenceAssignment extends AbstractSentence {
 
	 public SentenceAssignment(Access left, Expression right) {
		 this.left = left;
		 this.right = right;
 
		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(left, right);
	 }
 
	 public SentenceAssignment(Object left, Object right) {
		 this.left = (Access) getAST(left);
		 this.right = (Expression) getAST(right);
 
		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(left, right);
	 }
 
	 public Access getLeft() {
		 return left;
	 }
	 public void setLeft(Access left) {
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
 
	 private Access left;
	 private Expression right;
 
	 public String toString() {
		return "{left:" + getLeft() + ", right:" + getRight() + "}";
	}
 }
 