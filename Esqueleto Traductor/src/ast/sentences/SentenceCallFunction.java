/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.sentences;

import java.util.*;
import org.antlr.v4.runtime.*;

import ast.definitions.DefinitionFunction;
import ast.expressions.Expression;
import visitor.*;

//	sentenceCallFunction:sentence -> name:String  callFunctionParams:expression*

public class SentenceCallFunction extends AbstractSentence {

	public SentenceCallFunction(String name, List<Expression> callFunctionParams) {
		this.name = name;
		this.callFunctionParams = callFunctionParams;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(callFunctionParams);
	}

	public SentenceCallFunction(Object name, Object callFunctionParams) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.callFunctionParams = this.<Expression>getAstFromContexts(callFunctionParams);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, callFunctionParams);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expression> getCallFunctionParams() {
		return callFunctionParams;
	}

	public void setCallFunctionParams(List<Expression> callFunctionParams) {
		this.callFunctionParams = callFunctionParams;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private String name;
	private List<Expression> callFunctionParams;

	public String toString() {
		return "{name:" + getName() + ", callFunctionParams:" + getCallFunctionParams() + "}";
	}

	private DefinitionFunction definition;

	public DefinitionFunction getDefinition() {
		return definition;
	}

	public void setDefinition(DefinitionFunction definition) {
		this.definition = definition;
	}

}
