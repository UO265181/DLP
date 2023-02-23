// Generated from c:\Users\UO265181\Downloads\DLP\Esqueleto Traductor\src\parser\Grammar.g4 by ANTLR 4.9.2
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
		RULE_start = 0, RULE_definition = 1, RULE_type = 2, RULE_sentence = 3, 
		RULE_defFunParams = 4, RULE_callFunParams = 5, RULE_expression = 6, RULE_varAccess = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "definition", "type", "sentence", "defFunParams", "callFunParams", 
			"expression", "varAccess"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "';'", "'struct'", "'{'", "'}'", "'('", "')'", 
			"'int'", "'float'", "'char'", "'['", "']'", "'print'", "'printsp'", "'println'", 
			"'read'", "'return'", "'='", "'if'", "'else'", "'while'", "','", "'!'", 
			"'<'", "'>'", "'*'", "'/'", "'%'", "'+'", "'-'", "'>='", "'<='", "'=='", 
			"'!='", "'&&'", "'||'", "'.'"
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
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << IDENT))) != 0)) {
				{
				{
				setState(16);
				definition();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
			match(EOF);
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
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public DefFunParamsContext defFunParams() {
			return getRuleContext(DefFunParamsContext.class,0);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				match(T__0);
				setState(25);
				match(IDENT);
				setState(26);
				match(T__1);
				setState(27);
				type();
				setState(28);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(T__3);
				setState(31);
				match(IDENT);
				setState(32);
				match(T__4);
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(33);
					match(IDENT);
					setState(34);
					match(T__1);
					setState(35);
					type();
					setState(36);
					match(T__2);
					}
					}
					setState(42);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(43);
				match(T__5);
				setState(44);
				match(T__2);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				match(IDENT);
				setState(46);
				match(T__6);
				setState(47);
				defFunParams();
				setState(48);
				match(T__7);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(49);
					match(T__1);
					setState(50);
					type();
					}
				}

				setState(53);
				match(T__4);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(54);
					match(T__0);
					setState(55);
					match(IDENT);
					setState(56);
					match(T__1);
					setState(57);
					type();
					setState(58);
					match(T__2);
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(65);
					sentence();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
				match(T__5);
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

	public static class TypeContext extends ParserRuleContext {
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
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				match(T__11);
				setState(79);
				match(INT_CONSTANT);
				setState(80);
				match(T__12);
				setState(81);
				type();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				match(IDENT);
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

	public static class SentenceContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarAccessContext varAccess() {
			return getRuleContext(VarAccessContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public CallFunParamsContext callFunParams() {
			return getRuleContext(CallFunParamsContext.class,0);
		}
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentence);
		int _la;
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(T__13);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__23) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(86);
					expression(0);
					}
				}

				setState(89);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(T__14);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__23) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(91);
					expression(0);
					}
				}

				setState(94);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				match(T__15);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__23) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(96);
					expression(0);
					}
				}

				setState(99);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(T__16);
				setState(101);
				varAccess(0);
				setState(102);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(104);
				match(T__17);
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__23) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
					{
					setState(105);
					expression(0);
					}
				}

				setState(108);
				match(T__2);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				varAccess(0);
				setState(110);
				match(T__18);
				setState(111);
				expression(0);
				setState(112);
				match(T__2);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(114);
				match(IDENT);
				setState(115);
				match(T__6);
				setState(116);
				callFunParams();
				setState(117);
				match(T__7);
				setState(118);
				match(T__2);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(120);
				match(T__19);
				setState(121);
				match(T__6);
				setState(122);
				expression(0);
				setState(123);
				match(T__7);
				setState(124);
				match(T__4);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(125);
					sentence();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(T__5);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(133);
				match(T__19);
				setState(134);
				match(T__6);
				setState(135);
				expression(0);
				setState(136);
				match(T__7);
				setState(137);
				match(T__4);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(138);
					sentence();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(T__5);
				setState(145);
				match(T__20);
				setState(146);
				match(T__4);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(147);
					sentence();
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(153);
				match(T__5);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(155);
				match(T__21);
				setState(156);
				match(T__6);
				setState(157);
				expression(0);
				setState(158);
				match(T__7);
				setState(159);
				match(T__4);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__21) | (1L << IDENT))) != 0)) {
					{
					{
					setState(160);
					sentence();
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
				match(T__5);
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

	public static class DefFunParamsContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public DefFunParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFunParams; }
	}

	public final DefFunParamsContext defFunParams() throws RecognitionException {
		DefFunParamsContext _localctx = new DefFunParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defFunParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(170);
				match(IDENT);
				setState(171);
				match(T__1);
				setState(172);
				type();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__22) {
					{
					{
					setState(173);
					match(T__22);
					setState(174);
					match(IDENT);
					setState(175);
					match(T__1);
					setState(176);
					type();
					}
					}
					setState(181);
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

	public static class CallFunParamsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CallFunParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callFunParams; }
	}

	public final CallFunParamsContext callFunParams() throws RecognitionException {
		CallFunParamsContext _localctx = new CallFunParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_callFunParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__23) | (1L << T__24) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << IDENT))) != 0)) {
				{
				setState(184);
				expression(0);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__22) {
					{
					{
					setState(185);
					match(T__22);
					setState(186);
					expression(0);
					}
					}
					setState(191);
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
		public TerminalNode INT_CONSTANT() { return getToken(GrammarParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(GrammarParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(GrammarParser.CHAR_CONSTANT, 0); }
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public CallFunParamsContext callFunParams() {
			return getRuleContext(CallFunParamsContext.class,0);
		}
		public VarAccessContext varAccess() {
			return getRuleContext(VarAccessContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(195);
				match(INT_CONSTANT);
				}
				break;
			case 2:
				{
				setState(196);
				match(REAL_CONSTANT);
				}
				break;
			case 3:
				{
				setState(197);
				match(CHAR_CONSTANT);
				}
				break;
			case 4:
				{
				setState(198);
				match(IDENT);
				setState(199);
				match(T__6);
				setState(200);
				callFunParams();
				setState(201);
				match(T__7);
				}
				break;
			case 5:
				{
				setState(203);
				varAccess(0);
				}
				break;
			case 6:
				{
				setState(204);
				match(T__6);
				setState(205);
				expression(0);
				setState(206);
				match(T__7);
				}
				break;
			case 7:
				{
				setState(208);
				match(T__23);
				setState(209);
				expression(8);
				}
				break;
			case 8:
				{
				setState(210);
				match(T__24);
				setState(211);
				type();
				setState(212);
				match(T__25);
				setState(213);
				match(T__6);
				setState(214);
				expression(0);
				setState(215);
				match(T__7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(237);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(220);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(223);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(226);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__31) | (1L << T__32))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(227);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(229);
						_la = _input.LA(1);
						if ( !(_la==T__33 || _la==T__34) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(230);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(232);
						match(T__35);
						setState(233);
						expression(3);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(235);
						match(T__36);
						setState(236);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class VarAccessContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public VarAccessContext varAccess() {
			return getRuleContext(VarAccessContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAccess; }
	}

	public final VarAccessContext varAccess() throws RecognitionException {
		return varAccess(0);
	}

	private VarAccessContext varAccess(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarAccessContext _localctx = new VarAccessContext(_ctx, _parentState);
		VarAccessContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_varAccess, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(243);
			match(IDENT);
			}
			_ctx.stop = _input.LT(-1);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(253);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new VarAccessContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_varAccess);
						setState(245);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(246);
						match(T__37);
						setState(247);
						match(IDENT);
						}
						break;
					case 2:
						{
						_localctx = new VarAccessContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_varAccess);
						setState(248);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(249);
						match(T__11);
						setState(250);
						expression(0);
						setState(251);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 7:
			return varAccess_sempred((VarAccessContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean varAccess_sempred(VarAccessContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u0105\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2"+
		"\f\2\16\2\27\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3\66\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3\3\3\7\3"+
		"E\n\3\f\3\16\3H\13\3\3\3\3\3\5\3L\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4V\n\4\3\5\3\5\5\5Z\n\5\3\5\3\5\3\5\5\5_\n\5\3\5\3\5\3\5\5\5d\n\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5m\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0081\n\5\f\5\16\5\u0084\13"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u008e\n\5\f\5\16\5\u0091\13\5\3"+
		"\5\3\5\3\5\3\5\7\5\u0097\n\5\f\5\16\5\u009a\13\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5\u00a4\n\5\f\5\16\5\u00a7\13\5\3\5\3\5\5\5\u00ab\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00b4\n\6\f\6\16\6\u00b7\13\6\5\6\u00b9\n"+
		"\6\3\7\3\7\3\7\7\7\u00be\n\7\f\7\16\7\u00c1\13\7\5\7\u00c3\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00dc\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00f0\n\b\f\b\16\b\u00f3\13\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0100\n\t\f\t\16\t\u0103\13"+
		"\t\3\t\2\4\16\20\n\2\4\6\b\n\f\16\20\2\6\3\2\35\37\3\2 !\4\2\33\34\"#"+
		"\3\2$%\2\u012b\2\25\3\2\2\2\4K\3\2\2\2\6U\3\2\2\2\b\u00aa\3\2\2\2\n\u00b8"+
		"\3\2\2\2\f\u00c2\3\2\2\2\16\u00db\3\2\2\2\20\u00f4\3\2\2\2\22\24\5\4\3"+
		"\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2\2"+
		"\2\27\25\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32\33\7\3\2\2\33\34\7,\2\2"+
		"\34\35\7\4\2\2\35\36\5\6\4\2\36\37\7\5\2\2\37L\3\2\2\2 !\7\6\2\2!\"\7"+
		",\2\2\"*\7\7\2\2#$\7,\2\2$%\7\4\2\2%&\5\6\4\2&\'\7\5\2\2\')\3\2\2\2(#"+
		"\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\b\2\2."+
		"L\7\5\2\2/\60\7,\2\2\60\61\7\t\2\2\61\62\5\n\6\2\62\65\7\n\2\2\63\64\7"+
		"\4\2\2\64\66\5\6\4\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\67@\7\7"+
		"\2\289\7\3\2\29:\7,\2\2:;\7\4\2\2;<\5\6\4\2<=\7\5\2\2=?\3\2\2\2>8\3\2"+
		"\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AF\3\2\2\2B@\3\2\2\2CE\5\b\5\2DC\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\b\2\2JL\3\2"+
		"\2\2K\32\3\2\2\2K \3\2\2\2K/\3\2\2\2L\5\3\2\2\2MV\7\13\2\2NV\7\f\2\2O"+
		"V\7\r\2\2PQ\7\16\2\2QR\7)\2\2RS\7\17\2\2SV\5\6\4\2TV\7,\2\2UM\3\2\2\2"+
		"UN\3\2\2\2UO\3\2\2\2UP\3\2\2\2UT\3\2\2\2V\7\3\2\2\2WY\7\20\2\2XZ\5\16"+
		"\b\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\u00ab\7\5\2\2\\^\7\21\2\2]_\5\16\b"+
		"\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`\u00ab\7\5\2\2ac\7\22\2\2bd\5\16\b\2"+
		"cb\3\2\2\2cd\3\2\2\2de\3\2\2\2e\u00ab\7\5\2\2fg\7\23\2\2gh\5\20\t\2hi"+
		"\7\5\2\2i\u00ab\3\2\2\2jl\7\24\2\2km\5\16\b\2lk\3\2\2\2lm\3\2\2\2mn\3"+
		"\2\2\2n\u00ab\7\5\2\2op\5\20\t\2pq\7\25\2\2qr\5\16\b\2rs\7\5\2\2s\u00ab"+
		"\3\2\2\2tu\7,\2\2uv\7\t\2\2vw\5\f\7\2wx\7\n\2\2xy\7\5\2\2y\u00ab\3\2\2"+
		"\2z{\7\26\2\2{|\7\t\2\2|}\5\16\b\2}~\7\n\2\2~\u0082\7\7\2\2\177\u0081"+
		"\5\b\5\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\b"+
		"\2\2\u0086\u00ab\3\2\2\2\u0087\u0088\7\26\2\2\u0088\u0089\7\t\2\2\u0089"+
		"\u008a\5\16\b\2\u008a\u008b\7\n\2\2\u008b\u008f\7\7\2\2\u008c\u008e\5"+
		"\b\5\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\b"+
		"\2\2\u0093\u0094\7\27\2\2\u0094\u0098\7\7\2\2\u0095\u0097\5\b\5\2\u0096"+
		"\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\b\2\2\u009c"+
		"\u00ab\3\2\2\2\u009d\u009e\7\30\2\2\u009e\u009f\7\t\2\2\u009f\u00a0\5"+
		"\16\b\2\u00a0\u00a1\7\n\2\2\u00a1\u00a5\7\7\2\2\u00a2\u00a4\5\b\5\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\b\2\2\u00a9"+
		"\u00ab\3\2\2\2\u00aaW\3\2\2\2\u00aa\\\3\2\2\2\u00aaa\3\2\2\2\u00aaf\3"+
		"\2\2\2\u00aaj\3\2\2\2\u00aao\3\2\2\2\u00aat\3\2\2\2\u00aaz\3\2\2\2\u00aa"+
		"\u0087\3\2\2\2\u00aa\u009d\3\2\2\2\u00ab\t\3\2\2\2\u00ac\u00ad\7,\2\2"+
		"\u00ad\u00ae\7\4\2\2\u00ae\u00b5\5\6\4\2\u00af\u00b0\7\31\2\2\u00b0\u00b1"+
		"\7,\2\2\u00b1\u00b2\7\4\2\2\u00b2\u00b4\5\6\4\2\u00b3\u00af\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ac\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\13\3\2\2\2\u00ba\u00bf\5\16\b\2\u00bb\u00bc\7\31\2\2\u00bc\u00be\5\16"+
		"\b\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00ba\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\r\3\2\2\2\u00c4\u00c5\b\b\1\2\u00c5\u00dc"+
		"\7)\2\2\u00c6\u00dc\7*\2\2\u00c7\u00dc\7+\2\2\u00c8\u00c9\7,\2\2\u00c9"+
		"\u00ca\7\t\2\2\u00ca\u00cb\5\f\7\2\u00cb\u00cc\7\n\2\2\u00cc\u00dc\3\2"+
		"\2\2\u00cd\u00dc\5\20\t\2\u00ce\u00cf\7\t\2\2\u00cf\u00d0\5\16\b\2\u00d0"+
		"\u00d1\7\n\2\2\u00d1\u00dc\3\2\2\2\u00d2\u00d3\7\32\2\2\u00d3\u00dc\5"+
		"\16\b\n\u00d4\u00d5\7\33\2\2\u00d5\u00d6\5\6\4\2\u00d6\u00d7\7\34\2\2"+
		"\u00d7\u00d8\7\t\2\2\u00d8\u00d9\5\16\b\2\u00d9\u00da\7\n\2\2\u00da\u00dc"+
		"\3\2\2\2\u00db\u00c4\3\2\2\2\u00db\u00c6\3\2\2\2\u00db\u00c7\3\2\2\2\u00db"+
		"\u00c8\3\2\2\2\u00db\u00cd\3\2\2\2\u00db\u00ce\3\2\2\2\u00db\u00d2\3\2"+
		"\2\2\u00db\u00d4\3\2\2\2\u00dc\u00f1\3\2\2\2\u00dd\u00de\f\b\2\2\u00de"+
		"\u00df\t\2\2\2\u00df\u00f0\5\16\b\t\u00e0\u00e1\f\7\2\2\u00e1\u00e2\t"+
		"\3\2\2\u00e2\u00f0\5\16\b\b\u00e3\u00e4\f\6\2\2\u00e4\u00e5\t\4\2\2\u00e5"+
		"\u00f0\5\16\b\7\u00e6\u00e7\f\5\2\2\u00e7\u00e8\t\5\2\2\u00e8\u00f0\5"+
		"\16\b\6\u00e9\u00ea\f\4\2\2\u00ea\u00eb\7&\2\2\u00eb\u00f0\5\16\b\5\u00ec"+
		"\u00ed\f\3\2\2\u00ed\u00ee\7\'\2\2\u00ee\u00f0\5\16\b\4\u00ef\u00dd\3"+
		"\2\2\2\u00ef\u00e0\3\2\2\2\u00ef\u00e3\3\2\2\2\u00ef\u00e6\3\2\2\2\u00ef"+
		"\u00e9\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f1\u00f2\3\2\2\2\u00f2\17\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5"+
		"\b\t\1\2\u00f5\u00f6\7,\2\2\u00f6\u0101\3\2\2\2\u00f7\u00f8\f\4\2\2\u00f8"+
		"\u00f9\7(\2\2\u00f9\u0100\7,\2\2\u00fa\u00fb\f\3\2\2\u00fb\u00fc\7\16"+
		"\2\2\u00fc\u00fd\5\16\b\2\u00fd\u00fe\7\17\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00f7\3\2\2\2\u00ff\u00fa\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\21\3\2\2\2\u0103\u0101\3\2\2\2\33\25*\65"+
		"@FKUY^cl\u0082\u008f\u0098\u00a5\u00aa\u00b5\u00b8\u00bf\u00c2\u00db\u00ef"+
		"\u00f1\u00ff\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}