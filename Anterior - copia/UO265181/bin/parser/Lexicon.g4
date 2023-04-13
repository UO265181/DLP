lexer grammar Lexicon;

LITENT : [0-9]+;

LITREAL : [0-9]+ '.' [0-9]+;


LITCHAR : '\'' ~[\r\n] '\''
		| '\'\\n\''
		;


IDENT : [a-zA-Z] [a-zA-Z0-9_]*;



WHITESPACE : [ \t\r\n]+ -> skip;
COMENTLIN : '/''/' .*? '\n' -> skip;
COMENTMULTLIN : '/''*' .*? '*''/' -> skip;