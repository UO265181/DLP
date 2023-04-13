/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import java.util.*;

import ast.exp.Exp;
import visitor.*;

//	if:statement -> condition:exp  ifst:statement*  elsest:statement*

public class If extends AbstractStatement {

	public If(Exp condition, List<Statement> ifst, List<Statement> elsest) {
		this.condition = condition;
		this.ifst = ifst;
		this.elsest = elsest;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(condition, ifst, elsest);
	}

	public If(Object condition, Object ifst, Object elsest) {
		this.condition = (Exp) getAST(condition);
		this.ifst = this.<Statement>getAstFromContexts(ifst);
		this.elsest = this.<Statement>getAstFromContexts(elsest);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(condition, ifst, elsest);
	}

	public Exp getCondition() {
		return condition;
	}

	public void setCondition(Exp condition) {
		this.condition = condition;
	}

	public List<Statement> getIfst() {
		return ifst;
	}

	public void setIfst(List<Statement> ifst) {
		this.ifst = ifst;
	}

	public List<Statement> getElsest() {
		return elsest;
	}

	public void setElsest(List<Statement> elsest) {
		this.elsest = elsest;
	}

	public Return getReturn() {
		if (ifst != null) {
			for (Statement st : ifst) {
				if (st.getReturn() != null)
					return st.getReturn();
			}
		}
		if (elsest != null) {
			for (Statement st : elsest) {
				if (st.getReturn() != null)
					return st.getReturn();
			}
		}

		return null;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private Exp condition;
	private List<Statement> ifst;
	private List<Statement> elsest;

	public String toString() {
		return "{condition:" + getCondition() + ", ifst:" + getIfst() + ", elsest:" + getElsest() + "}";
	}
}
