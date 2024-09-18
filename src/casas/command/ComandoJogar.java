package casas.command;

//abdeel

import jogo.Dado;
import jogo.Peca;

public class ComandoJogar implements Comando {

    @Override
    public void executar(Peca peca) {

        Dado dado = new Dado();
        int dado1 = dado.lancarDado();
        int dado2 = dado.lancarDado();

        System.out.println("\nO jogador " + peca.getJogador().getNome() + " tirou " + dado1 + "," + dado2);

        if (dado1 == dado2) {

            System.out.println("Você saiu da prisão!\n");
            peca.resetarJogadas();

        } else {

            System.out.println("Você não conseguiu sair da prisão.");
            peca.incrementarJogadas();

        }

    }

}
