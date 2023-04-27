
package codegeneration;

import java.io.*;

import ast.*;
import ast.def.FuncDef;
import ast.def.Record;
import ast.def.StructDef;
import ast.def.VarDef;
import ast.exp.ArithmeticExpression;
import ast.exp.Cast;
import ast.exp.Exp;
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
import ast.statement.Statement;
import ast.statement.While;
import ast.type.StructType;
import ast.type.Type;
import ast.type.primitive.CharType;
import ast.type.primitive.FloatType;
import ast.type.primitive.IntType;
import visitor.*;

public class CodeSelection extends DefaultVisitor {

	public CodeSelection(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;
	}

//	class Program { List<Def> def; }
	public Object visit(Program node, Object param) {

		source(sourceFile);
		callMain();
		halt();

		super.visit(node, param);

		return null;
	}
	
	
	
	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {

		out(node.toStringMAPL());

		return null;
	}
	
	//	class StructDef { String name;  List<Record> record; }
	public Object visit(StructDef node, Object param) {


		out(node.toStringMAPL());

		return null;
	}

	// class FuncDef { String name; List<VarDef> params; Type type; List<VarDef>
	// vardef; List<Statement> statement; }
	public Object visit(FuncDef node, Object param) {

		line(node.getStart());
		comment("Definición función " + node.getName());
		label(node.getName());

		int paramSize = 0;
		if (node.getParams() != null) {
			for (VarDef child : node.getParams()) {
				child.accept(this, param);
				paramSize += child.getSize();
			}

		}

		int returnSize = 0;
		if (node.getType() != null) {
			node.getType().accept(this, param); 
			returnSize = node.getType().getSize();
		}

		int varLocalSize = 0;
		if (node.getVardef() != null) {
			for (VarDef child : node.getVardef()) {
				child.accept(this, param);
				varLocalSize += child.getSize();
			}

		}

		enter(varLocalSize);

		if (node.getStatement() != null)
			for (Statement child : node.getStatement())
				child.accept(this, param);

		line(node.getEnd());
		comment("Final de función");
		ret(returnSize, varLocalSize, paramSize);

		return null;

	}
	

	
//	class FuncStatement { String name;  List<Exp> params; }
	public Object visit(FuncStatement node, Object param) {

		line(node.getStart());
		comment("Llamada a función");

		if (node.getParams() != null)
			for (Exp child : node.getParams())
				child.accept(this, param);
		
		call(node.getDefinition().getName());
		
		if(node.getDefinition().getType()!=null) {
			pop(node.getDefinition().getType());
		}

		return null;
	}
	
	

	// class Assignment { Exp left; Exp right; }
	public Object visit(Assignment node, Object param) {

		line(node.getStart());
		comment("Asignación");

		if (node.getLeft() != null) {
			if (node.getLeft() instanceof Variable)
				getVariableAddress((Variable) node.getLeft()); 
			else if (node.getLeft() instanceof StructAccess)
				getStructAddress((StructAccess) node.getLeft(), param);
			else if (node.getLeft() instanceof ArrayAccess)
				getArrayAddress((ArrayAccess) node.getLeft(), param);
			else
				node.getLeft().accept(null, param);
		}

		if (node.getRight() != null) {
			node.getRight().accept(this, param);
			// Debería poner el valor en la cima de la pila
		}

		store(node.getRight().getType());

		return null;
	}

//	class If { Exp condition;  List<Statement> ifst;  List<Statement> elsest; }
	public Object visit(If node, Object param) {

		line(node.getStart());
		comment("If");

		int labelElse = getLabel();
		int labelEnd = getLabel();

		if (node.getCondition() != null) {
			line(node.getCondition().getStart());
			comment("Condición");
			node.getCondition().accept(this, param);
			// Deja en la cima de la pila un "bool"
		}

		jz("label" + labelElse);

		if (node.getIfst() != null) {
			comment("Sentencias If");
			for (Statement child : node.getIfst())
				child.accept(this, param);
		}

		jmp("label" + labelEnd);
		label("label" + labelElse);

		if (node.getElsest() != null) {
			comment("Sentencias Else");
			for (Statement child : node.getElsest())
				child.accept(this, param);
		}

		label("label" + labelEnd);
		line(node.getEnd());
		comment("Final de If");

		return null;
	}
	
	

	
//	class While { Exp condition;  List<Statement> statement; }
	public Object visit(While node, Object param) {

		line(node.getStart());
		
		int initWhile = getLabel();
		int endWhile = getLabel();
		
		label("label"+initWhile);

		if (node.getCondition() != null)
			node.getCondition().accept(this, param);
		
		jz("label"+endWhile);

		if (node.getStatement() != null)
			for (Statement child : node.getStatement())
				child.accept(this, param);
		
		jmp("label"+initWhile);
		label("label"+endWhile);

		return null;
	}
	
	

	
	// class Print { Exp exp; }
	public Object visit(Print node, Object param) {

		line(node.getStart());
		comment("Print");

		if (node.getExp() != null) {
			node.getExp().accept(this, param);

			out(node.getExp().getType());
		}

		return null;
	}

