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

		storeIntValue();

	}

	public ExpressionConstantChar(Object value) {
		this.value = (value instanceof Token) ? ((Token) value).getText() : (String) value;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(value);

		storeIntValue();
	}

	private void storeIntValue() {

		specialValues = new HashMap<String, Integer>();
		specialValues.put("'\\n\'", 10);

		Integer specialValue = specialValues.get(getValue());

		if (specialValue == null)
			setIntValue(value.charAt(1));
		else {
			setIntValue(specialValue);
		}
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

	private HashMap<String, Integer> specialValues;

	private int intValue;

	private void setIntValue(int value) {
		this.intValue = value;
	}

	public int getIntValue() {
		return intValue;
	}
}
