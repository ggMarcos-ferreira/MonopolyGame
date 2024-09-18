package casas.interfaces.implementacoes;

//abdeel

import casas.Prisao;
import casas.interfaces.PrisaoFactory;

public class PrisaoFactoryConcreta implements PrisaoFactory {
    @Override
    public Prisao criarPrisao(int posicao, String nome, boolean visitandoPrisao) {
        return new Prisao(posicao, nome, visitandoPrisao);
    }
}
