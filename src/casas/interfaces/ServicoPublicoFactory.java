package casas.interfaces;

//abdeel

import casas.ServicoPublico;

public interface ServicoPublicoFactory {
    ServicoPublico criarServicoPublico(int posicao, String nome, int preco);
}
