package Lexico.Utility;

import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.List;

public class Functions {
    private static List<Character> validacoes = Arrays.asList(' ', '+', '-', '*', '/', '(', ')', '{', '}', ';', ':', '\n', '\"', '\'', '<', '>', CharacterIterator.DONE);

    public static boolean validateEnd(CharacterIterator code){

        for (char validacao : validacoes){
            if (code.current() == validacao)
                return true;
        }
        return false;
    }

}
