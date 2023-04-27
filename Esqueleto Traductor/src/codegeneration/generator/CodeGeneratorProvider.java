package codegeneration.generator;

import codegeneration.CodeWriter;
import main.ErrorManager;

public class CodeGeneratorProvider {

    public static CodeGeneratorRun cgRun;
    public static CodeGeneratorValue cgValue;
    public static CodeGeneratorAddress cgAddress;
    public static CodeGeneratorDefine cgDefine;
    public static CodeGeneratorDefineLocalVariable cgDefineLocalVariable;
    public static CodeGeneratorDefineParam cgDefineParam;
    public static CodeGeneratorExecute cgExecute;

    public static void init(CodeWriter codeWriter, ErrorManager errorManager) {
        CodeGeneratorProvider.cgRun = new CodeGeneratorRun(codeWriter, errorManager);
        CodeGeneratorProvider.cgValue = new CodeGeneratorValue(codeWriter, errorManager);
        CodeGeneratorProvider.cgAddress = new CodeGeneratorAddress(codeWriter, errorManager);
        CodeGeneratorProvider.cgDefine = new CodeGeneratorDefine(codeWriter, errorManager);
        CodeGeneratorProvider.cgDefineLocalVariable = new CodeGeneratorDefineLocalVariable(codeWriter,
                errorManager);
        CodeGeneratorProvider.cgDefineParam = new CodeGeneratorDefineParam(codeWriter, errorManager);
        CodeGeneratorProvider.cgExecute = new CodeGeneratorExecute(codeWriter, errorManager);
    }

}
