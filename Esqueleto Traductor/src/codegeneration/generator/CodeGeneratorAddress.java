/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;
import ast.expressions.ExpressionVariable;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorAddress extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "address";

    public CodeGeneratorAddress(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    //address[[expressionVariable  →  name:String ]] = 
	//  pusha definition.address
    @Override
    public Object visit(ExpressionVariable node, Object param) {
        
        getCodeWriter().pusha(node.getDefinition().getAddress());
        
        return null;
    }

}
