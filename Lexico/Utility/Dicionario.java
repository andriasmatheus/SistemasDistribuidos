package Lexico.Utility;

public class Dicionario {
    public String chave;
    public String valor;

    public Dicionario(String chave, String valor){
        this.chave = chave;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" + chave + " : " + valor + "}";
    }
}