import java.io.*;

enum TokenType {
    NUM, SOMA, MULT, SUB, DIV, APar, FPar, EOF
}

class Token {
    String lexema;
    TokenType token;

    Token(String l, TokenType t) {
        lexema = l;
        token = t;
    }

    Token(char l, TokenType t) {
        lexema = String.valueOf(l);
        token = t;
    }
}

class AnaliseLexica {
    PushbackReader arquivo;

    AnaliseLexica(String a) throws Exception {
        this.arquivo = new PushbackReader(new FileReader(a));
    }

    Token getNextToken() throws Exception {
        Token token;
        int eof = -1;
        char currchar;
        int currchar1;

        do {
            currchar1 = arquivo.read();
            currchar = (char) currchar1;
        } while (currchar == '\n' || currchar == ' ' || currchar == '\t' || currchar == '\r');

        if (currchar1 != eof && currchar1 != 10) {
            if (currchar >= '0' && currchar <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(currchar);

                currchar1 = arquivo.read();
                currchar = (char) currchar1;
                while (currchar >= '0' && currchar <= '9') {
                    sb.append(currchar);
                    currchar1 = arquivo.read();
                    currchar = (char) currchar1;
                }

				arquivo.unread(currchar);

                if (sb.length() <= 2) {
                    return (new Token(sb.toString(), TokenType.NUM));
                } else {
                    throw (new Exception("Número com mais de 2 dígitos: " + sb.toString()));
                }
            }
			

            switch (currchar) {
                case '(':
                    return (new Token(currchar, TokenType.APar));
                case ')':
                    return (new Token(currchar, TokenType.FPar));
                case '+':
                    return (new Token(currchar, TokenType.SOMA));
                case '*':
                    return (new Token(currchar, TokenType.MULT));
				case '-':
					return (new Token(currchar, TokenType.SUB));
				case '/':
					return (new Token(currchar, TokenType.DIV));
                default:
                    throw (new Exception("Caractere inválido: " + ((int) currchar)));
            }
        }

        arquivo.close();

        return (new Token(currchar, TokenType.EOF));
    }
}