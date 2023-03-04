grammar Grammar;
import Lexicon;

@parser::header {
    import ast.*;
}

start
	returns[Program ast]:
	definitions EOF { $ast = new Program($definitions.list); };

definitions
	returns[List<Definition> list = new ArrayList<Definition>()]:
	(definition { $list.add($definition.ast); })*;

definition
	returns[Definition ast]:
	definitionVariable { $ast = $definitionVariable.ast; }
	| 'struct' IDENT '{' structFields '}' ';' { $ast = new DefinitionStruct($IDENT, $structFields.list); 
		}
	| IDENT '(' definitionFunctionParams ')' '{' definitionVariables sentences '}' { $ast = new DefinitionFunction($IDENT, $definitionFunctionParams.list, null, $definitionVariables.list, $sentences.list); 
		}
	| IDENT '(' definitionFunctionParams ')' ':' type '{' definitionVariables sentences '}' { $ast = new DefinitionFunction($IDENT, $definitionFunctionParams.list, $type.ast, $definitionVariables.list, $sentences.list); 
		};

definitionVariables
	returns[List<DefinitionVariable> list = new ArrayList<DefinitionVariable>()]: (
		definitionVariable { $list.add($definitionVariable.ast); }
	)*;

definitionVariable
	returns[DefinitionVariable ast]:
	'var' IDENT ':' type ';' { $ast = new DefinitionVariable($IDENT, $type.ast); };

structFields
	returns[List<DefinitionVariable> list = new ArrayList<DefinitionVariable>()]: (
		structField { $list.add($structField.ast); }
	)*;

structField
	returns[DefinitionVariable ast]:
	IDENT ':' type ';' { $ast = new DefinitionVariable($IDENT, $type.ast); };

definitionFunctionParams
	returns[List<DefinitionVariable> list = new ArrayList<DefinitionVariable>()]: (
		definitionFunctionParam { $list.add($definitionFunctionParam.ast); } (
			',' definitionFunctionParam { $list.add($definitionFunctionParam.ast); }
		)*
	)?;

definitionFunctionParam
	returns[DefinitionVariable ast]:
	IDENT ':' type { $ast = new DefinitionVariable($IDENT, $type.ast); };

type
	returns[Type ast]:
	'int' { $ast = new TypeInt(); }
	| 'float' { $ast = new TypeFloat(); }
	| 'char' { $ast = new TypeChar(); }
	| '[' INT_CONSTANT ']' type { $ast = new TypeArray($INT_CONSTANT, $type.ast); }
	| IDENT { $ast = new TypeStruct($IDENT); };

sentences
	returns[List<Sentence> list = new ArrayList<Sentence>()]: (
		sentence { $list.add($sentence.ast); }
	)*;

sentence
	returns[Sentence ast]:
	left = expression '=' right = expression ';' { $ast = new Assignment($left.ast, $right.ast); }
	| 'return' expression ';' { $ast = new Return($expression.ast); }
	| 'return' ';' { $ast = new Return(null); }
	| 'print' expression ';' { $ast = new Print($expression.ast); }
	| 'print' ';' { $ast = new Print(null); }
	| 'printsp' expression ';' { $ast = new Printsp($expression.ast); }
	| 'printsp' ';' { $ast = new Printsp(null); }
	| 'println' expression ';' { $ast = new Println($expression.ast); }
	| 'println' ';' { $ast = new Println(null); }
	| 'read' expression ';' { $ast = new Read($expression.ast); }
	| 'while' '(' expression ')' '{' sentences '}' { $ast = new While($expression.ast, $sentences.list); 
		}
	| 'if' '(' expression ')' '{' sentences '}' { $ast = new If($expression.ast, $sentences.list, null); 
		}
	| 'if' '(' expression ')' '{' ifSentences = sentences '}' 'else' '{' elseSentences = sentences
		'}' { $ast = new If($expression.ast, $ifSentences.list, $elseSentences.list); }
	| IDENT '(' callFunctionParams ')' ';' { $ast = new SentenceCallFunction($IDENT, $callFunctionParams.list); 
		};

callFunctionParams
	returns[List<Expression> list = new ArrayList<Expression>()]: (
		expression { $list.add($expression.ast); } (
			',' expression { $list.add($expression.ast); }
		)*
	)?;

/* 
 expression:
 INT_CONSTANT
 | REAL_CONSTANT
 | CHAR_CONSTANT
 | IDENT '(' callFunctionParams
 ')'
 | IDENT
 | expression '.' IDENT
 | expression '[' expression ']'
 | '(' expression ')'
 | '!'
 expression
 | '<' type '>' '(' expression ')'
 | expression ('*' | '/' | '%') expression
 |
 expression ('+' | '-') expression
 | expression ('<' | '>' | '>=' | '<=') expression
 | expression
 ('==' | '!=') expression
 | expression '&&' expression
 | expression '||' expression;
 */

expression
	returns[Expression ast]:
	'(' expression ')' { $ast = $expression.ast; }
	| array = expression '[' index = expression ']' { $ast = new AccessArray($array.ast,$index.ast); 
		}
	| struct = expression '.' IDENT { $ast = new AccessStructField($struct.ast,$IDENT); }
	| '<' type '>' '(' expression ')' { $ast = new Cast($type.ast,$expression.ast); }
	| left = expression operator = ('*' | '/' | '%') right = expression { $ast = new ArithmeticExpression($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = ('+' | '-') right = expression { $ast = new ArithmeticExpression($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = ('<' | '>' | '<=' | '>=') right = expression { $ast = new RelationalExpression($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = ('==' | '!=') right = expression { $ast = new RelationalExpression($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = '&&' right = expression { $ast = new LogicalExpression($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = '||' right = expression { $ast = new LogicalExpression($left.ast,$operator,$right.ast); 
		}
	| operator = '!' expression { $ast = new UnaryExpression($operator,$expression.ast); }
	| IDENT '(' callFunctionParams ')' { $ast = new ExpressionCallFunction($IDENT,$callFunctionParams.list); 
		}
	| IDENT { $ast = new AccessVariable($IDENT); }
	| INT_CONSTANT { $ast = new ConstantInt($INT_CONSTANT); }
	| REAL_CONSTANT { $ast = new ConstantFloat($REAL_CONSTANT); }
	| CHAR_CONSTANT { $ast = new ConstantChar($CHAR_CONSTANT); };

