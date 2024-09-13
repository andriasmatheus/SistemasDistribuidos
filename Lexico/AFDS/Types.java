package Lexico.AFDS;
import java.text.CharacterIterator;
import java.util.List;
import java.util.ArrayList;

import Lexico.Token;
import Lexico.Utility.Dicionario;

public class Types extends AFD{

    @Override
    public Token evaluate(CharacterIterator code){
        List<Dicionario> reservadas = new ArrayList<>();

        reservadas.add(new Dicionario("float", "dose"));
        reservadas.add(new Dicionario("int", "latinha"));
        reservadas.add(new Dicionario("string", "truco"));
        reservadas.add(new Dicionario("double", "shot"));

        int pos = code.getIndex();
        for (Dicionario reservada : reservadas){
            for (char c : reservada.valor.toCharArray()){
                if (code.current() == c)
                    code.next();
                else{
                    code.setIndex(pos);
                    break;
                }
            }
            if (endPalavra(code)){
                return new Token("RESERVADA_" + reservada.chave.toUpperCase(), reservada.valor);
            }
        }
        return null;
    }

    private boolean endPalavra(CharacterIterator code){
        return code.current() == ' ' ||
            code.current() == '\n' ||
            code.current() == CharacterIterator.DONE;
    }

}