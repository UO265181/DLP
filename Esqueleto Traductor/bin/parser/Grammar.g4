grammar Grammar;
import Lexicon;


start: definition* EOF;

definition:
	'var' IDENT ':' type ';'
	| 'struct' IDENT '{' (IDENT ':' type ';')* '}' ';'
	| IDENT '(' defFunParams ')' (':' type)? '{' (
		'var' IDENT ':' type ';'
	)* sentence* '}';

type:
	'int'
	| 'float'
	| 'char'
	| '[' INT_CONSTANT ']' type
	| IDENT;

sentence:
	'print' expression? ';'
	| 'printsp' expression? ';'
	| 'println' expression? ';'
	| 'read' varAccess ';'
	| 'return' expression? ';'
	| varAccess '=' expression ';'
	| IDENT '(' callFunParams ')' ';'
	| 'if' '(' expression ')' '{' sentence* '}'
	| 'if' '(' expression ')' '{' sentence* '}' 'else' '{' sentence* '}'
	| 'while' '(' expression ')' '{' sentence* '}';

defFunParams: (IDENT ':' type (',' IDENT ':' type)*)?;

callFunParams: (expression (',' expression)*)?;


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

varAccess:
	IDENT
	| varAccess '.' IDENT
	| varAccess '[' expression ']';

