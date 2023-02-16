grammar Grammar;

import Lexicon;

start: 'DATA' vars 'CODE' sentences;

vars: var | vars var;

var: tipo IDENT ';';

tipo: 'real' | 'int';

sentences: sentence | sentences sentence;

sentence:
	'read' exp ';'
	| 'print' exp ';'
	| IDENT '=' exp ';'
	| IDENT '(' llamFuncArgs ')' ';'
	| 'while' '(' exp ')' '{' sentences '}'
	| 'if' '(' exp ')' '{' sentences '}'
	| 'if' '(' exp ')' '{' sentences '}' 'else' '{' sentences '}';

exp:
	'(' exp ')'
	| '<' tipo '>' '(' exp ')'
	| exp '+' exp
	| exp '!=' exp
	| IDENT '(' llamFuncArgs ')'
	| IDENT
	| LITENT
	| LITREAL;

llamFuncArgs: exp | exp ',' llamFuncArgs;

