/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.types;

import ast.AbstractAST;

public abstract class AbstractType extends AbstractAST implements Type {

    private boolean primitive;

    public boolean isPrimitive() {
        return false;
    }

    public void setPrimitive(boolean primitive) {
        this.primitive=primitive;
    }

}
