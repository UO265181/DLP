/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.definitions;

import java.util.*;
import org.antlr.v4.runtime.*;

import ast.sentences.Sentence;
import ast.types.Type;
import visitor.*;

//	definitionFunction:definition -> name:String  definitionFunctionParams:definitionVariable*  type:type  localVariables:definitionVariable*  sentences:sentence*

public class DefinitionFunction extends AbstractDefinition {

	public DefinitionFunction(String name, List<DefinitionVariable> definitionFunctionParams, Type type,
			List<DefinitionVariable> localVariables, List<Sentence> sentences) {
		this.name = name;
		this.definitionFunctionParams = definitionFunctionParams;
		this.type = type;
		this.localVariables = localVariables;
		this.sentences = sentences;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(definitionFunctionParams, type, localVariables, sentences);
	}

	public DefinitionFunction(Object name, Object definitionFunctionParams, Object type, Object localVariables,
			Object sentences) {
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;
		this.definitionFunctionParams = this.<DefinitionVariable>getAstFromContexts(definitionFunctionParams);
		this.type = (Type) getAST(type);
		this.localVariables = this.<DefinitionVariable>getAstFromContexts(localVariables);
		this.sentences = this.<Sentence>getAstFromContexts(sentences);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, definitionFunctionParams, type, localVariables, sentences);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DefinitionVariable> getDefinitionFunctionParams() {
		return definitionFunctionParams;
	}

	public void setDefinitionFunctionParams(List<DefinitionVariable> definitionFunctionParams) {
		this.definitionFunctionParams = definitionFunctionParams;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<DefinitionVariable> getLocalVariables() {
		return localVariables;
	}

	public void setLocalVariables(List<DefinitionVariable> localVariables) {
		this.localVariables = localVariables;
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

	private String name;
	private List<DefinitionVariable> definitionFunctionParams;
	private Type type;
	private List<DefinitionVariable> localVariables;
	private List<Sentence> sentences;

	public String toString() {
		return "{name:" + getName() + ", definitionFunctionParams:" + getDefinitionFunctionParams() + ", type:"
				+ getType() + ", localVariables:" + getLocalVariables() + ", sentences:" + getSentences() + "}";
	}

	public void calculateAdresses() {

		int realtiveAddress = 4; // BP+4

		for (int i = getDefinitionFunctionParams().size() - 1; i >= 0; i--) {
			getDefinitionFunctionParams().get(i).setAddress(realtiveAddress);
			realtiveAddress += getDefinitionFunctionParams().get(i).getMemorySize();
		}

		realtiveAddress = 0; // BP-0

		for (DefinitionVariable localVariable : getLocalVariables()) {
			realtiveAddress -= localVariable.getMemorySize();
			localVariable.setAddress(realtiveAddress);
		}

	}
}
