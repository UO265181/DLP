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
	@Override
	public Object visit(DefinitionVariable node, Object param) {
		getCodeWriter().metaGlobal(node.getName(), node.getType());
		getCodeWriter().insertNewLine();

		return null;
	}

	// define[[definitionStruct → name:String structFields:structField* ]] =
	// #TYPE {name} : {
	// define[[structFields]]
	// }
	public Object visit(DefinitionStruct node, Object param) {
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

	//#FUNC {name}
	//defineParam[[definitionFunctionParams]]
	//#RET {type}
	//defineLocalVariable[[localVariables]]
	//{name}:
	//enter {localVariables.size}
	//execute[[sentences]]
	//if (!definitionFunction.hasGoodReturn) {
	//ret (0, localVariables.size, definitionFunctionParams.size}
	//}
	public Object visit(DefinitionFunction node, Object param) {

		getCodeWriter().metaFunc(node.getName()); // #FUNC {name}

		for (DefinitionVariable varParam : node.getDefinitionFunctionParams())
			varParam.accept(CodeGeneratorProvider.cgDefineParam, param); // defineParam[[definitionFunctionParams]]

		getCodeWriter().metaRet(node.getType()); // #RET {type}

		int metaLineForEnter = node.getStart().getLine();

		for (DefinitionVariable localVar : node.getLocalVariables()) {
			localVar.accept(CodeGeneratorProvider.cgDefineLocalVariable, param); // defineLocalVariable[[localVariables]]
			metaLineForEnter = localVar.getStart().getLine();
		}

		getCodeWriter().metaLine(metaLineForEnter);

		getCodeWriter().label(node.getName()); // {name}:

		getCodeWriter().enter(node.getLocalVariablesTotalSize()); // enter {localVariables.size}

		for (Sentence sentence : node.getSentences())
			sentence.accept(CodeGeneratorProvider.cgExecute, param); // execute[[sentences]]

		if (!node.hasGoodReturn())
			getCodeWriter().ret(node.getType().getMemorySize(), node.getLocalVariablesTotalSize(),
					node.getDefinitionFunctionParamsTotalSize()); // ret (0, localVariables.size,
																	// definitionFunctionParams.size}

		return null;
	}

	// define[[structField → name:String type:type ]] =
	// {name} : {type}
	public Object visit(StructField node, Object param) {
		getCodeWriter().insert(node.getName() + ":" + node.getType().toStringMAPL());

		return null;
	}

}
