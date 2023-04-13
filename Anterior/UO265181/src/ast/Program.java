/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast;

import java.util.*;

import ast.def.Def;
import visitor.*;

//	program -> def:def*

public class Program extends AbstractAST  {

	public Program(List<Def> def) {
		this.def = def;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(def);
	}

	public Program(Object def) {
		this.def = this.<Def>getAstFromContexts(def);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(def);
	}

	public List<Def> getDef() {
		return def;
	}
	public void setDef(List<Def> def) {
		this.def = def;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Def> def;

	public String toString() {
       return "{def:" + getDef() + "}";
   }
}
