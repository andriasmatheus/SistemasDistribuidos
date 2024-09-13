package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Utility.Functions;
import Lexico.Token;

public class ID extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        if (Character.isLetter(code.current())){
            String letter = readLetter(code);

            if (Functions.validateEnd(code)){
                return new Token("ID", letter);
            }
        }
        return null;
    }

    private String readLetter(CharacterIterator code){
        String letter = "";
        while (Character.isLetterOrDigit(code.current())){
            letter += code.current();
            code.next();
        }
        return letter;
    }
}