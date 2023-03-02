/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	definitionFunction:definition -> name:String  definitionFunctionParams:definitionFunctionParam*  type:type  localVariables:localVariable*  sentences:sentence*

public class DefinitionFunction extends AbstractDefinition {

	public DefinitionFunction(String name, List<DefinitionFunctionParam> definitionFunctionParams, Type type, List<LocalVariable> localVariables, List<Sentence> sentences) {
		this.name = name;
		this.definitionFunctionParams = definitionFunctionParams;
		this.type = type;
		this.localVariables = localVariables;
		this.sentences = sentences;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definitionFunctionParams, type, localVariables, sentences);
	}

	public DefinitionFunction(Object name, Object definitionFunctionParams, Object type, Object localVariables, Object sentences) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.definitionFunctionParams = this.<DefinitionFunctionParam>getAstFromContexts(definitionFunctionParams);
		this.type = (Type) getAST(type);
		this.localVariables = this.<LocalVariable>getAstFromContexts(localVariables);
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

	public List<DefinitionFunctionParam> getDefinitionFunctionParams() {
		return definitionFunctionParams;
	}
	public void setDefinitionFunctionParams(List<DefinitionFunctionParam> definitionFunctionParams) {
		this.definitionFunctionParams = definitionFunctionParams;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public List<LocalVariable> getLocalVariables() {
		return localVariables;
	}
	public void setLocalVariables(List<LocalVariable> localVariables) {
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
	private List<DefinitionFunctionParam> definitionFunctionParams;
	private Type type;
	private List<LocalVariable> localVariables;
	private List<Sentence> sentences;

	public String toString() {
       return "{name:" + getName() + ", definitionFunctionParams:" + getDefinitionFunctionParams() + ", type:" + getType() + ", localVariables:" + getLocalVariables() + ", sentences:" + getSentences() + "}";
   }
}
