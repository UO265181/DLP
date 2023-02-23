// Generated from src\parser\Grammar.g4 by ANTLR 4.7.2
package parser;
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, LITENT=21, LITREAL=22, IDENT=23, COMMENT=24, 
		WS=25;
	public static final int
		RULE_start = 0, RULE_vars = 1, RULE_var = 2, RULE_tipo = 3, RULE_sentences = 4, 
		RULE_sentence = 5, RULE_exp = 6, RULE_llamFuncArgs = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "vars", "var", "tipo", "sentences", "sentence", "exp", "llamFuncArgs"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DATA'", "'CODE'", "';'", "'real'", "'int'", "'read'", "'print'", 
			"'='", "'('", "')'", "'while'", "'{'", "'}'", "'if'", "'else'", "'<'", 
			"'>'", "'+'", "'!='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "LITENT", "LITREAL", 
			"IDENT", "COMMENT", "WS"
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
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
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
			setState(16);
			match(T__0);
			setState(17);
			vars(0);
			setState(18);
			match(T__1);
			setState(19);
			sentences(0);
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

	public static class VarsContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
	}

	public final VarsContext vars() throws RecognitionException {
		return vars(0);
	}

	private VarsContext vars(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarsContext _localctx = new VarsContext(_ctx, _parentState);
		VarsContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_vars, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(22);
			var();
			}
			_ctx.stop = _input.LT(-1);
			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_vars);
					setState(24);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(25);
					var();
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class VarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			tipo();
			setState(32);
			match(IDENT);
			setState(33);
			match(T__2);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class SentencesContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public SentencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentences; }
	}

	public final SentencesContext sentences() throws RecognitionException {
		return sentences(0);
	}

	private SentencesContext sentences(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SentencesContext _localctx = new SentencesContext(_ctx, _parentState);
		SentencesContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_sentences, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(38);
			sentence();
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SentencesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sentences);
					setState(40);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(41);
					sentence();
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class SentenceContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public LlamFuncArgsContext llamFuncArgs() {
			return getRuleContext(LlamFuncArgsContext.class,0);
		}
		public List<SentencesContext> sentences() {
			return getRuleContexts(SentencesContext.class);
		}
		public SentencesContext sentences(int i) {
			return getRuleContext(SentencesContext.class,i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sentence);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(T__5);
				setState(48);
				exp(0);
				setState(49);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(T__6);
				setState(52);
				exp(0);
				setState(53);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(IDENT);
				setState(56);
				match(T__7);
				setState(57);
				exp(0);
				setState(58);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				match(IDENT);
				setState(61);
				match(T__8);
				setState(62);
				llamFuncArgs();
				setState(63);
				match(T__9);
				setState(64);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				match(T__10);
				setState(67);
				match(T__8);
				setState(68);
				exp(0);
				setState(69);
				match(T__9);
				setState(70);
				match(T__11);
				setState(71);
				sentences(0);
				setState(72);
				match(T__12);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				match(T__13);
				setState(75);
				match(T__8);
				setState(76);
				exp(0);
				setState(77);
				match(T__9);
				setState(78);
				match(T__11);
				setState(79);
				sentences(0);
				setState(80);
				match(T__12);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(82);
				match(T__13);
				setState(83);
				match(T__8);
				setState(84);
				exp(0);
				setState(85);
				match(T__9);
				setState(86);
				match(T__11);
				setState(87);
				sentences(0);
				setState(88);
				match(T__12);
				setState(89);
				match(T__14);
				setState(90);
				match(T__11);
				setState(91);
				sentences(0);
				setState(92);
				match(T__12);
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

	public static class ExpContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public LlamFuncArgsContext llamFuncArgs() {
			return getRuleContext(LlamFuncArgsContext.class,0);
		}
		public TerminalNode LITENT() { return getToken(GrammarParser.LITENT, 0); }
		public TerminalNode LITREAL() { return getToken(GrammarParser.LITREAL, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(97);
				match(T__8);
				setState(98);
				exp(0);
				setState(99);
				match(T__9);
				}
				break;
			case 2:
				{
				setState(101);
				match(T__15);
				setState(102);
				tipo();
				setState(103);
				match(T__16);
				setState(104);
				match(T__8);
				setState(105);
				exp(0);
				setState(106);
				match(T__9);
				}
				break;
			case 3:
				{
				setState(108);
				match(IDENT);
				setState(109);
				match(T__8);
				setState(110);
				llamFuncArgs();
				setState(111);
				match(T__9);
				}
				break;
			case 4:
				{
				setState(113);
				match(IDENT);
				}
				break;
			case 5:
				{
				setState(114);
				match(LITENT);
				}
				break;
			case 6:
				{
				setState(115);
				match(LITREAL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(118);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(119);
						match(T__17);
						setState(120);
						exp(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(121);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(122);
						match(T__18);
						setState(123);
						exp(6);
						}
						break;
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class LlamFuncArgsContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LlamFuncArgsContext llamFuncArgs() {
			return getRuleContext(LlamFuncArgsContext.class,0);
		}
		public LlamFuncArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamFuncArgs; }
	}

	public final LlamFuncArgsContext llamFuncArgs() throws RecognitionException {
		LlamFuncArgsContext _localctx = new LlamFuncArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_llamFuncArgs);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				exp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				exp(0);
				setState(131);
				match(T__19);
				setState(132);
				llamFuncArgs();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return vars_sempred((VarsContext)_localctx, predIndex);
		case 4:
			return sentences_sempred((SentencesContext)_localctx, predIndex);
		case 6:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean vars_sempred(VarsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean sentences_sempred(SentencesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u008b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6-\n\6\f\6\16\6\60\13\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7a\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bw\n\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\b\177\n\b\f\b\16\b\u0082\13\b\3\t\3\t\3\t\3\t\3\t\5\t"+
		"\u0089\n\t\3\t\2\5\4\n\16\n\2\4\6\b\n\f\16\20\2\3\3\2\6\7\2\u0092\2\22"+
		"\3\2\2\2\4\27\3\2\2\2\6!\3\2\2\2\b%\3\2\2\2\n\'\3\2\2\2\f`\3\2\2\2\16"+
		"v\3\2\2\2\20\u0088\3\2\2\2\22\23\7\3\2\2\23\24\5\4\3\2\24\25\7\4\2\2\25"+
		"\26\5\n\6\2\26\3\3\2\2\2\27\30\b\3\1\2\30\31\5\6\4\2\31\36\3\2\2\2\32"+
		"\33\f\3\2\2\33\35\5\6\4\2\34\32\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37"+
		"\3\2\2\2\37\5\3\2\2\2 \36\3\2\2\2!\"\5\b\5\2\"#\7\31\2\2#$\7\5\2\2$\7"+
		"\3\2\2\2%&\t\2\2\2&\t\3\2\2\2\'(\b\6\1\2()\5\f\7\2).\3\2\2\2*+\f\3\2\2"+
		"+-\5\f\7\2,*\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\13\3\2\2\2\60.\3"+
		"\2\2\2\61\62\7\b\2\2\62\63\5\16\b\2\63\64\7\5\2\2\64a\3\2\2\2\65\66\7"+
		"\t\2\2\66\67\5\16\b\2\678\7\5\2\28a\3\2\2\29:\7\31\2\2:;\7\n\2\2;<\5\16"+
		"\b\2<=\7\5\2\2=a\3\2\2\2>?\7\31\2\2?@\7\13\2\2@A\5\20\t\2AB\7\f\2\2BC"+
		"\7\5\2\2Ca\3\2\2\2DE\7\r\2\2EF\7\13\2\2FG\5\16\b\2GH\7\f\2\2HI\7\16\2"+
		"\2IJ\5\n\6\2JK\7\17\2\2Ka\3\2\2\2LM\7\20\2\2MN\7\13\2\2NO\5\16\b\2OP\7"+
		"\f\2\2PQ\7\16\2\2QR\5\n\6\2RS\7\17\2\2Sa\3\2\2\2TU\7\20\2\2UV\7\13\2\2"+
		"VW\5\16\b\2WX\7\f\2\2XY\7\16\2\2YZ\5\n\6\2Z[\7\17\2\2[\\\7\21\2\2\\]\7"+
		"\16\2\2]^\5\n\6\2^_\7\17\2\2_a\3\2\2\2`\61\3\2\2\2`\65\3\2\2\2`9\3\2\2"+
		"\2`>\3\2\2\2`D\3\2\2\2`L\3\2\2\2`T\3\2\2\2a\r\3\2\2\2bc\b\b\1\2cd\7\13"+
		"\2\2de\5\16\b\2ef\7\f\2\2fw\3\2\2\2gh\7\22\2\2hi\5\b\5\2ij\7\23\2\2jk"+
		"\7\13\2\2kl\5\16\b\2lm\7\f\2\2mw\3\2\2\2no\7\31\2\2op\7\13\2\2pq\5\20"+
		"\t\2qr\7\f\2\2rw\3\2\2\2sw\7\31\2\2tw\7\27\2\2uw\7\30\2\2vb\3\2\2\2vg"+
		"\3\2\2\2vn\3\2\2\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\u0080\3\2\2\2xy\f\b"+
		"\2\2yz\7\24\2\2z\177\5\16\b\t{|\f\7\2\2|}\7\25\2\2}\177\5\16\b\b~x\3\2"+
		"\2\2~{\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\17\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0089\5\16\b\2\u0084\u0085\5\16"+
		"\b\2\u0085\u0086\7\26\2\2\u0086\u0087\5\20\t\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0089\21\3\2\2\2\t\36.`v~\u0080\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}