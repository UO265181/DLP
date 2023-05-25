/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;

import ast.expressions.Expression;
import ast.expressions.access.ExpressionArray;
import ast.expressions.constant.ExpressionConstantInt;
import ast.sentences.Sentence;
import ast.sentences.SentenceAssignment;
import ast.sentences.SentenceCallFunction;
import ast.sentences.SentenceDestructuringAssignment;
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

        getCodeWriter().metaLine(node.getStart());

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
    // #LINE {start.line}
    // value[[condition]]
    // if (hasElse) {
    // jz {elseLabel}
    // } else {
    // jz {endLabel}
    // }
    // execute[[ifSentences]]
    // if (hasElse) {
    // jmp {endLabel}
    // {elseLabel}:
    // execute[[elseSentences]]
    // }
    // {endLabel}:
    @Override
    public Object visit(SentenceIf node, Object param) {

        String[] labels = getCodeWriter().getIfLabels(); // { "else_" + nIfLabels, "endIf_" + nIfLabels };

        getCodeWriter().metaLine(node.getStart()); // #LINE {start.line}

        node.getCondition().accept(CodeGeneratorProvider.cgValue, param); // value[[condition]]

        if (node.hasElse()) // if (hasElse) {
            getCodeWriter().jz(labels[0]); // jz {elseLabel}
        else // } else {
            getCodeWriter().jz(labels[1]); // jz {endLabel}

        for (Sentence ifSentence : node.getIfSentences())
            ifSentence.accept(CodeGeneratorProvider.cgExecute, param); // execute[[ifSentences]]

        if (node.hasElse()) { // if (hasElse) {
            getCodeWriter().jmp(labels[1]); // jmp {endLabel}
            getCodeWriter().label(labels[0]); // {elseLabel}:
            for (Sentence elseSentence : node.getElseSentences()) // execute[[elseSentences]]
                elseSentence.accept(CodeGeneratorProvider.cgExecute, param);
        }

        getCodeWriter().label(labels[1]); // {endLabel}:
        
        return null;
    }

    // execute[[sentencePrint → expression:expression ]] =
    // #LINE {end.line}
    // if (expression!= Ø) {
    // value[[expression]]
    // out{expression.type.suffix}
    // }
    @Override
    public Object visit(SentencePrint node, Object param) {
        getCodeWriter().metaLine(node);

        if (node.getExpression() != null) {
            node.getExpression().accept(CodeGeneratorProvider.cgValue, param);
            getCodeWriter().out(node.getExpression().getType());
        }

        return null;
    }

    // execute[[sentencePrintsp → expression:expression ]] =
    // #LINE {end.line}
    // if (expression!= Ø) {
    // value[[expression]]
    // out{expression.type.suffix}
    // }
    // pushb 32
    // outb
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

    // execute[[sentencePrintln → expression:expression ]] =
    // #LINE {end.line}
    // if (expression!= Ø) {
    // value[[expression]]
    // out{expression.type.suffix}
    // }
    // pushb 10
    // outb
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


    // execute[[sentenceAssignment → left:expression right:expression ]] =
    // #LINE {end.line}
    // for
    // address[[left]]
    //
    @Override
    public Object visit(SentenceDestructuringAssignment node, Object param) {
        getCodeWriter().metaLine(node);

        int index = 0;

        for(Expression exp : node.getLeft()) {
            exp.accept(CodeGeneratorProvider.cgAddress, param);
            //v[i]
            ExpressionArray expArray = new ExpressionArray(node.getRight(), new ExpressionConstantInt(String.valueOf(index)));
            expArray.setType(node.getRight().getType().getTypeOfTheArray());
            expArray.accept(CodeGeneratorProvider.cgValue, param);
            getCodeWriter().store(exp.getType());

            index++;
        }

        return null;
    }

    // execute[[sentenceRead → expression:expression ]] =
    // #LINE {end.line}
    // address[[expression]]
    // in{expression.type.suffix}
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
    // #LINE {end.line}
    // if (fatherFunction.type== TypeVoid) {
    // ret 0, {fatherFunction.localVariables.size},
    // {fatherFunction.definitionFunctionParams.size}
    // } else {
    // value[[expression]]
    // ret {expression.type.size}, {fatherFunction.localVariables.size},
    // {fatherFunction.definitionFunctionParams.size}
    // }
    public Object visit(SentenceReturn node, Object param) {
        getCodeWriter().metaLine(node);
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
    // #LINE {end.line}
    // value[[callFuntionParams]]
    // call {definition.name}
    // if (definition.type!=TypeVoid) {
    // pop{definition.type.suffix}
    // }
    public Object visit(SentenceCallFunction node, Object param) {
        getCodeWriter().metaLine(node);

        for (Expression parameter : node.getCallFunctionParams())
            parameter.accept(CodeGeneratorProvider.cgValue, param);

        getCodeWriter().call(node.getName());

        if (!node.getDefinition().getType().isSameType(TypeVoid.getInstance()))
            getCodeWriter().pop(node.getDefinition().getType());

        return null;
    }
}
