package jogo;

//abdeel

import casas.*;
import casas.interfaces.*;
import casas.interfaces.implementacoes.*;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private final ArrayList<Casa> casas;

    public Tabuleiro() {
        this.casas = new ArrayList<>();
        inicializarCasas();
    }

    private void inicializarCasas(){

        PropriedadeFactory propriedadeFactory = new PropriedadeFactoryConcreta();
        CofreComunitarioFactory cofreComunitarioFactory = new CofreComunitarioFactoryConcreta();
        FerroviaFactory ferroviaFactory = new FerroviaFactoryConcreta();
        ServicoPublicoFactory servicoPublicoFactory = new ServicoPublicoFactoryConcreta();
        SorteFactory sorteFactory = new SorteFactoryConcreta();
        ImpostoFactory impostoFactory = new ImpostoFactoryConcreta();
        PrisaoFactory prisaoFactory = new PrisaoFactoryConcreta();
        PontoDePartidaFactory pontoDePartidaFactory = new PontoDePartidaFactoryConcreta();

        casas.add(propriedadeFactory.criarPropriedade(1, "Mediterranean Avenue",  "roxo",  60,  2));
        casas.add(cofreComunitarioFactory.criarCofreComunitario(2, "Cofre Comunitário 1"));
        casas.add(propriedadeFactory.criarPropriedade(3, "Baltic Avenue", "roxo", 60,  4));
        casas.add(impostoFactory.criarImposto(4, "Imposto de Renda", false));
        casas.add(ferroviaFactory.criarFerrovia(5, "Reading Railroad",  200, 0));
        casas.add(propriedadeFactory.criarPropriedade(6, "Oriental Avenue", "ciano", 100,  6));
        casas.add(sorteFactory.criarSorte(7, "Chance 1"));
        casas.add(propriedadeFactory.criarPropriedade(8, "Vermont Avenue", "ciano", 100, 6));
        casas.add(propriedadeFactory.criarPropriedade(9, "Connecticut Avenue", "ciano", 120, 8));
        casas.add(prisaoFactory.criarPrisao(10, "Prisão: Apenas Visitando",  true));
        casas.add(propriedadeFactory.criarPropriedade(11, "St. Charles Place", "rosa", 140, 10));
        casas.add(servicoPublicoFactory.criarServicoPublico(12, "Companhia Elétrica", 150));
        casas.add(propriedadeFactory.criarPropriedade(13, "States Avenue",  "rosa", 140, 10));
        casas.add(propriedadeFactory.criarPropriedade(14, "Virginia Avenue", "rosa", 160, 12));
        casas.add(ferroviaFactory.criarFerrovia(15, "Pennsylvania Railroad",  200, 0));
        casas.add(propriedadeFactory.criarPropriedade(16, "St. James Place", "laranja", 180, 14));
        casas.add(cofreComunitarioFactory.criarCofreComunitario(17, "Cofre Comunitário 2"));
        casas.add(propriedadeFactory.criarPropriedade(18, "Tennessee Avenue", "laranja", 180, 14));
        casas.add(propriedadeFactory.criarPropriedade(19, "New York Avenue", "laranja", 200, 16));
        casas.add(new CasaAcao(20, "Free Parking"));
        casas.add(propriedadeFactory.criarPropriedade(21, "Kentucky Avenue", "vermelho", 220, 18));
        casas.add(sorteFactory.criarSorte(22, "Chance 2"));
        casas.add(propriedadeFactory.criarPropriedade(23, "Indiana Avenue", "vermelho", 220, 18));
        casas.add(propriedadeFactory.criarPropriedade(24, "Illinois Avenue", "vermelho", 240, 20));
        casas.add(ferroviaFactory.criarFerrovia(25, "B & O Railroad", 200, 0));
        casas.add(propriedadeFactory.criarPropriedade(26, "Atlantic Avenue", "amarelo", 260, 22));
        casas.add(propriedadeFactory.criarPropriedade(27, "Ventnor Avenue", "amarelo", 260, 22));
        casas.add(servicoPublicoFactory.criarServicoPublico(28, "Companhia de Água", 150));
        casas.add(propriedadeFactory.criarPropriedade(29, "Marvin Gardens", "amarelo", 280, 24));
        casas.add(prisaoFactory.criarPrisao(30, "Vá para Prisão",  false));
        casas.add(propriedadeFactory.criarPropriedade(31, "Pacific Avenue", "verde", 300, 26));
        casas.add(propriedadeFactory.criarPropriedade(32, "North Carolina Avenue", "verde", 300, 26));
        casas.add(cofreComunitarioFactory.criarCofreComunitario(33, "Cofre Comunitário 3"));
        casas.add(propriedadeFactory.criarPropriedade(34, "Pennsylvania Avenue", "verde", 320, 28));
        casas.add(ferroviaFactory.criarFerrovia(35, "Short Line", 200, 0));
        casas.add(sorteFactory.criarSorte(36, "Chance 3"));
        casas.add(propriedadeFactory.criarPropriedade(37, "Park Place",  "azul", 350, 35));
        casas.add(impostoFactory.criarImposto(38, "Imposto de Riqueza", true));
        casas.add(propriedadeFactory.criarPropriedade(39, "Boardwalk", "azul", 400, 50));
        casas.add(pontoDePartidaFactory.criarPontoDePartida(40, "Ponto de Partida"));

    }

    public Casa getCasaNaPosicao(int posicao) {
        for (Casa casa : casas) {
            if (casa.getPosicao() == posicao) {
                return casa;
            }
        }
        return null;
    }

    public List<Ferrovia> getFerrovias() {
        List<Ferrovia> ferrovias = new ArrayList<>();
        for (Casa casa : casas) {
            if (casa instanceof Ferrovia) {
                ferrovias.add((Ferrovia) casa);
            }
        }
        return ferrovias;
    }

    public List<ServicoPublico> getServicoPublico() {
        List<ServicoPublico> servicoPublicos = new ArrayList<>();
        for (Casa casa : casas) {
            if (casa instanceof ServicoPublico) {
                servicoPublicos.add((ServicoPublico) casa);
            }
        }
        return servicoPublicos;
    }

}
