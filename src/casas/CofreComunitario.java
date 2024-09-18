package casas;

//abdeel

import java.util.Collections;
import java.util.ArrayList;

import cartas.Cartas;
import cartas.Movimento;
import cartas.SairPrisao;
import jogo.Jogador;
import jogo.Peca;

public class CofreComunitario extends Casa {
    private ArrayList<Cartas> cartas;
    private int indexAtual;

    public CofreComunitario(int posicao, String nome) {
        super(posicao, nome);
        this.indexAtual = 0;
        this.cartas = new ArrayList<>();
        inicializarCartas();
        espalharCartas();
    }

    private void inicializarCartas() {
        cartas.add(new Movimento(1, "Avance para o Ponto de Partida (Go)", "Receba $200", 40, true, false, false));
        cartas.add(new SairPrisao(2, "Saia Livre da Prisão, sem cartas.",
                "Esta carta pode ser mantida até o uso ou venda."));
        cartas.add(new Movimento(3, "Vá para a Prisão",
                "Vá direto para a prisão – Não passe pelo ponto de partida – Não receba $200", 30, false, false,
                false));
    }

    public Cartas getCartaAleatoria() {
        if (indexAtual >= cartas.size()) {
            espalharCartas();
            indexAtual = 0;
        }

        Cartas carta = cartas.get(indexAtual);
        indexAtual++;
        return carta;
    }

    private void espalharCartas() {
        Collections.shuffle(cartas);
    }

    @Override
    public void oferecerCompra(Jogador jogador) {

    }

    @Override
    public void venderPara(Jogador jogador) {

    }

    public void executarAcao(Peca peca) {
        System.out.println(" o peão seguiu para " + getPosicao() + " – " + getNome() + ".");
        Cartas cartaSorteada = getCartaAleatoria();
        System.out.println(cartaSorteada.getNome());
        System.out.println(cartaSorteada.getDescricao());
        cartaSorteada.executarAcao(peca);
    }
}
