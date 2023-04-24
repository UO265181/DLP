/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;

import ast.definitions.DefinitionVariable;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorDefineLocalVariable extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "defineLocalVariable";

    public CodeGeneratorDefineLocalVariable(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    // defineLocalVariable[[definitionVariable → name:String type:type ]] =
    // #LOCAL {name} : {type}
    @Override
    public Object visit(DefinitionVariable node, Object param) {
        getCodeWriter().out("#LOCAL " + node.getName() + ":" + node.getType().toStringMAPL());
        return null;
    }

}
