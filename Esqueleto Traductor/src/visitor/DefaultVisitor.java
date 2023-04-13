/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Definition> definitions; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getDefinitions(), param);
		return null;
	}

	//	class DefinitionVariable { String name;  Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class DefinitionStruct { String name;  List<StructField> structFields; }
	public Object visit(DefinitionStruct node, Object param) {
		visitChildren(node.getStructFields(), param);
		return null;
	}

	//	class DefinitionFunction { String name;  List<DefinitionVariable> definitionFunctionParams;  Type type;  List<DefinitionVariable> localVariables;  List<Sentence> sentences; }
	public Object visit(DefinitionFunction node, Object param) {
		visitChildren(node.getDefinitionFunctionParams(), param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		visitChildren(node.getLocalVariables(), param);
		visitChildren(node.getSentences(), param);
		return null;
	}

	//	class StructField { String name;  Type type; }
	public Object visit(StructField node, Object param) {
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
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class SentencePrintsp { Expression expression; }
	public Object visit(SentencePrintsp node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class SentencePrintln { Expression expression; }
	public Object visit(SentencePrintln node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class SentenceAssignment { Expression left;  Expression right; }
	public Object visit(SentenceAssignment node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class SentenceCallFunction { String name;  List<Expression> callFunctionParams; }
	public Object visit(SentenceCallFunction node, Object param) {
		visitChildren(node.getCallFunctionParams(), param);
		return null;
	}

	//	class SentenceIf { Expression condition;  List<Sentence> ifSentences;  List<Sentence> elseSentences; }
	public Object visit(SentenceIf node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getIfSentences(), param);
		visitChildren(node.getElseSentences(), param);
		return null;
	}

	//	class SentenceWhile { Expression condition;  List<Sentence> sentences; }
	public Object visit(SentenceWhile node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getSentences(), param);
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
		visitChildren(node.getCallFunctionParams(), param);
		return null;
	}

	//	class ExpressionUnary { String operator;  Expression expression; }
	public Object visit(ExpressionUnary node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class ExpressionCast { Type newType;  Expression expression; }
	public Object visit(ExpressionCast node, Object param) {
		if (node.getNewType() != null)
			node.getNewType().accept(this, param);
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class ExpressionArithmetic { Expression left;  String operator;  Expression right; }
	public Object visit(ExpressionArithmetic node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpressionRelational { Expression left;  String operator;  Expression right; }
	public Object visit(ExpressionRelational node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class ExpressionLogical { Expression left;  String operator;  Expression right; }
	public Object visit(ExpressionLogical node, Object param) {
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
		if (node.getStruct() != null)
			node.getStruct().accept(this, param);
		return null;
	}

	//	class ExpressionArray { Expression array;  Expression index; }
	public Object visit(ExpressionArray node, Object param) {
		if (node.getArray() != null)
			node.getArray().accept(this, param);
		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
