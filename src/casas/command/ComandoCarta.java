package casas.command;

//abdeel

import jogo.Peca;

public class ComandoCarta implements Comando{
    @Override
    public void executar(Peca peca) {
        System.out.println("Você usou uma carta para sair da prisão!");
        peca.resetarJogadas();
    }
}
