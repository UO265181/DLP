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

import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { List<Def> def; }
	public Object visit(Program node, Object param) {
		visitChildren(node.getDef(), param);
		return null;
	}

	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		return null;
	}

	//	class FloatType {  }
	public Object visit(FloatType node, Object param) {
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		return null;
	}

	//	class ArrayType { String size;  Type type; }
	public Object visit(ArrayType node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class StructType { String name; }
	public Object visit(StructType node, Object param) {
		return null;
	}

	//	class StructDef { String name;  List<Record> record; }
	public Object visit(StructDef node, Object param) {
		visitChildren(node.getRecord(), param);
		return null;
	}

	//	class Record { String name;  Type type; }
	public Object visit(Record node, Object param) {
		if (node.getType() != null)
			node.getType().accept(this, param);
		return null;
	}

	//	class FuncDef { String name;  List<VarDef> params;  Type type;  List<VarDef> vardef;  List<Statement> statement; }
	public Object visit(FuncDef node, Object param) {
		visitChildren(node.getParams(), param);
		if (node.getType() != null)
			node.getType().accept(this, param);
		visitChildren(node.getVardef(), param);
		visitChildren(node.getStatement(), param);
		return null;
	}

	//	class Assignment { Exp left;  Exp right; }
	public Object visit(Assignment node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Return { Exp exp; }
	public Object visit(Return node, Object param) {
		if (node.getExp() != null)
			node.getExp().accept(this, param);
		return null;
	}

	//	class Print { Exp exp; }
	public Object visit(Print node, Object param) {
		if (node.getExp() != null)
			node.getExp().accept(this, param);
		return null;
	}

	//	class Printsp { Exp exp; }
	public Object visit(Printsp node, Object param) {
		if (node.getExp() != null)
			node.getExp().accept(this, param);
		return null;
	}

	//	class Println { Exp exp; }
	public Object visit(Println node, Object param) {
		if (node.getExp() != null)
			node.getExp().accept(this, param);
		return null;
	}

	//	class Read { Exp exp; }
	public Object visit(Read node, Object param) {
		if (node.getExp() != null)
			node.getExp().accept(this, param);
		return null;
	}

	//	class While { Exp condition;  List<Statement> statement; }
	public Object visit(While node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getStatement(), param);
		return null;
	}

	//	class If { Exp condition;  List<Statement> ifst;  List<Statement> elsest; }
	public Object visit(If node, Object param) {
		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		visitChildren(node.getIfst(), param);
		visitChildren(node.getElsest(), param);
		return null;
	}

	//	class FuncStatement { String name;  List<Exp> params; }
	public Object visit(FuncStatement node, Object param) {
		visitChildren(node.getParams(), param);
		return null;
	}

	//	class ArithmeticExpression { Exp left;  String operator;  Exp right; }
	public Object visit(ArithmeticExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class RelationalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(RelationalExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class LogicalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(LogicalExpression node, Object param) {
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);
		if (node.getRight() != null)
			node.getRight().accept(this, param);
		return null;
	}

	//	class Cast { Type newType;  Exp exp; }
	public Object visit(Cast node, Object param) {
		if (node.getNewType() != null)
			node.getNewType().accept(this, param);
		if (node.getExp() != null)
			node.getExp().accept(this, param);
		return null;
	}

	//	class FuncExp { String name;  List<Exp> params; }
	public Object visit(FuncExp node, Object param) {
		visitChildren(node.getParams(), param);
		return null;
	}

	//	class StructAccess { Exp struct;  String name; }
	public Object visit(StructAccess node, Object param) {
		if (node.getStruct() != null)
			node.getStruct().accept(this, param);
		return null;
	}

	//	class ArrayAccess { Exp array;  Exp index; }
	public Object visit(ArrayAccess node, Object param) {
		if (node.getArray() != null)
			node.getArray().accept(this, param);
		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		return null;
	}

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		return null;
	}

	//	class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
