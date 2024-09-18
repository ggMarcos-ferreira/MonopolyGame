package casas.interfaces.implementacoes;

//abdeel

import casas.ServicoPublico;
import casas.interfaces.ServicoPublicoFactory;

public class ServicoPublicoFactoryConcreta implements ServicoPublicoFactory {
    @Override
    public ServicoPublico criarServicoPublico(int posicao, String nome, int preco) {
        return new ServicoPublico(posicao, nome, preco);
    }
}
