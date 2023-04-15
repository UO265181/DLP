/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import ast.definitions.Definition;
import ast.definitions.DefinitionFunction;
import ast.definitions.DefinitionStruct;
import ast.definitions.DefinitionVariable;
import ast.definitions.StructField;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

	private final static int INITIAL_ADDRESS = 0;
	private int currentAddress;

	// class Programa { List<DefVariable> definiciones; List<Sentencia> sentencias;
	// }
	public Object visit(Program node, Object param) {

		currentAddress = INITIAL_ADDRESS;

		super.visit(node, param);

		return null;
	}

	public Object visit(DefinitionVariable node, Object param) {

		node.setAddress(currentAddress);
		currentAddress += node.getMemorySize();


		return null;
	}

	public Object visit(DefinitionFunction node, Object param) {

		node.calculateAdresses();

		return null;
	}




	// class StructDef { String name; List<Record> record; }
	public Object visit(DefinitionStruct node, Object param) {

		int realtiveAddress = 0;

		for (StructField field : node.getStructFields()) {
			field.setAddress(realtiveAddress);
			realtiveAddress += field.getMemorySize();
		}

		return null;
	}

}
