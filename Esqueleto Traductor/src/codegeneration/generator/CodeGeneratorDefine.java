/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;

import ast.definitions.DefinitionFunction;
import ast.definitions.DefinitionStruct;
import ast.definitions.DefinitionVariable;
import ast.definitions.StructField;
import ast.sentences.Sentence;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorDefine extends DefaultCodeGeneratorVisitor {

	private final static String FUNCTION_NAME = "define";

	public CodeGeneratorDefine(CodeWriter codeWriter, ErrorManager errorManager) {
		super(codeWriter, errorManager, FUNCTION_NAME);
	}

	// define[[definitionVariable → name:String type:type ]] =
	// #GLOBAL {name} : {type}
	//
	// class DefinitionVariable { String name; Type type; }
	@Override
	public Object visit(DefinitionVariable node, Object param) {
		getCodeWriter().write("#GLOBAL " + node.getName() + ":" + node.getType().toStringMAPL() + "\n");

		return null;
	}

	// define[[definitionStruct → name:String structFields:structField* ]] =
	// #TYPE {name} : {
	// define[[structFields]]
	// }
	// class DefinitionStruct { String name; List<StructField> structFields; }
	public Object visit(DefinitionStruct node, Object param) {
		// TODO: mejorar¿
		getCodeWriter().write("#TYPE " + node.getName() + " : {");

		for (StructField field : node.getStructFields()) {
			getCodeWriter().insertTab();
			field.accept(this, param);
			getCodeWriter().insertNewLine();
		}

		getCodeWriter().insert("}");
		getCodeWriter().insertNewLine();
		getCodeWriter().insertNewLine();
		return null;
	}

	// define[[definitionFunction → name:String
	// definitionFunctionParams:definitionVariable*
	// type:type localVariables:definitionVariable* sentences:sentence* ]] =
	// #FUNC {name}
	// defineParam[[definitionFunctionParams]]
	// #RET {type}
	// defineLocalVariable[[localVariables]]
	// {name}:
	// enter {localVariables.size}
	// execute[[sentences]]
	// ret (0, localVariables.size, definitionFunctionParams.size}
	public Object visit(DefinitionFunction node, Object param) {

		getCodeWriter().metaFunc(node.getName());
		for (DefinitionVariable varParam : node.getDefinitionFunctionParams())
			varParam.accept(CodeGeneratorProvider.cgDefineParam, param);
		getCodeWriter().metaRet(node.getType());

		int metaLineForEnter = node.getStart().getLine();

		for (DefinitionVariable localVar : node.getLocalVariables()) {
			localVar.accept(CodeGeneratorProvider.cgDefineLocalVariable, param);
			metaLineForEnter = localVar.getStart().getLine();
		}

		getCodeWriter().metaLine(metaLineForEnter);

		getCodeWriter().label(node.getName());

		getCodeWriter().enter(node.getLocalVariablesTotalSize());

		for (Sentence sentence : node.getSentences())
			sentence.accept(CodeGeneratorProvider.cgExecute, param);
		
		if(!node.hasGoodReturn())
			getCodeWriter().ret(node.getType().getMemorySize(), node.getLocalVariablesTotalSize(), node.getDefinitionFunctionParamsTotalSize());

		return null;
	}

	// define[[structField → name:String type:type ]] =
	// {name} : {type}
	//
	// class StructField { String name; Type type; }
	public Object visit(StructField node, Object param) {
		getCodeWriter().insert(node.getName() + ":" + node.getType().toStringMAPL());

		return null;
	}

	

}
