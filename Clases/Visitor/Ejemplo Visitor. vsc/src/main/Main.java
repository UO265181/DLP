package main;

import AST.*;
import Visitor.*;
import recursivo.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // ----------------------------------------------------
        // # Parte 1. Crear un AST

        // read a;
        // print a + b;

        List<Sentencia> sentencias = new ArrayList<Sentencia>();
        sentencias.add(new Read(new RefVar("a")));

        Suma suma = new Suma(new RefVar("a"), new RefVar("b"));
        sentencias.add(new Print(suma));

        Programa prog = new Programa(sentencias);

        // ----------------------------------------------------
        // # Parte 2. Recorrerlo

        // A. Recorrido Recursivo
        RecorridoRecursivo recursivo = new RecorridoRecursivo();
        recursivo.visit(prog);

        // B. Recorrido Ideal
        // ideal bad = new VersionIdeal(); // No compila
        // ideal.visit(prog);

        // C. Patrón Visitor
        PrintVisitor visitor = new PrintVisitor();
        visitor.visit(prog, null);
    }
}
