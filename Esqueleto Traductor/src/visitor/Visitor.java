/**
 * @generated VGen (for ANTLR) 1.7.2
 */

 package visitor;

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
 
 public interface Visitor {
	 public Object visit(Program node, Object param);
	 public Object visit(DefinitionVariable node, Object param);
	 public Object visit(DefinitionStruct node, Object param);
	 public Object visit(DefinitionFunction node, Object param);
	 public Object visit(StructField node, Object param);
	 public Object visit(TypeInt node, Object param);
	 public Object visit(TypeFloat node, Object param);
	 public Object visit(TypeChar node, Object param);
	 public Object visit(TypeVoid node, Object param);
	 public Object visit(TypeArray node, Object param);
	 public Object visit(TypeStruct node, Object param);
	 public Object visit(SentencePrint node, Object param);
	 public Object visit(SentencePrintsp node, Object param);
	 public Object visit(SentencePrintln node, Object param);
	 public Object visit(SentenceReturn node, Object param);
	 public Object visit(SentenceRead node, Object param);
	 public Object visit(SentenceAssignment node, Object param);
	 public Object visit(SentenceDestructuringAssignment node, Object param);
	 public Object visit(SentenceCallFunction node, Object param);
	 public Object visit(SentenceIf node, Object param);
	 public Object visit(SentenceWhile node, Object param);
	 public Object visit(ExpressionConstantInt node, Object param);
	 public Object visit(ExpressionConstantFloat node, Object param);
	 public Object visit(ExpressionConstantChar node, Object param);
	 public Object visit(ExpressionCallFunction node, Object param);
	 public Object visit(ExpressionUnary node, Object param);
	 public Object visit(ExpressionCast node, Object param);
	 public Object visit(ExpressionArithmetic node, Object param);
	 public Object visit(ExpressionRelational node, Object param);
	 public Object visit(ExpressionLogical node, Object param);
	 public Object visit(ExpressionVariable node, Object param);
	 public Object visit(ExpressionStructField node, Object param);
	 public Object visit(ExpressionArray node, Object param);
 }
 