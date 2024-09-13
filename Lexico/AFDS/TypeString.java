package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Token;

public class TypeString extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        if (code.current() != '\"')
            return null;
        code.next();

        if (code.current() == '%')
            return null;
        
        String stringText = "\"";
        while (code.current() != '\"' && code.current() != '\n' && code.current() != CharacterIterator.DONE){
            stringText += code.current();
            code.next();
        }

        if (code.current() != '\"')
            return null;
        
        stringText += code.current();
        code.next();
        return new Token("STRING", stringText);
    }
}