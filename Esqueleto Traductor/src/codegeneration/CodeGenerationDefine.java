/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.definitions.DefinitionFunction;
import ast.definitions.DefinitionStruct;
import ast.definitions.DefinitionVariable;
import ast.definitions.StructField;
import main.ErrorManager;

public class CodeGenerationDefine extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "define";

    public CodeGenerationDefine(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    //define[[definitionVariable  →  name:String  type:type ]] = 
	//  #GLOBAL {name} : {type}
    //
    // class DefinitionVariable { String name; Type type; }
    @Override
	public Object visit(DefinitionVariable node, Object param) {
		getCodeWriter().out("#global " + node.getName() + ":" + node.getType().toStringMAPL() + "\n");

		return null;
	}

    //define[[definitionStruct  →  name:String  structFields:structField* ]] = 
	//  #TYPE {name} : {
	//  	define[[structFields]]
	//  }
    // class DefinitionStruct { String name; List<StructField> structFields; }
	public Object visit(DefinitionStruct node, Object param) {
		getCodeWriter().out("#type " + node.getName() + " : {");

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
		//throwError(node);
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
