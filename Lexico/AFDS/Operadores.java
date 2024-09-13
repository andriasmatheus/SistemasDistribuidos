package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Token;

public class Operadores extends AFD{
    
    @Override
    public Token evaluate(CharacterIterator code){

        switch (code.current()){
            case '+':
                code.next();
                return new Token("OPERADOR_MAIS", "+");
            case '-':
                code.next();
                return new Token("OPERADOR_MENOS", "-");
            case '*':
                code.next();
                    
                if (code.current() == '*') {
                    code.next();
                    return new Token("OPERADOR_VEZES", "**");
                }
                
                else return new Token("OPERADOR_EXPONENCIACAO", "*");
            case '/':
                code.next();
                return new Token("OPERADOR_DIVIDIR", "/");
            case '%':
                code.next();
                return new Token("OPERADOR_RESTO", "%");
            case '<':
                code.next();

                if (code.current() == '=') {
                    code.next();
                    return new Token("RELACAO_MENOR_IGUAL", "<=");
                }

                return new Token("RELACAO_MENOR", "<");
            case '>':
                code.next();
                
                if (code.current() == '=') {
                    code.next();
                    return new Token("RELACAO_MAIOR_IGUAL", ">=");
                }

                else return new Token("RELACAO_MAIOR", ">");
            case '!':
                code.next();
                
                if (code.current() == '=') {
                    code.next();
                    return new Token("RELACAO_DIFERENTE", "!=");
                }

                else return new Token("NEGACAO", "!");

            default:
                return null;
        }
    }
}
