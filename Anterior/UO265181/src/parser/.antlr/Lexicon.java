// Generated from e:\_Berto\Universidad\3\DLP\lab\UO265181\src\parser\Lexicon.g4 by ANTLR 4.9.2
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
		LITENT=1, LITREAL=2, LITCHAR=3, IDENT=4, WHITESPACE=5, COMENTLIN=6, COMENTMULTLIN=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LITENT", "LITREAL", "LITCHAR", "IDENT", "WHITESPACE", "COMENTLIN", "COMENTMULTLIN"
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
			null, "LITENT", "LITREAL", "LITCHAR", "IDENT", "WHITESPACE", "COMENTLIN", 
			"COMENTMULTLIN"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\tQ\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\3\6\3\30\n\3\r\3\16\3\31\3\3\3\3\6\3\36\n\3\r\3\16\3\37\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4)\n\4\3\5\3\5\7\5-\n\5\f\5\16\5\60\13\5\3\6\6"+
		"\6\63\n\6\r\6\16\6\64\3\6\3\6\3\7\3\7\3\7\7\7<\n\7\f\7\16\7?\13\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\7\bH\n\b\f\b\16\bK\13\b\3\b\3\b\3\b\3\b\3\b\4"+
		"=I\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\7\3\2\62;\4\2\f\f\17\17\4\2C"+
		"\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2X\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\22\3\2\2"+
		"\2\5\27\3\2\2\2\7(\3\2\2\2\t*\3\2\2\2\13\62\3\2\2\2\r8\3\2\2\2\17D\3\2"+
		"\2\2\21\23\t\2\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2"+
		"\2\2\25\4\3\2\2\2\26\30\t\2\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2"+
		"\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\35\7\60\2\2\34\36\t\2\2\2\35\34\3"+
		"\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \6\3\2\2\2!\"\7)\2\2\""+
		"#\n\3\2\2#)\7)\2\2$%\7)\2\2%&\7^\2\2&\'\7p\2\2\')\7)\2\2(!\3\2\2\2($\3"+
		"\2\2\2)\b\3\2\2\2*.\t\4\2\2+-\t\5\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2"+
		"./\3\2\2\2/\n\3\2\2\2\60.\3\2\2\2\61\63\t\6\2\2\62\61\3\2\2\2\63\64\3"+
		"\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\b\6\2\2\67\f\3"+
		"\2\2\289\7\61\2\29=\7\61\2\2:<\13\2\2\2;:\3\2\2\2<?\3\2\2\2=>\3\2\2\2"+
		"=;\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\f\2\2AB\3\2\2\2BC\b\7\2\2C\16\3\2\2"+
		"\2DE\7\61\2\2EI\7,\2\2FH\13\2\2\2GF\3\2\2\2HK\3\2\2\2IJ\3\2\2\2IG\3\2"+
		"\2\2JL\3\2\2\2KI\3\2\2\2LM\7,\2\2MN\7\61\2\2NO\3\2\2\2OP\b\b\2\2P\20\3"+
		"\2\2\2\13\2\24\31\37(.\64=I\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}