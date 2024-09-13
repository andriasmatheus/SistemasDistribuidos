package Lexico;

public class Token {
    String tipo;
    String lexema;
    int linha;
    int coluna;

    public Token(String tipo, String lexema){
        this.lexema = lexema;
        this.tipo = tipo;
    }

    public String getLexema(){
        return lexema;
    }

    public String getTipo(){
        return tipo;
    }

    public String getPosicao(){
        return "Linha: " + linha + "\nColuna: " + coluna;
    }

    @Override
    public String toString() {
        return "<" + tipo + ", " + lexema + ">";
    }
}