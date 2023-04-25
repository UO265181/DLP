/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;
import ast.sentences.SentenceAssignment;
import ast.sentences.SentencePrint;
import ast.sentences.SentencePrintln;
import ast.sentences.SentencePrintsp;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorExecute extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "execute";

    private CodeGeneratorValue cgValue;
    private CodeGeneratorAddress cgAddress;

    public CodeGeneratorExecute(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
        this.cgValue = new CodeGeneratorValue(codeWriter, errorManager);
        this.cgAddress = new CodeGeneratorAddress(codeWriter, errorManager);
    }

    //execute[[sentencePrint  →  expression:expression ]] =
 	//      #LINE {end.line}
	//      push{expression.type.suffix} expression.value
	//      out{expression.type.suffix}
    @Override
    public Object visit(SentencePrint node, Object param) {
        getCodeWriter().line(node);

        if(node.getExpression()!=null) { 
            node.getExpression().accept(cgValue, param);
            getCodeWriter().out(node.getExpression().getType());
        }
        
        return null;
    }

    //execute[[sentencePrint  →  expression:expression ]] =
 	//      #LINE {end.line}
	//      push{expression.type.suffix} expression.value
	//      out{expression.type.suffix}
    @Override
    public Object visit(SentencePrintsp node, Object param) {
        getCodeWriter().line(node);

        if(node.getExpression()!=null) { 
            node.getExpression().accept(cgValue, param);
            getCodeWriter().out(node.getExpression().getType());
        }

        getCodeWriter().pushOutSpace();
        
        return null;
    }

    //execute[[sentencePrint  →  expression:expression ]] =
 	//      #LINE {end.line}
	//      push{expression.type.suffix} expression.value
	//      out{expression.type.suffix}
    @Override
    public Object visit(SentencePrintln node, Object param) {
        getCodeWriter().line(node);

        if(node.getExpression()!=null) { 
            node.getExpression().accept(cgValue, param);
            getCodeWriter().out(node.getExpression().getType());
        }

        getCodeWriter().pushOutNewLine();
        
        return null;
    }


    //execute[[sentenceAssignment  →  left:expression  right:expression ]] = 
    //  #LINE {end.line}
    //  address[[left]]
    //  value[[right]]
    //  store{left.type.suffix}

    @Override
    public Object visit(SentenceAssignment node, Object param) {
        getCodeWriter().line(node);

        node.getLeft().accept(cgAddress, param);
        node.getRight().accept(cgValue, param);
        getCodeWriter().store(node.getLeft().getType());
        
        return null;
    }

}
