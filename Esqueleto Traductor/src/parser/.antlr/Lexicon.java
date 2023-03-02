// Generated from c:\Users\UO265181\Desktop\DLP\Esqueleto Traductor\src\parser\Lexicon.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Lexicon extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT_CONSTANT=1, REAL_CONSTANT=2, CHAR_CONSTANT=3, CHAR_CONSTANTa=4, CHAR_CONSTANTb=5, 
		CHAR_CONSTANTc=6, IDENT=7, LINE_COMMENT=8, MULTILINE_COMMENT=9, WHITESPACE=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "CHAR_CONSTANTa", "CHAR_CONSTANTb", 
			"CHAR_CONSTANTc", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'' (\\n|.~[\n\r\t]) ''", "''\\n''", "'' .~[\n\r\t] ''"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "CHAR_CONSTANTa", 
			"CHAR_CONSTANTb", "CHAR_CONSTANTc", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE"
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


	public Lexicon(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lexicon.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fz\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\6\2\31\n\2\r\2\16\2\32\3\3\6\3\36\n\3\r\3\16\3\37\3\3\3\3\6\3"+
		"$\n\3\r\3\16\3%\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\5\7M\n\7\3\7\3\7\3\b\3\b\7\bS\n\b\f\b\16\bV\13"+
		"\b\3\t\3\t\3\t\3\t\7\t\\\n\t\f\t\16\t_\13\t\3\t\5\tb\n\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\7\nj\n\n\f\n\16\nm\13\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13u\n\13"+
		"\r\13\16\13v\3\13\3\13\4]k\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\3\f\f\5\2\13\f\17\17\""+
		"\"\2\u0081\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\30"+
		"\3\2\2\2\5\35\3\2\2\2\7\'\3\2\2\2\t8\3\2\2\2\13=\3\2\2\2\rI\3\2\2\2\17"+
		"P\3\2\2\2\21W\3\2\2\2\23e\3\2\2\2\25t\3\2\2\2\27\31\t\2\2\2\30\27\3\2"+
		"\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\4\3\2\2\2\34\36\t\2"+
		"\2\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!"+
		"#\7\60\2\2\"$\t\2\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\6\3\2"+
		"\2\2\'(\7)\2\2()\7\"\2\2)*\7*\2\2*+\7^\2\2+,\7p\2\2,-\7~\2\2-.\7\60\2"+
		"\2./\7\u0080\2\2/\60\7]\2\2\60\61\7\f\2\2\61\62\7\17\2\2\62\63\7\13\2"+
		"\2\63\64\7_\2\2\64\65\7+\2\2\65\66\7\"\2\2\66\67\7)\2\2\67\b\3\2\2\28"+
		"9\7)\2\29:\7^\2\2:;\7p\2\2;<\7)\2\2<\n\3\2\2\2=>\7)\2\2>?\7\"\2\2?@\7"+
		"\60\2\2@A\7\u0080\2\2AB\7]\2\2BC\7\f\2\2CD\7\17\2\2DE\7\13\2\2EF\7_\2"+
		"\2FG\7\"\2\2GH\7)\2\2H\f\3\2\2\2IL\7)\2\2JM\7\f\2\2KM\13\2\2\2LJ\3\2\2"+
		"\2LK\3\2\2\2MN\3\2\2\2NO\7)\2\2O\16\3\2\2\2PT\t\3\2\2QS\t\4\2\2RQ\3\2"+
		"\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\20\3\2\2\2VT\3\2\2\2WX\7\61\2\2XY"+
		"\7\61\2\2Y]\3\2\2\2Z\\\13\2\2\2[Z\3\2\2\2\\_\3\2\2\2]^\3\2\2\2][\3\2\2"+
		"\2^a\3\2\2\2_]\3\2\2\2`b\t\5\2\2a`\3\2\2\2bc\3\2\2\2cd\b\t\2\2d\22\3\2"+
		"\2\2ef\7\61\2\2fg\7,\2\2gk\3\2\2\2hj\13\2\2\2ih\3\2\2\2jm\3\2\2\2kl\3"+
		"\2\2\2ki\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7,\2\2op\7\61\2\2pq\3\2\2\2qr\b"+
		"\n\2\2r\24\3\2\2\2su\t\6\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w"+
		"x\3\2\2\2xy\b\13\2\2y\26\3\2\2\2\f\2\32\37%LT]akv\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}