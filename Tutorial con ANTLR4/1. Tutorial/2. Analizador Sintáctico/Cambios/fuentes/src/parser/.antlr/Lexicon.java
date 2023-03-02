// Generated from c:\Users\UO265181\Desktop\DLP\Tutorial con ANTLR4\1. Tutorial\2. Analizador Sintáctico\Cambios\fuentes\src\parser\Lexicon.g4 by ANTLR 4.9.2
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
		INT_CONSTANT=1, REAL_CONSTANT=2, IDENT=3, LINE_COMMENT=4, MULTILINE_COMMENT=5, 
		WHITESPACE=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_CONSTANT", "REAL_CONSTANT", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WHITESPACE"
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
			null, "INT_CONSTANT", "REAL_CONSTANT", "IDENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\bI\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\21\n\2\r\2\16\2\22\3\3"+
		"\6\3\26\n\3\r\3\16\3\27\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\4\3\4\7\4\"\n"+
		"\4\f\4\16\4%\13\4\3\5\3\5\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\5\5\5\61\n"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\6\7D\n\7\r\7\16\7E\3\7\3\7\4,:\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\7"+
		"\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\3\3\f\f\5\2\13\f\17\17\"\"\2O\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\20"+
		"\3\2\2\2\5\25\3\2\2\2\7\37\3\2\2\2\t&\3\2\2\2\13\64\3\2\2\2\rC\3\2\2\2"+
		"\17\21\t\2\2\2\20\17\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2"+
		"\23\4\3\2\2\2\24\26\t\2\2\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2"+
		"\27\30\3\2\2\2\30\31\3\2\2\2\31\33\7\60\2\2\32\34\t\2\2\2\33\32\3\2\2"+
		"\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\6\3\2\2\2\37#\t\3\2\2"+
		" \"\t\4\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\b\3\2\2\2%#\3\2"+
		"\2\2&\'\7\61\2\2\'(\7\61\2\2(,\3\2\2\2)+\13\2\2\2*)\3\2\2\2+.\3\2\2\2"+
		",-\3\2\2\2,*\3\2\2\2-\60\3\2\2\2.,\3\2\2\2/\61\t\5\2\2\60/\3\2\2\2\61"+
		"\62\3\2\2\2\62\63\b\5\2\2\63\n\3\2\2\2\64\65\7\61\2\2\65\66\7,\2\2\66"+
		":\3\2\2\2\679\13\2\2\28\67\3\2\2\29<\3\2\2\2:;\3\2\2\2:8\3\2\2\2;=\3\2"+
		"\2\2<:\3\2\2\2=>\7,\2\2>?\7\61\2\2?@\3\2\2\2@A\b\6\2\2A\f\3\2\2\2BD\t"+
		"\6\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\b\7\2\2H\16"+
		"\3\2\2\2\13\2\22\27\35#,\60:E\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}