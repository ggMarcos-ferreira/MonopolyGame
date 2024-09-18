
/**
 *
 * @author marcos
 */

import casas.Casa;
import jogo.Dado;
import jogo.Jogador;
import jogo.Peca;
import jogo.Tabuleiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Dado dado = new Dado();
        Tabuleiro tabuleiro = new Tabuleiro();

        System.out.print("Escolha o número de jogadores entre [2-8]: ");
        int numJogadores = scanner.nextInt();
        scanner.nextLine();
        if (numJogadores < 2 || numJogadores > 8) {
            System.out.println("Número de jogadores inválido. Escolha entre 2 e 8 jogadores.");
            return;
        }

        List<Peca> pecas = new ArrayList<>();

        List<String> addCores = Arrays.asList("preto", "branco", "vermelho", "verde", "azul", "amarelo", "laranja", "rosa");
        List<String> cores = new ArrayList<>(addCores);

        for (int i = 1; i <= numJogadores; i++) {
            System.out.print("Entre com o nome do jogador " + i + ": ");
            String jogadorNome = scanner.nextLine();

            System.out.println("Escolha a cor do peão para o jogador: " + i );
            System.out.println(cores);

            String jogadorCor;
            do {
                jogadorCor = scanner.nextLine();

                if (!cores.contains(jogadorCor)) {
                    System.out.println("Cor inválida. Escolha uma cor disponível.");
                }
            } while (!cores.contains(jogadorCor));

            cores.remove(jogadorCor);

            Peca peca = new Peca(new Jogador(jogadorNome, jogadorCor), tabuleiro);
            pecas.add(peca);

        }

        System.out.println("\nO jogo MONOPOLY foi iniciado.\n");

        int jogadorAtual = 0;
        boolean jogoEncerrado = false;


        while (!jogoEncerrado) {
            Peca peca = pecas.get(jogadorAtual);

            System.out.println("A vez é de " + peca.getJogador().getNome());
            System.out.println("Escolha: [jogar][status][sair]");
            System.out.print("Entre com uma das opções: ");
            String comando = scanner.nextLine();

            if ("sair".equalsIgnoreCase(comando)) {
                System.out.print("\nVocê tem certeza de que quer sair (s/n)? ");
                String confirmacao = scanner.nextLine();
                if ("s".equalsIgnoreCase(confirmacao)) {
                    System.out.println("\nJogo encerrado.");
                    jogoEncerrado = true;
                } else {
                    System.out.println("\nContinuando o jogo.\n");
                }
            } else if ("jogar".equalsIgnoreCase(comando)) {

                int dado1 = dado.lancarDado();
                int dado2 = dado.lancarDado();
                int resultadoDados = dado1 + dado2;

                System.out.print("O jogador " + peca.getJogador().getNome() + " tirou " + dado1 + "," + dado2);
                peca.mover(resultadoDados);

                int novaPosicao = peca.getPosicao();
                if (novaPosicao > 40) {
                    novaPosicao -= 40;
                }

                Casa casaAtual = tabuleiro.getCasaNaPosicao(novaPosicao);
                casaAtual.executarAcao(peca);

                if (peca.jogadorFaliu(peca.getJogador())) {
                    System.out.println("O jogador " + peca.getJogador().getNome() + " faliu e saiu do jogo!");
                    pecas.remove(jogadorAtual);
                    numJogadores--;

                    if (numJogadores == 1) {

                        System.out.println("Parabéns! O jogador " + pecas.get(0).getJogador().getNome() + " venceu!");
                        jogoEncerrado = true;

                    } else {
                        System.out.println("Continuando o jogo com " + numJogadores + " jogadores.\n");
                    }
                } else {
                    System.out.println("\n");
                    jogadorAtual = (jogadorAtual + 1) % numJogadores;
                }


            } else if ("status".equalsIgnoreCase(comando)) {
                peca.status();
            }
        }

        scanner.close();
    }

}
