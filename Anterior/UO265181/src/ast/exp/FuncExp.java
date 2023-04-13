/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.exp;

import java.util.*;
import org.antlr.v4.runtime.*;

import ast.def.FuncDef;
import visitor.*;

//	funcExp:exp -> name:String  params:exp*

public class FuncExp extends AbstractExp {
	
	private FuncDef definition;

	public FuncExp(String name, List<Exp> params) {
		this.name = name;
		this.params = params;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params);
	}

	public FuncExp(Object name, Object params) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.params = this.<Exp>getAstFromContexts(params);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, params);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Exp> getParams() {
		return params;
	}
	public void setParams(List<Exp> params) {
		this.params = params;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Exp> params;

	public String toString() {
       return "{name:" + getName() + ", params:" + getParams() + "}";
   }

	public FuncDef getDefinition() {
		return definition;
	}

	public void setDefinition(FuncDef definition) {
		this.definition = definition;
	}
}
