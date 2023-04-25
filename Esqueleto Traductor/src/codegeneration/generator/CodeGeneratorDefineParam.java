/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;
import ast.definitions.DefinitionVariable;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorDefineParam extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "defineParam";

    public CodeGeneratorDefineParam(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

   // defineParam[[definitionVariable → name:String type:type ]] =
    // #PARAM {name} : {type}
    @Override
    public Object visit(DefinitionVariable node, Object param) {
        getCodeWriter().write("#PARAM " + node.getName() + ":" + node.getType().toStringMAPL());
        return null;
    }

}
