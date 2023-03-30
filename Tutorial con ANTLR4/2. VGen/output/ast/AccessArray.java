/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	accessArray:access -> array:access  index:expression

public class AccessArray extends AbstractAccess {

	public AccessArray(Access array, Expression index) {
		this.array = array;
		this.index = index;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, index);
	}

	public AccessArray(Object array, Object index) {
		this.array = (Access) getAST(array);
		this.index = (Expression) getAST(index);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, index);
	}

	public Access getArray() {
		return array;
	}
	public void setArray(Access array) {
		this.array = array;
	}

	public Expression getIndex() {
		return index;
	}
	public void setIndex(Expression index) {
		this.index = index;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Access array;
	private Expression index;

	public String toString() {
       return "{array:" + getArray() + ", index:" + getIndex() + "}";
   }
}
