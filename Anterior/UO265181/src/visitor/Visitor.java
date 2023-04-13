/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import ast.*;
import ast.def.FuncDef;
import ast.def.Record;
import ast.def.StructDef;
import ast.def.VarDef;
import ast.exp.ArithmeticExpression;
import ast.exp.Cast;
import ast.exp.FuncExp;
import ast.exp.LogicalExpression;
import ast.exp.RelationalExpression;
import ast.exp.access.ArrayAccess;
import ast.exp.access.StructAccess;
import ast.exp.access.Variable;
import ast.exp.constant.CharConstant;
import ast.exp.constant.IntConstant;
import ast.exp.constant.RealConstant;
import ast.statement.Assignment;
import ast.statement.FuncStatement;
import ast.statement.If;
import ast.statement.Print;
import ast.statement.Println;
import ast.statement.Printsp;
import ast.statement.Read;
import ast.statement.Return;
import ast.statement.While;
import ast.type.ArrayType;
import ast.type.StructType;
import ast.type.primitive.CharType;
import ast.type.primitive.FloatType;
import ast.type.primitive.IntType;

public interface Visitor {
	public Object visit(Program program, Object param);
	public Object visit(VarDef node, Object param);
	public Object visit(IntType node, Object param);
	public Object visit(FloatType node, Object param);
	public Object visit(CharType node, Object param);
	public Object visit(ArrayType node, Object param);
	public Object visit(StructType node, Object param);
	public Object visit(StructDef node, Object param);
	public Object visit(Record node, Object param);
	public Object visit(FuncDef node, Object param);
	public Object visit(Assignment node, Object param);
	public Object visit(Return node, Object param);
	public Object visit(Print node, Object param);
	public Object visit(Printsp node, Object param);
	public Object visit(Println node, Object param);
	public Object visit(Read node, Object param);
	public Object visit(While node, Object param);
	public Object visit(If node, Object param);
	public Object visit(FuncStatement node, Object param);
	public Object visit(ArithmeticExpression node, Object param);
	public Object visit(RelationalExpression node, Object param);
	public Object visit(LogicalExpression node, Object param);
	public Object visit(Cast node, Object param);
	public Object visit(FuncExp node, Object param);
	public Object visit(StructAccess node, Object param);
	public Object visit(ArrayAccess node, Object param);
	public Object visit(Variable node, Object param);
	public Object visit(IntConstant node, Object param);
	public Object visit(RealConstant node, Object param);
	public Object visit(CharConstant node, Object param);
}
