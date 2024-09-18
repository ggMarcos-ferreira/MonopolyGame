package casas.interfaces.implementacoes;

//abdeel

import casas.Ferrovia;
import casas.interfaces.FerroviaFactory;

public class FerroviaFactoryConcreta implements FerroviaFactory {
    @Override
    public Ferrovia criarFerrovia(int posicao, String nome, int preco, int aluguel) {
        return new Ferrovia(posicao, nome, preco, aluguel);
    }
}
