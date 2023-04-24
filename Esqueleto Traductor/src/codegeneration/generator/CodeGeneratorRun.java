/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration.generator;
import ast.*;
import ast.definitions.Definition;
import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorRun extends DefaultCodeGeneratorVisitor {

    private CodeGeneratorDefine cgDefine;

    private final static String FUNCTION_NAME = "run";

    public CodeGeneratorRun(CodeWriter codeWriter, ErrorManager errorManager) {
        super(codeWriter, errorManager, FUNCTION_NAME);
        this.cgDefine = new CodeGeneratorDefine(codeWriter, errorManager);
    }

    /*
     * run[[program  →  definitions:definition* ]] = 
	 *      #SOURCE {file}
	 *      define[[definitions]]
     *      HALT
     */
    // class Program { List<Definition> definitions; }
    @Override
    public Object visit(Program node, Object param) {
        getCodeWriter().metaSource();
        //getCodeWriter().callMain();

        for(Definition def : node.getDefinitions())
            def.accept(cgDefine, param);

        getCodeWriter().halt();

        return null;
    }

}
