grammar Grammar;
import Lexicon;

start: definitions EOF;

definitions: | definitions definition;

definition:
	'var' IDENT ':' type ';'
	| 'struct' IDENT '{' structFields '}' ';'
	| IDENT '(' defFunParams ')' '{' localVars sentences '}'
	| IDENT '(' defFunParams ')' ':' type '{' localVars sentences '}';

localVars: | localVars 'var' IDENT ':' type ';';

structFields: | structFields IDENT ':' type ';';

defFunParams: | defFunParamsList;

defFunParamsList:
	IDENT ':' type
	| defFunParamsList ',' IDENT ':' type;

type:
	'int'
	| 'float'
	| 'char'
	| '[' INT_CONSTANT ']' type
	| IDENT;

sentences: | sentences sentence;

sentence:
	'print' ';'
	| 'print' expression ';'
	| 'printsp' ';'
	| 'printsp' expression ';'
	| 'println' ';'
	| 'println' expression ';'
	| 'return' ';'
	| 'return' expression ';'
	| 'read' varAccess ';'
	| varAccess '=' expression ';'
	| IDENT '(' callFunParams ')' ';'
	| 'if' '(' expression ')' '{' sentences '}'
	| 'if' '(' expression ')' '{' sentences '}' 'else' '{' sentences '}'
	| 'while' '(' expression ')' '{' sentences '}';

callFunParams: | callFunParamsList;

callFunParamsList:
	expression
	| callFunParamsList ',' expression;

expression:
	INT_CONSTANT
	| REAL_CONSTANT
	| CHAR_CONSTANT
	| IDENT '(' callFunParams ')'
	| varAccess
	| '(' expression ')'
	| '!' expression
	| '<' type '>' '(' expression ')'
	| expression ('*' | '/' | '%') expression
	| expression ('+' | '-') expression
	| expression ('<' | '>' | '>=' | '<=') expression
	| expression ('==' | '!=') expression
	| expression '&&' expression
	| expression '||' expression;

//TODO: no necesario
varAccess:
	IDENT
	| varAccess '.' IDENT
	| varAccess '[' expression ']';

