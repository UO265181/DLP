/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;

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
	public Object visit(ExpressionAccess node, Object param);
	public Object visit(AccessVariable node, Object param);
	public Object visit(AccessStructField node, Object param);
	public Object visit(AccessArray node, Object param);
}
