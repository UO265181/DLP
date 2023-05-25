/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package codegeneration.generator;

import ast.*;
import ast.definitions.DefinitionFunction;
import ast.definitions.DefinitionStruct;
import ast.definitions.DefinitionVariable;
import ast.definitions.StructField;
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
import ast.sentences.SentenceAssignment;
import ast.sentences.SentenceCallFunction;
import ast.sentences.SentenceDestructuringAssignment;
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
import codegeneration.CodeWriter;
import main.ErrorManager;
import visitor.Visitor;

import java.util.*;

public class DefaultCodeGeneratorVisitor implements Visitor {

	private CodeWriter codeWriter;
	private ErrorManager errorManager;
	private String functionName;

	public DefaultCodeGeneratorVisitor(CodeWriter codeWriter, ErrorManager errorManager) {
		this.codeWriter=codeWriter;
		this.errorManager=errorManager;
	}

	public DefaultCodeGeneratorVisitor(CodeWriter codeWriter, ErrorManager errorManager, String functionName) {
		this(codeWriter, errorManager);
		this.functionName = functionName;
	}

	public CodeWriter getCodeWriter() {
		return codeWriter;
	}

	public void setCodeWriter(CodeWriter codeWriter) {
		this.codeWriter = codeWriter;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	private void throwError(AST node) {
		errorManager.notify("Code Generation",
				"No se ha definido la función " + getFunctionName() + " para el nodo " + node.getClass(),
				node.getStart());
	}

	// class Program { List<Definition> definitions; }
	public Object visit(Program node, Object param) {
		throwError(node);
		return null;
	}

	// class DefinitionVariable { String name; Type type; }
	public Object visit(DefinitionVariable node, Object param) {
		throwError(node);
		return null;
	}

	// class DefinitionStruct { String name; List<StructField> structFields; }
	public Object visit(DefinitionStruct node, Object param) {
		throwError(node);
		return null;
	}

	// class DefinitionFunction { String name; List<DefinitionVariable>
	// definitionFunctionParams; Type type; List<DefinitionVariable> localVariables;
	// List<Sentence> sentences; }
	public Object visit(DefinitionFunction node, Object param) {
		throwError(node);
		return null;
	}

	// class StructField { String name; Type type; }
	public Object visit(StructField node, Object param) {
		throwError(node);
		return null;
	}

	// class TypeInt { }
	public Object visit(TypeInt node, Object param) {
		throwError(node);
		return null;
	}

	// class TypeFloat { }
	public Object visit(TypeFloat node, Object param) {
		throwError(node);
		return null;
	}

	// class TypeChar { }
	public Object visit(TypeChar node, Object param) {
		throwError(node);
		return null;
	}

	// class TypeVoid { }
	public Object visit(TypeVoid node, Object param) {
		throwError(node);
		return null;
	}

	// class TypeArray { ExpressionConstantInt size; Type type; }
	public Object visit(TypeArray node, Object param) {
		throwError(node);
		return null;
	}

	// class TypeStruct { String name; }
	public Object visit(TypeStruct node, Object param) {
		throwError(node);
		return null;
	}

	// class SentencePrint { Expression expression; }
	public Object visit(SentencePrint node, Object param) {
		throwError(node);
		return null;
	}

	// class SentencePrintsp { Expression expression; }
	public Object visit(SentencePrintsp node, Object param) {
		throwError(node);
		return null;
	}

	// class SentencePrintln { Expression expression; }
	public Object visit(SentencePrintln node, Object param) {
		throwError(node);
		return null;
	}

	// class SentenceReturn { Expression expression; }
	public Object visit(SentenceReturn node, Object param) {
		throwError(node);
		return null;
	}

	// class SentenceRead { Expression expression; }
	public Object visit(SentenceRead node, Object param) {
		throwError(node);
		return null;
	}

	// class SentenceAssignment { Expression left; Expression right; }
	public Object visit(SentenceAssignment node, Object param) {
		throwError(node);
		return null;
	}

	// class SentenceCallFunction { String name; List<Expression>
	// callFunctionParams; }
	public Object visit(SentenceCallFunction node, Object param) {
		throwError(node);
		return null;
	}

	// class SentenceIf { Expression condition; List<Sentence> ifSentences;
	// List<Sentence> elseSentences; }
	public Object visit(SentenceIf node, Object param) {
		throwError(node);
		return null;
	}

	// class SentenceWhile { Expression condition; List<Sentence> sentences; }
	public Object visit(SentenceWhile node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionConstantInt { String value; }
	public Object visit(ExpressionConstantInt node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionConstantFloat { String value; }
	public Object visit(ExpressionConstantFloat node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionConstantChar { String value; }
	public Object visit(ExpressionConstantChar node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionCallFunction { String name; List<Expression>
	// callFunctionParams; }
	public Object visit(ExpressionCallFunction node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionUnary { String operator; Expression expression; }
	public Object visit(ExpressionUnary node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionCast { Type newType; Expression expression; }
	public Object visit(ExpressionCast node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionArithmetic { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpressionArithmetic node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionRelational { Expression left; String operator; Expression
	// right; }
	public Object visit(ExpressionRelational node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionLogical { Expression left; String operator; Expression right;
	// }
	public Object visit(ExpressionLogical node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionVariable { String name; }
	public Object visit(ExpressionVariable node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionStructField { Expression struct; String name; }
	public Object visit(ExpressionStructField node, Object param) {
		throwError(node);
		return null;
	}

	// class ExpressionArray { Expression array; Expression index; }
	public Object visit(ExpressionArray node, Object param) {
		throwError(node);
		return null;
	}

	@Override
	public Object visit(SentenceDestructuringAssignment node, Object param) {
		throwError(node);
		return null;
	}


	// Método auxiliar -----------------------------
	protected void visitChildren(List<? extends AST> children, Object param) {
		if (children != null)
			for (AST child : children)
				child.accept(this, param);
	}


}
