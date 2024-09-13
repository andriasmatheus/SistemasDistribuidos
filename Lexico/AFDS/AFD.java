package Lexico.AFDS;
import java.text.CharacterIterator;

import Lexico.Token;

public abstract class AFD {
    public abstract Token evaluate(CharacterIterator code); // Tenta criar um objeto Token. Se não conseguir, retorna um objeto nulo.
    // Essa CharacterIterator dá métodos para manipulação de string. Para poder iterar nela como alto nível, sem precisar manipular os vetores.
}
