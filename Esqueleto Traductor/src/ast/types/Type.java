/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;

import ast.AST;
import ast.definitions.DefinitionStruct;

public interface Type extends AST {

    boolean isPrimitive();
    /**
     * Tipos primitivos, void y error son Singleton. 
     * Struct compara nombre de la definición. 
     * Array compara referencia.
     * @param type
     * @return
     */
    boolean isSameType(Type type);
    DefinitionStruct getDefinitionStruct();
    int getMemorySize();
    String toStringMAPL();
    String getSuffix();
    String getExplicitSuffix();
    /**
     * Devuelve el tipo de este tipo (que se presupone array)
     * @return TypeError si no es array
     * @return El tipo de este array
     */
    Type getTypeOfTheArray();

}
