grammar Grammar;

import Lexicon;

@parser::header {
    import ast.*;
	import ast.Record;
}

start returns [Program ast]
	: defs EOF { $ast = new Program($defs.list); }
	; 
	
defs returns[List<Def> list = new ArrayList<Def>()]
	: (def { $list.add($def.ast); })*
	;

def returns[Def ast]
	: varDef { $ast = $varDef.ast; }
	| 'struct' IDENT '{' records '}' ';' { $ast = new StructDef($IDENT, $records.list); }
	| IDENT '(' defParams ')' ':' type '{' varDefs statements'}' { $ast = new FuncDef($IDENT, $defParams.list, $type.ast, $varDefs.list, $statements.list); }
	| IDENT '(' defParams ')' '{' varDefs statements'}' { $ast = new FuncDef($IDENT, $defParams.list, null, $varDefs.list, $statements.list); }
	;

	
varDefs returns[List<VarDef> list = new ArrayList<VarDef>()]
	: (varDef { $list.add($varDef.ast); })*
	;

varDef returns[VarDef ast]
	:'var' IDENT ':' type ';' { $ast = new VarDef($IDENT, $type.ast); }
	;

	
type returns[Type ast]
	: 'int' { $ast = new IntType(); }
	| 'float' { $ast = new FloatType(); }
	| 'char'{ $ast = new CharType(); }
	| '[' LITENT ']' type { $ast = new ArrayType($LITENT, $type.ast); }
	| IDENT { $ast = new StructType($IDENT); }
	;
	

	
records returns[List<Record> list = new ArrayList<Record>()]
	: (record { $list.add($record.ast); })*
	;



record returns[Record ast]
	: IDENT ':' type ';'  { $ast = new Record($IDENT, $type.ast); }
	;


//
//defParams returns[List<VarDef> list = new ArrayList<VarDef>()]
//	: (IDENT ':' type { $list.add(new VarDef($IDENT, $type.ast)); } (',' IDENT ':' type { $list.add(new VarDef($IDENT, $type.ast)); })*)?
//	;



defParams returns[List<VarDef> list = new ArrayList<VarDef>()]
	: (defParam { $list.add($defParam.ast); }(',' defParam { $list.add($defParam.ast); })*)?
	;
	

defParam returns[VarDef ast]
	: IDENT ':' type { $ast = new VarDef($IDENT, $type.ast); }
	;


statements returns[List<Statement> list = new ArrayList<Statement>()]
	: (statement { $list.add($statement.ast); })*
	;



statement returns[Statement ast]
	: l=exp '=' r=exp ';' { $ast = new Assignment($l.ast, $r.ast); }
	| 'return' exp ';' { $ast = new Return($exp.ast); }
	| 'return' ';' { $ast = new Return(null); }
	| 'print' exp ';' { $ast = new Print($exp.ast); }
	| 'print' ';' { $ast = new Print(null); }
	| 'printsp' exp ';' { $ast = new Printsp($exp.ast); }
	| 'printsp' ';' { $ast = new Printsp(null); }
	| 'println' exp ';' { $ast = new Println($exp.ast); }
	| 'println' ';' { $ast = new Println(null); }
	| 'read' exp ';' { $ast = new Read($exp.ast); }
	| 'while' '(' exp ')' '{' statements '}' { $ast = new While($exp.ast, $statements.list); }
	| 'if' '(' exp ')' '{' ifst=statements '}' { $ast = new If($exp.ast, $ifst.list, null); }
	| 'if' '(' exp ')' '{' ifst=statements '}' 'else' '{' elsest=statements '}' { $ast = new If($exp.ast, $ifst.list, $elsest.list); }
	| IDENT '(' callParams ')' ';' { $ast = new FuncStatement($IDENT, $callParams.list); }
	;




exp returns[Exp ast]
	: '(' exp ')' { $ast = $exp.ast; }
	| a=exp '[' i=exp ']' { $ast = new ArrayAccess($a.ast,$i.ast); }
	| st=exp '.' IDENT { $ast = new StructAccess($st.ast,$IDENT); }
	| '<' type '>' '(' exp ')' { $ast = new Cast($type.ast,$exp.ast); }
	| l=exp op=('*'|'/'|'%') r=exp { $ast = new ArithmeticExpression($l.ast,$op,$r.ast); }
	| l=exp op=('+'|'-') r=exp { $ast = new ArithmeticExpression($l.ast,$op,$r.ast); }
	| l=exp op=('<'|'>'|'<='|'>=') r=exp { $ast = new RelationalExpression($l.ast,$op,$r.ast); }
	| l=exp op=('=='|'!=') r=exp { $ast = new RelationalExpression($l.ast,$op,$r.ast); }
	| l=exp op='&&' r=exp { $ast = new LogicalExpression($l.ast,$op,$r.ast); }
	| l=exp op='||' r=exp { $ast = new LogicalExpression($l.ast,$op,$r.ast); }
	| op='!' exp { $ast = new LogicalExpression(null,$op,$exp.ast); }
	| IDENT '(' callParams ')' { $ast = new FuncExp($IDENT,$callParams.list); }
	| IDENT { $ast = new Variable($IDENT); }
	| LITENT { $ast = new IntConstant($LITENT); }
	| LITREAL { $ast = new RealConstant($LITREAL); }
	| LITCHAR { $ast = new CharConstant($LITCHAR); }
	;
	
	
	
callParams returns[List<Exp> list = new ArrayList<Exp>()]
	: (exp { $list.add($exp.ast); } (',' exp { $list.add($exp.ast); })*)?
	;

