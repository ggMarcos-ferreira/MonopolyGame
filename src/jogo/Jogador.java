package jogo;

/**
 *
 * @author marcos
 */

import casas.Ferrovia;
import casas.Propriedade;
import casas.ServicoPublico;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private String cor;
    private int dinheiro;
    private ArrayList<Titulo> titulos = new ArrayList<>();

    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;

        dinheiro = 1500;
    }

    public String getNome() {
        return nome;
    }
    public String getCor() {
        return cor;
    }
    public int getDinheiro(){
        return dinheiro;
    }
    public void diminuirDinheiro(int valor){ dinheiro -= valor; }
    public void aumentarDinheiro(int valor) {
        dinheiro += valor;
    }

    public void comprarPropriedade(Propriedade propriedade) {
            if (dinheiro >= propriedade.getPreco()) {
                dinheiro -= propriedade.getPreco();
                propriedade.setProprietario(this);

                adicionarTitulo(new Titulo(propriedade.getNome(), propriedade.getGrupo(), propriedade.getPreco()));
                System.out.println(getNome() + " comprou a propriedade " + propriedade.getNome() + " por " + propriedade.getPreco() + ".");
            } else {
                System.out.println(getNome() + ", Dinheiro insuficiente para comprar esta propriedade.");
            }
    }

    public void comprarFerrovia(Ferrovia ferrovia) {
        if (dinheiro >= ferrovia.getPreco()) {
            dinheiro -= ferrovia.getPreco();

            adicionarTitulo(new Titulo(ferrovia.getNome(), " ", ferrovia.getPreco()));
            System.out.println(getNome() + " comprou a ferrovia " + ferrovia.getNome() + " por " + ferrovia.getPreco() + ".");
        } else {
            System.out.println(getNome() + ", Dinheiro insuficiente para comprar esta ferrovia.");
        }
    }

    public void comprarServicoPublico(ServicoPublico servicoPublico){
        if(dinheiro >= servicoPublico.getPreco()){
            dinheiro -= servicoPublico.getPreco();

            adicionarTitulo(new Titulo(servicoPublico.getNome(), " ", servicoPublico.getPreco()));
            System.out.println(getNome() + " comprou o seviço público " + servicoPublico.getNome() + " por " + servicoPublico.getPreco() + ".");
        } else {
            System.out.println(getNome() + ", Dinheiro insuficiente para comprar este serviço.");
        }

    }

    public void adicionarTitulo(Titulo titulo) {
        titulos.add(titulo);
    }

    public ArrayList<Titulo> getTitulos() {
        return titulos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("jogo.Jogador{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor +
                ", dinheiro=" + dinheiro +
                ", titulos=");

        if (titulos.isEmpty()) {
            stringBuilder.append("Nenhum título");
        } else {
            for (Titulo titulo : titulos) {
                stringBuilder.append("\n").append(titulo);
            }
        }

        return stringBuilder.toString();
    }

}




