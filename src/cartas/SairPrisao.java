package cartas;

/**
 *
 * @author marcos
 */

import jogo.Peca;

public class SairPrisao extends Cartas {
    public SairPrisao(int numero, String nome, String descricao) {
        super(numero, nome, descricao);
    }

    @Override
    public void executarAcao(Peca peca) {
        System.out.println("Sair da prisão.");
    }
}
