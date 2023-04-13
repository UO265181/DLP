/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.def;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	structDef:def -> name:String  record:record*

public class StructDef extends AbstractDef {

	public StructDef(String name, List<Record> record) {
		this.name = name;
		this.record = record;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(record);
	}

	public StructDef(Object name, Object record) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.record = this.<Record>getAstFromContexts(record);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, record);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Record> getRecord() {
		return record;
	}
	public void setRecord(List<Record> record) {
		this.record = record;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Record> record;

	public String toString() {
       return "{name:" + getName() + ", record:" + getRecord() + "}";
   }
	
	public String toStringMAPL() {
		 String toString = "#type "+ name + ":" + "{ \n";
		 for(Record r: record) {
			 toString+=r.toStringMAPL();
			 toString+="\n";
		 }
		 toString+="\n";
		 toString+="}";
		 return toString;
	}
}
