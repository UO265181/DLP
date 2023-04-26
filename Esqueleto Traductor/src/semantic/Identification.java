/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.*;
import ast.definitions.DefinitionFunction;
import ast.definitions.DefinitionStruct;
import ast.definitions.DefinitionVariable;
import ast.definitions.StructField;
import ast.expressions.ExpressionCallFunction;
import ast.expressions.access.ExpressionVariable;
import ast.sentences.SentenceCallFunction;
import ast.types.TypeStruct;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // class SentenceCallFunction { String name; List<Expression>
    // callFunctionParams; }
    public Object visit(SentenceCallFunction node, Object param) {        
        super.visit(node, param);

        DefinitionFunction function = functions.get(node.getName());
        predicado(function != null, "Procedimiento no definida: " + node.getName(), node);
        node.setDefinition(function); // Enlazar referencia con definición

        return null;
    }

    // class ExpressionCallFunction { String name; List<Expression>
    // callFunctionParams; }
    public Object visit(ExpressionCallFunction node, Object param) {
        super.visit(node, param);

        DefinitionFunction function = functions.get(node.getName());
        predicado(function != null, "Función no definida: " + node.getName(), node);
        node.setDefinition(function); // Enlazar referencia con definición

        return null;
    }

    // # --------------------------------------------------------

    // class DefinitionStruct { String name; List<DefinitionVariable> structFields;
    // }
    public Object visit(DefinitionStruct node, Object param) {
    	super.visit(node, param);

        DefinitionStruct struct = structs.get(node.getName());
        predicado(struct == null, "Estructura ya definida: " + node.getName(), node);
        structs.put(node.getName(), node);

        structFields.clear();

        return null;
    }

    // class StructField { String name; Type type; }
    public Object visit(StructField node, Object param) {
        super.visit(node, param);

        StructField structField = structFields.get(node.getName());
        predicado(structField == null, "Campo de estructura ya definido: " + node.getName(), node);
        structFields.put(node.getName(), node);

        return null;
    }

    // class TypeStruct { String name; }
    public Object visit(TypeStruct node, Object param) {
    	super.visit(node, param);

        DefinitionStruct struct = structs.get(node.getName());
        predicado(struct != null, "Estructura no definida: " + node.getName(), node);
        node.setDefinition(struct); // Enlazar referencia con definición

        return null;
    }
 
    // # --------------------------------------------------------

    // class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {

        super.visit(node, param);

        return null;
    }

    // class DefinitionFunction { String name; List<DefinitionVariable>
    // definitionFunctionParams; Type type; List<DefinitionVariable> localVariables;
    // List<Sentence> sentences; }
    public Object visit(DefinitionFunction node, Object param) {

        DefinitionFunction function = functions.get(node.getName());
        predicado(function == null, "Función ya definida: " + node.getName(), node);
        functions.put(node.getName(), node);

        variables.set();
        super.visit(node, param);
        variables.reset();

        return null;
    }

    // class DefinitionVariable { String name; Type type; }
    public Object visit(DefinitionVariable node, Object param) {
    	super.visit(node, param);

        DefinitionVariable variable = variables.getFromTop(node.getName());
        predicado(variable == null, "Variable ya definida: " + node.getName(), node);
        variables.put(node.getName(), node);

        return null;
    }

    // class ExpressionVariable { String name; }
    public Object visit(ExpressionVariable node, Object param) {
    	super.visit(node, param);

        DefinitionVariable variable = variables.getFromAny(node.getName());
        predicado(variable != null, "Variable no definida: " + node.getName(), node);
        node.setDefinition(variable);

        return null;
    }

    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        if (!condition)
            error(errorMessage, node.getStart());
    }

    private ErrorManager errorManager;
    private Map<String, DefinitionFunction> functions = new HashMap<String, DefinitionFunction>();
    private Map<String, DefinitionStruct> structs = new HashMap<String, DefinitionStruct>();
    private Map<String, StructField> structFields = new HashMap<String, StructField>();
    ContextMap<String, DefinitionVariable> variables = new ContextMap<String, DefinitionVariable>();
}
