/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.sentences;

import ast.AbstractAST;
import ast.definitions.DefinitionFunction;

public abstract class AbstractSentence extends AbstractAST implements Sentence {

    private DefinitionFunction fatherFunction;
    private boolean hasGoodReturn;

    public DefinitionFunction getFatherFunction() {
        return fatherFunction;
    }

    public void setFatherFunction(DefinitionFunction fatherFunction) {
        this.fatherFunction = fatherFunction;
    }

    public boolean hasGoodReturn() {
		return hasGoodReturn;
	}

	public void setHasGoodReturn(boolean hasGoodReturn) {
		this.hasGoodReturn = hasGoodReturn;
	}

}
