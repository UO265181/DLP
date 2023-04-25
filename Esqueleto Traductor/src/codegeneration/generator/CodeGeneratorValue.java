/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;
import ast.expressions.ExpressionVariable;
import ast.expressions.constant.ExpressionConstantChar;
import ast.expressions.constant.ExpressionConstantFloat;
import ast.expressions.constant.ExpressionConstantInt;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorValue extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "value";

    private CodeGeneratorAddress cgAddress;

    public CodeGeneratorValue(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
        this.cgAddress = new CodeGeneratorAddress(codeWriter, errorManager);
    }

    //value[[expressionVariable  →  name:String ]] = 
	//  address[[this]]
	//  load{type.suffix}
    @Override
    public Object visit(ExpressionVariable node, Object param) {
        
        node.accept(cgAddress, param);

        getCodeWriter().load(node.getType());

        return null;
    }

    //value[[expressionConstantInt  →  value:String ]] = 
	//  push{type.suffix} {value}
    @Override
    public Object visit(ExpressionConstantInt node, Object param) {
        
        getCodeWriter().pushi(node.getValue());

        return null;
    }

    //value[[expressionConstantFloat  →  value:String ]] = 
	//  push{type.suffix} {value}
    @Override
    public Object visit(ExpressionConstantFloat node, Object param) {
        
        getCodeWriter().pushf(node.getValue());

        return null;
    }

    //value[[expressionConstantChar  →  value:String ]] = 
	//  push{type.suffix} {value}
    @Override
    public Object visit(ExpressionConstantChar node, Object param) {
        
        getCodeWriter().pushb(node.getASCII());

        return null;
    }



}
