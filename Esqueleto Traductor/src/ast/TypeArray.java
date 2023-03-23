/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	typeArray:type -> size:constantInt  type:type

public class TypeArray extends AbstractType {

	public TypeArray(ConstantInt size, Type type) {
		this.size = size;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public TypeArray(Object size, Object type) {
		this.size = (ConstantInt) getAST(size);
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(size, type);
	}

	public ConstantInt getSize() {
		return size;
	}
	public void setSize(ConstantInt size) {
		this.size = size;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private ConstantInt size;
	private Type type;

	public String toString() {
       return "{size:" + getSize() + ", type:" + getType() + "}";
   }
}
