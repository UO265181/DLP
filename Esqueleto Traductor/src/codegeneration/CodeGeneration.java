/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;

import ast.*;
import codegeneration.generator.CodeGeneratorProvider;
import codegeneration.generator.CodeGeneratorRun;
import main.ErrorManager;

/**
 * Esta clase coordina las dos fases principales de la Generación de Código:
 *  1. Gestión de Memoria (asignación de direcciones).
 *  2. Selección de Código.
 *
 * No es necesario modificar esta clase. En su lugar, hay que modificar las clases
 * que son llamadas desde aquí: "MemoryAllocation.java" y "CodeSelection.java".
 */
public class CodeGeneration {

    private ErrorManager errorManager;

    public CodeGeneration(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    public void generate(String sourceFile, AST ast, Writer out) {
        MemoryAllocation allocator = new MemoryAllocation();
        ast.accept(allocator, null);

        CodeWriter codeWriter = new CodeWriter(out, sourceFile);

        CodeGeneratorProvider.init(codeWriter,errorManager);

        ast.accept(CodeGeneratorProvider.cgRun, null);
    }

}
