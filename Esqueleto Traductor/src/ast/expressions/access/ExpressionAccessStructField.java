/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions.access;

import org.antlr.v4.runtime.*;

import ast.definitions.DefinitionVariable;
import ast.expressions.AbstractExpression;
import visitor.*;

//	expressionAccessStructField:expression, access -> struct:expression  name:String

public class ExpressionAccessStructField extends AbstractExpression implements Access {

	public ExpressionAccessStructField(Access struct, String name) {
		this.struct = struct;
		this.name = name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct);
	}

	public ExpressionAccessStructField(Object struct, Object name) {
		this.struct = (Access) getAST(struct);
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(struct, name);
	}

	public Access getStruct() {
		return struct;
	}
	public void setStruct(Access struct) {
		this.struct = struct;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Access struct;
	private String name;

	public String toString() {
       return "{struct:" + getStruct() + ", name:" + getName() + "}";
   }

	@Override
	public DefinitionVariable getDefinition() {
		return this.struct.getDefinition();
	}
}
