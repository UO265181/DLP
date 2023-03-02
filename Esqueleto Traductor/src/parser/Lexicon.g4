lexer grammar Lexicon
	;

INT_CONSTANT
	: [0-9]+
	;

REAL_CONSTANT
	: [0-9]+'.'[0-9]+
	;


CHAR_CONSTANT
	: '\' (\\n|.~[\n\r\t]) \''
	;

CHAR_CONSTANTa
	: '\'\\n\''
	;

CHAR_CONSTANTb
	: '\' .~[\n\r\t] \''
	;

CHAR_CONSTANTc
	: '\'' ('\n'|.) '\''
	;

IDENT
	: [a-zA-Z_][a-zA-Z0-9_]*
	;

LINE_COMMENT
	: '//' .*? ('\n' | EOF) -> skip
	;

MULTILINE_COMMENT
	: '/*' .*? '*/' -> skip
	;

WHITESPACE
	: [ \t\r\n]+ -> skip
	;
