package cartas;

/**
 *
 * @author marcos
 */

import casas.ServicoPublico;
import casas.Ferrovia;
import jogo.Peca;
import java.util.List;

public class Movimento extends Cartas {

    private int novaPosicao;
    private boolean podeReceberBonus;
    private boolean irFerrovia;
    private boolean irServicoPublico;

    public Movimento(int numero, String nome, String descricao, int novaPosicao, boolean podeReceberBonus, boolean irFerrovia, boolean irServicoPublico) {
        super(numero, nome, descricao);
        this.novaPosicao = novaPosicao;
        this.podeReceberBonus = podeReceberBonus;
        this.irFerrovia = irFerrovia;
        this.irServicoPublico = irServicoPublico;

    }

    public int getNovaPosicao() {
        return novaPosicao;
    }

    public boolean isPodeReceberBonus() {
        return podeReceberBonus;
    }

    public boolean isIrParaFerrovia() {
        return irFerrovia;
    }

    public boolean isIrParaServicoPublico() {
        return irServicoPublico;
    }

    private Ferrovia encontrarFerroviaProxima(int posicaoAtual, List<Ferrovia> ferrovias) {
        Ferrovia ferroviaProxima = ferrovias.get(0);
        int menorDistancia = Math.min(
                (ferroviaProxima.getPosicao() - posicaoAtual + 40) % 40,
                (posicaoAtual - ferroviaProxima.getPosicao() + 40) % 40
        );

        for (Ferrovia ferrovia : ferrovias) {
            int distancia = Math.min(
                    (ferrovia.getPosicao() - posicaoAtual + 40) % 40,
                    (posicaoAtual - ferrovia.getPosicao() + 40) % 40
            );

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                ferroviaProxima = ferrovia;
            }
        }

        return ferroviaProxima;
    }

    private ServicoPublico encontrarServicoProximo(int posicaoAtual, List<ServicoPublico> servicoPublico) {
        ServicoPublico servicoProximo = servicoPublico.get(0);
        int menorDistancia = Math.min(
                (servicoProximo.getPosicao() - posicaoAtual + 40) % 40,
                (posicaoAtual - servicoProximo.getPosicao() + 40) % 40
        );

        for (ServicoPublico servico : servicoPublico) {
            int distancia = Math.min(
                    (servico.getPosicao() - posicaoAtual + 40) % 40,
                    (posicaoAtual - servico.getPosicao() + 40) % 40
            );

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                servicoProximo = servico;
            }
        }

        return servicoProximo;
    }

    @Override
    public void executarAcao(Peca peca) {
        System.out.println("\nAvançando para " + getNovaPosicao() + ".");

        int posicaoAtual = peca.getPosicao();


        if(isIrParaFerrovia()){

            List<Ferrovia> ferrovias = peca.getFerrovias();
            Ferrovia ferroviaProxima = encontrarFerroviaProxima(posicaoAtual, ferrovias);
            peca.mover(ferroviaProxima.getPosicao() - posicaoAtual);
            System.out.println("o peão avançou para " + ferroviaProxima.getPosicao() + " – " + ferroviaProxima.getNome() + ".");

        } else if (isIrParaServicoPublico()) {
            List<ServicoPublico> servicoPublicos = peca.getServicoPublico();
            ServicoPublico servicoProximo = encontrarServicoProximo(posicaoAtual, servicoPublicos);
            peca.mover(servicoProximo.getPosicao() - posicaoAtual);
            System.out.println("o peão avançou para " + servicoProximo.getPosicao() + " – " + servicoProximo.getNome() + ".");

        } else {

            peca.mover(getNovaPosicao() - peca.getPosicao());
            System.out.println("o peão avançou para " + peca.getPosicao() + " – " + peca.getNomeDaCasa() + ".");

        }

        int bonus = 200;
        if(isPodeReceberBonus()){
            peca.getJogador().aumentarDinheiro(bonus);
        }
    }

}
