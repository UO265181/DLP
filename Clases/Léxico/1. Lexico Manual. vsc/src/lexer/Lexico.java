/*
Añadir EN ESTE ORDEN:
- Literales reales: 3.15, 78.23, ... (parte entera obligatoria/parte decimal OPCIONAL)
- Operadores aritméticos y otros simbolos:  + - * / . : = ; [ ] ( ) { } < >
- Palabras reservadas: if, while, read, print, int y float
*/

package lexer;

import java.io.*;

public class Lexico {
	public static final int END = 0;

	public static final int LITENT = 256;
	public static final int IDENT = 257;
	public static final int LITREAL = 258;
	public static final int IF = 259;
	public static final int WHILE = 260;
	public static final int READ = 261;
	public static final int PRINT = 262;
	public static final int INT = 263;
	public static final int FLOAT = 264;

	private Reader input;
	private int currentChar;

	public Lexico(Reader reader) throws IOException {
		input = reader;
		readNext();
	}

	// Funciones auxiliares -------------------------------
	private int readNext() throws IOException {
		currentChar = input.read();
		return currentChar;
	}

	private int getChar() throws IOException {
		return currentChar;
	}

	// Aquí empieza el Analizador Léxico ------------------
	public Token nextToken() throws IOException {

		while (true) {
			while (Character.isWhitespace(getChar()))
				readNext();

			if (getChar() == -1)
				return new Token(END, null);

			if (getChar() == '*') {
				readNext();
				return new Token('*', "*");
			}

			if ((getChar() >= 40 && getChar() <= 47) || (getChar() >= 58 && getChar() <= 62)
					|| (getChar() >= 123 && getChar() <= 125) || getChar() == 91 || getChar() == 93) {
				int op = getChar();
				readNext();
				return new Token(op, Character.toString(op));
			}

			/*
			 * if (getChar() == '+' || getChar() == '-' || getChar() == '*' || getChar() ==
			 * '/' || getChar() == '.' || getChar() == ':' || getChar() == '=' || getChar()
			 * == ';' || getChar() == '[' || getChar() == ']' || getChar() == '(' ||
			 * getChar() == ')' || getChar() == '{' || getChar() == '}' || getChar() == '<'
			 * || getChar() == '>') { int op = getChar(); readNext(); return new Token(op,
			 * Character.toString(op)); }
			 */
			
			if (Character.isDigit(getChar())) {
				StringBuffer buffer = new StringBuffer();
				buffer.append((char) getChar());
				while (Character.isDigit(readNext()))
					buffer.append((char) getChar());

				if (getChar() == '.') {
					buffer.append('.');
					while (Character.isDigit(readNext()))
						buffer.append((char) getChar());
					return new Token(LITREAL, buffer.toString());
				}

				return new Token(LITENT, buffer.toString());
			}

			if (Character.isLetter(getChar())) {
				StringBuffer buffer = new StringBuffer();
				buffer.append((char) getChar());

				while (Character.isLetter(readNext()))
					buffer.append((char) getChar());

				switch (buffer.toString()) {
				case "float":
					return new Token(FLOAT, buffer.toString());
				case "if":
					return new Token(IF, buffer.toString());
				case "while":
					return new Token(WHILE, buffer.toString());
				case "print":
					return new Token(PRINT, buffer.toString());
				case "read":
					return new Token(READ, buffer.toString());
				case "int":
					return new Token(INT, buffer.toString());
				}

				if (Character.isLetterOrDigit(getChar())) {
					buffer.append((char) getChar());
					while (Character.isDigit(readNext()))
						buffer.append((char) getChar());
				}

				return new Token(LITREAL, buffer.toString());
			}

			System.out.println("Error léxico: " + (char) getChar());
			readNext();
		}
	}
}
