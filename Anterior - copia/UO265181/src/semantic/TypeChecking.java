/**
 * Tutorial de DiseÃ±o de Lenguajes de ProgramaciÃ³n
 * @author RaÃºl Izquierdo
 */

package semantic;

import ast.*;
import ast.def.FuncDef;
import ast.def.Record;
import ast.def.StructDef;
import ast.def.VarDef;
import ast.exp.ArithmeticExpression;
import ast.exp.Cast;
import ast.exp.FuncExp;
import ast.exp.LogicalExpression;
import ast.exp.RelationalExpression;
import ast.exp.access.ArrayAccess;
import ast.exp.access.StructAccess;
import ast.exp.access.Variable;
import ast.exp.constant.CharConstant;
import ast.exp.constant.IntConstant;
import ast.exp.constant.RealConstant;
import ast.statement.Assignment;
import ast.statement.FuncStatement;
import ast.statement.If;
import ast.statement.Print;
import ast.statement.Println;
import ast.statement.Printsp;
import ast.statement.Read;
import ast.statement.Return;
import ast.statement.Statement;
import ast.statement.While;
import ast.type.ArrayType;
import ast.type.Type;
import ast.type.primitive.CharType;
import ast.type.primitive.FloatType;
import ast.type.primitive.IntType;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    
    
    //	class ArrayType { String size;  Type type; }
	public Object visit(ArrayType node, Object param) {
		super.visit(node, param);
		
		
		//?¿?¿?¿?
		
		Integer size = null;
		
		try {
			size = Integer.parseInt(node.getArraySize());
		} catch (Error e) {}
		
		predicado(size!=null, "El tamaño debe ser un entero", node);
		
		node.setIntegerSizeOfArray(size);
		
	
		return null;
	}
    
	//	class FuncDef { String name;  List<VarDef> params;  Type type;  List<VarDef> vardef;  List<Statement> statement; }
	public Object visit(FuncDef node, Object param) {
		
		
		if (node.getParams() != null)
			for (VarDef child : node.getParams()) {
				child.accept(this, param);
				predicado(child.getType().isPrimitive(),"El tipo de los parámetros ha de ser simple", node);
			}

		if (node.getType() != null)
			node.getType().accept(this, param);

		if (node.getVardef() != null)
			for (VarDef child : node.getVardef()) 
				child.accept(this, param);
		
		if (node.getStatement() != null)
			for (Statement child : node.getStatement()) {
				if(child.getReturn()!=null) 
					child.getReturn().setFuncAm(node);
				child.accept(this, param);
			}

		if(node.getType()!=null)
			predicado(node.getType().isPrimitive(),"El retorno de la función ha de ser simple", node);

		return null;
	}
	
	
	//	class Return { Exp exp; }
	public Object visit(Return node, Object param) {
		super.visit(node, param);

		
		if(node.getFuncAm().getType()==null)
			predicado(node.getExp()==null,"No debe retornar ningún valor", node);
		else
			if(node.getExp()!=null) {
				predicado(node.getExp().getType().isSameType(node.getFuncAm().getType()),"El valor de retorno debe coincidir con el de la función", node);
			} else {
				predicado(false,"Debe retornar un valor", node);
			}
			


		return null;
	}
   
    
    //	class Assignment { Exp left;  Exp right; }
	public Object visit(Assignment node, Object param) {
		super.visit(node, param);
		
		predicado(node.getLeft().getType().isPrimitive(),"Valor de la izquierda debe ser simple", node);
		predicado(node.getLeft().isModificable(),"Valor de la izquierda no modificable", node);
		predicado(node.getLeft().getType()==node.getRight().getType(), "Valores de distinto tipo", node);
		

		return null;
	}
    
	
	//	class FuncStatement { String name;  List<Exp> params; }
	public Object visit(FuncStatement node, Object param) {

		super.visit(node, param);
		
		boolean mismoTipo = true, mismoNum = node.getParams().size()==node.getDefinition().getParams().size();
		
		if(mismoNum) {
			for(int i=0; i<node.getParams().size(); i++) {
				if(!node.getParams().get(i).getType().isSameType(node.getDefinition().getParams().get(i).getType()))
					mismoTipo=false;
			}
		}
		
		predicado(mismoNum,"Debe tener el mismo número de parámetros", node);
		predicado(mismoTipo, "Los parámetros han de ser del mismo tipo", node);
		
		
		return null;
	}
	
	
	
	
	
	
	
	//	class Print { Exp exp; }
	public Object visit(Print node, Object param) {
		super.visit(node, param);

		if(node.getExp()!=null) {
			predicado(node.getExp().getType().isPrimitive(),"Debe ser un tipo simple", node);
		}

		return null;
	}

	//	class Printsp { Exp exp; }
	public Object visit(Printsp node, Object param) {
		super.visit(node, param);

		if(node.getExp()!=null) {
			predicado(node.getExp().getType().isPrimitive(),"Debe ser un tipo simple", node);
		}

		return null;
	}

	//	class Println { Exp exp; }
	public Object visit(Println node, Object param) {
		super.visit(node, param);

		if(node.getExp()!=null) {
			predicado(node.getExp().getType().isPrimitive(),"Debe ser un tipo simple", node);
		}

		return null;
	}

	//	class Read { Exp exp; }
	public Object visit(Read node, Object param) {
		super.visit(node, param);

		predicado(node.getExp().isModificable(),"Debe ser modificable", node);
		predicado(node.getExp().getType().isPrimitive(),"Debe ser un tipo simple", node);

		return null;
	}
	
	
	
