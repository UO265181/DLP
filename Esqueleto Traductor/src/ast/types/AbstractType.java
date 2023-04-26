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
        //TODO: mejor?
        return null;
    }

    public String getSuffix() {
        //TODO: mejorar
        return null;
    }

    public Type getTypeOfTheArray() {
        return this;
    }

}
