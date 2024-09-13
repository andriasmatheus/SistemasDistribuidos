package Sintatico;

import java.util.List;

import Sintatico.AST.Node;
import Sintatico.AST.Tree;
import Lexico.Token;

public abstract class Sintatico {
    public static List<Token> tokens;
    public static Token token;
    public static Tree arvore;
    public static Node no;

    public static Token nextToken(){
        if (tokens.size() > 0)
            return tokens.remove(0);
        return null;
    }
    
    public static void erro(String regra){
        System.out.println("Erro na regra: " + regra + "\nToken: " + token.toString() + "\n" + token.getPosicao());
        System.exit(1); // encerra o programa
    }
    
    public static boolean success(){
        System.out.println("RODOU!!");
        return true;
    }

    /**
     * Refatoração do método matchLexema para construção da árvore
     *
     * @param lexema palavra
     * @param newCode token.lexema
     * @return
     */
    public static boolean matchLexema(String lexema, String newCode){
        if (token.getLexema().equals(lexema)){
            no.addChild(newCode);
            token = nextToken();
            return true;
        }
        return false;
    }

    public static boolean matchLexema(String lexema){
        if (token.getLexema().equals(lexema)){
            no.addChild(lexema);
            token = nextToken();
            return true;
        }
        return false;
    }

    public static boolean matchLexema(String lexema, boolean espaco){
        if (token.getLexema().equals(lexema)){
            Node node = no.addChild(lexema);
            if (!espaco){
                node.exit = "";
            }
            token = nextToken();
            return true;
        }
        return false;
    }

    /**
     * Refatoração do método matchTipo para construção da árvore final
     *
     * @param tipo palavra
     * @param newCode token.lexema
     * @return
     */
    public static boolean matchTipo(String tipo, String newCode){
        if (token.getTipo().equals(tipo)){
            no.addChild(newCode);
            token = nextToken();
            return true;
        }
        return false;
    }
    
    public static boolean matchTipo(String tipo){
        if (token.getTipo().equals(tipo)){
            no.addChild(token.getLexema());
            token = nextToken();
            return true;
        }
        return false;
    }

    public static boolean matchTipo(String tipo, boolean espaco){
        if (token.getTipo().equals(tipo)){
            Node node = no.addChild(tipo);
            if (!espaco){
                node.exit = "";
            }
            token = nextToken();
            return true;
        }
        return false;
    }

    public static boolean lexemaEquals(String lexema){
        if (token.getLexema().equals(lexema)){
            return true;
        }
        return false;
    }

    public static boolean tipoEquals(String tipo){
        if (token.getTipo().equals(tipo)){
            return true;
        }
        return false;
    }

    public static boolean endCode(){
        return matchLexema(";") && ( lexemaEquals("}") || Parser.codigo()) || matchTipo("RESERVADA_END", "") || lexemaEquals("}") || tipoEquals("EOF");
    }
}
