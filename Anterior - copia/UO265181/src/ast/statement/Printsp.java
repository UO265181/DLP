/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;



import ast.exp.Exp;
import visitor.*;

//	printsp:statement -> exp:exp

public class Printsp extends AbstractStatement {

	public Printsp(Exp exp) {
		this.exp = exp;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(exp);
	}

	public Printsp(Object exp) {
		this.exp = (Exp) getAST(exp);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(exp);
	}

	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Exp exp;

	public String toString() {
       return "{exp:" + getExp() + "}";
   }
}
