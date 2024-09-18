package casas.interfaces;

//abdeel

import casas.PontoDePartida;

public interface PontoDePartidaFactory {
    PontoDePartida criarPontoDePartida(int posicao, String nome);
}
