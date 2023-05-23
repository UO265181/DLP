/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions.access;

import org.antlr.v4.runtime.*;

import ast.definitions.DefinitionVariable;
import ast.expressions.AbstractExpression;
import visitor.*;

//	expressionAccessVariable:expression, access -> name:String

public class ExpressionAccessVariable extends AbstractExpression implements Access {

	public ExpressionAccessVariable(String name) {
		this.name = name;
	}

	public ExpressionAccessVariable(Object name) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;

	public String toString() {
       return "{name:" + getName() + "}";
   }


   //TODO: docs


   private DefinitionVariable definition;

	@Override
	public DefinitionVariable getDefinition() {
		return this.definition;
	}
	
	public void setDefinition(DefinitionVariable definition) {
		this.definition = definition;
	}

}