//	class While { Exp condition;  List<Statement> statement; }
	public Object visit(While node, Object param) {
		super.visit(node, param);
		
		predicado(node.getCondition().getType()==IntType.getInstance(),"Debe ser de tipo entero", node);

		return null;
	}

	//	class If { Exp condition;  List<Statement> ifst;  List<Statement> elsest; }
	public Object visit(If node, Object param) {
		super.visit(node, param);

		predicado(node.getCondition().getType()==IntType.getInstance(),"Debe ser de tipo entero", node);
		
		return null;
	}
	
	
	
	//	class FuncExp { String name;  List<Exp> params; }
	public Object visit(FuncExp node, Object param) {
		super.visit(node, param);
		
		boolean mismoTipo = true, mismoNum = node.getParams().size()==node.getDefinition().getParams().size();
		
		if(mismoNum) {
			for(int i=0; i<node.getParams().size(); i++) {
				if(!node.getParams().get(i).getType().isSameType(node.getDefinition().getParams().get(i).getType()))
					mismoTipo=false;
			}
		}
		
		predicado(node.getDefinition().getType()!=null, "La función debe tener tipo de retorno", node);
		predicado(mismoNum,"Debe tener el mismo número de parámetros", node);
		predicado(mismoTipo, "Los parámetros han de ser del mismo tipo", node);
		
		
		node.setModificable(false);
		node.setType(node.getDefinition().getType());

		return null;
	}
	
	
	//	class ArithmeticExpression { Exp left;  String operator;  Exp right; }
	public Object visit(ArithmeticExpression node, Object param) {
		super.visit(node, param);
		
		if(node.getOperator().matches("[+-\\\\*/]")) {
			predicado(node.getLeft().getType()==IntType.getInstance() || node.getLeft().getType()==FloatType.getInstance(),"Deben ser de tipo entero o real", node);
		}
		if(node.getOperator().equals("%")) {
			predicado(node.getLeft().getType()==IntType.getInstance(),"Debe ser de tipo entero", node);
		}
		predicado(node.getLeft().getType()==node.getRight().getType(),"Deben ser del mismo tipo", node);
		
		
		node.setType(node.getLeft().getType());
		node.setModificable(false);


		return null;
	}

	//	class RelationalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(RelationalExpression node, Object param) {
		super.visit(node, param);
		
		predicado(node.getLeft().getType()==IntType.getInstance() || node.getLeft().getType()==FloatType.getInstance(),"Deben ser de tipo entero o real", node);
		predicado(node.getLeft().getType()==node.getRight().getType(),"Deben ser del mismo tipo", node);
		
	
		node.setType(IntType.getInstance());
		node.setModificable(false);

		return null;
	}

	//	class LogicalExpression { Exp left;  String operator;  Exp right; }
	public Object visit(LogicalExpression node, Object param) {
		super.visit(node, param);
		
		
		if(node.getOperator().equals("!")) {
			predicado(node.getRight().getType()==IntType.getInstance(),"Deben ser de tipo entero", node);
		} else {
			predicado(node.getLeft().getType()==IntType.getInstance(),"Deben ser de tipo entero", node);
			predicado(node.getLeft().getType()==node.getRight().getType(),"Deben ser del mismo tipo", node);
		}
		
		
	
		node.setType(IntType.getInstance());
		node.setModificable(false);

		return null;
	}
	
	
	
	
	
	
	
	//	class Cast { Type type;  Exp exp; }
	public Object visit(Cast node, Object param) {
		super.visit(node, param);
		
		predicado(node.getNewType().isPrimitive(),"Solo se permiten cast de tipos simples", node);
		predicado(node.getExp().getType().isPrimitive(),"Solo se permiten cast de tipos simples", node);
		predicado(node.getNewType()!=node.getExp().getType(),"Los tipos han de ser distintos", node);

		
		node.setType(node.getNewType());
		node.setModificable(false);
		
		return null;
	}
	
	
	
	//	class StructAccess { Exp struct;  String name; }
	public Object visit(StructAccess node, Object param) {
		super.visit(node, param);
		
		StructDef structDef = node.getStruct().getType().getStructDef();
		Type tipoDelAcceso = null;
		boolean existe = false;
		
		if(structDef!=null) {
			for(Record record : structDef.getRecord()) {
				if(record.getName().equals(node.getName())) {
					existe = true;
					tipoDelAcceso=record.getType();
				}
			}
		}
		
		predicado(structDef!=null,"Debe ser de tipo struct", node);
		predicado(existe,"Debe existir el campo en el struct", node);
		

		node.setModificable(true);
		node.setType(tipoDelAcceso);
		
		
		return null;
	}
	
	
	//	class ArrayAccess { Exp array;  Exp index; }
	public Object visit(ArrayAccess node, Object param) {
		super.visit(node, param);
		
		Type tipoDelArray = node.getArray().getType().getArrayType();
		
		predicado(tipoDelArray!=null,"Debe ser de tipo array", node);
		predicado(node.getIndex().getType()==IntType.getInstance(),"El índice debe ser de tipo entero", node);
		
		
		node.setType(tipoDelArray);
		node.setModificable(true);
		
		return null;
	}
	
	
	//	class Variable { String name; }
	public Object visit(Variable node, Object param) {
		
		node.setType(node.getDefinition().getType());
		node.setModificable(true);

		return null;
	}
    
    

	//	class IntConstant { String value; }
	public Object visit(IntConstant node, Object param) {
		node.setType(IntType.getInstance());
		node.setModificable(false);
		return null;
	}


	//	class RealConstant { String value; }
	public Object visit(RealConstant node, Object param) {
		node.setType(FloatType.getInstance());
		node.setModificable(false);
		return null;
	}

	//	class CharConstant { String value; }
	public Object visit(CharConstant node, Object param) {
		node.setType(CharType.getInstance());
		node.setModificable(false);
		return null;
	}
    
    
    
    

    

	private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Type Checking", errorMessage, position);
    }

    /*
    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }
    */

    private ErrorManager errorManager;
}
