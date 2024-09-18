package casas.command;

//abdeel

import jogo.Peca;

public class ComandoPagar implements Comando {
    @Override
    public void executar(Peca peca) {
        int valorFianca = 75;

        if (peca.getJogador().getDinheiro() >= valorFianca) {

            System.out.println("Você pagou para sair da prisão!");
            peca.getJogador().diminuirDinheiro(valorFianca);
            peca.resetarJogadas();

        } else {
            System.out.println("Dinheiro insuficiente para pagar a fiança.");
        }
    }
}
