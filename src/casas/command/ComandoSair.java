package casas.command;

//abdeel

import jogo.Peca;

import java.util.Scanner;

public class ComandoSair implements Comando {
    @Override
    public void executar(Peca peca) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nTem certeza de que quer sair (s/n)? ");
        String confirmacao = scanner.nextLine();

        if ("s".equalsIgnoreCase(confirmacao)) {

            System.out.println("\nAté a próxima!");
            System.exit(0);

        } else {
            System.out.println("Continuando o jogo.\n");
        }
    }
}
