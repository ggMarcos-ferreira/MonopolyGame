package cartas;

/**
 *
 * @author marcos
 */

import jogo.Peca;

public class Pagamento extends Cartas{
    private int valor;
    private boolean pagar;

    public Pagamento(int numero, String nome, String descricao, int valor, boolean pagar) {
        super(numero, nome, descricao);
        this.valor = valor;
        this.pagar = pagar;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isPagar() {
        return pagar;
    }

    public void setPagar(boolean pagar) {
        this.pagar = pagar;
    }

    @Override
    public void executarAcao(Peca peca) {
        int valor = getValor();

        if(isPagar()){

            peca.getJogador().diminuirDinheiro(valor);
            int dinheiroAtual = peca.getJogador().getDinheiro();
            System.out.println("O jogador pagou " + valor + ". Novo saldo: R$" + dinheiroAtual);

        } else {

            peca.getJogador().aumentarDinheiro(valor);
            int dinheiroAtual = peca.getJogador().getDinheiro();
            System.out.println("O jogador recebeu " + valor + ". Novo saldo: R$" + dinheiroAtual);

        }

    }
}
