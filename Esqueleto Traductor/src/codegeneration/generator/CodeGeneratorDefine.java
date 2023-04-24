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

	private CodeGeneratorExecute cgDefineParam;
	private CodeGeneratorDefineLocalVariable cgDefineLocalVariable;
	private CodeGeneratorExecute cgExecute;
	
    public CodeGeneratorDefine(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
        this.cgDefineParam = new CodeGeneratorExecute(codeWriter, errorManager);
        this.cgDefineLocalVariable = new CodeGeneratorDefineLocalVariable(codeWriter, errorManager);
        this.cgExecute = new CodeGeneratorExecute(codeWriter, errorManager);
    }

    //define[[definitionVariable  →  name:String  type:type ]] = 
	//  #GLOBAL {name} : {type}
    //
    // class DefinitionVariable { String name; Type type; }
    @Override
	public Object visit(DefinitionVariable node, Object param) {
		getCodeWriter().out("#GLOBAL " + node.getName() + ":" + node.getType().toStringMAPL() + "\n");

		return null;
	}

    //define[[definitionStruct  →  name:String  structFields:structField* ]] = 
	//  #TYPE {name} : {
	//  	define[[structFields]]
	//  }
    // class DefinitionStruct { String name; List<StructField> structFields; }
	public Object visit(DefinitionStruct node, Object param) {
		getCodeWriter().out("#TYPE " + node.getName() + " : {");

        for(StructField field : node.getStructFields()) {
            getCodeWriter().insertTab();
            field.accept(this, param);
            getCodeWriter().insertNewLine();
        }

        getCodeWriter().insert("}");
        getCodeWriter().insertNewLine();
        getCodeWriter().insertNewLine();
		return null;
	}

	// class DefinitionFunction { String name; List<DefinitionVariable>
	// definitionFunctionParams; Type type; List<DefinitionVariable> localVariables;
	// List<Sentence> sentences; }
	public Object visit(DefinitionFunction node, Object param) {
		
		/*
		getCodeWriter().out("#FUNC "+ node.getName());
		for(DefinitionVariable varParam : node.getDefinitionFunctionParams())
			varParam.accept(cgDefineParam, param);
		getCodeWriter().out("#RET "+ node.getType().toStringMAPL());
		for(DefinitionVariable localVar : node.getLocalVariables())
			localVar.accept(cgDefineLocalVariable, param);

			 */

			 //TODO: temporal
		for(Sentence sentence : node.getSentences())
			sentence.accept(cgExecute, param);
		

		return null;
	}

    //define[[structField  →  name:String  type:type ]] = 
 	//  {name} : {type}
    //
	// class StructField { String name; Type type; }
	public Object visit(StructField node, Object param) {
		getCodeWriter().insert(node.getName() + ":" + node.getType().toStringMAPL());
        
		return null;
	}

}
