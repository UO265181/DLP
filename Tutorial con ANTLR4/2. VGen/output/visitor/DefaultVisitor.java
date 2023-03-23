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

	//	class TypeArray { ConstantInt size;  Type type; }
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

	//	class Print { Expression expression; }
	public Object visit(Print node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Printsp { Expression expression; }
	public Object visit(Printsp node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Println { Expression expression; }
	public Object visit(Println node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Return { Expression expression; }
	public Object visit(Return node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Read { Expression expression; }
	public Object visit(Read node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Assignment { Expression left;  Expression right; }
	public Object visit(Assignment node, Object param) {
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

	//	class If { Expression condition;  List<Sentence> ifSentences;  List<Sentence> elseSentences; }
	public Object visit(If node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getIfSentences(), param);
		visitChildren(node.getElseSentences(), param);
		return null;
	}

	//	class While { Expression condition;  List<Sentence> sentences; }
	public Object visit(While node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getSentences(), param);
		return null;
	}

	//	class ConstantInt { String value; }
	public Object visit(ConstantInt node, Object param) {
		return null;
	}

	//	class ConstantFloat { String value; }
	public Object visit(ConstantFloat node, Object param) {
		return null;
	}

	//	class ConstantChar { String value; }
	public Object visit(ConstantChar node, Object param) {
		return null;
	}

	//	class ExpressionCallFunction { String name;  List<Expression> callFunctionParams; }
	public Object visit(ExpressionCallFunction node, Object param) {
		visitChildren(node.getCallFunctionParams(), param);
		return null;
	}

	//	class AccessVariable { String name; }
	public Object visit(AccessVariable node, Object param) {
		return null;
	}

	//	class AccessStructField { Expression struct;  String name; }
	public Object visit(AccessStructField node, Object param) {
		if (node.getStruct() != null)
			node.getStruct().accept(this, param);
		return null;
	}

	//	class AccessArray { Expression array;  Expression index; }
	public Object visit(AccessArray node, Object param) {
		if (node.getArray() != null)
			node.getArray().accept(this, param);
		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		return null;
	}

	//	class UnaryExpression { String operator;  Expression expression; }
	public Object visit(UnaryExpression node, Object param) {
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class Cast { Type type;  Expression expression; }
	public Object visit(Cast node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		if (node.getExpression() != null)
			node.getExpression().accept(this, param);
		return null;
	}

	//	class ArithmeticExpression { Expression left;  String operator;  Expression right; }
	public Object visit(ArithmeticExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class RelationalExpression { Expression left;  String operator;  Expression right; }
	public Object visit(RelationalExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class LogicalExpression { Expression left;  String operator;  Expression right; }
	public Object visit(LogicalExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
