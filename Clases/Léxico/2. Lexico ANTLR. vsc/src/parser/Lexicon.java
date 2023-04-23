// Generated from src\parser\Lexicon.g4 by ANTLR 4.7.2
package parser;
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENTMULTI=1, COMMENTLINE=2, WHITESPACE=3, READ=4, PRINT=5, INT=6, FLOAT=7, 
		IDENT=8, OPARIT=9, EQUAL=10, PCOMA=11, LITENT=12, LITREAL=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENTMULTI", "COMMENTLINE", "WHITESPACE", "READ", "PRINT", "INT", 
			"FLOAT", "IDENT", "OPARIT", "EQUAL", "PCOMA", "LITENT", "LITREAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'read'", "'print'", "'int'", "'float'", null, 
			null, "'='", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENTMULTI", "COMMENTLINE", "WHITESPACE", "READ", "PRINT", "INT", 
			"FLOAT", "IDENT", "OPARIT", "EQUAL", "PCOMA", "LITENT", "LITREAL"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3/\n\3\f\3\16\3\62\13\3\3\3\3\3\3\3"+
		"\3\3\3\4\6\49\n\4\r\4\16\4:\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\tV\n\t\f"+
		"\t\16\tY\13\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rb\n\r\r\r\16\rc\3\16\6"+
		"\16g\n\16\r\16\16\16h\3\16\3\16\6\16m\n\16\r\16\16\16n\4\"\60\2\17\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\7\5\2"+
		"\13\f\17\17\"\"\4\2C\\c|\6\2\62;C\\aac|\4\2--//\3\2\62;\2v\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\3\35\3\2\2\2\5*\3\2\2\2\78\3\2\2\2\t>\3\2\2\2\13C\3\2\2"+
		"\2\rI\3\2\2\2\17M\3\2\2\2\21S\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2"+
		"\2\2\31a\3\2\2\2\33f\3\2\2\2\35\36\7\61\2\2\36\"\7,\2\2\37!\13\2\2\2 "+
		"\37\3\2\2\2!$\3\2\2\2\"#\3\2\2\2\" \3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7,"+
		"\2\2&\'\7\61\2\2\'(\3\2\2\2()\b\2\2\2)\4\3\2\2\2*+\7\61\2\2+,\7\61\2\2"+
		",\60\3\2\2\2-/\13\2\2\2.-\3\2\2\2/\62\3\2\2\2\60\61\3\2\2\2\60.\3\2\2"+
		"\2\61\63\3\2\2\2\62\60\3\2\2\2\63\64\7\f\2\2\64\65\3\2\2\2\65\66\b\3\2"+
		"\2\66\6\3\2\2\2\679\t\2\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2"+
		";<\3\2\2\2<=\b\4\2\2=\b\3\2\2\2>?\7t\2\2?@\7g\2\2@A\7c\2\2AB\7f\2\2B\n"+
		"\3\2\2\2CD\7r\2\2DE\7t\2\2EF\7k\2\2FG\7p\2\2GH\7v\2\2H\f\3\2\2\2IJ\7k"+
		"\2\2JK\7p\2\2KL\7v\2\2L\16\3\2\2\2MN\7h\2\2NO\7n\2\2OP\7q\2\2PQ\7c\2\2"+
		"QR\7v\2\2R\20\3\2\2\2SW\t\3\2\2TV\t\4\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2"+
		"\2WX\3\2\2\2X\22\3\2\2\2YW\3\2\2\2Z[\t\5\2\2[\24\3\2\2\2\\]\7?\2\2]\26"+
		"\3\2\2\2^_\7=\2\2_\30\3\2\2\2`b\t\6\2\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2"+
		"cd\3\2\2\2d\32\3\2\2\2eg\t\6\2\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2"+
		"\2ij\3\2\2\2jl\7\60\2\2km\t\6\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2"+
		"\2\2o\34\3\2\2\2\n\2\"\60:Wchn\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}