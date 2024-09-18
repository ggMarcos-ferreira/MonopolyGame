package casas.interfaces.implementacoes;

//abdeel

import casas.Propriedade;
import casas.interfaces.PropriedadeFactory;

public class PropriedadeFactoryConcreta implements PropriedadeFactory {
    @Override
    public Propriedade criarPropriedade(int posicao, String nome, String grupo, int preco, int corrida) {
        return new Propriedade(posicao, nome, grupo, preco, corrida);
    }
}
