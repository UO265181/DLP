/**
 * @generated VGen (for ANTLR) 1.7.2
 */

package ast.def;

import org.antlr.v4.runtime.*;

import ast.type.Type;
import visitor.*;

//	varDef:def -> name:String  type:type

public class VarDef extends AbstractDef {

	public VarDef(String name, Type type) {
		this.name = name;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public VarDef(Object name, Object type) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, type);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	private int address;
	
	private boolean isParam=false;
	private boolean isLocal=false;

    public int getAddress() {
        return address;
    }
    
    public int getSize() {
    	return getType().getSize();
    }

    public void setAddress(int address) {

    	if(isLocal) {
    		this.address = address;
    	} 
    	else {
    		if(getType().getStructDef()!=null) {
            	
            	for (Record r : getType().getStructDef().getRecord()) {
                	
            		r.setAddress(address);
            		address = address + r.getType().getSize();
                }
            	
            } else {
            	this.address = address;
            }
    	}
    	
        
    }

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private Type type;

	public String toString() {
       return "{name:" + getName() + ", type:" + getType() + "}";
   }
	
	public String toStringMAPL() {
		if(!isLocal && !isParam) {
			return "#global " +name+":"+ type.toStringMAPL();
		}
		return "";
	}

	public boolean isParam() {
		return isParam;
	}

	public void setParam(boolean isParam) {
		this.isParam = isParam;
	}

	public boolean isLocal() {
		return isLocal;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}
}
