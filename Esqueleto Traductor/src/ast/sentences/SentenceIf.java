/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.sentences;

import java.util.*;

import ast.expressions.Expression;
import visitor.*;

//	sentenceIf:sentence -> condition:expression  ifSentences:sentence*  elseSentences:sentence*

public class SentenceIf extends AbstractSentence {

	public SentenceIf(Expression condition, List<Sentence> ifSentences, List<Sentence> elseSentences) {
		this.condition = condition;
		this.ifSentences = ifSentences;
		this.elseSentences = elseSentences;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(condition, ifSentences, elseSentences);
		if(elseSentences==null)
			setHasElse(false);
	}

	public SentenceIf(Object condition, Object ifSentences, Object elseSentences) {
		this.condition = (Expression) getAST(condition);
		this.ifSentences = this.<Sentence>getAstFromContexts(ifSentences);
		this.elseSentences = this.<Sentence>getAstFromContexts(elseSentences);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(condition, ifSentences, elseSentences);
		if(elseSentences==null)
			setHasElse(false);
	}

	public Expression getCondition() {
		return condition;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public List<Sentence> getIfSentences() {
		return ifSentences;
	}

	public void setIfSentences(List<Sentence> ifSentences) {
		this.ifSentences = ifSentences;
	}

	public List<Sentence> getElseSentences() {
		return elseSentences;
	}

	public void setElseSentences(List<Sentence> elseSentences) {
		this.elseSentences = elseSentences;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Sentence> ifSentences;
	private List<Sentence> elseSentences;

	public String toString() {
		return "{condition:" + getCondition() + ", ifSentences:" + getIfSentences() + ", elseSentences:"
				+ getElseSentences() + "}";
	}

	private boolean hasElse = true;

	public boolean hasElse() {
		return hasElse;
	}

	public void setHasElse(boolean hasElse) {
		this.hasElse = hasElse;
	}
}
