package casas.interfaces;

//abdeel

import casas.Imposto;

public interface ImpostoFactory {
    Imposto criarImposto(int posicao, String nome, boolean impostoRiqueza);
}
