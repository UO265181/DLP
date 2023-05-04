/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;

import ast.AbstractAST;
import ast.definitions.DefinitionStruct;

public abstract class AbstractType extends AbstractAST implements Type {

    public boolean isPrimitive() {
        return false;
    }


    public DefinitionStruct getDefinitionStruct() {
        throw new IllegalStateException("Llamada a una estructura no definida: " + this.toString());
    }

    public String getSuffix() {
        throw new IllegalStateException("Llamada a un sufijo no definido: " + this.toString());
    }

    public String getExplicitSuffix() {
        throw new IllegalStateException("Llamada a un sufijo no definido: " + this.toString());
    }

    public Type getTypeOfTheArray() {
        return TypeError.getInstance();
    }


}
