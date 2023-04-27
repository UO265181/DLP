/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;



import ast.expressions.access.ExpressionArray;
import ast.expressions.access.ExpressionStructField;
import ast.expressions.access.ExpressionVariable;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorAddress extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "address";

    public CodeGeneratorAddress(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    // address[[expressionVariable → name:String ]] =
    // pusha definition.address
    //
    //
    // pusha BP
    // push definition.address
    // add
    // TODO: poner los comentarios de esta clase bien
    @Override
    public Object visit(ExpressionVariable node, Object param) {

        if (node.getDefinitionVariable().isLocal()) {
            getCodeWriter().pushaBP();
            getCodeWriter().pushi(node.getDefinitionVariable().getAddress());
            getCodeWriter().add();
        } else {
            getCodeWriter().pusha(node.getDefinitionVariable().getAddress());
        }

        return null;
    }

    // address[[expressionArray → array:expression index:expression ]] =
    // pusha {array.address}
    // value[[index]]
    // push {array.type.typeOfTheArray.size}
    // mul
    // add
    @Override
    public Object visit(ExpressionArray node, Object param) {



        if (node.getDefinitionVariable().isLocal()) {
            getCodeWriter().pushaBP();
            getCodeWriter().pushi(node.getDefinitionVariable().getAddress());
            getCodeWriter().add();
        } else {
            getCodeWriter().pusha(node.getDefinitionVariable().getAddress());
        }

        node.getIndex().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().pushi(node.getArray().getType().getTypeOfTheArray().getMemorySize());
        getCodeWriter().mul();
        getCodeWriter().add();



        return null;
    }

    // address[[expressionStructField → struct:expression name:String ]] =
    // pusha {struct.address}
    // push {struct.getStructFieldRelativeAddress(name)}
    // add
    @Override
    public Object visit(ExpressionStructField node, Object param) {

        

        if (node.getDefinitionVariable().isLocal()) {
            getCodeWriter().pushaBP();
            getCodeWriter().pushi(node.getDefinitionVariable().getAddress());
            getCodeWriter().add();
        } else {
            getCodeWriter().pusha(node.getDefinitionVariable().getAddress());
        }

        getCodeWriter().pushi(node.getStruct().getType().getDefinitionStruct().getField(node.getName()).getAddress());
        getCodeWriter().add();

        return null;
    }
}
