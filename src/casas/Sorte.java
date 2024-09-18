package casas;

/**
 *
 * @author marcos
 */

import cartas.Cartas;
import cartas.Movimento;
import cartas.Pagamento;
import cartas.SairPrisao;
import jogo.Jogador;
import jogo.Peca;

import java.util.ArrayList;
import java.util.Collections;

public class Sorte extends Casa {
    private ArrayList<Cartas> cartas;
    private int indexAtual;

    public Sorte(int posicao, String nome){
        super(posicao, nome);
        this.indexAtual = 0;
        this.cartas = new ArrayList<>();
        inicializarCartas();
        embaralharCartas();
    }


    public void inicializarCartas() {
        cartas.add(new Movimento(1, "Avance para o Ponto de Partida", "Receba $200",  40, true, false, false));
        cartas.add(new Movimento(2, "Avance para Illinois Avenue", "O jogador não recebe $200 se passar pelo Ponto de Partida.", 24, false, false, false));
        cartas.add(new Movimento(3, "Avance para St. Charles Place", "Se passar pelo Ponto de Partida, receba $200", 11, true, false, false));
        cartas.add(new Movimento(4, "Avance o peão para o serviço público mais próximo", "Se não tiver dono, você pode comprá-lo do banco. Se tiver, lance os dados e pague ao dono 10 vezes o resultado do lançamento. O jogador não recebe $200 se passar pelo Ponto de Partida.", 2, false, false, true));
        cartas.add(new Movimento(5, "Avance o peão para a ferrovia mais próxima", "Pague ao dono duas vezes o valor que ele deveria receber normalmente. Se a ferrovia não tiver dono, você pode comprá-la do banco. O jogador não recebe $200 se passar pelo Ponto de Partida.", 5, false, true, false));
        cartas.add(new Pagamento(6, "O banco lhe pagou dividendos de $50", "", 50, false));
        cartas.add(new Movimento(7, "Volte 3 espaços", "", 3,false, false, false));
        cartas.add(new Movimento(8, "Vá diretamente para a Prisão", "Não passe pelo ponto de partida, não receba $200.",  30, false, false, false));
        cartas.add(new SairPrisao(9, "Esta carta pode ser mantida até seu uso ou venda", "Sair Livre da Prisão."));
        cartas.add(new Movimento(10, "Dê uma volta no Tabuleiro", "Se você passar pelo Ponto de Partida, receba $200", 5,true, false, false));
    }

    public Cartas getCartaAleatoria() {
        if (indexAtual >= cartas.size()) {
            embaralharCartas();
            indexAtual = 0;
        }

        Cartas carta = cartas.get(indexAtual);
        indexAtual++;
        return carta;
    }

    private void embaralharCartas() {
        Collections.shuffle(cartas);
    }

    @Override
    public void oferecerCompra(Jogador jogador) {

    }

    @Override
    public void venderPara(Jogador jogador) {

    }

    @Override
    public void executarAcao(Peca peca) {
        System.out.println(" o peão seguiu para " + getPosicao() + " – " + getNome() + ".");
        Cartas cartaSorteada = getCartaAleatoria();

        if(cartaSorteada.getNumero() == 7){
            peca.voltar(3);

        } else {

            System.out.println(cartaSorteada.getNome());
            System.out.println(cartaSorteada.getDescricao());
            cartaSorteada.executarAcao(peca);
        }

    }
}
