/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.def;

import java.util.*;
import org.antlr.v4.runtime.*;

import ast.statement.Statement;
import ast.type.Type;
import visitor.*;

//	funcDef:def -> name:String  params:varDef*  type:type  vardef:varDef*  statement:statement*

public class FuncDef extends AbstractDef {

	public FuncDef(String name, List<VarDef> params, Type type, List<VarDef> vardef, List<Statement> statement) {
		this.name = name;
		this.params = params;
		this.type = type;
		this.vardef = vardef;
		this.statement = statement;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(params, type, vardef, statement);
	}

	public FuncDef(Object name, Object params, Object type, Object vardef, Object statement) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.params = this.<VarDef>getAstFromContexts(params);
		this.type = (Type) getAST(type);
		this.vardef = this.<VarDef>getAstFromContexts(vardef);
		this.statement = this.<Statement>getAstFromContexts(statement);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, params, type, vardef, statement);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<VarDef> getParams() {
		return params;
	}
	public void setParams(List<VarDef> params) {
		this.params = params;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public List<VarDef> getVardef() {
		return vardef;
	}
	public void setVardef(List<VarDef> vardef) {
		this.vardef = vardef;
	}

	public List<Statement> getStatement() {
		return statement;
	}
	public void setStatement(List<Statement> statement) {
		this.statement = statement;
	}
	
	
	public int getSize() {
		return 0;
	}

	public void setAddress(int address) {

		address = 4; //BP+4
	
		int acumulated=0;
		
		for(int i=params.size()-1; i>=0; i--) {
			params.get(i).setParam(true);
			params.get(i).setAddress(address+acumulated);
			acumulated = acumulated+params.get(i).getSize();
		}
		
		
		address = 0; //BP-0
		acumulated=0;
		
		for(int i=0; i<vardef.size(); i++) {
			acumulated = acumulated+vardef.get(i).getSize();
			vardef.get(i).setLocal(true);
			vardef.get(i).setAddress(address-acumulated);
		}
		
		
		
		
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<VarDef> params;
	private Type type;
	private List<VarDef> vardef;
	private List<Statement> statement;

	public String toString() {
       return "{name:" + getName() + ", params:" + getParams() + ", type:" + getType() + ", vardef:" + getVardef() + ", statement:" + getStatement() + "}";
   }

	@Override
	public String toStringMAPL() {
		return "#func " + name;
	}
}
