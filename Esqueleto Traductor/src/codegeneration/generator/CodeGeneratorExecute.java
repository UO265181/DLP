/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;

import ast.sentences.SentenceAssignment;
import ast.sentences.SentencePrint;
import ast.sentences.SentencePrintln;
import ast.sentences.SentencePrintsp;
import ast.sentences.SentenceRead;
import ast.sentences.SentenceReturn;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorExecute extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "execute";

    public CodeGeneratorExecute(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    // execute[[sentencePrint → expression:expression ]] =
    // #LINE {end.line}
    // push{expression.type.suffix} expression.value
    // out{expression.type.suffix}
    @Override
    public Object visit(SentencePrint node, Object param) {
        getCodeWriter().line(node);

        if (node.getExpression() != null) {
            node.getExpression().accept(CodeGeneratorProvider.cgValue, param);
            getCodeWriter().out(node.getExpression().getType());
        }

        return null;
    }

    // execute[[sentencePrint → expression:expression ]] =
    // #LINE {end.line}
    // push{expression.type.suffix} expression.value
    // out{expression.type.suffix}
    @Override
    public Object visit(SentencePrintsp node, Object param) {
        getCodeWriter().line(node);

        if (node.getExpression() != null) {
            node.getExpression().accept(CodeGeneratorProvider.cgValue, param);
            getCodeWriter().out(node.getExpression().getType());
        }

        getCodeWriter().pushOutSpace();

        return null;
    }

    // execute[[sentencePrint → expression:expression ]] =
    // #LINE {end.line}
    // push{expression.type.suffix} expression.value
    // out{expression.type.suffix}
    @Override
    public Object visit(SentencePrintln node, Object param) {
        getCodeWriter().line(node);

        if (node.getExpression() != null) {
            node.getExpression().accept(CodeGeneratorProvider.cgValue, param);
            getCodeWriter().out(node.getExpression().getType());
        }

        getCodeWriter().pushOutNewLine();

        return null;
    }

    // execute[[sentenceAssignment → left:expression right:expression ]] =
    // #LINE {end.line}
    // address[[left]]
    // value[[right]]
    // store{left.type.suffix}
    @Override
    public Object visit(SentenceAssignment node, Object param) {
        getCodeWriter().line(node);

        node.getLeft().accept(CodeGeneratorProvider.cgAddress, param);
        node.getRight().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().store(node.getLeft().getType());

        return null;
    }

    // execute[[sentenceRead → expression:expression ]] =
    // address[[expression]]
    // in
    // store{expression.type.suffix}
    @Override
    public Object visit(SentenceRead node, Object param) {
        getCodeWriter().line(node);

        node.getExpression().accept(CodeGeneratorProvider.cgAddress, param);
        getCodeWriter().in(node.getExpression().getType());
        getCodeWriter().store(node.getExpression().getType());

        return null;
    }

    // execute[[sentenceReturn → expression:expression ]] =
    // value[[expression]]
    // ret {expression.type.size}, {fatherFunction.localVariables.size},
    // {fatherFunction.definitionFunctionParams.size}
    public Object visit(SentenceReturn node, Object param) {
        getCodeWriter().line(node);
        // TODO: meter line en el docx
        node.getExpression().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().ret(node.getExpression().getType().getMemorySize(),
                node.getFatherFunction().getLocalVariablesTotalSize(),
                node.getFatherFunction().getDefinitionFunctionParamsTotalSize());

        return null;
    }
}
