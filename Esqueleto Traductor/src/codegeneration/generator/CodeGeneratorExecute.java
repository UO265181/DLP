/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;
import ast.definitions.DefinitionVariable;
import ast.sentences.SentencePrint;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorExecute extends DefaultCodeGeneratorVisitor {

    private final static String FUNCTION_NAME = "execute";

    public CodeGeneratorExecute(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
    }

    //execute[[sentencePrint  →  expression:expression ]] =
 	//      #LINE {end.line}
	//      push{expression.type.suffix} expression.value
	//      out{expression.type.suffix}
    @Override
    public Object visit(SentencePrint node, Object param) {
        getCodeWriter().line(node);
        getCodeWriter().push(node.getExpression().getType());
        
        return null;
    }

}
