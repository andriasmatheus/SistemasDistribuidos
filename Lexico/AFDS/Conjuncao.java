package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Token;

public class Conjuncao extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        switch (code.current()){
            case '&':
                code.next();

                if (code.current() == '&') {
                    code.next();
                    return new Token("AND", "&&");
                }

                return new Token("AND2", "&");
            case '|':
                code.next();
                
                if (code.current() == '|') {
                    code.next();
                    return new Token("OR", "|");
                }

                else return new Token("OR2", "|");

            default:
                return null;
        }
    }
}
