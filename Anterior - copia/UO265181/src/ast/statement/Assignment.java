/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;



import ast.exp.Exp;
import visitor.*;

//	assignment:statement -> left:exp  right:exp

public class Assignment extends AbstractStatement {

	public Assignment(Exp left, Exp right) {
		this.left = left;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Assignment(Object left, Object right) {
		this.left = (Exp) getAST(left);
		this.right = (Exp) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Exp getLeft() {
		return left;
	}
	public void setLeft(Exp left) {
		this.left = left;
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
	private Exp right;

	public String toString() {
       return "{left:" + getLeft() + ", right:" + getRight() + "}";
   }
}
