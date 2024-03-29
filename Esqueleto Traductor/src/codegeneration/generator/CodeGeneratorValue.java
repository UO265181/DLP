/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;

import ast.expressions.Expression;
import ast.expressions.ExpressionArithmetic;
import ast.expressions.ExpressionCallFunction;
import ast.expressions.ExpressionCast;
import ast.expressions.ExpressionLogical;
import ast.expressions.ExpressionRelational;
import ast.expressions.ExpressionUnary;
import ast.expressions.access.ExpressionArray;
import ast.expressions.access.ExpressionStructField;
import ast.expressions.access.ExpressionVariable;
import ast.expressions.constant.ExpressionConstantChar;
import ast.expressions.constant.ExpressionConstantFloat;
import ast.expressions.constant.ExpressionConstantInt;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorValue extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "value";

    public CodeGeneratorValue(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    // value[[expressionVariable → name:String ]] =
    // address[[this]]
    // load{type.suffix}
    @Override
    public Object visit(ExpressionVariable node, Object param) {

        node.accept(CodeGeneratorProvider.cgAddress, param);

        getCodeWriter().load(node.getType());

        return null;
    }

    // value[[expressionConstantInt → value:String ]] =
    // push{type.suffix} {value}
    @Override
    public Object visit(ExpressionConstantInt node, Object param) {

        getCodeWriter().pushi(node.getValue());

        return null;
    }

    // value[[expressionConstantFloat → value:String ]] =
    // push{type.suffix} {value}
    @Override
    public Object visit(ExpressionConstantFloat node, Object param) {

        getCodeWriter().pushf(node.getValue());

        return null;
    }

    // value[[expressionConstantChar → value:String ]] =
    // push{type.suffix} {value}
    @Override
    public Object visit(ExpressionConstantChar node, Object param) {

        getCodeWriter().pushb(node.getIntValue());

        return null;
    }

    // value[[expressionArray → array:expression index:expression ]] =
    // address[[this]]
    // load{type.suffix}
    @Override
    public Object visit(ExpressionArray node, Object param) {

        node.accept(CodeGeneratorProvider.cgAddress, param);
        getCodeWriter().load(node.getType());

        return null;
    }

    // value[[expressionStructField → struct:expression name:String ]] =
    // address[[this]]
    // load{type.suffix}
    @Override
    public Object visit(ExpressionStructField node, Object param) {

        node.accept(CodeGeneratorProvider.cgAddress, param);
        getCodeWriter().load(node.getType());

        return null;
    }

    // value[[expressionCast → newType:type expression:expression ]] =
    // value[[expression]]
    // {getCast(expression.type.suffix,newType.suffix)}
    @Override
    public Object visit(ExpressionCast node, Object param) {

        node.getExpression().accept(CodeGeneratorProvider.cgValue, param);

        getCodeWriter().cast(node.getExpression().getType(), node.getNewType());

        return null;
    }

    // value[[expressionArithmetic → left:expression operator:String
    // right:expression ]] =
    // value[[left]]
    // value[[right]]
    // {getOperation(operator, left.type.suffix)}
    @Override
    public Object visit(ExpressionArithmetic node, Object param) {

        node.getLeft().accept(CodeGeneratorProvider.cgValue, param);
        node.getRight().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().operation(node.getOperator(), node.getLeft().getType());

        return null;
    }

    // value[[expressionRelational → left:expression operator:String
    // right:expression ]] =
    // value[[left]]
    // value[[right]]
    // {getOperation(operator, left.type.suffix)}
    @Override
    public Object visit(ExpressionRelational node, Object param) {

        node.getLeft().accept(CodeGeneratorProvider.cgValue, param);
        node.getRight().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().operation(node.getOperator(), node.getLeft().getType());

        return null;
    }

    // value[[expressionLogical → left:expression operator:String
    // right:expression ]] =
    // value[[left]]
    // value[[right]]
    // {getOperation(operator, left.type.suffix)}
    @Override
    public Object visit(ExpressionLogical node, Object param) {

        node.getLeft().accept(CodeGeneratorProvider.cgValue, param);
        node.getRight().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().operation(node.getOperator(), node.getLeft().getType());

        return null;
    }

    // value[[expressionUnary → operator:String expression:expression ]] =
    // value[[expression]]
    // {getOperation(operator, type.suffix)}
    @Override
    public Object visit(ExpressionUnary node, Object param) {

        node.getExpression().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().operation(node.getOperator(), node.getType());

        return null;
    }

    // value[[expressionCallFunction → name:String callFunctionParams:expression* ]]
    // =
    // #LINE {start.line}
    // value[[callFunctionParams]]
    // call {name}
    public Object visit(ExpressionCallFunction node, Object param) {
        getCodeWriter().metaLine(node);

        for (Expression parameter : node.getCallFunctionParams())
            parameter.accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().call(node.getName());

        return null;
    }

}
