/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;

import ast.AST;
import ast.definitions.DefinitionStruct;

public interface Type extends AST {

    boolean isPrimitive();
    /**
     * Solo para tipos primitivos, void y error
     * @param type
     * @return
     */
    boolean isSameType(Type type);
    DefinitionStruct getDefinitionStruct();
    int getMemorySize();
    String toStringMAPL();
    String getSuffix();
    String getExplicitSuffix();
    Type getTypeOfTheArray();

}
