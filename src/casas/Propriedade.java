package casas;

/**
 *
 * @author marcos
 */

import jogo.Jogador;
import jogo.Peca;

import java.util.Scanner;

public class Propriedade extends Casa {
    private String grupo;
    private int preco;
    private int aluguel;

    public Propriedade(int posicao, String nome, String grupo, int preco, int aluguel) {
        super(posicao, nome);
        this.grupo = grupo;
        this.preco = preco;
        this.aluguel = aluguel;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public void oferecerCompra(Jogador jogador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("A propriedade " + getNome() + " está disponível por " + getPreco() + ".");
        System.out.println(jogador.getNome() + ", você possui R$" + jogador.getDinheiro() + ".");

        System.out.print("Você deseja comprar " + getNome() +  " (s/n)? ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            venderPara(jogador);
        }
    }

    @Override
    public void venderPara(Jogador jogador) {
        if (jogador.getDinheiro() >= getPreco()) {
            jogador.comprarPropriedade(this);
        } else {
            System.out.println(jogador.getNome() + ", Dinheiro insuficiente para comprar esta propriedade.");
        }
    }

    @Override
    public void executarAcao(Peca peca) {
        System.out.println(" o peão seguiu para " + getPosicao() + " – " + getNome());

        if (getProprietario() != null) {
            System.out.println("A propriedade " + getNome() + " já possui proprietário.");

            int taxa = getAluguel();

            peca.getJogador().diminuirDinheiro(taxa);
            getProprietario().aumentarDinheiro(taxa);

            System.out.println("O jogador " + peca.getJogador().getNome() + " pagou o aluguel de " + taxa +
                    " para " + getProprietario().getNome());
            System.out.println("Novo saldo: R$" + peca.getJogador().getDinheiro());

        } else {
            oferecerCompra(peca.getJogador());
        }
    }
}
