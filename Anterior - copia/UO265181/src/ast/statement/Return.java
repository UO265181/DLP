/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;



import ast.def.FuncDef;
import ast.exp.Exp;
import visitor.*;

//	return:statement -> exp:exp

public class Return extends AbstractStatement {
	


	public Return(Exp exp) {
		this.exp = exp;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(exp);
	}

	public Return(Object exp) {
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

	public Return getReturn() {
		return this;
	}
	
	private FuncDef funcAm;
	
	
	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Exp exp;

	public String toString() {
       return "{exp:" + getExp() + "}";
   }

	public FuncDef getFuncAm() {
		return funcAm;
	}

	public void setFuncAm(FuncDef funcAm) {
		this.funcAm = funcAm;
	}
}
