package Sintatico.GLCS;

import Sintatico.Sintatico;

public class Expressoes  extends Sintatico{
    
    public static boolean expressao(){
        if (expressaoAritimetica()){
            if (matchLexema(";"))
                return true;
            else if (operadorLogico() && expressaoAritimetica() && expressaoLogica2())
                return true;

            erro("expressaoLogica");
            return false;
        }
        /* 
        if (expressaoAritimetica() || expressaoLogica()){
            return true;
        }
        */

        erro("expressao");
        return false;
    }

    public static boolean expressaoAritimetica(){
        if (fator() && expressaoAritimetica2()){
            return true;
        }

        erro("expressaoAritimetica");
        return false;
    }
    
    public static boolean expressaoAritimetica2(){   // Validar, não entendi como o first follow funcionaria aqui, esse jeito parece funcionar
        if (operadorMatematico());
        if (lexemaEquals(")"))
            return true;
        if (endCode() || expressaoAritimetica())
            return true;

        return true;
    }
 
    public static boolean expressaoLogica(){
        if (expressaoAritimetica() && operadorLogico() && expressaoAritimetica() && expressaoLogica2()){
            return true;
        }

        erro("expressaoLogica");
        return false;
    }
    
    public static boolean expressaoLogica2(){   // Validar, não entendi como o first follow funcionaria aqui, esse jeito parece funcionar
        if (operadorConjuncao() && expressaoLogica() && expressaoLogica2()){
            return true;
        }
        
        return true;
    }

    public static boolean fator(){
        if (matchTipo("ID") || (matchLexema("(") && expressaoAritimetica() && matchLexema(")")) || numero()){
            return true;
        }

        erro("fator");
        return false;
    }

    public static boolean operadorMatematico(){
        if (matchLexema("-", false) || matchLexema("+", false) || matchLexema("*", false) || matchLexema("/", false) || matchLexema("**", false) || matchLexema("%", false))
        {
            return true;
        }
    
        return false;
    }

    public static boolean operadorLogico(){
        if (matchLexema("==") || matchLexema("!=") || matchLexema("<") || matchLexema(">") || matchLexema("<=") || matchLexema(">="))
        {
            return true;
        }
    
        return false;
    }

    public static boolean operadorConjuncao(){
        if (matchLexema("&&") || matchLexema("||") || matchLexema("&") || matchLexema("|"))
        {
            return true;
        }
    
        return false;
    }

    public static boolean equalsOperadorLogico(){
        if (lexemaEquals("==") || lexemaEquals("!=") || lexemaEquals("<") || lexemaEquals(">") || lexemaEquals("<=") || lexemaEquals(">="))
        {
            return true;
        }
    
        return false;
    }

    public static boolean equalsOperadorConjuncao(){
        if (lexemaEquals("&&") || lexemaEquals("||") || lexemaEquals("&") || lexemaEquals("|"))
        {
            return true;
        }
    
        return false;
    }

    public static boolean numero(){
        if (matchTipo("NUM") || matchTipo("FLUTUANTE"))
        {
            return true;
        }
    
        return false;
    }
}
