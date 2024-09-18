package casas.interfaces.implementacoes;

//abdeel

import casas.CofreComunitario;
import casas.interfaces.CofreComunitarioFactory;

public class CofreComunitarioFactoryConcreta implements CofreComunitarioFactory {
    @Override
    public CofreComunitario criarCofreComunitario(int posicao, String nome) {
        return new CofreComunitario(posicao, nome);
    }
}
