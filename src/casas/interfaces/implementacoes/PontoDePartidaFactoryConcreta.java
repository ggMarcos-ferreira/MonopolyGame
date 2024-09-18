package casas.interfaces.implementacoes;

//abdeel

import casas.PontoDePartida;
import casas.interfaces.PontoDePartidaFactory;

public class PontoDePartidaFactoryConcreta implements PontoDePartidaFactory {
    @Override
    public PontoDePartida criarPontoDePartida(int posicao, String nome) {
        return new PontoDePartida(posicao, nome);
    }
}
