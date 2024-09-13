package Sintatico.GLCS;

import Sintatico.Sintatico;

public class Variaveis  extends Sintatico{
    
    public static boolean declara(){
        if (matchTipo("RESERVADA_STRING", "char") && matchTipo("ID", token.getLexema() + "[200]") && atribuicao2() && endCode()){
            return true;
        }
        if (matchTipoDado() && matchTipo("ID")){
            if (lexemaEquals("=") && atribuicao2())
                return true;
            else if (endCode())
                return true;
        }

        erro("declara");
        return false;
    }

    public static boolean atribuicao(){
        if (matchTipo("ID") && atribuicao2())
            return true;

        erro("atribuicao");
        return false;
    }

    public static boolean atribuicao2(){
        if (matchLexema("=")){
            if ((matchTipo("STRING") || Expressoes.expressaoAritimetica()) && endCode())
                return true;
        }

        erro("atribuicao2");
        return false;
    }

    public static boolean matchTipoDado(){
        if (matchTipo("RESERVADA_INT", "int") || matchTipo("RESERVADA_FLOAT", "float") || matchTipo("RESERVADA_DOUBLE", "double"))
        {
            return true;
        }
    
        return false;
    }

    public static boolean equalsTipoDado(){
        if (tipoEquals("RESERVADA_INT") || tipoEquals("RESERVADA_FLOAT") || tipoEquals("RESERVADA_DOUBLE") || tipoEquals("RESERVADA_STRING"))
        {
            return true;
        }
    
        return false;
    }

    public static boolean valor_inicial(){
        if (matchTipo("NUM") || matchTipo("FLUTUANTE") || matchTipo("STRING"))
        {
            return true;
        }
    
        return false;
    }
}
