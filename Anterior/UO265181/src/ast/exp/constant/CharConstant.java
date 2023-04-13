/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp.constant;

import org.antlr.v4.runtime.*;

import ast.exp.AbstractExp;
import visitor.*;

//	charConstant:exp -> value:String

public class CharConstant extends AbstractExp {

	public CharConstant(String value) {
		this.value = value;
	}

	public CharConstant(Object value) {
		this.value = (value instanceof Token) ? ((Token)value).getText() : (String) value;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(value);
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
}
