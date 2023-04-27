/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;

import javax.swing.text.AbstractDocument.LeafElement;

import ast.expressions.Expression;
import ast.sentences.Sentence;
import ast.sentences.SentenceAssignment;
import ast.sentences.SentenceCallFunction;
import ast.sentences.SentenceIf;
import ast.sentences.SentencePrint;
import ast.sentences.SentencePrintln;
import ast.sentences.SentencePrintsp;
import ast.sentences.SentenceRead;
import ast.sentences.SentenceReturn;
import ast.sentences.SentenceWhile;
import ast.types.TypeVoid;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorExecute extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "execute";

    public CodeGeneratorExecute(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    // execute[[sentenceWhile → condition:expression sentences:sentence* ]] =
    // {initLabel}:
    // value[[condition]]
    // jz {endLabel}
    // execute[[sentences]]
    // jmp {initLabel}
    // {endLabel}
    @Override
    public Object visit(SentenceWhile node, Object param) {

        String[] labels = getCodeWriter().getWhileLabels();

        getCodeWriter().metaLine(node);

        getCodeWriter().label(labels[0]);
        node.getCondition().accept(CodeGeneratorProvider.cgValue, param);
        getCodeWriter().jz(labels[1]);
        for (Sentence sentence : node.getSentences())
            sentence.accept(CodeGeneratorProvider.cgExecute, param);
        getCodeWriter().jmp(labels[0]);
        getCodeWriter().label(labels[1]);

        return null;
    }

    // execute[[sentenceIf → condition:expression ifSentences:sentence*
    // elseSentences:sentence* ]] =
    // value[[condition]]
    // jz {elseLabel}
    // execute[[ifSentences]]
    // jmp {endLabel}
    // {elseLabel}:
    // execute[[elseSentences]]
    // {endLabel}:
    @Override
    public Object visit(SentenceIf node, Object param) {

        String[] labels = getCodeWriter().getIfLabels();

        boolean hasElse = node.getElseSentences() != null;

        getCodeWriter().metaLine(node);

        node.getCondition().accept(CodeGeneratorProvider.cgValue, param);
        if (hasElse)
            getCodeWriter().jz(labels[0]);
        else
            getCodeWriter().jz(labels[1]);
        for (Sentence ifSentence : node.getIfSentences())
            ifSentence.accept(CodeGeneratorProvider.cgExecute, param);
        if (hasElse) {
            getCodeWriter().jmp(labels[1]);
            getCodeWriter().label(labels[0]);
        }
        if (node.getElseSentences() != null)
            for (Sentence elseSentence : node.getElseSentences())
                elseSentence.accept(CodeGeneratorProvider.cgExecute, param);
        getCodeWriter().label(labels[1]);

        return null;
    }

    // execute[[sentencePrint → expression:expression ]] =
    // #LINE {end.line}
    // push{expression.type.suffix} expression.value
    // out{expression.type.suffix}
    @Override
    public Object visit(SentencePrint node, Object param) {
        getCodeWriter().metaLine(node);

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
        getCodeWriter().metaLine(node);

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
        getCodeWriter().metaLine(node);

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
        getCodeWriter().metaLine(node);

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
        getCodeWriter().metaLine(node);

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
        getCodeWriter().metaLine(node);
        // TODO: meter line en el docx
        if (node.getFatherFunction().getType().isSameType(TypeVoid.getInstance())) {
            getCodeWriter().ret(0,
                    node.getFatherFunction().getLocalVariablesTotalSize(),
                    node.getFatherFunction().getDefinitionFunctionParamsTotalSize());
        } else {
            node.getExpression().accept(CodeGeneratorProvider.cgValue, param);
            getCodeWriter().ret(node.getExpression().getType().getMemorySize(),
                    node.getFatherFunction().getLocalVariablesTotalSize(),
                    node.getFatherFunction().getDefinitionFunctionParamsTotalSize());
        }
        return null;
    }

    // execute[[sentenceCallFunction → name:String callFunctionParams:expression* ]]
    // =
    // value[[callFuntionParams]]
    // call {name}
    public Object visit(SentenceCallFunction node, Object param) {
        getCodeWriter().metaLine(node);
        // TODO: meter line en el docx
        for (Expression parameter : node.getCallFunctionParams())
            parameter.accept(CodeGeneratorProvider.cgValue, param);

        getCodeWriter().call(node.getName());

        if(!node.getDefinition().getType().isSameType(TypeVoid.getInstance()))
            getCodeWriter().pop(node.getDefinition().getType());

        return null;
    }
}
