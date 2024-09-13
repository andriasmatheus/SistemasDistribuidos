package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Token;

public class Delimitadores extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        switch (code.current()){
            case '<':
                code.next();
                return new Token("MENOR", "<");
            case '>':
                code.next();
                return new Token("MAIOR", ">");

            case '/':
                code.next();
                return new Token("RBARRA", "/");

            case '\"':
                code.next();
                return new Token("LBARRA", "\"");

            default:
                return null;
        }
    }
}
