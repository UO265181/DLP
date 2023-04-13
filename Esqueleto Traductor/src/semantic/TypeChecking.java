/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # ----------------------------------------------------------
    /*
    * Poner aquí los visit.
    *
    * Si se ha usado VGen, solo hay que copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
    */

    // public Object visit(Program prog, Object param) {
    //      ...
    // }

    // ...
    // ...
    // ...

    // # ----------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
     *
     *      1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr.getStart());
     *      2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo", expr); // Se asume getStart()
     *      3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo primitivo");
     *
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero fuente donde estaba el nodo
     * (y así poder dar información más detallada de la posición del error). Si se usa VGen, dicho método
     * habrá sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo, se usará por defecto dicha
     * posición.
     * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer argumento (ejemplo 3).
     *
     * @param condition     Debe cumplirse para que no se produzca un error
     * @param errorMessage  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el error.
     */

    

	//	class DefinitionVariable { String name;  Type type; }
	public Object visit(DefinitionVariable node, Object param) {

		// super.visit(node, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	//	class DefinitionStruct { String name;  List<StructField> structFields; }
	public Object visit(DefinitionStruct node, Object param) {

		// super.visit(node, param);

		if (node.getStructFields() != null)
			for (StructField child : node.getStructFields())
				child.accept(this, param);

		return null;
	}

	//	class DefinitionFunction { String name;  List<DefinitionVariable> definitionFunctionParams;  Type type;  List<DefinitionVariable> localVariables;  List<Sentence> sentences; }
	public Object visit(DefinitionFunction node, Object param) {

		// super.visit(node, param);

		if (node.getDefinitionFunctionParams() != null)
			for (DefinitionVariable child : node.getDefinitionFunctionParams())
				child.accept(this, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getLocalVariables() != null)
			for (DefinitionVariable child : node.getLocalVariables())
				child.accept(this, param);

		if (node.getSentences() != null)
			for (Sentence child : node.getSentences())
				child.accept(this, param);

		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {

		// super.visit(node, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	//	class TypeInt {  }
	public Object visit(TypeInt node, Object param) {
		return null;
	}

	//	class TypeFloat {  }
	public Object visit(TypeFloat node, Object param) {
		return null;
	}

	//	class TypeChar {  }
	public Object visit(TypeChar node, Object param) {
		return null;
	}

	//	class TypeVoid {  }
	public Object visit(TypeVoid node, Object param) {
		return null;
	}

	//	class TypeArray { ExpressionConstantInt size;  Type type; }
	public Object visit(TypeArray node, Object param) {

		// super.visit(node, param);

		if (node.getSize() != null)
			node.getSize().accept(this, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	//	class TypeStruct { String name; }
	public Object visit(TypeStruct node, Object param) {
		return null;
	}

	//	class SentencePrint { Expression expression; }
	public Object visit(SentencePrint node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class SentencePrintsp { Expression expression; }
	public Object visit(SentencePrintsp node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class SentencePrintln { Expression expression; }
	public Object visit(SentencePrintln node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class SentenceAssignment { Expression left;  Expression right; }
	public Object visit(SentenceAssignment node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class SentenceCallFunction { String name;  List<Expression> callFunctionParams; }
	public Object visit(SentenceCallFunction node, Object param) {

		// super.visit(node, param);

		if (node.getCallFunctionParams() != null)
			for (Expression child : node.getCallFunctionParams())
				child.accept(this, param);

		return null;
	}

	//	class SentenceIf { Expression condition;  List<Sentence> ifSentences;  List<Sentence> elseSentences; }
	public Object visit(SentenceIf node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		if (node.getIfSentences() != null)
			for (Sentence child : node.getIfSentences())
				child.accept(this, param);

		if (node.getElseSentences() != null)
			for (Sentence child : node.getElseSentences())
				child.accept(this, param);

		return null;
	}

	//	class SentenceWhile { Expression condition;  List<Sentence> sentences; }
	public Object visit(SentenceWhile node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		if (node.getSentences() != null)
			for (Sentence child : node.getSentences())
				child.accept(this, param);

		return null;
	}

	//	class ExpressionConstantInt { String value; }
	public Object visit(ExpressionConstantInt node, Object param) {
		return null;
	}

	//	class ExpressionConstantFloat { String value; }
	public Object visit(ExpressionConstantFloat node, Object param) {
		return null;
	}

	//	class ExpressionConstantChar { String value; }
	public Object visit(ExpressionConstantChar node, Object param) {
		return null;
	}

	//	class ExpressionCallFunction { String name;  List<Expression> callFunctionParams; }
	public Object visit(ExpressionCallFunction node, Object param) {

		// super.visit(node, param);

		if (node.getCallFunctionParams() != null)
			for (Expression child : node.getCallFunctionParams())
				child.accept(this, param);

		return null;
	}

	//	class ExpressionUnary { String operator;  Expression expression; }
	public Object visit(ExpressionUnary node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class ExpressionCast { Type newType;  Expression expression; }
	public Object visit(ExpressionCast node, Object param) {

		// super.visit(node, param);

		if (node.getNewType() != null)
			node.getNewType().accept(this, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	//	class ExpressionArithmetic { Expression left;  String operator;  Expression right; }
	public Object visit(ExpressionArithmetic node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class ExpressionRelational { Expression left;  String operator;  Expression right; }
	public Object visit(ExpressionRelational node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class ExpressionLogical { Expression left;  String operator;  Expression right; }
	public Object visit(ExpressionLogical node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	//	class ExpressionVariable { String name; }
	public Object visit(ExpressionVariable node, Object param) {
		return null;
	}

	//	class ExpressionStructField { Expression struct;  String name; }
	public Object visit(ExpressionStructField node, Object param) {

		// super.visit(node, param);

		if (node.getStruct() != null)
			node.getStruct().accept(this, param);

		return null;
	}

	//	class ExpressionArray { Expression array;  Expression index; }
	public Object visit(ExpressionArray node, Object param) {

		// super.visit(node, param);

		if (node.getArray() != null)
			node.getArray().accept(this, param);

		if (node.getIndex() != null)
			node.getIndex().accept(this, param);

		return null;
	}











    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Type Checking", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }

    private ErrorManager errorManager;
}
