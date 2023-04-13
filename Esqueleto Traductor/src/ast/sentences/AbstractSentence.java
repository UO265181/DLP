/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.sentences;

import ast.AbstractAST;
import ast.definitions.DefinitionFunction;

public abstract class AbstractSentence extends AbstractAST implements Sentence {

    private DefinitionFunction fatherFunction;

    public DefinitionFunction getFatherFunction() {
        return fatherFunction;
    }

    public void setFatherFunction(DefinitionFunction fatherFunction) {
        this.fatherFunction = fatherFunction;
    }

}
