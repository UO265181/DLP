package lexer;

public class Token {
    // Faltaría también guardar la columna

    private int type, line;
    private String text;
	
    public Token(int type, String text, int line) {
        this.type = type;
        this.text = text;
        this.line = line;
    }

    public Token(int type, String text) {
        this(type, text, 1);
    }

    public int getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public int getLine() {
        return line;
    }


}
