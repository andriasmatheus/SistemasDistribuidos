package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Token;

public class Comentario extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        if (code.current() != '<')
            return null;
        code.next();
        if (code.current() != '!')
            return null;
        code.next();
        if (code.current() != '-')
            return null;
        code.next();
        if (code.current() != '-')
            return null;
        code.next();
        

        String comment = readComment(code);
        return new Token("COMENTARIO", comment);
    }

    private String readComment(CharacterIterator code){
        String comment = "<!--";
        while (code.current() != '-->' && code.current() != CharacterIterator.DONE){
            comment += code.current();
            code.next();
        }
        return comment;
    }
}