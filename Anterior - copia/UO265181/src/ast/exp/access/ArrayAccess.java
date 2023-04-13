/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp.access;


import ast.exp.AbstractExp;
import ast.exp.Exp;
import visitor.*;

//	arrayAccess:exp -> array:exp  index:exp

public class ArrayAccess extends AbstractExp {

	public ArrayAccess(Exp array, Exp index) {
		this.array = array;
		this.index = index;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, index);
	}

	public ArrayAccess(Object array, Object index) {
		this.array = (Exp) getAST(array);
		this.index = (Exp) getAST(index);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(array, index);
	}

	public Exp getArray() {
		return array;
	}
	public void setArray(Exp array) {
		this.array = array;
	}

	public Exp getIndex() {
		return index;
	}
	public void setIndex(Exp index) {
		this.index = index;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Exp array;
	private Exp index;

	public String toString() {
       return "{array:" + getArray() + ", index:" + getIndex() + "}";
   }
}
