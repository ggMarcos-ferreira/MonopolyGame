package casas;

/**
 *
 * @author marcos
 */

import jogo.Jogador;
import jogo.Peca;

import java.util.Scanner;

public class ServicoPublico extends Casa{
    private int preco;

    public ServicoPublico(int posicao, String nome, int preco) {
        super(posicao, nome);
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public void oferecerCompra(Jogador jogador) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("O serviço " + getNome() + " está disponível por " + getPreco() + ".");
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
            jogador.comprarServicoPublico(this);
        } else {
            System.out.println(jogador.getNome() + ", Dinheiro insuficiente para comprar esta propriedade.");
        }
    }

    @Override
    public void executarAcao(Peca peca) {
        System.out.println(" o peão seguiu para " + getPosicao() + " – " + getNome());

        if (getProprietario() != null) {
            System.out.println("O serviço público " + getNome() + " já possui proprietário.");

            int taxa = getPreco();

            peca.getJogador().diminuirDinheiro(taxa);
            getProprietario().aumentarDinheiro(taxa);

            System.out.println("O jogador " + peca.getJogador().getNome() + " pagou a taxa fixa de " + taxa +
                    " para " + getProprietario().getNome());
            System.out.println("Novo saldo: R$" + peca.getJogador().getDinheiro());

        } else {
            oferecerCompra(peca.getJogador());
        }
    }

}
