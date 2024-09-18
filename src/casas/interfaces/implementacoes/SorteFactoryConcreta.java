package casas.interfaces.implementacoes;

//abdeel

import casas.Sorte;
import casas.interfaces.SorteFactory;

public class SorteFactoryConcreta implements SorteFactory {
    @Override
    public Sorte criarSorte(int posicao, String nome) {
        return new Sorte(posicao, nome);
    }
}
