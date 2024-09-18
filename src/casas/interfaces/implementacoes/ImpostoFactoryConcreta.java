package casas.interfaces.implementacoes;

//abdeel

import casas.Imposto;
import casas.interfaces.ImpostoFactory;

public class ImpostoFactoryConcreta implements ImpostoFactory {
    @Override
    public Imposto criarImposto(int posicao, String nome, boolean impostoRiqueza) {
        return new Imposto(posicao, nome, impostoRiqueza);
    }
}
