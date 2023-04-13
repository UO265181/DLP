/**
 * Tutorial de DiseÃ±o de Lenguajes de ProgramaciÃ³n
 * @author RaÃºl Izquierdo
 */

package semantic;

import java.util.HashMap;
import java.util.Map;

import ast.*;
import ast.def.FuncDef;
import ast.def.Record;
import ast.def.StructDef;
import ast.def.VarDef;
import ast.exp.FuncExp;
import ast.exp.access.Variable;
import ast.statement.FuncStatement;
import ast.type.StructType;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

   
    //varDefs[name]==∅
    //
    //varDefs[name]=varDef
    public Object visit(VarDef node, Object param) {
    	super.visit(node, param);
    	
    	VarDef definicion = varDefs.getFromTop(node.getName()); 
	    predicado(definicion == null, "Variable ya definida: " + node.getName(), node); 
	    varDefs.put(node.getName(), node); 
	    
	    return null; 
    } 
    
    
    //varDefs[name]≠∅
    //
    //variable.definition=varDefs[name]
    public Object visit(Variable node, Object param) {
    	super.visit(node, param);
    	
    	VarDef definicion = varDefs.getFromAny(node.getName()); 
	    predicado(definicion != null, "Variable no definida: " + node.getName(), node); 
	    node.setDefinition(definicion);
	    return null; 
    } 
    
    
    //structDefs[name]==∅
    //
    //structDefs[name]=structDef
    public Object visit(StructDef node, Object param) {
    	super.visit(node, param);
    	
    	StructDef definicion = structDefs.get(node.getName()); 
	    predicado(definicion == null, "Estructura ya definida: " + node.getName(), node); 
	    structDefs.put(node.getName(), node); 
	    
	    records.clear();
	    return null; 
    } 

    //structDefs[name]≠∅
    //
    //structType.definition=structDefs[name]
    public Object visit(StructType node, Object param) { 
    	super.visit(node, param);
    	
    	StructDef definicion = structDefs.get(node.getName()); 
	    predicado(definicion != null, "Estructura no definida: " + node.getName(), node); 
	    node.setDefinition(definicion); // Enlazar referencia con definición
	    return null; 
    }
    
    
    //records[name]==∅
    //
    //records[name]=record
    public Object visit(Record node, Object param) { 
    	super.visit(node, param);
    	
    	Record definicion = records.get(node.getName()); 
	    predicado(definicion == null, "Campo repetido: " + node.getName(), node); 
	    records.put(node.getName(), node); 
	    return null; 
    }
    
    
    //funcDefs[name]==∅
    //
    //funcDefs[name]=funcDef
    public Object visit(FuncDef node, Object param) { 
    	
    	varDefs.set();
    	
    	FuncDef definicion = funcDefs.get(node.getName()); 
	    predicado(definicion == null, "Función ya definida: " + node.getName(), node); 
	    funcDefs.put(node.getName(), node);
    	
    	super.visit(node, param);
    	
	     
	    
	    varDefs.reset();
	    return null; 
    } 

    //funcDefs[name]≠∅
    //
    //funcExp.definition=funcDefs[name]
    public Object visit(FuncExp node, Object param) { 
    	super.visit(node, param);
    	
    	FuncDef definicion = funcDefs.get(node.getName()); 
	    predicado(definicion != null, "Función no definida: " + node.getName(), node); 
	    node.setDefinition(definicion); // Enlazar referencia con definición
	    return null; 
    } 
    
    //funcDefs[name]≠∅
    //
    //funcStatement.definition=funcDefs[name]
    public Object visit(FuncStatement node, Object param) { 
    	super.visit(node, param);
    	
    	
    	
    	FuncDef definicion = funcDefs.get(node.getName()); 
	    predicado(definicion != null, "Procedimiento no definido: " + node.getName(), node); 
	    node.setDefinition(definicion); // Enlazar referencia con definición
	    return null; 
    } 
    


    
    
    
    private void predicado(boolean condition, String errorMessage, AST node) { 
    	 if (!condition) 
    	 error(errorMessage, node.getStart()); 
    }

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }


    private ErrorManager errorManager;
    private Map<String, FuncDef> funcDefs = new HashMap<String, FuncDef>();
    private Map<String, StructDef> structDefs = new HashMap<String, StructDef>();
    private Map<String, Record> records = new HashMap<String, Record>();
    private ContextMap<String, VarDef> varDefs = new ContextMap<String, VarDef>();
}
