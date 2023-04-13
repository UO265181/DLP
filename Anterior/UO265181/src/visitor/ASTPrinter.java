/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package visitor;

import java.io.*;

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

/**
 * ASTPrinter. Utilidad que ayuda a validar un arbol AST:
 * - Muestra la estructura del árbol en HTML.
 * - Destaca los hijos/propiedades a null.
 * - Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna)
 *      ayudando a decidir cual de ellas usar en los errores y generación de código.
 *
 * Esta clase se genera con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */
public class ASTPrinter extends DefaultVisitor {

    /**
     * toHtml. Muestra la estructura del AST indicando qué hay en las posiciones
     * (línea y columna) de cada nodo.
     *
     * @param sourceFile El fichero del cual se ha obtenido el AST
     * @param raiz       El AST creado a partir de sourceFile
     * @param filename   Nombre del fichero HMTL a crear con la traza del AST
     */

    public static void toHtml(String sourceFile, AST raiz, String filename) {
        toHtml(sourceFile, raiz, filename, 4);
    }

    public static void toHtml(AST raiz, String filename) {
        toHtml(null, raiz, filename);
    }

    // tabWidth deberían ser los espacios correspondientes a un tabulador en eclipse.
    // Normalmente no sería necesario especificarlo. Usar mejor los dos métodos anteriores.

