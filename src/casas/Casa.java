package casas;

/**
 *
 * @author marcos
 */

import jogo.Jogador;
import jogo.Peca;

public abstract class Casa {
    private int posicao;
    private String nome;
    private Jogador proprietario;

    public Casa(int posicao, String nome){
        this.posicao = posicao;
        this.nome = nome;

        this.proprietario = null;
    }

    public String getNome(){
        return nome;
    }
    public int getPosicao(){
        return posicao;
    }
    public Jogador getProprietario() {
        return proprietario;
    }
    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }
    public abstract void oferecerCompra(Jogador jogador);
    public abstract void venderPara(Jogador jogador);
    public  abstract void executarAcao(Peca peca);

}