	// class Printsp { Exp exp; }
	public Object visit(Printsp node, Object param) {

		line(node.getStart());
		comment("Printsp");

		if (node.getExp() != null) {
			node.getExp().accept(this, param);

			out(node.getExp().getType());
		}
		push(CharType.getInstance(), "32");
		out(CharType.getInstance());

		return null;
	}

	// class Println { Exp exp; }
	public Object visit(Println node, Object param) {

		line(node.getStart());
		comment("Println");

		if (node.getExp() != null) {
			node.getExp().accept(this, param);

			out(node.getExp().getType());
		}
		push(CharType.getInstance(), "10");
		out(CharType.getInstance());

		return null;
	}

	

	
	// class Read { Exp exp; }
	public Object visit(Read node, Object param) {

		line(node.getStart());
		comment("Read");

		if (node.getExp() != null)
			if (node.getExp() instanceof Variable)
				getVariableAddress((Variable) node.getExp());
			else
				node.getExp().accept(this, param);
		
		

		in(node.getExp().getType());
		store(node.getExp().getType());
		
		return null;
	}
	
	
	
	
	//	class FuncExp { String name;  List<Exp> params; }
	public Object visit(FuncExp node, Object param) {

		if (node.getParams() != null)
			for (Exp child : node.getParams())
				child.accept(this, param);
		
		call(node.getName());

		return null;
	}

	
	//	class Cast { Type newType;  Exp exp; }
	public Object visit(Cast node, Object param) {

		if (node.getExp() != null)
			node.getExp().accept(this, param);
		
		cast(node.getExp().getType(), node.getNewType());

		return null;
	}
	

//	class RelationalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(RelationalExpression node, Object param) {


		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);

		if (node.getOperator().equals("<"))
			lt(node.getLeft().getType());
		else if (node.getOperator().equals(">"))
			gt(node.getLeft().getType());
		else if (node.getOperator().equals("<="))
			le(node.getLeft().getType());
		else if (node.getOperator().equals(">="))
			ge(node.getLeft().getType());
		else if (node.getOperator().equals("=="))
			eq(node.getLeft().getType());
		else if (node.getOperator().equals("!="))
			ne(node.getLeft().getType());

		return null;
	}



	
	//	class LogicalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(LogicalExpression node, Object param) {

		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		if(node.getOperator().equals("&&"))
            and();
		else if(node.getOperator().equals("||"))
            or();
		else if(node.getOperator().equals("!"))
			not();

		return null;
	}
	
    
	//	class ArithmeticExpression { Exp left;  String operator;  Exp right; }
	public Object visit(ArithmeticExpression node, Object param) {
		
		if (node.getLeft() != null)
			node.getLeft().accept(this, param);

		if (node.getRight() != null)
			node.getRight().accept(this, param);
		
		if(node.getOperator().equals("+"))
            add(node.getType());
		else if(node.getOperator().equals("-"))
            sub(node.getType());
		else if(node.getOperator().equals("*"))
            mul(node.getType());
		else if(node.getOperator().equals("/"))
            div(node.getType());
		else if(node.getOperator().equals("%"))
            mod(node.getType());

		

		return null;
	}
	
	
	
	
	

	
	//	class StructAccess { Exp struct;  String name; }
	public Object visit(StructAccess node, Object param) {

		if (node.getStruct() != null)
			if (node.getStruct() instanceof Variable)
				getVariableAddress((Variable) node.getStruct()); 
			else if (node.getStruct() instanceof StructAccess)
				getStructAddress((StructAccess) node.getStruct(), param);
			else if (node.getStruct() instanceof ArrayAccess)
				getArrayAddress((ArrayAccess) node.getStruct(), param);
			else
				node.getStruct().accept(null, param);
		
		for(Record record : ((StructType)node.getStruct().getType()).getDefinition().getRecord()){
            if(record.getName().equals(node.getName())){
                pushi(record.getAddress());
                break;
            }
		}
		
		add(IntType.getInstance());
		
		load(node.getType());

		return null;
	}

	
	
	
	

	//	class ArrayAccess { Exp array;  Exp index; }
	public Object visit(ArrayAccess node, Object param) {

		if (node.getArray() != null)
			if (node.getArray() instanceof Variable)
				getVariableAddress((Variable) node.getArray()); 
			else if (node.getArray() instanceof StructAccess)
				getStructAddress((StructAccess) node.getArray(), param);
			else if (node.getArray() instanceof ArrayAccess)
				getArrayAddress((ArrayAccess) node.getArray(), param);
			else
				node.getArray().accept(null, param);
		
		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		
		pushi(node.getType().getSize());
		mul(IntType.getInstance());
		add(IntType.getInstance());
		
		load(node.getType());
		
		return null;
	}

	// class Variable { String name; }
	public Object visit(Variable node, Object param) {
		if (node.getDefinition().isLocal()) {
			pushBP();
			pushi(node.getDefinition().getAddress());
			add(IntType.getInstance());
		} else if (node.getDefinition().isParam()) {
			pushBP();
			pushi(node.getDefinition().getAddress());
			add(IntType.getInstance());
		} else { // Es global
			pusha(node.getDefinition().getAddress());
		}

		load(node.getType());

		return null;
	}

	// class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		push(IntType.getInstance(), node.getValue());
		return null;
	}

	// class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		push(FloatType.getInstance(), node.getValue());
		return null;
	}

	// class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		char ac = node.getValue().charAt(1);
		int ai = (int)ac;
		
		
		pushb(ai);
		return null;
	}

	// # ----------------------------------------------------------
	// MÃ©todos auxiliares recomendados (opcionales) -------------

	public void pushBP() {
		out("pusha BP");
	}

	public void push(Type type, String value) {
		out("push" + type.getSuffix() + " " + value);
	}

	public void pushb(int ch) {
		out("pushb " + ch);
	}

	public void pushi(String value) {
		out("pushi " + value);
	}

	private void pushi(int value) {
		out("pushi " + value);
	}

	public void pushf(String value) {
		out("pushf " + value);
	}

	public void pusha(int dir) {
		out("pusha " + dir);
	}

	public void load(Type type) {
		out("load" + type.getSuffix());
	}

	public void store(Type type) {
		out("store" + type.getSuffix());
	}

	public void pop(Type type) {
		out("pop" + type.getSuffix());
	}

	public void dup(Type type) {
		out("dup" + type.getSuffix());
	}

	public void add(Type type) {
		out("add" + type.getSuffix());
	}

	public void sub(Type type) {
		out("sub" + type.getSuffix());
	}

	public void mul(Type type) {
		out("mul" + type.getSuffix());
	}

	public void div(Type type) {
		out("div" + type.getSuffix());
	}

	public void mod(Type type) {
		out("mod" + type.getSuffix());
	}

	public void gt(Type type) {
		out("gt" + type.getSuffix());
	}

	public void lt(Type type) {
		out("lt" + type.getSuffix());
	}

	public void ge(Type type) {
		out("ge" + type.getSuffix());
	}

	public void le(Type type) {
		out("le" + type.getSuffix());
	}

	public void eq(Type type) {
		out("eq" + type.getSuffix());
	}

	public void ne(Type type) {
		out("ne" + type.getSuffix());
	}

	public void and() {
		out("and");
	}

	public void or() {
		out("or");
	}

	public void not() {
		out("not");
	}

	public void out(Type type) {
		out("out" + type.getSuffix());
	}

	public void in(Type type) {
		out("in" + type.getSuffix());
	}

	public void cast(Type left, Type right) {

		if (left.equals(CharType.getInstance())) {
			if (right.equals(IntType.getInstance())) {
				out("b2i");
			}

			else if (right.equals(FloatType.getInstance())) {
				out("b2i");
				out("i2f");
			}
		}

		if (left.equals(IntType.getInstance())) {
			if (right.equals(CharType.getInstance())) {
				out("i2b");
			} else if (right.equals(FloatType.getInstance())) {
				out("i2f");
			}
		}

		if (left.equals(FloatType.getInstance())) {
			if (right.equals(IntType.getInstance())) {
				out("f2i");
			}

			else if (right.equals(CharType.getInstance())) {
				out("f2i");
				out("i2n");
			}
		}

	}

	public void halt() {
		out("halt");
	}

	public void ret(int ret, int localVar, int param) {
		out("ret " + ret + ", " + localVar + ", " + param);
	}

	public void enter(int size) {
		out("enter " + size);
	}

	public void call(String function) {
		out("call " + function);
	}

	public void jmp(String label) {
		out("jmp " + label);
	}

	public void jz(String label) {
		out("jz " + label);
	}

	public void jnz(String label) {
		out("jnz " + label);
	}

	public void callMain() {
		comment("Llamada a main");
		out("call main");
	}

	public void comment(String comment) {
		out("'" + comment);
	}

	private void source(String fileName) {
		out("#source \"" + fileName + "\"\n");
	}

	private int labels;

	public void label(String name) {
		out("\t" + name + ":");
	}

	public int getLabel() {
		labels++;
		return labels - 1;
	}

	private void getVariableAddress(Variable node) {

		if (node.getDefinition().isLocal()) {
			pushBP();
			pushi(node.getDefinition().getAddress());
			add(IntType.getInstance());
		} else if (node.getDefinition().isParam()) {
			pushBP();
			pushi(4); 
			add(IntType.getInstance());
		} else { // Es global
			pusha(node.getDefinition().getAddress());
		}
	}
	
	private void getStructAddress(StructAccess node, Object param) {

		if (node.getStruct() != null)
			if (node.getStruct() instanceof Variable)
				getVariableAddress((Variable) node.getStruct()); 
			else if (node.getStruct() instanceof StructAccess)
				getStructAddress((StructAccess) node.getStruct(), param);
			else if (node.getStruct() instanceof ArrayAccess)
				getArrayAddress((ArrayAccess) node.getStruct(), param);
			else
				node.getStruct().accept(null, param);
		
		for(Record record : ((StructType)node.getStruct().getType()).getDefinition().getRecord()){
            if(record.getName().equals(node.getName())){
                pushi(record.getAddress());
                break;
            }
		}
		
		add(IntType.getInstance());
	}
	

	

	public void getArrayAddress(ArrayAccess node, Object param) {

		if (node.getArray() != null)
			if (node.getArray() instanceof Variable)
				getVariableAddress((Variable) node.getArray()); 
			else if (node.getArray() instanceof StructAccess)
				getStructAddress((StructAccess) node.getArray(), param);
			else if (node.getArray() instanceof ArrayAccess)
				getArrayAddress((ArrayAccess) node.getArray(), param);
			else
				node.getArray().accept(null, param);
		
		if (node.getIndex() != null)
			node.getIndex().accept(this, param);
		
		pushi(node.getType().getSize());
		mul(IntType.getInstance());
		add(IntType.getInstance());
		
	}

	// Imprime una lÃ­nea en el fichero de salida
	private void out(String instruction) {
		writer.println(instruction);
	}

	/*
	private void line(AST node) {
		line(node.getEnd());
	}
	*/

	private void line(Position pos) {
		if (pos != null)
			out("\n#line " + pos.getLine());
		else
			System.out.println("#line no generado. Se ha pasado una Position null. Falta informaciÃ³n en el AST");
	}

	private PrintWriter writer;
	private String sourceFile;
}
