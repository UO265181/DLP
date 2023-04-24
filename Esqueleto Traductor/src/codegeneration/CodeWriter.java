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

    public void out(String instruction) {
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
            out("\n#line " + pos.getLine());
        else
            System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
    }

    public void metaSource() {
		out("#SOURCE \"" + sourceFile + "\"\n");
	}

    public void comment(String comment) {
		out("'" + comment);
	}

    public void halt() {
		out("HALT");
	}

	public void ret(int ret, int localVar, int param) {
		out("ret " + ret + ", " + localVar + ", " + param);
	}

	public void push(Type type) {
		out("push" + type.getSuffix());
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

    private int labels;

	public void label(String name) {
		out("\t" + name + ":");
	}

	public int getLabel() {
		labels++;
		return labels - 1;
	}

    private PrintWriter writer;
    private String sourceFile;


}
