package Sintatico;

import Lexico.Token;

import java.io.IOException;
import java.util.List;

import Sintatico.AST.Node;
import Sintatico.AST.Tree;
import Sintatico.GLCS.*;

public class Parser extends Sintatico{

    public Parser(List<Token> tokens){
        Sintatico.tokens = tokens;
    }
    
    public void run(){
        boolean sucesso = false;
        
        no = new Node("#include <stdio.h>\n\nint main(){\n"); // passar inicio de um programa em C
        arvore = new Tree(no);
        
        token = nextToken();
        if (codigo())
                if (matchTipo("EOF", "\nreturn 0;\n}")){
                    sucesso = success();
                    try {
                        arvore.createOutputFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        if (!sucesso)
            erro("main");
    }

    public static boolean codigo(){
        if (tipoEquals("EOF") || matchTipo("RESERVADA_END"))
            return true;
        
        else if (Fluxo.fluxo())
            return true;
        else if (Variaveis.equalsTipoDado() && Variaveis.declara())
            return true;
        else if (tipoEquals("ID") && Variaveis.atribuicao())
            return true;
        else if (tipoEquals("RESERVADA_PRINTF") && Funcoes.print())
            return true;
        else if (tipoEquals("RESERVADA_SCANF") && Funcoes.scan())
            return true;
        else if (Expressoes.expressaoAritimetica())
            return true;

        erro("codigo");
        return false;
    }
}
