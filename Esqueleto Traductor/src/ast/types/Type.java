/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;

import ast.AST;
import ast.definitions.DefinitionStruct;

public interface Type extends AST {

    boolean isPrimitive();
    boolean isSameType(Type type);
    Type getType();
    DefinitionStruct getDefinitionStruct();
    int getMemorySize();
    String toStringMAPL();
    String getSuffix();

}
