package codegeneration;

import java.io.PrintWriter;
import java.io.Writer;

import ast.AST;
import ast.Position;
import ast.definitions.Definition;
import ast.definitions.DefinitionStruct;
import ast.types.Type;

public class CodeWriter {

	public CodeWriter(Writer writer, String sourceFile) {
		this.writer = new PrintWriter(writer);
		this.sourceFile = sourceFile;
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

	public void ret(int ret, int localVar, int param) {
		write("ret " + ret + ", " + localVar + ", " + param);
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
		comment("Llamada a main");
		write("call main");
	}

	private int labels;

	public void label(String name) {
		write("\t" + name + ":");
	}

	public int getLabel() {
		labels++;
		return labels - 1;
	}

	private PrintWriter writer;
	private String sourceFile;



}
