/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions.constant;

import java.util.HashMap;

import org.antlr.v4.runtime.*;

import ast.expressions.AbstractExpression;
import visitor.*;

//	expressionConstantChar:expression -> value:String

public class ExpressionConstantChar extends AbstractExpression {

	public ExpressionConstantChar(String value) {
		this.value = value;


		nonSingleChars = new HashMap<String, Integer>();
		nonSingleChars.put("'\n'", 10);
	}

	public ExpressionConstantChar(Object value) {
		this.value = (value instanceof Token) ? ((Token)value).getText() : (String) value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);

		nonSingleChars = new HashMap<String, Integer>();
		nonSingleChars.put("'\\n'", 10);
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String value;

	public String toString() {
       return "{value:" + getValue() + "}";
   }

   private HashMap<String,Integer> nonSingleChars;

   public int getASCII() {

		Integer specialValue = nonSingleChars.get(getValue());
	

		if(specialValue==null)
			return value.charAt(1);
		return specialValue;
   }
}
