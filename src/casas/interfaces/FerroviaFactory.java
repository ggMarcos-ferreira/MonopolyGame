package casas.interfaces;

//abdeel

import casas.Ferrovia;

public interface FerroviaFactory {
    Ferrovia criarFerrovia(int posicao, String nome, int preco, int corrida);
}
