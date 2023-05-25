grammar Grammar;
import Lexicon;

@parser::header {
	import ast.*;
	import ast.definitions.*;
	import ast.expressions.Expression;
	import ast.expressions.access.*;
	import ast.expressions.constant.*;
	import ast.expressions.*;
	import ast.definitions.*;
	import ast.sentences.*;
	import ast.types.*;
	import ast.types.primitives.*;
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
	| IDENT '(' definitionFunctionParams ')' '{' definitionVariables sentences '}' { $ast = new DefinitionFunction($IDENT, $definitionFunctionParams.list, new TypeVoid(), $definitionVariables.list, $sentences.list); 
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
	returns[List<StructField> list = new ArrayList<StructField>()]: (
		structField { $list.add($structField.ast); }
	)*;

structField
	returns[StructField ast]:
	IDENT ':' type ';' { $ast = new StructField($IDENT, $type.ast); };

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
	| '[' INT_CONSTANT ']' type { $ast = new TypeArray(new ExpressionConstantInt($INT_CONSTANT), $type.ast); 
		}
	| IDENT { $ast = new TypeStruct($IDENT); };

sentences
	returns[List<Sentence> list = new ArrayList<Sentence>()]: (
		sentence { $list.add($sentence.ast); }
	)*;

sentence
	returns[Sentence ast]:
	left = expression '=' right = expression ';' { $ast = new SentenceAssignment($left.ast, $right.ast); 
		}
	| 'return' expression ';' { $ast = new SentenceReturn($expression.ast); }
	| s = 'return' ';' { $ast = new SentenceReturn(null);  $ast.setPositions($s);}
	| 'print' expression ';' { $ast = new SentencePrint($expression.ast); }
	| s = 'print' ';' { $ast = new SentencePrint(null); $ast.setPositions($s);}
	| 'printsp' expression ';' { $ast = new SentencePrintsp($expression.ast); }
	| s = 'printsp' ';' { $ast = new SentencePrintsp(null); $ast.setPositions($s);}
	| 'println' expression ';' { $ast = new SentencePrintln($expression.ast); }
	| s = 'println' ';' { $ast = new SentencePrintln(null); $ast.setPositions($s);}
	| 'read' expression ';' { $ast = new SentenceRead($expression.ast); }
	| 'while' '(' expression ')' '{' sentences '}' { $ast = new SentenceWhile($expression.ast, $sentences.list); 
		}
	| 'if' '(' expression ')' '{' sentences '}' { $ast = new SentenceIf($expression.ast, $sentences.list, null); 
		}
	| 'if' '(' expression ')' '{' ifSentences = sentences '}' 'else' '{' elseSentences = sentences
		'}' { $ast = new SentenceIf($expression.ast, $ifSentences.list, $elseSentences.list); }
	| IDENT '(' callFunctionParams ')' ';' { $ast = new SentenceCallFunction($IDENT, $callFunctionParams.list); 
		};

callFunctionParams
	returns[List<Expression> list = new ArrayList<Expression>()]: (
		expression { $list.add($expression.ast); } (
			',' expression { $list.add($expression.ast); }
		)*
	)?;

expression
	returns[Expression ast]:
	'(' expression ')' { $ast = $expression.ast; }
	| array = expression '[' index = expression ']' { $ast = new ExpressionArray($array.ast,$index.ast); 
		}
	| struct = expression '.' IDENT { $ast = new ExpressionStructField($struct.ast,$IDENT); }
	| IDENT { $ast = new ExpressionVariable($IDENT); }
	| '<' type '>' '(' expression ')' { $ast = new ExpressionCast($type.ast,$expression.ast); }
	| left = expression operator = ('*' | '/' | '%') right = expression { $ast = new ExpressionArithmetic($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = ('+' | '-') right = expression { $ast = new ExpressionArithmetic($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = ('<' | '>' | '<=' | '>=') right = expression { $ast = new ExpressionRelational($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = ('==' | '!=') right = expression { $ast = new ExpressionRelational($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = '&&' right = expression { $ast = new ExpressionLogical($left.ast,$operator,$right.ast); 
		}
	| left = expression operator = '||' right = expression { $ast = new ExpressionLogical($left.ast,$operator,$right.ast); 
		}
	| operator = '!' expression { $ast = new ExpressionUnary($operator,$expression.ast); }
	| IDENT '(' callFunctionParams ')' { $ast = new ExpressionCallFunction($IDENT,$callFunctionParams.list); 
		}
	| INT_CONSTANT { $ast = new ExpressionConstantInt($INT_CONSTANT); }
	| REAL_CONSTANT { $ast = new ExpressionConstantFloat($REAL_CONSTANT); }
	| CHAR_CONSTANT { $ast = new ExpressionConstantChar($CHAR_CONSTANT); };

