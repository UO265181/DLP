/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.expressions.access;

import org.antlr.v4.runtime.*;

import ast.definitions.DefinitionVariable;
import ast.expressions.AbstractExpression;
import ast.expressions.Expression;
import visitor.*;

//	expressionStructField:expression -> struct:expression  name:String

public class ExpressionStructField extends AbstractExpression {

	public ExpressionStructField(Expression struct, String name) {
		this.struct = struct;
		this.name = name;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(struct);
	}

	public ExpressionStructField(Object struct, Object name) {
		this.struct = (Expression) getAST(struct);
		this.name = (name instanceof Token) ? ((Token) name).getText() : (String) name;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(struct, name);
	}

	public Expression getStruct() {
		return struct;
	}

	public void setStruct(Expression struct) {
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

	private Expression struct;
	private String name;

	public String toString() {
		return "{struct:" + getStruct() + ", name:" + getName() + "}";
	}

	@Override
	public DefinitionVariable getDefinitionVariable() {
		return getStruct().getDefinitionVariable();
	}

}
