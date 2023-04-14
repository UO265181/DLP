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
import ast.expressions.ExpressionArray;
import ast.expressions.ExpressionCallFunction;
import ast.expressions.ExpressionCast;
import ast.expressions.ExpressionConstantChar;
import ast.expressions.ExpressionConstantFloat;
import ast.expressions.ExpressionConstantInt;
import ast.expressions.ExpressionLogical;
import ast.expressions.ExpressionRelational;
import ast.expressions.ExpressionStructField;
import ast.expressions.ExpressionUnary;
import ast.expressions.ExpressionVariable;
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
import ast.types.TypeArray;
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

		predicado(node.getType() != TypeVoid.getInstance(),
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
					"El tipo de las variables de una función ha de ser primitivo: " + node.getName(), node);
		}

		node.getType().accept(this, param);

		if (node.getType() != TypeVoid.getInstance()) {
			predicado(node.getType().isPrimitive(),
					"El tipo de retorno de una función ha de ser primitivo: " + node.getName(), node);
		}

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

	// class TypeInt { }
	public Object visit(TypeInt node, Object param) {
		return null;
	}

	// class TypeFloat { }
	public Object visit(TypeFloat node, Object param) {
		return null;
	}

	// class TypeChar { }
	public Object visit(TypeChar node, Object param) {
		return null;
	}

	// class TypeVoid { }
	public Object visit(TypeVoid node, Object param) {
		return null;
	}

	// class TypeArray { ExpressionConstantInt size; Type type; }
	public Object visit(TypeArray node, Object param) {

		// super.visit(node, param);

		if (node.getSize() != null)
			node.getSize().accept(this, param);

		if (node.getType() != null)
			node.getType().accept(this, param);

		return null;
	}

	// class TypeStruct { String name; }
	public Object visit(TypeStruct node, Object param) {
		return null;
	}

	// class SentencePrint { Expression expression; }
	public Object visit(SentencePrint node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	// class SentencePrintsp { Expression expression; }
	public Object visit(SentencePrintsp node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	// class SentencePrintln { Expression expression; }
	public Object visit(SentencePrintln node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	// class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		super.visit(node, param);

		if (node.getExpression() == null) {
			predicado(node.getFatherFunction().getType() == TypeVoid.getInstance(),
					"Esta función tiene tipo de retorno y ha de devolver un valor: " + node.getFatherFunction().getName(),
					node.getFatherFunction());
		} else {

			predicado(node.getFatherFunction().getType() != TypeVoid.getInstance(),
					"El retorno de una función void no puede devolver un valor: " + node.getFatherFunction().getName(),
					node);
			predicado(node.getExpression().getType() == node.getFatherFunction().getType(),
					"El tipo de retorno ha de coincidir con el tipo de la función: "
							+ node.getFatherFunction().getName(),
					node);
		}

		return null;
	}

	// class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {

		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		return null;
	}

	// class SentenceAssignment { Expression left; Expression right; }
	public Object visit(SentenceAssignment node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		return null;
	}

	// class SentenceCallFunction { String name; List<Expression>
	// callFunctionParams; }
	public Object visit(SentenceCallFunction node, Object param) {

		// super.visit(node, param);

		if (node.getCallFunctionParams() != null)
			for (Expression child : node.getCallFunctionParams())
				child.accept(this, param);

		return null;
	}

	// class SentenceIf { Expression condition; List<Sentence> ifSentences;
	// List<Sentence> elseSentences; }
	public Object visit(SentenceIf node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		if (node.getIfSentences() != null)
			for (Sentence child : node.getIfSentences()) {
				child.setFatherFunction(node.getFatherFunction());
				child.accept(this, param);
			}

		if (node.getElseSentences() != null)
			for (Sentence child : node.getElseSentences()) {
				child.setFatherFunction(node.getFatherFunction());
				child.accept(this, param);
			}

		return null;
	}

	// class SentenceWhile { Expression condition; List<Sentence> sentences; }
	public Object visit(SentenceWhile node, Object param) {

		// super.visit(node, param);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);

		if (node.getSentences() != null)
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

		
		// super.visit(node, param);

		if (node.getCallFunctionParams() != null)
			for (Expression child : node.getCallFunctionParams())
				child.accept(this, param);

		node.setType(node.getDefinition().getType());

		node.setModifiable(false);



		return null;
	}

	// class ExpressionUnary { String operator; Expression expression; }
	public Object visit(ExpressionUnary node, Object param) {
		// super.visit(node, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		node.setType(TypeInt.getInstance());

		node.setModifiable(false);



		return null;
	}

	// class ExpressionCast { Type newType; Expression expression; }
	public Object visit(ExpressionCast node, Object param) {

		// super.visit(node, param);

		if (node.getNewType() != null)
			node.getNewType().accept(this, param);

		if (node.getExpression() != null)
			node.getExpression().accept(this, param);

		node.setType(node.getNewType());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionArithmetic { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpressionArithmetic node, Object param) {
		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		node.setType(node.getLeft().getType());

		node.setModifiable(false);



		return null;
	}

	// class ExpressionRelational { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpressionRelational node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		node.setType(TypeInt.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionLogical { Expression left; String operator; Expression right;
	// }
	public Object visit(ExpressionLogical node, Object param) {

		// super.visit(node, param);

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		node.setType(TypeInt.getInstance());

		node.setModifiable(false);

		return null;
	}

	// class ExpressionVariable { String name; }
	public Object visit(ExpressionVariable node, Object param) {

		node.setType(node.getDefinition().getType());

		node.setModifiable(true);

		return null;
	}

	// class ExpressionStructField { Expression struct; String name; }
	public Object visit(ExpressionStructField node, Object param) {
		// super.visit(node, param);

		if (node.getStruct() != null)
			node.getStruct().accept(this, param);

		node.setType(node.getStruct().getType());

		node.setModifiable(true);


		return null;
	}

	// class ExpressionArray { Expression array; Expression index; }
	public Object visit(ExpressionArray node, Object param) {
		// super.visit(node, param);

		if (node.getArray() != null)
			node.getArray().accept(this, param);

		if (node.getIndex() != null)
			node.getIndex().accept(this, param);

		//TODO:type=array.type.type
		//IO??¿
		node.setType(node.getArray().getType());

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
