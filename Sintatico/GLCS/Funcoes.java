package Sintatico.GLCS;

import Sintatico.Parser;
import Sintatico.Sintatico;

public class Funcoes extends Sintatico {

    public static boolean print(){
        if (matchTipo("RESERVADA_PRINTF", "printf") && matchLexema("(") && ( matchTipo("STRING", correctPrintString()) || argumentoPrintScan() ) && matchLexema(")") && endCode()){
            return true;
        }

        erro("printf");
        return false;
    }

    public static boolean scan(){
        if (matchTipo("RESERVADA_SCANF", "scanf") && matchLexema("(") && argumentoPrintScan() && matchLexema(")") && matchLexema(";") && ( lexemaEquals("}") || Parser.codigo() )){
            return true;
        }

        erro("scanf");
        return false;
    }

    public static boolean argumentoPrintScan(){
        if (matchLexema("\"", false) && matchLexema("%", false) && tipoScan() && matchLexema("\"") && matchLexema(",") && ( matchLexema("&", false) || true ) && matchTipo("ID")){
            return true;
        }

        erro("argumentoPrintScan");
        return false;
    }

    public static boolean tipoScan(){
        if (matchLexema("s", false) || matchLexema("d", false) || matchLexema("f", false) || matchLexema("lf", false)){
            return true;
        }

        erro("tipoScan");
        return false;
    }

    public static String correctPrintString(){
        return token.getLexema().substring(0, token.getLexema().length() - 1) + "\\n\"";
    }
}
