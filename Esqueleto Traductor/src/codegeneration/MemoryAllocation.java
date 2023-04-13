/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import ast.definitions.Definition;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

    // class Programa { List<DefVariable> definiciones; List<Sentencia> sentencias; }
    public Object visit(Program node, Object param) {
    	
        int currentAddress = 0;
        
        for (Definition definition : node.getDefinitions()) {
        	
        	int size = definition.getSize();
        	
        	if(size!=-1) {
        		definition.setAddress(currentAddress);
        		currentAddress += size;
        	}
        }
        
        
        super.visit(node, param);
        
        return null;
    }
    
    
    //	class StructDef { String name;  List<Record> record; }
	public Object visit(StructDef node, Object param) {
		
		int currentAddress = 0;
		
		if (node.getRecord() != null)
			for (Record child : node.getRecord()) {
				child.setAddress(currentAddress);
				currentAddress += child.getType().getSize();
			}

		return null;
	}

}
