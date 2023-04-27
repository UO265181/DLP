/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import ast.definitions.DefinitionFunction;
import ast.definitions.DefinitionStruct;
import ast.definitions.DefinitionVariable;
import ast.definitions.StructField;
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
import ast.types.Type;
import ast.types.TypeArray;
import ast.types.TypeError;
import ast.types.TypeStruct;
import ast.types.TypeVoid;
import ast.types.primitives.TypeChar;
import ast.types.primitives.TypeFloat;
import ast.types.primitives.TypeInt;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

	public TypeChecking(ErrorManager errorManager) {
		this.errorManager = errorManager;
	}

	// class DefinitionVariable { String name; Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		super.visit(node, param);

		predicado(!node.getType().isSameType(TypeVoid.getInstance()),
				"No se puede definir una variable de tipo void: " + node.getName(), node);

		return null;
	}

	// class DefinitionFunction { String name; List<DefinitionVariable>
	// definitionFunctionParams; Type type; List<DefinitionVariable> localVariables;
	// List<Sentence> sentences; }
	public Object visit(DefinitionFunction node, Object param) {

		for (DefinitionVariable child : node.getDefinitionFunctionParams()) {
			child.accept(this, param);
			predicado(child.getType().isPrimitive(),
					"Los parámetros de una función han de ser primitivos: " + node.getName(), node);
		}

		node.getType().accept(this, param);

		predicado(node.getType().isPrimitive() || node.getType().isSameType(TypeVoid.getInstance()),
				"El tipo de retorno de una función ha de ser primitivo: " + node.getName(), node);

		for (DefinitionVariable child : node.getLocalVariables()) {
			child.accept(this, param);
		}

		for (Sentence child : node.getSentences()) {
			child.setFatherFunction(node);
			child.accept(this, param);
		}

		return null;
	}

	// class StructField { String name; Type type; }
	public Object visit(StructField node, Object param) {

		// super.visit(node, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	// class SentencePrint { Expression expression; }
	public Object visit(SentencePrint node, Object param) {

		if (node.getExpression() != null) {
			node.getExpression().accept(this, param);

			predicado(node.getExpression().getType().isPrimitive(),
					"El tipo de la expresión a imprimir ha de ser primitivo", node);
		}

		return null;
	}

	// class SentencePrintsp { Expression expression; }
	public Object visit(SentencePrintsp node, Object param) {

		if (node.getExpression() != null) {
			node.getExpression().accept(this, param);

			predicado(node.getExpression().getType().isPrimitive(),
					"El tipo de la expresión a imprimir ha de ser primitivo", node);
		}

		return null;
	}

	// class SentencePrintln { Expression expression; }
	public Object visit(SentencePrintln node, Object param) {

		if (node.getExpression() != null) {
			node.getExpression().accept(this, param);

			predicado(node.getExpression().getType().isPrimitive(),
					"El tipo de la expresión a imprimir ha de ser primitivo", node);
		}

		return null;
	}

	// class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		super.visit(node, param);

		if (node.getExpression() == null) {
			predicado(node.getFatherFunction().getType().isSameType(TypeVoid.getInstance()),
					"Esta función tiene tipo de retorno y ha de devolver un valor: "
							+ node.getFatherFunction().getName(),
					node.getFatherFunction());
		} else {

			if (node.getFatherFunction().getType().isSameType(TypeVoid.getInstance())) {
				errorManager.notify("Type Checking", "El retorno de una función void no puede devolver un valor: "
						+ node.getFatherFunction().getName(), node.getStart());
			} else {
				predicado(node.getExpression().getType().isSameType(node.getFatherFunction().getType()),
						"El tipo de retorno ha de coincidir con el tipo de la función: "
								+ node.getFatherFunction().getName(),
						node);
			}
		}

		return null;
	}

	// class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {
		super.visit(node, param);

		predicado(node.getExpression().getType().isPrimitive(), "El tipo de la expresión a leer ha de ser primitivo",
				node);
		predicado(node.getExpression().isModifiable(), "La expresión a leer ha de ser modificable", node);

		return null;
	}

	// class SentenceAssignment { Expression left; Expression right; }
	public Object visit(SentenceAssignment node, Object param) {
		super.visit(node, param);

		predicado(node.getLeft().isModifiable(), "La expresión izquierda de una asignación ha de ser modificable",
				node);
		predicado(node.getLeft().getType().isPrimitive(),
				"La expresión izquierda de una asignación ha de ser de tipo primitivo", node);
		predicado(node.getRight().getType().isPrimitive(),
				"La expresión derecha de una asignación ha de ser de tipo primitivo", node);
		predicado(node.getLeft().getType().isSameType(node.getRight().getType()),
				"La asignación ha de ser del mismo tipo",
				node);

		return null;
	}

	// class SentenceCallFunction { String name; List<Expression>
	// callFunctionParams; }
	public Object visit(SentenceCallFunction node, Object param) {

		if (node.getCallFunctionParams().size() != node.getDefinition().getDefinitionFunctionParams()
				.size()) {
			errorManager.notify("Type Checking",
					"El número de parámetros de la función ha de coincidir con el de su definición: "
							+ node.getName(),
					node.getStart());
		} else {
			for (int i = 0; i < node.getCallFunctionParams().size(); i++) {

				node.getCallFunctionParams().get(i).accept(this, param);

				predicado(node.getCallFunctionParams().get(i).getType().isPrimitive(),
						"El tipo del parámetro número " + (i+1) + " de la llamada a función ha de ser primitivo: " + node.getName(),
						node);
				predicado(
						node.getCallFunctionParams().get(i).getType().isSameType(node.getDefinition()
								.getDefinitionFunctionParams().get(i).getType()),
						"El tipo del parámetro número " + (i+1) + " de la llamada a función ha de coincidir con el de su definición: "
								+ node.getName(),
						node);
			}
		}

		return null;
	}

	// class SentenceIf { Expression condition; List<Sentence> ifSentences;
	// List<Sentence> elseSentences; }
	public Object visit(SentenceIf node, Object param) {

		node.getCondition().accept(this, param);

		predicado(node.getCondition().getType().isSameType(TypeInt.getInstance()),
				"La condición de una sentencia if ha de ser de tipo entero", node);

		for (Sentence child : node.getIfSentences()) {
			child.setFatherFunction(node.getFatherFunction());
			child.accept(this, param);
		}

		if (node.getElseSentences() != null) {
			for (Sentence child : node.getElseSentences()) {
				child.setFatherFunction(node.getFatherFunction());
				child.accept(this, param);
			}
		}

		return null;
	}

	// class SentenceWhile { Expression condition; List<Sentence> sentences; }
	public Object visit(SentenceWhile node, Object param) {

		node.getCondition().accept(this, param);

		predicado(node.getCondition().getType().isSameType(TypeInt.getInstance()),
				"La condición de una sentencia while ha de ser de tipo entero", node);

		for (Sentence child : node.getSentences()) {
			child.setFatherFunction(node.getFatherFunction());
			child.accept(this, param);
		}

		return null;
	}

	// class ExpressionConstantInt { String value; }
	public Object visit(ExpressionConstantInt node, Object param) {

		node.setType(TypeInt.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionConstantFloat { String value; }
	public Object visit(ExpressionConstantFloat node, Object param) {

		node.setType(TypeFloat.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionConstantChar { String value; }
	public Object visit(ExpressionConstantChar node, Object param) {

		node.setType(TypeChar.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionCallFunction { String name; List<Expression>
	// callFunctionParams; }
	public Object visit(ExpressionCallFunction node, Object param) {

		if (node.getCallFunctionParams().size() != node.getDefinition().getDefinitionFunctionParams()
				.size()) {
			errorManager.notify("Type Checking",
					"El número de parámetros de la función ha de coincidir con el de su definición: "
							+ node.getName(),
					node.getStart());
		} else {
			for (int i = 0; i < node.getCallFunctionParams().size(); i++) {

				node.getCallFunctionParams().get(i).accept(this, param);

				predicado(node.getCallFunctionParams().get(i).getType().isPrimitive(),
						"El tipo del parámetro número " + (i+1) + " de la llamada a función ha de ser primitivo: " + node.getName(),
						node);
				predicado(
						node.getCallFunctionParams().get(i).getType().isSameType(node.getDefinition()
								.getDefinitionFunctionParams().get(i).getType()),
						"El tipo del parámetro número " + (i+1) + " de la llamada a función ha de coincidir con el de su definición: "
								+ node.getName(),
						node);
			}
		}

		predicado(!node.getDefinition().getType().isSameType(TypeVoid.getInstance()),
				"La función invocada como expresión ha de tener valor de retorno: " + node.getName(), node);

		node.setType(node.getDefinition().getType());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionUnary { String operator; Expression expression; }
	public Object visit(ExpressionUnary node, Object param) {
		super.visit(node, param);

		predicado(node.getExpression().getType().isSameType(TypeInt.getInstance()),
				"La expresión unaria ha de ser de tipo int",
				node);

		node.setType(TypeInt.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionCast { Type newType; Expression expression; }
	public Object visit(ExpressionCast node, Object param) {
		super.visit(node, param);

		predicado(node.getExpression().getType().isPrimitive(), "La expresión de un cast ha de ser de tipo simple",
				node);
		predicado(node.getNewType().isPrimitive(), "El tipo de un cast ha de ser simple", node);
		predicado(!node.getExpression().getType().isSameType(node.getNewType()),
				"El cast ha de implicar una conversión de tipo",
				node);

		node.setType(node.getNewType());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionArithmetic { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpressionArithmetic node, Object param) {
		super.visit(node, param);

		predicado(node.getLeft().getType().isSameType(node.getRight().getType()),
				"Los tipos en una expresión aritmética han de ser los mismos", node);

		if (node.getOperator().contains("+-*/")) {
			predicado(
					node.getLeft().getType().isSameType(TypeInt.getInstance())
							|| node.getLeft().getType().isSameType(TypeFloat.getInstance()),
					"El tipo de la izquierda en una expresión aritmética ha de ser int o float para el operando: "
							+ node.getOperator(),
					node);
			predicado(
					node.getRight().getType().isSameType(TypeInt.getInstance())
							|| node.getRight().getType().isSameType(TypeFloat.getInstance()),
					"El tipo de la derecha en una expresión aritmética ha de ser int o float para el operando: "
							+ node.getOperator(),
					node);

		} else if (node.getOperator().contains("%")) {
			predicado(
					node.getLeft().getType().isSameType(TypeInt.getInstance()),
					"El tipo de la izquierda en una expresión aritmética ha de ser int para el operando: "
							+ node.getOperator(),
					node);
			predicado(
					node.getRight().getType().isSameType(TypeInt.getInstance()),
					"El tipo de la derecha en una expresión aritmética ha de ser int para el operando: "
							+ node.getOperator(),
					node);
		}

		node.setType(node.getLeft().getType());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionRelational { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpressionRelational node, Object param) {
		super.visit(node, param);

		predicado(node.getLeft().getType().isSameType(node.getRight().getType()),
				"Los tipos en una expresión relacional han de ser los mismos", node);

		predicado(
				node.getLeft().getType().isSameType(TypeInt.getInstance())
						|| node.getLeft().getType().isSameType(TypeFloat.getInstance()),
				"El tipo de la izquierda en una expresión relacional ha de ser int o float", node);

		predicado(
				node.getRight().getType().isSameType(TypeInt.getInstance())
						|| node.getRight().getType().isSameType(TypeFloat.getInstance()),
				"El tipo de la derecha en una expresión relacional ha de ser int o float", node);

		node.setType(TypeInt.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionLogical { Expression left; String operator; Expression right;
	// }
	public Object visit(ExpressionLogical node, Object param) {
		super.visit(node, param);

		predicado(node.getLeft().getType().isSameType(node.getRight().getType()),
				"Los tipos en una expresión lógica han de ser los mismos", node);

		predicado(
				node.getLeft().getType().isSameType(TypeInt.getInstance()),
				"El tipo de la izquierda en una expresión lógica ha de ser int", node);

		predicado(
				node.getRight().getType().isSameType(TypeInt.getInstance()),
				"El tipo de la derecha en una expresión lógica ha de ser int", node);

		node.setType(TypeInt.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionVariable { String name; }
	public Object visit(ExpressionVariable node, Object param) {

		node.setType(node.getDefinitionVariable().getType());

		node.setModifiable(true);

		return null;
	}

	// class ExpressionStructField { Expression struct; String name; }
	public Object visit(ExpressionStructField node, Object param) {
		super.visit(node, param);

		DefinitionStruct defStruct = node.getStruct().getType().getDefinitionStruct();
		StructField field = null;

		if (defStruct != null) {
			field = defStruct.getField(node.getName());

			predicado(field!=null,
					"El campo '" + node.getName() + "' ha de estar definido en la estructura: " + defStruct.getName(),
					node);
		} else {
			//TODO: mejor¿
			errorManager.notify("Type Checking", "La expresión del acceso a estructura ha de ser de tipo estructura",
					node.getStart());
		}

		node.setType(field.getType());

		node.setModifiable(true);

		return null;
	}

	// class ExpressionArray { Expression array; Expression index; }
	public Object visit(ExpressionArray node, Object param) {
		super.visit(node, param);

		
		predicado(node.getIndex().getType().isSameType(TypeInt.getInstance()),
				"El índice de un acceso array ha de ser int", node);
		//TODO: ??
		predicado(!node.getArray().getType().getTypeOfTheArray().isSameType(TypeError.getInstance()),
				"La expresión del acceso array ha de ser de tipo array", node);

		node.setType(node.getArray().getType().getTypeOfTheArray());

		node.setModifiable(true);

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
