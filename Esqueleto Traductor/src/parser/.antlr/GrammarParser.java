// Generated from d:\Temporal\dlp\continua\DLP\Esqueleto Traductor\src\parser\Grammar.g4 by ANTLR 4.9.2

    import ast.*;

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
		RULE_sentences = 10, RULE_sentence = 11, RULE_callFunctionParams = 12, 
		RULE_expression = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definitions", "definition", "definitionVariables", "definitionVariable", 
			"structFields", "structField", "definitionFunctionParams", "definitionFunctionParam", 
			"type", "sentences", "sentence", "callFunctionParams", "expression"
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
			setState(28);
			((StartContext)_localctx).definitions = definitions();
			setState(29);
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << IDENT))) != 0)) {
				{
				{
				setState(32);
				((DefinitionsContext)_localctx).definition = definition();
				 _localctx.list.add(((DefinitionsContext)_localctx).definition.ast); 
				}
				}
				setState(39);
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				((DefinitionContext)_localctx).definitionVariable = definitionVariable();
				 ((DefinitionContext)_localctx).ast =  ((DefinitionContext)_localctx).definitionVariable.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(T__0);
				setState(44);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(45);
				match(T__1);
				setState(46);
				((DefinitionContext)_localctx).structFields = structFields();
				setState(47);
				match(T__2);
				setState(48);
				match(T__3);
				 ((DefinitionContext)_localctx).ast =  new DefinitionStruct(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).structFields.list); 
						
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(52);
				match(T__4);
				setState(53);
				((DefinitionContext)_localctx).definitionFunctionParams = definitionFunctionParams();
				setState(54);
				match(T__5);
				setState(55);
				match(T__1);
				setState(56);
				((DefinitionContext)_localctx).definitionVariables = definitionVariables();
				setState(57);
				((DefinitionContext)_localctx).sentences = sentences();
				setState(58);
				match(T__2);
				 ((DefinitionContext)_localctx).ast =  new DefinitionFunction(((DefinitionContext)_localctx).IDENT, ((DefinitionContext)_localctx).definitionFunctionParams.list, null, ((DefinitionContext)_localctx).definitionVariables.list, ((DefinitionContext)_localctx).sentences.list); 
						
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				((DefinitionContext)_localctx).IDENT = match(IDENT);
				setState(62);
				match(T__4);
				setState(63);
				((DefinitionContext)_localctx).definitionFunctionParams = definitionFunctionParams();
				setState(64);
				match(T__5);
				setState(65);
				match(T__6);
				setState(66);
				((DefinitionContext)_localctx).type = type();
				setState(67);
				match(T__1);
				setState(68);
				((DefinitionContext)_localctx).definitionVariables = definitionVariables();
				setState(69);
				((DefinitionContext)_localctx).sentences = sentences();
				setState(70);
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
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(75);
				((DefinitionVariablesContext)_localctx).definitionVariable = definitionVariable();
				 _localctx.list.add(((DefinitionVariablesContext)_localctx).definitionVariable.ast); 
				}
				}
				setState(82);
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
			setState(83);
			match(T__7);
			setState(84);
			((DefinitionVariableContext)_localctx).IDENT = match(IDENT);
			setState(85);
			match(T__6);
			setState(86);
			((DefinitionVariableContext)_localctx).type = type();
			setState(87);
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
		public List<DefinitionVariable> list = new ArrayList<DefinitionVariable>();
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(90);
				((StructFieldsContext)_localctx).structField = structField();
				 _localctx.list.add(((StructFieldsContext)_localctx).structField.ast); 
				}
				}
				setState(97);
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
		public DefinitionVariable ast;
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
			setState(98);
			((StructFieldContext)_localctx).IDENT = match(IDENT);
			setState(99);
			match(T__6);
			setState(100);
			((StructFieldContext)_localctx).type = type();
			setState(101);
			match(T__3);
			 ((StructFieldContext)_localctx).ast =  new DefinitionVariable(((StructFieldContext)_localctx).IDENT, ((StructFieldContext)_localctx).type.ast); 
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
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(104);
				((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam = definitionFunctionParam();
				 _localctx.list.add(((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam.ast); 
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(106);
					match(T__8);
					setState(107);
					((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam = definitionFunctionParam();
					 _localctx.list.add(((DefinitionFunctionParamsContext)_localctx).definitionFunctionParam.ast); 
					}
					}
					setState(114);
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
			setState(117);
			((DefinitionFunctionParamContext)_localctx).IDENT = match(IDENT);
			setState(118);
			match(T__6);
			setState(119);
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
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(T__9);
				 ((TypeContext)_localctx).ast =  new TypeInt(); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(T__10);
				 ((TypeContext)_localctx).ast =  new TypeFloat(); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				match(T__11);
				 ((TypeContext)_localctx).ast =  new TypeChar(); 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				match(T__12);
				setState(129);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(130);
				match(T__13);
				setState(131);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new TypeArray(((TypeContext)_localctx).INT_CONSTANT, ((TypeContext)_localctx).type.ast); 
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
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
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__24) | (1L << T__37) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				{
				setState(138);
				((SentencesContext)_localctx).sentence = sentence();
				 _localctx.list.add(((SentencesContext)_localctx).sentence.ast); 
				}
				}
				setState(145);
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

	public static class SentenceContext extends ParserRuleContext {
		public Sentence ast;
		public ExpressionContext left;
		public ExpressionContext right;
		public ExpressionContext expression;
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
		enterRule(_localctx, 22, RULE_sentence);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				((SentenceContext)_localctx).left = expression(0);
				setState(147);
				match(T__14);
				setState(148);
				((SentenceContext)_localctx).right = expression(0);
				setState(149);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Assignment(((SentenceContext)_localctx).left.ast, ((SentenceContext)_localctx).right.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(T__15);
				setState(153);
				((SentenceContext)_localctx).expression = expression(0);
				setState(154);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Return(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(T__15);
				setState(158);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Return(null); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(T__16);
				setState(161);
				((SentenceContext)_localctx).expression = expression(0);
				setState(162);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Print(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				match(T__16);
				setState(166);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Print(null); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				match(T__17);
				setState(169);
				((SentenceContext)_localctx).expression = expression(0);
				setState(170);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Printsp(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(173);
				match(T__17);
				setState(174);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Printsp(null); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(176);
				match(T__18);
				setState(177);
				((SentenceContext)_localctx).expression = expression(0);
				setState(178);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Println(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(181);
				match(T__18);
				setState(182);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Println(null); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(184);
				match(T__19);
				setState(185);
				((SentenceContext)_localctx).expression = expression(0);
				setState(186);
				match(T__3);
				 ((SentenceContext)_localctx).ast =  new Read(((SentenceContext)_localctx).expression.ast); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(189);
				match(T__20);
				setState(190);
				match(T__4);
				setState(191);
				((SentenceContext)_localctx).expression = expression(0);
				setState(192);
				match(T__5);
				setState(193);
				match(T__1);
				setState(194);
				((SentenceContext)_localctx).sentences = sentences();
				setState(195);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new While(((SentenceContext)_localctx).expression.ast, ((SentenceContext)_localctx).sentences.list); 
						
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(198);
				match(T__21);
				setState(199);
				match(T__4);
				setState(200);
				((SentenceContext)_localctx).expression = expression(0);
				setState(201);
				match(T__5);
				setState(202);
				match(T__1);
				setState(203);
				((SentenceContext)_localctx).sentences = sentences();
				setState(204);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new If(((SentenceContext)_localctx).expression.ast, ((SentenceContext)_localctx).sentences.list, null); 
						
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(207);
				match(T__21);
				setState(208);
				match(T__4);
				setState(209);
				((SentenceContext)_localctx).expression = expression(0);
				setState(210);
				match(T__5);
				setState(211);
				match(T__1);
				setState(212);
				((SentenceContext)_localctx).ifSentences = sentences();
				setState(213);
				match(T__2);
				setState(214);
				match(T__22);
				setState(215);
				match(T__1);
				setState(216);
				((SentenceContext)_localctx).elseSentences = sentences();
				setState(217);
				match(T__2);
				 ((SentenceContext)_localctx).ast =  new If(((SentenceContext)_localctx).expression.ast, ((SentenceContext)_localctx).ifSentences.list, ((SentenceContext)_localctx).elseSentences.list); 
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(220);
				((SentenceContext)_localctx).IDENT = match(IDENT);
				setState(221);
				match(T__4);
				setState(222);
				((SentenceContext)_localctx).callFunctionParams = callFunctionParams();
				setState(223);
				match(T__5);
				setState(224);
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
		enterRule(_localctx, 24, RULE_callFunctionParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__24) | (1L << T__37) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(229);
				((CallFunctionParamsContext)_localctx).expression = expression(0);
				 _localctx.list.add(((CallFunctionParamsContext)_localctx).expression.ast); 
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(231);
					match(T__8);
					setState(232);
					((CallFunctionParamsContext)_localctx).expression = expression(0);
					 _localctx.list.add(((CallFunctionParamsContext)_localctx).expression.ast); 
					}
					}
					setState(239);
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
		public TypeContext type;
		public Token operator;
		public Token IDENT;
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(243);
				match(T__4);
				setState(244);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(245);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast; 
				}
				break;
			case 2:
				{
				setState(248);
				match(T__24);
				setState(249);
				((ExpressionContext)_localctx).type = type();
				setState(250);
				match(T__25);
				setState(251);
				match(T__4);
				setState(252);
				((ExpressionContext)_localctx).expression = expression(0);
				setState(253);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).type.ast,((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 3:
				{
				setState(256);
				((ExpressionContext)_localctx).operator = match(T__37);
				setState(257);
				((ExpressionContext)_localctx).expression = expression(6);
				 ((ExpressionContext)_localctx).ast =  new UnaryExpression(((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).expression.ast); 
				}
				break;
			case 4:
				{
				setState(260);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				setState(261);
				match(T__4);
				setState(262);
				((ExpressionContext)_localctx).callFunctionParams = callFunctionParams();
				setState(263);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  new ExpressionCallFunction(((ExpressionContext)_localctx).IDENT,((ExpressionContext)_localctx).callFunctionParams.list); 
						
				}
				break;
			case 5:
				{
				setState(266);
				((ExpressionContext)_localctx).IDENT = match(IDENT);
				 ((ExpressionContext)_localctx).ast =  new AccessVariable(((ExpressionContext)_localctx).IDENT); 
				}
				break;
			case 6:
				{
				setState(268);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new ConstantInt(((ExpressionContext)_localctx).INT_CONSTANT); 
				}
				break;
			case 7:
				{
				setState(270);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new ConstantFloat(((ExpressionContext)_localctx).REAL_CONSTANT); 
				}
				break;
			case 8:
				{
				setState(272);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new ConstantChar(((ExpressionContext)_localctx).CHAR_CONSTANT); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(318);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(316);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(277);
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
						setState(278);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(13);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(281);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(282);
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
						setState(283);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(12);
						 ((ExpressionContext)_localctx).ast =  new ArithmeticExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(286);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(287);
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
						setState(288);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(11);
						 ((ExpressionContext)_localctx).ast =  new RelationalExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(292);
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
						setState(293);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(10);
						 ((ExpressionContext)_localctx).ast =  new RelationalExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(297);
						((ExpressionContext)_localctx).operator = match(T__35);
						setState(298);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(9);
						 ((ExpressionContext)_localctx).ast =  new LogicalExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(301);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(302);
						((ExpressionContext)_localctx).operator = match(T__36);
						setState(303);
						((ExpressionContext)_localctx).right = ((ExpressionContext)_localctx).expression = expression(8);
						 ((ExpressionContext)_localctx).ast =  new LogicalExpression(((ExpressionContext)_localctx).left.ast,((ExpressionContext)_localctx).operator,((ExpressionContext)_localctx).right.ast); 
						          		
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.array = _prevctx;
						_localctx.array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(307);
						match(T__12);
						setState(308);
						((ExpressionContext)_localctx).index = ((ExpressionContext)_localctx).expression = expression(0);
						setState(309);
						match(T__13);
						 ((ExpressionContext)_localctx).ast =  new AccessArray(((ExpressionContext)_localctx).array.ast,((ExpressionContext)_localctx).index.ast); 
						          		
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.struct = _prevctx;
						_localctx.struct = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(313);
						match(T__23);
						setState(314);
						((ExpressionContext)_localctx).IDENT = match(IDENT);
						 ((ExpressionContext)_localctx).ast =  new AccessStructField(((ExpressionContext)_localctx).struct.ast,((ExpressionContext)_localctx).IDENT); 
						}
						break;
					}
					} 
				}
				setState(320);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 15);
		case 7:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0144\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7"+
		"\3&\n\3\f\3\16\3)\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\7\5Q\n\5\f\5\16\5T\13\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tq\n\t\f\t\16\tt\13\t\5\tv\n\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u008b\n\13\3\f\3\f\3\f\7\f\u0090\n\f\f\f\16\f\u0093"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e6\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\7\16\u00ee\n\16\f\16\16\16\u00f1\13\16\5\16"+
		"\u00f3\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0115\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u013f\n\17\f\17\16\17\u0142\13"+
		"\17\3\17\2\3\34\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\6\3\2\35\37\3"+
		"\2 !\4\2\33\34\"#\3\2$%\2\u0160\2\36\3\2\2\2\4\'\3\2\2\2\6K\3\2\2\2\b"+
		"R\3\2\2\2\nU\3\2\2\2\fa\3\2\2\2\16d\3\2\2\2\20u\3\2\2\2\22w\3\2\2\2\24"+
		"\u008a\3\2\2\2\26\u0091\3\2\2\2\30\u00e5\3\2\2\2\32\u00f2\3\2\2\2\34\u0114"+
		"\3\2\2\2\36\37\5\4\3\2\37 \7\2\2\3 !\b\2\1\2!\3\3\2\2\2\"#\5\6\4\2#$\b"+
		"\3\1\2$&\3\2\2\2%\"\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2"+
		")\'\3\2\2\2*+\5\n\6\2+,\b\4\1\2,L\3\2\2\2-.\7\3\2\2./\7,\2\2/\60\7\4\2"+
		"\2\60\61\5\f\7\2\61\62\7\5\2\2\62\63\7\6\2\2\63\64\b\4\1\2\64L\3\2\2\2"+
		"\65\66\7,\2\2\66\67\7\7\2\2\678\5\20\t\289\7\b\2\29:\7\4\2\2:;\5\b\5\2"+
		";<\5\26\f\2<=\7\5\2\2=>\b\4\1\2>L\3\2\2\2?@\7,\2\2@A\7\7\2\2AB\5\20\t"+
		"\2BC\7\b\2\2CD\7\t\2\2DE\5\24\13\2EF\7\4\2\2FG\5\b\5\2GH\5\26\f\2HI\7"+
		"\5\2\2IJ\b\4\1\2JL\3\2\2\2K*\3\2\2\2K-\3\2\2\2K\65\3\2\2\2K?\3\2\2\2L"+
		"\7\3\2\2\2MN\5\n\6\2NO\b\5\1\2OQ\3\2\2\2PM\3\2\2\2QT\3\2\2\2RP\3\2\2\2"+
		"RS\3\2\2\2S\t\3\2\2\2TR\3\2\2\2UV\7\n\2\2VW\7,\2\2WX\7\t\2\2XY\5\24\13"+
		"\2YZ\7\6\2\2Z[\b\6\1\2[\13\3\2\2\2\\]\5\16\b\2]^\b\7\1\2^`\3\2\2\2_\\"+
		"\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\r\3\2\2\2ca\3\2\2\2de\7,\2\2e"+
		"f\7\t\2\2fg\5\24\13\2gh\7\6\2\2hi\b\b\1\2i\17\3\2\2\2jk\5\22\n\2kr\b\t"+
		"\1\2lm\7\13\2\2mn\5\22\n\2no\b\t\1\2oq\3\2\2\2pl\3\2\2\2qt\3\2\2\2rp\3"+
		"\2\2\2rs\3\2\2\2sv\3\2\2\2tr\3\2\2\2uj\3\2\2\2uv\3\2\2\2v\21\3\2\2\2w"+
		"x\7,\2\2xy\7\t\2\2yz\5\24\13\2z{\b\n\1\2{\23\3\2\2\2|}\7\f\2\2}\u008b"+
		"\b\13\1\2~\177\7\r\2\2\177\u008b\b\13\1\2\u0080\u0081\7\16\2\2\u0081\u008b"+
		"\b\13\1\2\u0082\u0083\7\17\2\2\u0083\u0084\7)\2\2\u0084\u0085\7\20\2\2"+
		"\u0085\u0086\5\24\13\2\u0086\u0087\b\13\1\2\u0087\u008b\3\2\2\2\u0088"+
		"\u0089\7,\2\2\u0089\u008b\b\13\1\2\u008a|\3\2\2\2\u008a~\3\2\2\2\u008a"+
		"\u0080\3\2\2\2\u008a\u0082\3\2\2\2\u008a\u0088\3\2\2\2\u008b\25\3\2\2"+
		"\2\u008c\u008d\5\30\r\2\u008d\u008e\b\f\1\2\u008e\u0090\3\2\2\2\u008f"+
		"\u008c\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\27\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\5\34\17\2\u0095"+
		"\u0096\7\21\2\2\u0096\u0097\5\34\17\2\u0097\u0098\7\6\2\2\u0098\u0099"+
		"\b\r\1\2\u0099\u00e6\3\2\2\2\u009a\u009b\7\22\2\2\u009b\u009c\5\34\17"+
		"\2\u009c\u009d\7\6\2\2\u009d\u009e\b\r\1\2\u009e\u00e6\3\2\2\2\u009f\u00a0"+
		"\7\22\2\2\u00a0\u00a1\7\6\2\2\u00a1\u00e6\b\r\1\2\u00a2\u00a3\7\23\2\2"+
		"\u00a3\u00a4\5\34\17\2\u00a4\u00a5\7\6\2\2\u00a5\u00a6\b\r\1\2\u00a6\u00e6"+
		"\3\2\2\2\u00a7\u00a8\7\23\2\2\u00a8\u00a9\7\6\2\2\u00a9\u00e6\b\r\1\2"+
		"\u00aa\u00ab\7\24\2\2\u00ab\u00ac\5\34\17\2\u00ac\u00ad\7\6\2\2\u00ad"+
		"\u00ae\b\r\1\2\u00ae\u00e6\3\2\2\2\u00af\u00b0\7\24\2\2\u00b0\u00b1\7"+
		"\6\2\2\u00b1\u00e6\b\r\1\2\u00b2\u00b3\7\25\2\2\u00b3\u00b4\5\34\17\2"+
		"\u00b4\u00b5\7\6\2\2\u00b5\u00b6\b\r\1\2\u00b6\u00e6\3\2\2\2\u00b7\u00b8"+
		"\7\25\2\2\u00b8\u00b9\7\6\2\2\u00b9\u00e6\b\r\1\2\u00ba\u00bb\7\26\2\2"+
		"\u00bb\u00bc\5\34\17\2\u00bc\u00bd\7\6\2\2\u00bd\u00be\b\r\1\2\u00be\u00e6"+
		"\3\2\2\2\u00bf\u00c0\7\27\2\2\u00c0\u00c1\7\7\2\2\u00c1\u00c2\5\34\17"+
		"\2\u00c2\u00c3\7\b\2\2\u00c3\u00c4\7\4\2\2\u00c4\u00c5\5\26\f\2\u00c5"+
		"\u00c6\7\5\2\2\u00c6\u00c7\b\r\1\2\u00c7\u00e6\3\2\2\2\u00c8\u00c9\7\30"+
		"\2\2\u00c9\u00ca\7\7\2\2\u00ca\u00cb\5\34\17\2\u00cb\u00cc\7\b\2\2\u00cc"+
		"\u00cd\7\4\2\2\u00cd\u00ce\5\26\f\2\u00ce\u00cf\7\5\2\2\u00cf\u00d0\b"+
		"\r\1\2\u00d0\u00e6\3\2\2\2\u00d1\u00d2\7\30\2\2\u00d2\u00d3\7\7\2\2\u00d3"+
		"\u00d4\5\34\17\2\u00d4\u00d5\7\b\2\2\u00d5\u00d6\7\4\2\2\u00d6\u00d7\5"+
		"\26\f\2\u00d7\u00d8\7\5\2\2\u00d8\u00d9\7\31\2\2\u00d9\u00da\7\4\2\2\u00da"+
		"\u00db\5\26\f\2\u00db\u00dc\7\5\2\2\u00dc\u00dd\b\r\1\2\u00dd\u00e6\3"+
		"\2\2\2\u00de\u00df\7,\2\2\u00df\u00e0\7\7\2\2\u00e0\u00e1\5\32\16\2\u00e1"+
		"\u00e2\7\b\2\2\u00e2\u00e3\7\6\2\2\u00e3\u00e4\b\r\1\2\u00e4\u00e6\3\2"+
		"\2\2\u00e5\u0094\3\2\2\2\u00e5\u009a\3\2\2\2\u00e5\u009f\3\2\2\2\u00e5"+
		"\u00a2\3\2\2\2\u00e5\u00a7\3\2\2\2\u00e5\u00aa\3\2\2\2\u00e5\u00af\3\2"+
		"\2\2\u00e5\u00b2\3\2\2\2\u00e5\u00b7\3\2\2\2\u00e5\u00ba\3\2\2\2\u00e5"+
		"\u00bf\3\2\2\2\u00e5\u00c8\3\2\2\2\u00e5\u00d1\3\2\2\2\u00e5\u00de\3\2"+
		"\2\2\u00e6\31\3\2\2\2\u00e7\u00e8\5\34\17\2\u00e8\u00ef\b\16\1\2\u00e9"+
		"\u00ea\7\13\2\2\u00ea\u00eb\5\34\17\2\u00eb\u00ec\b\16\1\2\u00ec\u00ee"+
		"\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00e7\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\33\3\2\2\2\u00f4\u00f5\b\17\1\2\u00f5\u00f6"+
		"\7\7\2\2\u00f6\u00f7\5\34\17\2\u00f7\u00f8\7\b\2\2\u00f8\u00f9\b\17\1"+
		"\2\u00f9\u0115\3\2\2\2\u00fa\u00fb\7\33\2\2\u00fb\u00fc\5\24\13\2\u00fc"+
		"\u00fd\7\34\2\2\u00fd\u00fe\7\7\2\2\u00fe\u00ff\5\34\17\2\u00ff\u0100"+
		"\7\b\2\2\u0100\u0101\b\17\1\2\u0101\u0115\3\2\2\2\u0102\u0103\7(\2\2\u0103"+
		"\u0104\5\34\17\b\u0104\u0105\b\17\1\2\u0105\u0115\3\2\2\2\u0106\u0107"+
		"\7,\2\2\u0107\u0108\7\7\2\2\u0108\u0109\5\32\16\2\u0109\u010a\7\b\2\2"+
		"\u010a\u010b\b\17\1\2\u010b\u0115\3\2\2\2\u010c\u010d\7,\2\2\u010d\u0115"+
		"\b\17\1\2\u010e\u010f\7)\2\2\u010f\u0115\b\17\1\2\u0110\u0111\7*\2\2\u0111"+
		"\u0115\b\17\1\2\u0112\u0113\7+\2\2\u0113\u0115\b\17\1\2\u0114\u00f4\3"+
		"\2\2\2\u0114\u00fa\3\2\2\2\u0114\u0102\3\2\2\2\u0114\u0106\3\2\2\2\u0114"+
		"\u010c\3\2\2\2\u0114\u010e\3\2\2\2\u0114\u0110\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0140\3\2\2\2\u0116\u0117\f\16\2\2\u0117\u0118\t\2\2\2\u0118"+
		"\u0119\5\34\17\17\u0119\u011a\b\17\1\2\u011a\u013f\3\2\2\2\u011b\u011c"+
		"\f\r\2\2\u011c\u011d\t\3\2\2\u011d\u011e\5\34\17\16\u011e\u011f\b\17\1"+
		"\2\u011f\u013f\3\2\2\2\u0120\u0121\f\f\2\2\u0121\u0122\t\4\2\2\u0122\u0123"+
		"\5\34\17\r\u0123\u0124\b\17\1\2\u0124\u013f\3\2\2\2\u0125\u0126\f\13\2"+
		"\2\u0126\u0127\t\5\2\2\u0127\u0128\5\34\17\f\u0128\u0129\b\17\1\2\u0129"+
		"\u013f\3\2\2\2\u012a\u012b\f\n\2\2\u012b\u012c\7&\2\2\u012c\u012d\5\34"+
		"\17\13\u012d\u012e\b\17\1\2\u012e\u013f\3\2\2\2\u012f\u0130\f\t\2\2\u0130"+
		"\u0131\7\'\2\2\u0131\u0132\5\34\17\n\u0132\u0133\b\17\1\2\u0133\u013f"+
		"\3\2\2\2\u0134\u0135\f\21\2\2\u0135\u0136\7\17\2\2\u0136\u0137\5\34\17"+
		"\2\u0137\u0138\7\20\2\2\u0138\u0139\b\17\1\2\u0139\u013f\3\2\2\2\u013a"+
		"\u013b\f\20\2\2\u013b\u013c\7\32\2\2\u013c\u013d\7,\2\2\u013d\u013f\b"+
		"\17\1\2\u013e\u0116\3\2\2\2\u013e\u011b\3\2\2\2\u013e\u0120\3\2\2\2\u013e"+
		"\u0125\3\2\2\2\u013e\u012a\3\2\2\2\u013e\u012f\3\2\2\2\u013e\u0134\3\2"+
		"\2\2\u013e\u013a\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\35\3\2\2\2\u0142\u0140\3\2\2\2\20\'KRaru\u008a\u0091"+
		"\u00e5\u00ef\u00f2\u0114\u013e\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}