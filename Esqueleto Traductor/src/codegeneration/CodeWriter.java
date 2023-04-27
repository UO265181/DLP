package codegeneration;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;

import ast.AST;
import ast.Position;
import ast.definitions.Definition;
import ast.definitions.DefinitionStruct;
import ast.types.Type;

public class CodeWriter {

	private HashMap<String, String> operations;
	private PrintWriter writer;
	private int labels;
	private String sourceFile;


	public CodeWriter(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;
		this.operations = new HashMap<String, String>();
		
		this.operations.put("+", "add");
		this.operations.put("-", "sub");
		this.operations.put("*", "mul");
		this.operations.put("/", "div");
		this.operations.put("%", "mod");

		this.operations.put("<", "lt");
		this.operations.put(">", "gt");
		this.operations.put("<=", "le");
		this.operations.put(">=", "ge");
		this.operations.put("==", "eq");
		this.operations.put("!=", "ne");

		this.operations.put("&&", "and");
		this.operations.put("||", "or");

		this.operations.put("!", "not");
	}

	public void write(String instruction) {
		writer.println(instruction);
	}

	public void insert(String instruction) {
		writer.print(instruction);
	}

	public void insertTab() {
		insert("\t");
	}

	public void insertNewLine() {
		insert("\n");
	}

	public void line(AST node) {
		line(node.getEnd());
	}

	public void line(Position pos) {
		if (pos != null)
			write("\n#line " + pos.getLine());
		else
			System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
	}

	public void metaSource() {
		write("#SOURCE \"" + sourceFile + "\"\n");
	}

	public void comment(String comment) {
		write("'" + comment);
	}

	public void halt() {
		write("HALT");
	}

	public void in(Type type) {
		write("in" + type.getSuffix());
	}


	public void ret(int ret, int localVar, int param) {
		write("ret " + ret + ", " + localVar + ", " + param);
	}

	
	public void operation(String operator, Type type) {
		write(operations.get(operator) + type.getSuffix());
    }


	public void pushf(String value) {
		write("pushf " + value);
	}

	public void pushi(String value) {
		write("pushi " + value);
	}

	public void pushi(int value) {
		write("pushi " + value);
	}

	public void pushb(int value) {
		write("pushb " + value);
	}

	public void out(Type type) {
		write("out" + type.getSuffix());
	}

	public void pusha(int address) {
		write("pusha " + address);
	}

	public void load(Type type) {
		write("load" + type.getSuffix());
	}

	public void store(Type type) {
		write("store" + type.getSuffix());
	}

	public void cast(Type type, Type newType) {
		write(type.getExplicitSuffix()+"2"+newType.getExplicitSuffix());
    }

	public void pushOutNewLine() {
		write("pushb 10");
		write("outb");
	}

	public void pushOutSpace() {
		write("pushb 32");
		write("outb");
	}

	public void mul() {
		write("mul");
    }

	public void add() {
		write("add");
    }

	public void enter(int size) {
		write("enter " + size);
	}

	public void call(String function) {
		write("call " + function);
	}

	public void jmp(String label) {
		write("jmp " + label);
	}

	public void jz(String label) {
		write("jz " + label);
	}

	public void jnz(String label) {
		write("jnz " + label);
	}

	public void callMain() {
		write("call main");
	}


	public void label(String name) {
		write(name + ":");
	}

	public int getLabel() {
		labels++;
		return labels - 1;
	}

    public void metaFunc(String name) {
		write("#FUNC "+ name);
    }

    public void metaRet(Type type) {
		write("#RET "+ type.toStringMAPL());
    }









}
