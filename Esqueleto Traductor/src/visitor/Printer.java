package visitor;

/**
 * @generated VGen (for ANTLR) 1.7.2
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// package <nombre paquete>;

import ast.*;

public class Printer extends DefaultVisitor {

    private PrintWriter writer;
    private int tabCounter = 0;

    // class Program { List<Definition> definitions; }
    public Object visit(Program node, Object param) {

        try {
            writer = new PrintWriter(new FileWriter("printer.txt"));

            writer.print("//// Printer ----");
            writer.println();
            writer.println();

            if (node.getDefinitions() != null)
                for (Definition child : node.getDefinitions()) {
                    writer.println();
                    child.accept(this, param);
                }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // class DefinitionVariable { String name; Type type; }
    public Object visit(DefinitionVariable node, Object param) {

        writer.print("var "+node.getName() + ":");

        super.visit(node, param);

        writer.print( ";");

        return null;
    }

    // class DefinitionStruct { String name; List<DefinitionVariable> structFields;
    // }
    public Object visit(DefinitionStruct node, Object param) {

        writer.println();
        writer.print("struct " + node.getName() + " {");

        super.visit(node, param);

        writer.println();
        writer.print("};");

        return null;
    }

    // class StructField { String name; Type type; }
    public Object visit(StructField node, Object param) {

        writer.println();
        writer.print("\t");
        writer.print(node.getName() + ":");
        super.visit(node, param);

        writer.print(";");

        return null;
    }

    // class DefinitionFunction { String name; List<DefinitionVariable>
    // definitionFunctionParams; Type type; List<DefinitionVariable> localVariables;
    // List<Sentence> sentences; }
    public Object visit(DefinitionFunction node, Object param) {

        tabCounter++;

        writer.println();
        writer.print(node.getName() + "(");

        if (node.getDefinitionFunctionParams() != null) {
            int counter = 0;
            for (DefinitionVariable child : node.getDefinitionFunctionParams()) {
                child.accept(this, param);
                counter++;
                if (counter < node.getDefinitionFunctionParams().size())
                    writer.print(",");
            }

        }

        writer.print(")");

        if (node.getType() != null) {

            writer.print(": ");

            node.getType().accept(this, param);
        }

        writer.print(" {");

        if (node.getLocalVariables() != null)
            for (DefinitionVariable child : node.getLocalVariables()) {
                writer.println();
                for (int i = 0; i < tabCounter; i++) {
                    writer.print('\t');
                }
                child.accept(this, param);
            }

        if (node.getSentences() != null)

            writer.println();

        for (Sentence child : node.getSentences()) {
            writer.println();
            for (int i = 0; i < tabCounter; i++) {
                writer.print('\t');
            }

            child.accept(this, param);
        }

        writer.println();

        tabCounter--;

        for (int i = 0; i < tabCounter; i++) {
            writer.print('\t');
        }

        writer.print("}");

        return null;
    }

    // class TypeInt { }
    public Object visit(TypeInt node, Object param) {

        writer.print("int");

        return null;
    }

    // class TypeFloat { }
    public Object visit(TypeFloat node, Object param) {

        writer.print("float");

        return null;
    }

    // class TypeChar { }
    public Object visit(TypeChar node, Object param) {

        writer.print("char");

        return null;
    }

    // class TypeArray { String size; Type type; }
    public Object visit(TypeArray node, Object param) {

        writer.print("[" + node.getSize() + "]");

        super.visit(node, param);

        return null;
    }

    // class TypeStruct { String name; }
    public Object visit(TypeStruct node, Object param) {

        writer.print(node.getName());

        return null;
    }

    // class Print { Expression expression; }
    public Object visit(Print node, Object param) {

        writer.print("print ");

        super.visit(node, param);

        writer.print(";");

        return null;
    }

    // class Printsp { Expression expression; }
    public Object visit(Printsp node, Object param) {

        writer.print("printsp ");

        super.visit(node, param);

        writer.print(";");

        return null;
    }

    // class Println { Expression expression; }
    public Object visit(Println node, Object param) {

        writer.print("println ");

        super.visit(node, param);

        writer.print(";");

        return null;
    }

    // class Return { Expression expression; }
    public Object visit(Return node, Object param) {

        writer.print("return");

        if (node.getExpression() != null) {
            writer.print(" ");
            node.getExpression().accept(this, param);
        }

        writer.print(";");

        return null;
    }

    // class Read { Expression expression; }
    public Object visit(Read node, Object param) {

        writer.print("read ");

        super.visit(node, param);

        writer.print(";");

        return null;
    }

    // class Assignment { Expression left; Expression right; }
    public Object visit(Assignment node, Object param) {

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        writer.print(" = ");

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        writer.print(";");

        return null;
    }

    // class SentenceCallFunction { String name; List<Expression>
    // callFunctionParams; }
    public Object visit(SentenceCallFunction node, Object param) {

        writer.print(node.getName() + "(");

        if (node.getCallFunctionParams() != null) {
            int counter = 0;
            for (Expression child : node.getCallFunctionParams()) {
                child.accept(this, param);
                counter++;
                if (counter < node.getCallFunctionParams().size())
                    writer.print(",");
            }

        }
        writer.print(");");

        return null;
    }

    // class If { Expression condition; List<Sentence> ifSentences; List<Sentence>
    // elseSentences; }
    public Object visit(If node, Object param) {

        writer.print("if (");

        if (node.getCondition() != null)
            node.getCondition().accept(this, param);

        writer.print(") {");

        tabCounter++;

        if (node.getIfSentences() != null)
            for (Sentence child : node.getIfSentences()) {
                writer.println();
                for (int i = 0; i < tabCounter; i++) {
                    writer.print('\t');
                }
                child.accept(this, param);
            }

        writer.println();

        tabCounter--;

        for (int i = 0; i < tabCounter; i++) {
            writer.print('\t');
        }

        writer.print("}");

        if (node.getElseSentences() != null) {
            writer.print(" else {");
            tabCounter++;
            for (Sentence child : node.getElseSentences()) {
                writer.println();
                for (int i = 0; i < tabCounter; i++) {
                    writer.print('\t');
                }
                child.accept(this, param);
            }
            writer.println();
            tabCounter--;

            for (int i = 0; i < tabCounter; i++) {
                writer.print('\t');
            }

            writer.print("}");
        }

        return null;
    }

    // class While { Expression condition; List<Sentence> sentences; }
    public Object visit(While node, Object param) {

        writer.print("while (");

        if (node.getCondition() != null)
            node.getCondition().accept(this, param);

        writer.print(") {");

        tabCounter++;

        if (node.getSentences() != null)
            for (Sentence child : node.getSentences()) {
                writer.println();
                for (int i = 0; i < tabCounter; i++) {
                    writer.print('\t');
                }

                child.accept(this, param);
            }

        writer.println();
        tabCounter--;

        for (int i = 0; i < tabCounter; i++) {
            writer.print('\t');
        }

        writer.print("}");

        return null;
    }

    // class ConstantInt { String value; }
    public Object visit(ConstantInt node, Object param) {

        writer.print(node.getValue());

        return null;
    }

    // class ConstantFloat { String value; }
    public Object visit(ConstantFloat node, Object param) {

        writer.print(node.getValue());

        return null;
    }

    // class ConstantChar { String value; }
    public Object visit(ConstantChar node, Object param) {

        writer.print(node.getValue());

        return null;
    }

    // class ExpressionCallFunction { String name; List<Expression>
    // callFunctionParams; }
    public Object visit(ExpressionCallFunction node, Object param) {

        // super.visit(node, param);

        writer.print(node.getName() + "(");

        if (node.getCallFunctionParams() != null) {
            int counter = 0;
            for (Expression child : node.getCallFunctionParams()) {
                child.accept(this, param);
                counter++;
                if (counter < node.getCallFunctionParams().size())
                    writer.print(",");
            }
        }

        writer.print(")");

        return null;

    }

    // class AccessVariable { String name; }
    public Object visit(AccessVariable node, Object param) {

        writer.print(node.getName());

        return null;
    }

    // class AccessStructField { Expression struct; String name; }
    public Object visit(AccessStructField node, Object param) {

        super.visit(node, param);

        writer.print("." + node.getName());

        return null;
    }

    // class AccessArray { Expression array; Expression index; }
    public Object visit(AccessArray node, Object param) {

        // super.visit(node, param);

        if (node.getArray() != null)
            node.getArray().accept(this, param);

        writer.print("[");

        if (node.getIndex() != null)
            node.getIndex().accept(this, param);

        writer.print("]");

        return null;
    }

    // class UnaryExpression { String operator; Expression expression; }
    public Object visit(UnaryExpression node, Object param) {

        writer.print(node.getExpression());

        super.visit(node, param);

        return null;
    }

    // class Cast { Type type; Expression expression; }
    public Object visit(Cast node, Object param) {

        writer.print("<");

        if (node.getType() != null)
            node.getType().accept(this, param);

        writer.print(">(");

        if (node.getExpression() != null)
            node.getExpression().accept(this, param);

        writer.print(")");

        return null;
    }

    // class ArithmeticExpression { Expression left; String operator; Expression
    // right; }
    public Object visit(ArithmeticExpression node, Object param) {

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        writer.print(" ");
        writer.print(node.getOperator());
        writer.print(" ");

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    // class RelationalExpression { Expression left; String operator; Expression
    // right; }
    public Object visit(RelationalExpression node, Object param) {

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        writer.print(" ");
        writer.print(node.getOperator());
        writer.print(" ");

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }

    // class LogicalExpression { Expression left; String operator; Expression right;
    // }
    public Object visit(LogicalExpression node, Object param) {

        if (node.getLeft() != null)
            node.getLeft().accept(this, param);

        writer.print(" ");
        writer.print(node.getOperator());
        writer.print(" ");

        if (node.getRight() != null)
            node.getRight().accept(this, param);

        return null;
    }
}
