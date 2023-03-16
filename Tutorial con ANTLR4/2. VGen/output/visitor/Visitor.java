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
	public Object visit(TypeArray node, Object param);
	public Object visit(TypeStruct node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Printsp node, Object param);
	public Object visit(Println node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(Assignment node, Object param);
	public Object visit(SentenceCallFunction node, Object param);
	public Object visit(If node, Object param);
	public Object visit(While node, Object param);
	public Object visit(ConstantInt node, Object param);
	public Object visit(ConstantFloat node, Object param);
	public Object visit(ConstantChar node, Object param);
	public Object visit(ExpressionCallFunction node, Object param);
	public Object visit(AccessVariable node, Object param);
	public Object visit(AccessStructField node, Object param);
	public Object visit(AccessArray node, Object param);
	public Object visit(UnaryExpression node, Object param);
	public Object visit(Cast node, Object param);
	public Object visit(ArithmeticExpression node, Object param);
	public Object visit(RelationalExpression node, Object param);
	public Object visit(LogicalExpression node, Object param);
}
