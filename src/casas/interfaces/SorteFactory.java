package casas.interfaces;

//abdeel

import casas.Sorte;

public interface SorteFactory {
    Sorte criarSorte(int posicao, String nome);
}
