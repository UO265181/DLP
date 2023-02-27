// Generated from d:\Temporal\dlp\continua\DLP\Esqueleto Traductor\src\parser\Lexicon.g4 by ANTLR 4.9.2
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
		INT_CONSTANT=1, REAL_CONSTANT=2, CHAR_CONSTANT=3, IDENT=4, LINE_COMMENT=5, 
		MULTILINE_COMMENT=6, WHITESPACE=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "IDENT", "LINE_COMMENT", 
			"MULTILINE_COMMENT", "WHITESPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\tR\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\3\6\3\30\n\3\r\3\16\3\31\3\3\3\3\6\3\36\n\3\r\3\16\3\37\3\4\3\4"+
		"\3\4\5\4%\n\4\3\4\3\4\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\6\3\6\3\6\3\6"+
		"\7\6\64\n\6\f\6\16\6\67\13\6\3\6\5\6:\n\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7"+
		"B\n\7\f\7\16\7E\13\7\3\7\3\7\3\7\3\7\3\7\3\b\6\bM\n\b\r\b\16\bN\3\b\3"+
		"\b\4\65C\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\7\3\2\62;\5\2C\\aac|\6"+
		"\2\62;C\\aac|\3\3\f\f\5\2\13\f\17\17\"\"\2Y\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\22\3\2"+
		"\2\2\5\27\3\2\2\2\7!\3\2\2\2\t(\3\2\2\2\13/\3\2\2\2\r=\3\2\2\2\17L\3\2"+
		"\2\2\21\23\t\2\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2"+
		"\2\2\25\4\3\2\2\2\26\30\t\2\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2"+
		"\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\35\7\60\2\2\34\36\t\2\2\2\35\34\3"+
		"\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \6\3\2\2\2!$\7)\2\2\"%"+
		"\7\f\2\2#%\13\2\2\2$\"\3\2\2\2$#\3\2\2\2%&\3\2\2\2&\'\7)\2\2\'\b\3\2\2"+
		"\2(,\t\3\2\2)+\t\4\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\n\3\2"+
		"\2\2.,\3\2\2\2/\60\7\61\2\2\60\61\7\61\2\2\61\65\3\2\2\2\62\64\13\2\2"+
		"\2\63\62\3\2\2\2\64\67\3\2\2\2\65\66\3\2\2\2\65\63\3\2\2\2\669\3\2\2\2"+
		"\67\65\3\2\2\28:\t\5\2\298\3\2\2\2:;\3\2\2\2;<\b\6\2\2<\f\3\2\2\2=>\7"+
		"\61\2\2>?\7,\2\2?C\3\2\2\2@B\13\2\2\2A@\3\2\2\2BE\3\2\2\2CD\3\2\2\2CA"+
		"\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7,\2\2GH\7\61\2\2HI\3\2\2\2IJ\b\7\2\2J"+
		"\16\3\2\2\2KM\t\6\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2"+
		"\2PQ\b\b\2\2Q\20\3\2\2\2\f\2\24\31\37$,\659CN\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}