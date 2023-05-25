// Generated from d:\Temporal\dlp\continua\DLP\Esqueleto Traductor\src\parser\Grammar.g4 by ANTLR 4.9.2

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		INT_CONSTANT=39, REAL_CONSTANT=40, CHAR_CONSTANT=41, IDENT=42, LINE_COMMENT=43, 
		MULTILINE_COMMENT=44, WHITESPACE=45;
	public static final int
		RULE_start = 0, RULE_definitions = 1, RULE_definition = 2, RULE_definitionVariables = 3, 
		RULE_definitionVariable = 4, RULE_structFields = 5, RULE_structField = 6, 
		RULE_definitionFunctionParams = 7, RULE_definitionFunctionParam = 8, RULE_type = 9, 
		RULE_sentences = 10, RULE_destructuring = 11, RULE_sentence = 12, RULE_callFunctionParams = 13, 
		RULE_expression = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definitions", "definition", "definitionVariables", "definitionVariable", 
			"structFields", "structField", "definitionFunctionParams", "definitionFunctionParam", 
			"type", "sentences", "destructuring", "sentence", "callFunctionParams", 
			"expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "'('", "')'", "':'", "'var'", 
			"','", "'int'", "'float'", "'char'", "'['", "']'", "'='", "'return'", 
			"'print'", "'printsp'", "'println'", "'read'", "'while'", "'if'", "'else'", 
			"'.'", "'<'", "'>'", "'*'", "'/'", "'%'", "'+'", "'-'", "'<='", "'>='", 
			"'=='", "'!='", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext definitions;
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((StartContext)_localctx).definitions = definitions();
			setState(31);
			match(EOF);
			 ((StartContext)_localctx).ast =  new Program(((StartContext)_localctx).definitions.list); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> list = new ArrayList<Definition>();
		public DefinitionContext definition;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << IDENT))) != 0)) {
				{
				{
				setState(34);
				((DefinitionsContext)_localctx).definition = definition();
				 _localctx.list.add(((DefinitionsContext)_localctx).definition.ast); 
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public Definition ast;
		public DefinitionVariableContext definitionVariable;
		public Token IDENT;
		public StructFieldsContext structFields;
		public DefinitionFunctionParamsContext definitionFunctionParams;
		public DefinitionVariablesContext definitionVariables;
		public SentencesContext sentences;
		public TypeContext type;
		public DefinitionVariableContext definitionVariable() {
			return getRuleContext(DefinitionVariableContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public StructFieldsContext structFields() {
			return getRuleContext(StructFieldsContext.class,0);
		}
		public DefinitionFunctionParamsContext definitionFunctionParams() {
			return getRuleContext(DefinitionFunctionParamsContext.class,0);
		}
		public DefinitionVariablesContext definitionVariables() {
			return getRuleContext(DefinitionVariablesContext.class,0);
		}
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				((DefinitionContext)_localctx).definitionVariable = definitionVariable();
				 ((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).definitionVariable.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__0);
				setState(46);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(47);
				match(T__1);
				setState(48);
				((DefinitionContext)_localctx).structFields = structFields();
				setState(49);
				match(T__2);
				setState(50);
				match(T__3);
				 ((DefinitionContext)_localctx).ast =  new DefinitionStruct(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).structFields.list); 
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(54);
				match(T__4);
				setState(55);
				((DefinitionContext)_localctx).definitionFunctionParams = definitionFunctionParams();
				setState(56);
				match(T__5);
				setState(57);
				match(T__1);
				setState(58);
				((DefinitionContext)_localctx).definitionVariables = definitionVariables();
				setState(59);
				((DefinitionContext)_localctx).sentences = sentences();
				setState(60);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new DefinitionFunction(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).definitionFunctionParams.list, new TypeVoid(), ((DefinitionContext)_localctx).definitionVariables.list, ((DefinitionContext)_localctx).sentences.list); 
						
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(64);
				match(T__4);
				setState(65);
				((DefinitionContext)_localctx).definitionFunctionParams = definitionFunctionParams();
				setState(66);
				match(T__5);
				setState(67);
				match(T__6);
				setState(68);
				((DefinitionContext)_localctx).type = type();
				setState(69);
				match(T__1);
				setState(70);
				((DefinitionContext)_localctx).definitionVariables = definitionVariables();
				setState(71);
				((DefinitionContext)_localctx).sentences = sentences();
				setState(72);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new DefinitionFunction(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).definitionFunctionParams.list, ((DefinitionContext)_localctx).type.ast, ((DefinitionContext)_localctx).definitionVariables.list, ((DefinitionContext)_localctx).sentences.list); 
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionVariablesContext extends ParserRuleContext {
		public List<DefinitionVariable> list = new ArrayList<DefinitionVariable>();
		public DefinitionVariableContext definitionVariable;
		public List<DefinitionVariableContext> definitionVariable() {
			return getRuleContexts(DefinitionVariableContext.class);
		}
		public DefinitionVariableContext definitionVariable(int i) {
			return getRuleContext(DefinitionVariableContext.class,i);
		}
		public DefinitionVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionVariables; }
	}

	public final DefinitionVariablesContext definitionVariables() throws RecognitionException {
		DefinitionVariablesContext _localctx = new DefinitionVariablesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definitionVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(77);
				((DefinitionVariablesContext)_localctx).definitionVariable = definitionVariable();
				 _localctx.list.add(((DefinitionVariablesContext)_localctx).definitionVariable.ast); 
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionVariableContext extends ParserRuleContext {
		public DefinitionVariable ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefinitionVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionVariable; }
	}

	public final DefinitionVariableContext definitionVariable() throws RecognitionException {
		DefinitionVariableContext _localctx = new DefinitionVariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_definitionVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__7);
			setState(86);
			((DefinitionVariableContext)_localctx).IDENT = match(IDENT);
			setState(87);
			match(T__6);
			setState(88);
			((DefinitionVariableContext)_localctx).type = type();
			setState(89);
			match(T__3);
			 ((DefinitionVariableContext)_localctx).ast =  new DefinitionVariable(((DefinitionVariableContext)_localctx).IDENT, ((DefinitionVariableContext)_localctx).type.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructFieldsContext extends ParserRuleContext {
		public List<StructField> list = new ArrayList<StructField>();
		public StructFieldContext structField;
		public List<StructFieldContext> structField() {
			return getRuleContexts(StructFieldContext.class);
		}
		public StructFieldContext structField(int i) {
			return getRuleContext(StructFieldContext.class,i);
		}
		public StructFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structFields; }
	}

	public final StructFieldsContext structFields() throws RecognitionException {
		StructFieldsContext _localctx = new StructFieldsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(92);
				((StructFieldsContext)_localctx).structField = structField();
				 _localctx.list.add(((StructFieldsContext)_localctx).structField.ast); 
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructFieldContext extends ParserRuleContext {
		public StructField ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			((StructFieldContext)_localctx).IDENT = match(IDENT);
			setState(101);
			match(T__6);
			setState(102);
			((StructFieldContext)_localctx).type = type();
			setState(103);
			match(T__3);
			 ((StructFieldContext)_localctx).ast =  new StructField(((StructFieldContext)_localctx).IDENT, ((StructFieldContext)_localctx).type.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionFunctionParamsContext extends ParserRuleContext {
		public List<DefinitionVariable> list = new ArrayList<DefinitionVariable>();
		public DefinitionFunctionParamContext definitionFunctionParam;
		public List<DefinitionFunctionParamContext> definitionFunctionParam() {
			return getRuleContexts(DefinitionFunctionParamContext.class);
		}
		public DefinitionFunctionParamContext definitionFunctionParam(int i) {
			return getRuleContext(DefinitionFunctionParamContext.class,i);
		}
		public DefinitionFunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionFunctionParams; }
	}

	public final DefinitionFunctionParamsContext definitionFunctionParams() throws RecognitionException {
		DefinitionFunctionParamsContext _localctx = new DefinitionFunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_definitionFunctionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(106);
				((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam = definitionFunctionParam();
				 _localctx.list.add(((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam.ast); 
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(108);
					match(T__8);
					setState(109);
					((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam = definitionFunctionParam();
					 _localctx.list.add(((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam.ast); 
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionFunctionParamContext extends ParserRuleContext {
		public DefinitionVariable ast;
		public Token IDENT;
		public TypeContext type;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefinitionFunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionFunctionParam; }
	}

	public final DefinitionFunctionParamContext definitionFunctionParam() throws RecognitionException {
		DefinitionFunctionParamContext _localctx = new DefinitionFunctionParamContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_definitionFunctionParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((DefinitionFunctionParamContext)_localctx).IDENT = match(IDENT);
			setState(120);
			match(T__6);
			setState(121);
			((DefinitionFunctionParamContext)_localctx).type = type();
			 ((DefinitionFunctionParamContext)_localctx).ast =  new DefinitionVariable(((DefinitionFunctionParamContext)_localctx).IDENT, ((DefinitionFunctionParamContext)_localctx).type.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token INT_CONSTANT;
		public TypeContext type;
		public Token IDENT;
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__9);
				 ((TypeContext)_localctx).ast =  new TypeInt(); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__10);
				 ((TypeContext)_localctx).ast =  new TypeFloat(); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(T__11);
				 ((TypeContext)_localctx).ast =  new TypeChar(); 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(T__12);
				setState(131);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(132);
				match(T__13);
				setState(133);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new TypeArray(new ExpressionConstantInt(((TypeContext)_localctx).INT_CONSTANT), ((TypeContext)_localctx).type.ast); 
						
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(136);
				((TypeContext)_localctx).IDENT = match(IDENT);
				 ((TypeContext)_localctx).ast =  new TypeStruct(((TypeContext)_localctx).IDENT); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentencesContext extends ParserRuleContext {
		public List<Sentence> list = new ArrayList<Sentence>();
		public SentenceContext sentence;
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public SentencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentences; }
	}

	public final SentencesContext sentences() throws RecognitionException {
		SentencesContext _localctx = new SentencesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentences);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__24) | (1L << T__37) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(140);
				((SentencesContext)_localctx).sentence = sentence();
				 _localctx.list.add(((SentencesContext)_localctx).sentence.ast); 
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DestructuringContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DestructuringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructuring; }
	}

	public final DestructuringContext destructuring() throws RecognitionException {
		DestructuringContext _localctx = new DestructuringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_destructuring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__12);
			setState(149);
			((DestructuringContext)_localctx).expression = expression(0);
			 _localctx.list.add(((DestructuringContext)_localctx).expression.ast);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(151);
				match(T__8);
				setState(152);
				((DestructuringContext)_localctx).expression = expression(0);
				 _localctx.list.add(((DestructuringContext)_localctx).expression.ast);
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public Sentence ast;
		public ExpressionContext left;
		public ExpressionContext right;
		public DestructuringContext destructuring;
		public ExpressionContext expression;
		public Token s;
		public SentencesContext sentences;
		public SentencesContext ifSentences;
		public SentencesContext elseSentences;
		public Token IDENT;
		public CallFunctionParamsContext callFunctionParams;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DestructuringContext destructuring() {
			return getRuleContext(DestructuringContext.class,0);
		}
		public List<SentencesContext> sentences() {
			return getRuleContexts(SentencesContext.class);
		}
		public SentencesContext sentences(int i) {
			return getRuleContext(SentencesContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public CallFunctionParamsContext callFunctionParams() {
			return getRuleContext(CallFunctionParamsContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentence);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				((SentenceContext)_localctx).left = expression(0);
				setState(163);
				match(T__14);
				setState(164);
				((SentenceContext)_localctx).right = expression(0);
				setState(165);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentenceAssignment(((SentenceContext)_localctx).left.ast, ((SentenceContext)_localctx).right.ast); 
						
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				((SentenceContext)_localctx).destructuring = destructuring();
				setState(169);
				match(T__14);
				setState(170);
				((SentenceContext)_localctx).right = expression(0);
				setState(171);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentenceDestructuringAssignment(((SentenceContext)_localctx).destructuring.list, ((SentenceContext)_localctx).right.ast); 
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(T__15);
				setState(175);
				((SentenceContext)_localctx).expression = expression(0);
				setState(176);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentenceReturn(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				((SentenceContext)_localctx).s = match(T__15);
				setState(180);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentenceReturn(null);  _localctx.ast.setPositions(((SentenceContext)_localctx).s);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				match(T__16);
				setState(183);
				((SentenceContext)_localctx).expression = expression(0);
				setState(184);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentencePrint(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				((SentenceContext)_localctx).s = match(T__16);
				setState(188);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentencePrint(null); _localctx.ast.setPositions(((SentenceContext)_localctx).s);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(190);
				match(T__17);
				setState(191);
				((SentenceContext)_localctx).expression = expression(0);
				setState(192);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentencePrintsp(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(195);
				((SentenceContext)_localctx).s = match(T__17);
				setState(196);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentencePrintsp(null); _localctx.ast.setPositions(((SentenceContext)_localctx).s);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(198);
				match(T__18);
				setState(199);
				((SentenceContext)_localctx).expression = expression(0);
				setState(200);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentencePrintln(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(203);
				((SentenceContext)_localctx).s = match(T__18);
				setState(204);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentencePrintln(null); _localctx.ast.setPositions(((SentenceContext)_localctx).s);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(206);
				match(T__19);
				setState(207);
				((SentenceContext)_localctx).expression = expression(0);
				setState(208);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentenceRead(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(211);
				match(T__20);
				setState(212);
				match(T__4);
				setState(213);
				((SentenceContext)_localctx).expression = expression(0);
				setState(214);
				match(T__5);
				setState(215);
				match(T__1);
				setState(216);
				((SentenceContext)_localctx).sentences = sentences();
				setState(217);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new SentenceWhile(((SentenceContext)_localctx).expression.ast, ((SentenceContext)_localctx).sentences.list); 
						
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(220);
				match(T__21);
				setState(221);
				match(T__4);
				setState(222);
				((SentenceContext)_localctx).expression = expression(0);
				setState(223);
				match(T__5);
				setState(224);
				match(T__1);
				setState(225);
				((SentenceContext)_localctx).sentences = sentences();
				setState(226);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new SentenceIf(((SentenceContext)_localctx).expression.ast, ((SentenceContext)_localctx).sentences.list, null); 
						
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(229);
				match(T__21);
				setState(230);
				match(T__4);
				setState(231);
				((SentenceContext)_localctx).expression = expression(0);
				setState(232);
				match(T__5);
				setState(233);
				match(T__1);
				setState(234);
				((SentenceContext)_localctx).ifSentences = sentences();
				setState(235);
				match(T__2);
				setState(236);
				match(T__22);
				setState(237);
				match(T__1);
				setState(238);
				((SentenceContext)_localctx).elseSentences = sentences();
				setState(239);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new SentenceIf(((SentenceContext)_localctx).expression.ast, ((SentenceContext)_localctx).ifSentences.list, ((SentenceContext)_localctx).elseSentences.list); 
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(242);
				((SentenceContext)_localctx).IDENT = match(IDENT);
				setState(243);
				match(T__4);
				setState(244);
				((SentenceContext)_localctx).callFunctionParams = callFunctionParams();
				setState(245);
				match(T__5);
				setState(246);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new SentenceCallFunction(((SentenceContext)_localctx).IDENT, ((SentenceContext)_localctx).callFunctionParams.list); 
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallFunctionParamsContext extends ParserRuleContext {
		public List<Expression> list = new ArrayList<Expression>();
		public ExpressionContext expression;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CallFunctionParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callFunctionParams; }
	}

	public final CallFunctionParamsContext callFunctionParams() throws RecognitionException {
		CallFunctionParamsContext _localctx = new CallFunctionParamsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_callFunctionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__24) | (1L << T__37) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(251);
				((CallFunctionParamsContext)_localctx).expression = expression(0);
				 _localctx.list.add(((CallFunctionParamsContext)_localctx).expression.ast); 
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(253);
					match(T__8);
					setState(254);
					((CallFunctionParamsContext)_localctx).expression = expression(0);
					 _localctx.list.add(((CallFunctionParamsContext)_localctx).expression.ast); 
					}
					}
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext array;
		public ExpressionContext struct;
		public ExpressionContext left;
		public ExpressionContext expression;
		public Token IDENT;
		public TypeContext type;
		public Token operator;
		public CallFunctionParamsContext callFunctionParams;
		public Token INT_CONSTANT;
		public Token REAL_CONSTANT;
		public Token CHAR_CONSTANT;
		public ExpressionContext right;
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CallFunctionParamsContext callFunctionParams() {
			return getRuleContext(CallFunctionParamsContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(265);
				match(T__4);
				setState(266);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(267);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast; 
				}
				break;
			case 2:
				{
				setState(270);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				 ((ExpressionContext)_localctx).ast =  new ExpressionVariable(((ExpressionContext)_localctx).IDENT); 
				}
				break;
			case 3:
				{
				setState(272);
				match(T__24);
				setState(273);
				((ExpressionContext)_localctx).type = type();
				setState(274);
				match(T__25);
				setState(275);
				match(T__4);
				setState(276);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(277);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  new ExpressionCast(((ExpressionContext)_localctx).type.ast,((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 4:
				{
				setState(280);
				((ExpressionContext)_localctx).operator = match(T__37);
				setState(281);
				((ExpressionContext)_localctx).expression = expression(5);
				 ((ExpressionContext)_localctx).ast =  new ExpressionUnary(((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 5:
				{
				setState(284);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				setState(285);
				match(T__4);
				setState(286);
				((ExpressionContext)_localctx).callFunctionParams = callFunctionParams();
				setState(287);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  new ExpressionCallFunction(((ExpressionContext)_localctx).IDENT,((ExpressionContext)_localctx).callFunctionParams.list); 
						
				}
				break;
			case 6:
				{
				setState(290);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new ExpressionConstantInt(((ExpressionContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 7:
				{
				setState(292);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new ExpressionConstantFloat(((ExpressionContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 8:
				{
				setState(294);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new ExpressionConstantChar(((ExpressionContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(338);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(298);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(299);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(300);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(12);
						 ((ExpressionContext)_localctx).ast =  new ExpressionArithmetic(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(304);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(305);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(11);
						 ((ExpressionContext)_localctx).ast =  new ExpressionArithmetic(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(308);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(309);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__31) | (1L << T__32))) != 0)) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(310);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						 ((ExpressionContext)_localctx).ast =  new ExpressionRelational(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(313);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(314);
						((ExpressionContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
							((ExpressionContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(315);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(9);
						 ((ExpressionContext)_localctx).ast =  new ExpressionRelational(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(319);
						((ExpressionContext)_localctx).operator = match(T__35);
						setState(320);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(8);
						 ((ExpressionContext)_localctx).ast =  new ExpressionLogical(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(323);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(324);
						((ExpressionContext)_localctx).operator = match(T__36);
						setState(325);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(7);
						 ((ExpressionContext)_localctx).ast =  new ExpressionLogical(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.array = _prevctx;
						_localctx.array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(329);
						match(T__12);
						setState(330);
						((ExpressionContext)_localctx).index = ((ExpressionContext)_localctx).expression = expression(0);
						setState(331);
						match(T__13);
						 ((ExpressionContext)_localctx).ast =  new ExpressionArray(((ExpressionContext)_localctx).array.ast,((ExpressionContext)_localctx).index.ast); 
						          		
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.struct = _prevctx;
						_localctx.struct = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(334);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(335);
						match(T__23);
						setState(336);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						 ((ExpressionContext)_localctx).ast =  new ExpressionStructField(((ExpressionContext)_localctx).struct.ast,((ExpressionContext)_localctx).IDENT); 
						}
						break;
					}
					} 
				}
				setState(342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u015a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3\5\3\5\3\5\7\5S\n\5\f\5\16\5V\13\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7b\n\7\f\7\16\7e\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\ts\n\t\f\t\16\tv\13\t\5\t"+
		"x\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u008d\n\13\3\f\3\f\3\f\7\f\u0092\n\f\f"+
		"\f\16\f\u0095\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u009e\n\r\f\r\16\r"+
		"\u00a1\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00fc\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\7\17\u0104\n\17\f\17\16\17\u0107\13\17\5\17\u0109\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u012b\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u0155\n\20\f\20\16\20\u0158\13\20\3\20\2\3\36"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\6\3\2\35\37\3\2 !\4\2\33"+
		"\34\"#\3\2$%\2\u0177\2 \3\2\2\2\4)\3\2\2\2\6M\3\2\2\2\bT\3\2\2\2\nW\3"+
		"\2\2\2\fc\3\2\2\2\16f\3\2\2\2\20w\3\2\2\2\22y\3\2\2\2\24\u008c\3\2\2\2"+
		"\26\u0093\3\2\2\2\30\u0096\3\2\2\2\32\u00fb\3\2\2\2\34\u0108\3\2\2\2\36"+
		"\u012a\3\2\2\2 !\5\4\3\2!\"\7\2\2\3\"#\b\2\1\2#\3\3\2\2\2$%\5\6\4\2%&"+
		"\b\3\1\2&(\3\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2"+
		"\2+)\3\2\2\2,-\5\n\6\2-.\b\4\1\2.N\3\2\2\2/\60\7\3\2\2\60\61\7,\2\2\61"+
		"\62\7\4\2\2\62\63\5\f\7\2\63\64\7\5\2\2\64\65\7\6\2\2\65\66\b\4\1\2\66"+
		"N\3\2\2\2\678\7,\2\289\7\7\2\29:\5\20\t\2:;\7\b\2\2;<\7\4\2\2<=\5\b\5"+
		"\2=>\5\26\f\2>?\7\5\2\2?@\b\4\1\2@N\3\2\2\2AB\7,\2\2BC\7\7\2\2CD\5\20"+
		"\t\2DE\7\b\2\2EF\7\t\2\2FG\5\24\13\2GH\7\4\2\2HI\5\b\5\2IJ\5\26\f\2JK"+
		"\7\5\2\2KL\b\4\1\2LN\3\2\2\2M,\3\2\2\2M/\3\2\2\2M\67\3\2\2\2MA\3\2\2\2"+
		"N\7\3\2\2\2OP\5\n\6\2PQ\b\5\1\2QS\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2\2"+
		"\2TU\3\2\2\2U\t\3\2\2\2VT\3\2\2\2WX\7\n\2\2XY\7,\2\2YZ\7\t\2\2Z[\5\24"+
		"\13\2[\\\7\6\2\2\\]\b\6\1\2]\13\3\2\2\2^_\5\16\b\2_`\b\7\1\2`b\3\2\2\2"+
		"a^\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\r\3\2\2\2ec\3\2\2\2fg\7,\2\2"+
		"gh\7\t\2\2hi\5\24\13\2ij\7\6\2\2jk\b\b\1\2k\17\3\2\2\2lm\5\22\n\2mt\b"+
		"\t\1\2no\7\13\2\2op\5\22\n\2pq\b\t\1\2qs\3\2\2\2rn\3\2\2\2sv\3\2\2\2t"+
		"r\3\2\2\2tu\3\2\2\2ux\3\2\2\2vt\3\2\2\2wl\3\2\2\2wx\3\2\2\2x\21\3\2\2"+
		"\2yz\7,\2\2z{\7\t\2\2{|\5\24\13\2|}\b\n\1\2}\23\3\2\2\2~\177\7\f\2\2\177"+
		"\u008d\b\13\1\2\u0080\u0081\7\r\2\2\u0081\u008d\b\13\1\2\u0082\u0083\7"+
		"\16\2\2\u0083\u008d\b\13\1\2\u0084\u0085\7\17\2\2\u0085\u0086\7)\2\2\u0086"+
		"\u0087\7\20\2\2\u0087\u0088\5\24\13\2\u0088\u0089\b\13\1\2\u0089\u008d"+
		"\3\2\2\2\u008a\u008b\7,\2\2\u008b\u008d\b\13\1\2\u008c~\3\2\2\2\u008c"+
		"\u0080\3\2\2\2\u008c\u0082\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008d\25\3\2\2\2\u008e\u008f\5\32\16\2\u008f\u0090\b\f\1\2\u0090"+
		"\u0092\3\2\2\2\u0091\u008e\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\27\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097"+
		"\7\17\2\2\u0097\u0098\5\36\20\2\u0098\u009f\b\r\1\2\u0099\u009a\7\13\2"+
		"\2\u009a\u009b\5\36\20\2\u009b\u009c\b\r\1\2\u009c\u009e\3\2\2\2\u009d"+
		"\u0099\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\20\2\2\u00a3"+
		"\31\3\2\2\2\u00a4\u00a5\5\36\20\2\u00a5\u00a6\7\21\2\2\u00a6\u00a7\5\36"+
		"\20\2\u00a7\u00a8\7\6\2\2\u00a8\u00a9\b\16\1\2\u00a9\u00fc\3\2\2\2\u00aa"+
		"\u00ab\5\30\r\2\u00ab\u00ac\7\21\2\2\u00ac\u00ad\5\36\20\2\u00ad\u00ae"+
		"\7\6\2\2\u00ae\u00af\b\16\1\2\u00af\u00fc\3\2\2\2\u00b0\u00b1\7\22\2\2"+
		"\u00b1\u00b2\5\36\20\2\u00b2\u00b3\7\6\2\2\u00b3\u00b4\b\16\1\2\u00b4"+
		"\u00fc\3\2\2\2\u00b5\u00b6\7\22\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00fc\b"+
		"\16\1\2\u00b8\u00b9\7\23\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\7\6\2\2"+
		"\u00bb\u00bc\b\16\1\2\u00bc\u00fc\3\2\2\2\u00bd\u00be\7\23\2\2\u00be\u00bf"+
		"\7\6\2\2\u00bf\u00fc\b\16\1\2\u00c0\u00c1\7\24\2\2\u00c1\u00c2\5\36\20"+
		"\2\u00c2\u00c3\7\6\2\2\u00c3\u00c4\b\16\1\2\u00c4\u00fc\3\2\2\2\u00c5"+
		"\u00c6\7\24\2\2\u00c6\u00c7\7\6\2\2\u00c7\u00fc\b\16\1\2\u00c8\u00c9\7"+
		"\25\2\2\u00c9\u00ca\5\36\20\2\u00ca\u00cb\7\6\2\2\u00cb\u00cc\b\16\1\2"+
		"\u00cc\u00fc\3\2\2\2\u00cd\u00ce\7\25\2\2\u00ce\u00cf\7\6\2\2\u00cf\u00fc"+
		"\b\16\1\2\u00d0\u00d1\7\26\2\2\u00d1\u00d2\5\36\20\2\u00d2\u00d3\7\6\2"+
		"\2\u00d3\u00d4\b\16\1\2\u00d4\u00fc\3\2\2\2\u00d5\u00d6\7\27\2\2\u00d6"+
		"\u00d7\7\7\2\2\u00d7\u00d8\5\36\20\2\u00d8\u00d9\7\b\2\2\u00d9\u00da\7"+
		"\4\2\2\u00da\u00db\5\26\f\2\u00db\u00dc\7\5\2\2\u00dc\u00dd\b\16\1\2\u00dd"+
		"\u00fc\3\2\2\2\u00de\u00df\7\30\2\2\u00df\u00e0\7\7\2\2\u00e0\u00e1\5"+
		"\36\20\2\u00e1\u00e2\7\b\2\2\u00e2\u00e3\7\4\2\2\u00e3\u00e4\5\26\f\2"+
		"\u00e4\u00e5\7\5\2\2\u00e5\u00e6\b\16\1\2\u00e6\u00fc\3\2\2\2\u00e7\u00e8"+
		"\7\30\2\2\u00e8\u00e9\7\7\2\2\u00e9\u00ea\5\36\20\2\u00ea\u00eb\7\b\2"+
		"\2\u00eb\u00ec\7\4\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\7\5\2\2\u00ee"+
		"\u00ef\7\31\2\2\u00ef\u00f0\7\4\2\2\u00f0\u00f1\5\26\f\2\u00f1\u00f2\7"+
		"\5\2\2\u00f2\u00f3\b\16\1\2\u00f3\u00fc\3\2\2\2\u00f4\u00f5\7,\2\2\u00f5"+
		"\u00f6\7\7\2\2\u00f6\u00f7\5\34\17\2\u00f7\u00f8\7\b\2\2\u00f8\u00f9\7"+
		"\6\2\2\u00f9\u00fa\b\16\1\2\u00fa\u00fc\3\2\2\2\u00fb\u00a4\3\2\2\2\u00fb"+
		"\u00aa\3\2\2\2\u00fb\u00b0\3\2\2\2\u00fb\u00b5\3\2\2\2\u00fb\u00b8\3\2"+
		"\2\2\u00fb\u00bd\3\2\2\2\u00fb\u00c0\3\2\2\2\u00fb\u00c5\3\2\2\2\u00fb"+
		"\u00c8\3\2\2\2\u00fb\u00cd\3\2\2\2\u00fb\u00d0\3\2\2\2\u00fb\u00d5\3\2"+
		"\2\2\u00fb\u00de\3\2\2\2\u00fb\u00e7\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fc"+
		"\33\3\2\2\2\u00fd\u00fe\5\36\20\2\u00fe\u0105\b\17\1\2\u00ff\u0100\7\13"+
		"\2\2\u0100\u0101\5\36\20\2\u0101\u0102\b\17\1\2\u0102\u0104\3\2\2\2\u0103"+
		"\u00ff\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u00fd\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\35\3\2\2\2\u010a\u010b\b\20\1\2\u010b\u010c\7\7\2"+
		"\2\u010c\u010d\5\36\20\2\u010d\u010e\7\b\2\2\u010e\u010f\b\20\1\2\u010f"+
		"\u012b\3\2\2\2\u0110\u0111\7,\2\2\u0111\u012b\b\20\1\2\u0112\u0113\7\33"+
		"\2\2\u0113\u0114\5\24\13\2\u0114\u0115\7\34\2\2\u0115\u0116\7\7\2\2\u0116"+
		"\u0117\5\36\20\2\u0117\u0118\7\b\2\2\u0118\u0119\b\20\1\2\u0119\u012b"+
		"\3\2\2\2\u011a\u011b\7(\2\2\u011b\u011c\5\36\20\7\u011c\u011d\b\20\1\2"+
		"\u011d\u012b\3\2\2\2\u011e\u011f\7,\2\2\u011f\u0120\7\7\2\2\u0120\u0121"+
		"\5\34\17\2\u0121\u0122\7\b\2\2\u0122\u0123\b\20\1\2\u0123\u012b\3\2\2"+
		"\2\u0124\u0125\7)\2\2\u0125\u012b\b\20\1\2\u0126\u0127\7*\2\2\u0127\u012b"+
		"\b\20\1\2\u0128\u0129\7+\2\2\u0129\u012b\b\20\1\2\u012a\u010a\3\2\2\2"+
		"\u012a\u0110\3\2\2\2\u012a\u0112\3\2\2\2\u012a\u011a\3\2\2\2\u012a\u011e"+
		"\3\2\2\2\u012a\u0124\3\2\2\2\u012a\u0126\3\2\2\2\u012a\u0128\3\2\2\2\u012b"+
		"\u0156\3\2\2\2\u012c\u012d\f\r\2\2\u012d\u012e\t\2\2\2\u012e\u012f\5\36"+
		"\20\16\u012f\u0130\b\20\1\2\u0130\u0155\3\2\2\2\u0131\u0132\f\f\2\2\u0132"+
		"\u0133\t\3\2\2\u0133\u0134\5\36\20\r\u0134\u0135\b\20\1\2\u0135\u0155"+
		"\3\2\2\2\u0136\u0137\f\13\2\2\u0137\u0138\t\4\2\2\u0138\u0139\5\36\20"+
		"\f\u0139\u013a\b\20\1\2\u013a\u0155\3\2\2\2\u013b\u013c\f\n\2\2\u013c"+
		"\u013d\t\5\2\2\u013d\u013e\5\36\20\13\u013e\u013f\b\20\1\2\u013f\u0155"+
		"\3\2\2\2\u0140\u0141\f\t\2\2\u0141\u0142\7&\2\2\u0142\u0143\5\36\20\n"+
		"\u0143\u0144\b\20\1\2\u0144\u0155\3\2\2\2\u0145\u0146\f\b\2\2\u0146\u0147"+
		"\7\'\2\2\u0147\u0148\5\36\20\t\u0148\u0149\b\20\1\2\u0149\u0155\3\2\2"+
		"\2\u014a\u014b\f\21\2\2\u014b\u014c\7\17\2\2\u014c\u014d\5\36\20\2\u014d"+
		"\u014e\7\20\2\2\u014e\u014f\b\20\1\2\u014f\u0155\3\2\2\2\u0150\u0151\f"+
		"\20\2\2\u0151\u0152\7\32\2\2\u0152\u0153\7,\2\2\u0153\u0155\b\20\1\2\u0154"+
		"\u012c\3\2\2\2\u0154\u0131\3\2\2\2\u0154\u0136\3\2\2\2\u0154\u013b\3\2"+
		"\2\2\u0154\u0140\3\2\2\2\u0154\u0145\3\2\2\2\u0154\u014a\3\2\2\2\u0154"+
		"\u0150\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2"+
		"\2\2\u0157\37\3\2\2\2\u0158\u0156\3\2\2\2\21)MTctw\u008c\u0093\u009f\u00fb"+
		"\u0105\u0108\u012a\u0154\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}