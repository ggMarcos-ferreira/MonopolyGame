package jogo;

//Abdeel 

import java.util.Random;

public class Dado {
    public int lancarDado() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
