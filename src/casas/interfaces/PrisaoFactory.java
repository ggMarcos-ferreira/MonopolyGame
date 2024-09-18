package casas.interfaces;

//abdeel

import casas.Prisao;

public interface PrisaoFactory {
    Prisao criarPrisao(int posicao, String nome, boolean visitandoPrisao);
}
