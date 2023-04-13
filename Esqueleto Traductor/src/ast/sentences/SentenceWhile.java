/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.sentences;

import java.util.*;
import org.antlr.v4.runtime.*;

import ast.expressions.Expression;
import visitor.*;

//	sentenceWhile:sentence -> condition:expression  sentences:sentence*

public class SentenceWhile extends AbstractSentence {

	public SentenceWhile(Expression condition, List<Sentence> sentences) {
		this.condition = condition;
		this.sentences = sentences;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, sentences);
	}

	public SentenceWhile(Object condition, Object sentences) {
		this.condition = (Expression) getAST(condition);
		this.sentences = this.<Sentence>getAstFromContexts(sentences);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, sentences);
	}

	public Expression getCondition() {
		return condition;
	}
	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}
	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expression condition;
	private List<Sentence> sentences;

	public String toString() {
       return "{condition:" + getCondition() + ", sentences:" + getSentences() + "}";
   }
}
