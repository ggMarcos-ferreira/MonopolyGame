package casas;

/**
 *
 * @author marcos
 */

import jogo.Jogador;
import jogo.Peca;

public class CasaAcao extends Casa{
    public CasaAcao(int posicao, String nome) {
        super(posicao, nome);
    }

    @Override
    public void oferecerCompra(Jogador jogador) {

    }

    @Override
    public void venderPara(Jogador jogador) {

    }

    @Override
    public void executarAcao(Peca peca) {
        System.out.println(" o peão avançou para " + peca.getPosicao() + " – " + getNome());

    }
}
