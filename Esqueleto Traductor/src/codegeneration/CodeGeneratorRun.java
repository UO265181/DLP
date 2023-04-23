/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;
import ast.*;
import ast.definitions.Definition;

public class CodeGeneratorRun extends DefaultCodeGeneratorVisitor {

    

    public CodeGeneratorRun(CodeWriter codeWriter) {
        setCodeWriter(codeWriter);
    }

    // class Program { List<Definition> definitions; }
    @Override
    public Object visit(Program node, Object param) {
        getCodeWriter().source();
        getCodeWriter().callMain();

        for(Definition def : node.getDefinitions())
            def.accept(this, param);

        return null;
    }

}