    public static void toHtml(String sourceFile, AST raiz, String filename, int tabWidth) {
        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(filename.endsWith(".html") ? filename : filename + ".html"));
            generateHeader(writer);
            writer.println("[ASTPrinter] -------------------------------- line:col  line:col");
            if (raiz != null) {
                ASTPrinter tracer = new ASTPrinter(writer, loadLines(sourceFile, tabWidth));
                raiz.accept(tracer, Integer.valueOf(0));
            } else
                writer.println("raiz == null");
            writer.println(ls + ls + "[ASTPrinter] --------------------------------");
            generateFooter(writer);
            writer.close();
            System.out.println(ls + "ASTPrinter: Fichero '" + filename
                    + ".html' generado. Abra dicho fichero para validar el AST generado.");
        } catch (IOException e) {
            System.out.println(ls + "ASTPrinter: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private static void generateHeader(PrintWriter writer) {
        writer.println("<html>\r\n"
            + "<head>\r\n"
            + "<meta charset=\"utf-8\" />\r\n"
            + "<style type=\"text/css\">\r\n"
            + ".value { font-weight: bold; }\r\n"
            + ".dots { color: #bebdbd; }\r\n"
            + ".type { color: #BBBBBB; }\r\n"
            + ".pos { color: #CCCCCC; }\r\n"
            + ".sourceText { color: #BBBBBB; }\r\n"
            + ".posText {\r\n" + "	color: #BBBBBB;\r\n"
            + "	text-decoration: underline; font-weight: bold;\r\n"
            + "}\r\n"
            + ".null {\r\n"
            + "	color: #FF0000;\r\n"
            + "	font-weight: bold;\r\n"
            + "	font-style: italic;\r\n" + "}\r\n"
            + "</style>\r\n" + "</head>\r\n" + "\r\n"
            + "<body><pre>");
    }

    private static void generateFooter(PrintWriter writer) {
        writer.println("</pre>\r\n" + "</body>\r\n" + "</html>");
    }

    private ASTPrinter(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
        this.sourceLines = sourceLines;
    }

    // ----------------------------------------------
	//	class Program { List<Def> def; }
	public Object visit(Program node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Program", node, false);

		visit(indent + 1, "def", "List<Def>",node.getDef());
		return null;
	}

	//	class VarDef { String name;  Type type; }
	public Object visit(VarDef node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "VarDef", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		
		print(indent + 1, "address", "int", node.getAddress());
		
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "IntType", node, true);

		return null;
	}

	//	class FloatType {  }
	public Object visit(FloatType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "FloatType", node, true);

		return null;
	}

	//	class CharType {  }
	public Object visit(CharType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "CharType", node, true);

		return null;
	}

	//	class ArrayType { String size;  Type type; }
	public Object visit(ArrayType node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ArrayType", node, false);

		print(indent + 1, "size", "String", node.getArraySize());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class StructType { String name; }
	public Object visit(StructType node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "StructType", node, "name", node.getName());
		return null;
	}

	//	class StructDef { String name;  List<Record> record; }
	public Object visit(StructDef node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "StructDef", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "record", "List<Record>",node.getRecord());
		return null;
	}

	//	class Record { String name;  Type type; }
	public Object visit(Record node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Record", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "type", "Type",node.getType());
		return null;
	}

	//	class FuncDef { String name;  List<VarDef> params;  Type type;  List<VarDef> vardef;  List<Statement> statement; }
	public Object visit(FuncDef node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "FuncDef", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "params", "List<VarDef>",node.getParams());
		visit(indent + 1, "type", "Type",node.getType());
		visit(indent + 1, "vardef", "List<VarDef>",node.getVardef());
		visit(indent + 1, "statement", "List<Statement>",node.getStatement());
		return null;
	}

	//	class Assignment { Exp left;  Exp right; }
	public Object visit(Assignment node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Assignment", node, false);

		visit(indent + 1, "left", "Exp",node.getLeft());
		visit(indent + 1, "right", "Exp",node.getRight());
		return null;
	}

	//	class Return { Exp exp; }
	public Object visit(Return node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Return", node, false);

		visit(indent + 1, "exp", "Exp",node.getExp());
		return null;
	}

	//	class Print { Exp exp; }
	public Object visit(Print node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Print", node, false);

		visit(indent + 1, "exp", "Exp",node.getExp());
		return null;
	}

	//	class Printsp { Exp exp; }
	public Object visit(Printsp node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Printsp", node, false);

		visit(indent + 1, "exp", "Exp",node.getExp());
		return null;
	}

	//	class Println { Exp exp; }
	public Object visit(Println node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Println", node, false);

		visit(indent + 1, "exp", "Exp",node.getExp());
		return null;
	}

	//	class Read { Exp exp; }
	public Object visit(Read node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Read", node, false);

		visit(indent + 1, "exp", "Exp",node.getExp());
		return null;
	}

	//	class While { Exp condition;  List<Statement> statement; }
	public Object visit(While node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "While", node, false);

		visit(indent + 1, "condition", "Exp",node.getCondition());
		visit(indent + 1, "statement", "List<Statement>",node.getStatement());
		return null;
	}

	//	class If { Exp condition;  List<Statement> ifst;  List<Statement> elsest; }
	public Object visit(If node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "If", node, false);

		visit(indent + 1, "condition", "Exp",node.getCondition());
		visit(indent + 1, "ifst", "List<Statement>",node.getIfst());
		visit(indent + 1, "elsest", "List<Statement>",node.getElsest());
		return null;
	}

	//	class FuncStatement { String name;  List<Exp> params; }
	public Object visit(FuncStatement node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "FuncStatement", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "params", "List<Exp>",node.getParams());
		return null;
	}

	//	class ArithmeticExpression { Exp left;  String operator;  Exp right; }
	public Object visit(ArithmeticExpression node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ArithmeticExpression", node, false);

		visit(indent + 1, "left", "Exp",node.getLeft());
		print(indent + 1, "operator", "String", node.getOperator());
		visit(indent + 1, "right", "Exp",node.getRight());
		return null;
	}

	//	class RelationalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(RelationalExpression node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "RelationalExpression", node, false);

		visit(indent + 1, "left", "Exp",node.getLeft());
		print(indent + 1, "operator", "String", node.getOperator());
		visit(indent + 1, "right", "Exp",node.getRight());
		return null;
	}

	//	class LogicalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(LogicalExpression node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "LogicalExpression", node, false);

		visit(indent + 1, "left", "Exp",node.getLeft());
		print(indent + 1, "operator", "String", node.getOperator());
		visit(indent + 1, "right", "Exp",node.getRight());
		return null;
	}

	//	class Cast { Type newType;  Exp exp; }
	public Object visit(Cast node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Cast", node, false);

		visit(indent + 1, "newType", "Type",node.getNewType());
		visit(indent + 1, "exp", "Exp",node.getExp());
		return null;
	}

	//	class FuncExp { String name;  List<Exp> params; }
	public Object visit(FuncExp node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "FuncExp", node, false);

		print(indent + 1, "name", "String", node.getName());
		visit(indent + 1, "params", "List<Exp>",node.getParams());
		return null;
	}

	//	class StructAccess { Exp struct;  String name; }
	public Object visit(StructAccess node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "StructAccess", node, false);

		visit(indent + 1, "struct", "Exp",node.getStruct());
		print(indent + 1, "name", "String", node.getName());
		return null;
	}

	//	class ArrayAccess { Exp array;  Exp index; }
	public Object visit(ArrayAccess node, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ArrayAccess", node, false);

		visit(indent + 1, "array", "Exp",node.getArray());
		visit(indent + 1, "index", "Exp",node.getIndex());
		return null;
	}

	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Variable", node, "name", node.getName());
		return null;
	}

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "IntConstant", node, "value", node.getValue());
		return null;
	}

	//	class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "RealConstant", node, "value", node.getValue());
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "CharConstant", node, "value", node.getValue());
		return null;
	}


	// -----------------------------------------------------------------
	// Métodos invocados desde los métodos visit -----------------------

	private void printName(int indent, String name, AST node, boolean empty) {
		String text = ls + tabula(indent) + name + " &rarr;  ";
		text = String.format("%1$-" + 93 + "s", text);
		if (empty)
			text = text.replace(name, valueTag(name));
		writer.print(text + getPosition(node));
	}

	private void print(int indent, String name, String type, Object value) {
		write(indent, formatValue(value) + "  " + typeTag(type));
	}

	@SuppressWarnings("unused")
	private void print(int indent, String attName, String type, List<? extends Object> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (Object child : children)
				write(indent + 1, formatValue(child));
		else
			writer.print(" " + valueTag(null));
	}

	// Versión compacta de una linea para nodos que solo tienen un atributo String
	private void printCompact(int indent, String nodeName, AST node, String attName, Object value) {
		String fullName = nodeName + '.' + attName;
		String text = ls + tabula(indent) + '\"' + value + "\"  " + fullName;
		text = String.format("%1$-" + 88 + "s", text);
		// text = text.replace(value.toString(), valueTag(value));
		text = text.replace(fullName, typeTag(fullName));
		writer.print(text + getPosition(node));
	}

	private void visit(int indent, String attName, String type, List<? extends AST> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (AST child : children)
				child.accept(this, indent + 1);
		else
			writer.print(" " + valueTag(null));
	}

	private void visit(int indent, String attName, String type, AST child) {
		if (child != null)
			child.accept(this, Integer.valueOf(indent));
		else
			write(indent, valueTag(null) + "  " + attName + ':' + typeTag(type));
	}

	// -----------------------------------------------------------------
	// Métodos auxiliares privados -------------------------------------

	private void write(int indent, String text) {
		writer.print(ls + tabula(indent) + text);
	}

	private static String tabula(int count) {
		StringBuffer cadena = new StringBuffer("<span class=\"dots\">");
		for (int i = 0; i < count; i++)
			cadena.append(i % 2 == 0 && i > 0 ? "|  " : ".  ");
		return cadena.toString() + "</span>";
	}

	private String typeTag(String type) {
		if (type.equals("String"))
			return "";
		return "<span class=\"type\">" + type.replace("<", "&lt;").replace(">", "&gt;") + "</span>";
	}

	private String valueTag(Object value) {
		if (value == null)
			return "<span class=\"null\">null</span>";
		return "<span class=\"value\">" + value + "</span>";
	}

	private String formatValue(Object value) {
		String text = valueTag(value);
		if (value instanceof String)
			text = "\"" + text + '"';
		return text;
	}


	// -----------------------------------------------------------------
	// Métodos para mostrar las Posiciones -----------------------------

	private String getPosition(AST node) {
		String text = node.getStart() + "  " + node.getEnd();
		text = "<span class=\"pos\">" + String.format("%1$-" + 13 + "s", text) + "</span>";
		text = text.replace("null", "<span class=\"null\">null</span>");
		String sourceText = findSourceText(node);
		if (sourceText != null)
			text += sourceText;
		return text;
	}

	private String findSourceText(AST node) {
		if (sourceLines == null)
			return null;

		Position start = node.getStart();
		Position end = node.getEnd();
		if (start == null || end == null)
			return null;

		String afterText, text, beforeText;
		if (start.getLine() == end.getLine()) {
			String line = sourceLines.get(start.getLine() - 1);
			afterText = line.substring(0, start.getColumn() - 1);
			text = line.substring(start.getColumn() - 1, end.getColumn());
			beforeText = line.substring(end.getColumn());
		} else {
			String firstLine = sourceLines.get(start.getLine() - 1);
			String lastLine = sourceLines.get(end.getLine() - 1);

			afterText = firstLine.substring(0, start.getColumn() - 1);

			text = firstLine.substring(start.getColumn() - 1);
			text += "</span><span class=\"sourceText\">" + " ... " + "</span><span class=\"posText\">";
			text += lastLine.substring(0, end.getColumn()).replaceAll("^\\s+", "");

			beforeText = lastLine.substring(end.getColumn());
		}
		return "<span class=\"sourceText\">" + afterText.replaceAll("^\\s+", "")
				+ "</span><span class=\"posText\">" + text
				+ "</span><span class=\"sourceText\">" + beforeText + "</span>";
	}

	private static List<String> loadLines(String sourceFile, int tabWidth) {
		if (sourceFile == null)
			return null;
		try {
			
			@SuppressWarnings("unused")
			String spaces = new String(new char[tabWidth]).replace("\0", " ");

			List<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			String line;
			while ((line = br.readLine()) != null) {
			//	lines.add(line.replace("\t", spaces)); // Si tab = 4 espaces (Eclipse)
				lines.add(line);
            }
			br.close();
			return lines;
		} catch (FileNotFoundException e) {
			System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		} catch (IOException e) {
			System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		}
	}


	private List<String> sourceLines;
	private static String ls = System.getProperty("line.separator");
	private PrintWriter writer;
}
