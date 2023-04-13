/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp;



import ast.type.Type;
import visitor.*;

//	cast:exp -> newType:type  exp:exp

public class Cast extends AbstractExp {

	public Cast(Type newType, Exp exp) {
		this.newType = newType;
		this.exp = exp;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(newType, exp);
	}

	public Cast(Object newType, Object exp) {
		this.newType = (Type) getAST(newType);
		this.exp = (Exp) getAST(exp);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(newType, exp);
	}

	public Type getNewType() {
		return newType;
	}
	public void setNewType(Type newType) {
		this.newType = newType;
	}

	public Exp getExp() {
		return exp;
	}
	public void setExp(Exp exp) {
		this.exp = exp;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Type newType;
	private Exp exp;

	public String toString() {
       return "{newType:" + getNewType() + ", exp:" + getExp() + "}";
   }
}
