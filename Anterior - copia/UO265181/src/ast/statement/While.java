/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.statement;

import java.util.*;

import ast.exp.Exp;
import visitor.*;

//	while:statement -> condition:exp  statement:statement*

public class While extends AbstractStatement {

	public While(Exp condition, List<Statement> statement) {
		this.condition = condition;
		this.statement = statement;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(condition, statement);
	}

	public While(Object condition, Object statement) {
		this.condition = (Exp) getAST(condition);
		this.statement = this.<Statement>getAstFromContexts(statement);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(condition, statement);
	}

	public Exp getCondition() {
		return condition;
	}

	public void setCondition(Exp condition) {
		this.condition = condition;
	}

	public List<Statement> getStatement() {
		return statement;
	}

	public void setStatement(List<Statement> statement) {
		this.statement = statement;
	}

	public Return getReturn() {
		if (statement != null) {
			for (Statement st : statement) {
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
	private List<Statement> statement;

	public String toString() {
		return "{condition:" + getCondition() + ", statement:" + getStatement() + "}";
	}
}
