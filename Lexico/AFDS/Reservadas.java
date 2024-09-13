package Lexico.AFDS;

import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.List;

import Lexico.Token;
import Lexico.Utility.Dicionario;

public class Reservadas extends AFD{
    List<Dicionario> reservadas;

    public Reservadas()
    {
        reservadas = new ArrayList<>();
        reservadas.add(new Dicionario("<head>", "head_abertura"));
        reservadas.add(new Dicionario("</head>", "head_fechamento"));
        reservadas.add(new Dicionario("<body>", "body_abertura"));
        reservadas.add(new Dicionario("</body>", "body_fechamento"));
        reservadas.add(new Dicionario("<footer>", "footer_abertura"));
        reservadas.add(new Dicionario("</footer>", "footer_fechamento"));
        reservadas.add(new Dicionario("<href", "href_abertura"));
        reservadas.add(new Dicionario("<link", "link_abertura"));
        reservadas.add(new Dicionario("<script", "script_abertura"));
        reservadas.add(new Dicionario("<a", "a_abertura"));
        reservadas.add(new Dicionario("</a>", "a_fechamento"));
        reservadas.add(new Dicionario("<div", "div_abertura"));
        reservadas.add(new Dicionario("<h3", "h3_abertura"));
        reservadas.add(new Dicionario("<p", "p_abertura"));
        reservadas.add(new Dicionario("</p>", "p_fechamento"));
        reservadas.add(new Dicionario("<figure>", "figura_abertura"));
        reservadas.add(new Dicionario("</figure>", "figura_fechamento"));
    }

    @Override
    public Token evaluate(CharacterIterator code)
    {
        int pos = code.getIndex();
        for (Dicionario reservada : reservadas){
            for (char c : reservada.valor.toCharArray()){
                if (code.current() == c){
                    code.next(); 
                }
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
            code.current() == '\n'   ||
            code.current() == '/'    ||
            code.current() == CharacterIterator.DONE;
    }
}
