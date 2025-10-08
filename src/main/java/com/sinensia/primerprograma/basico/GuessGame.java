package com.sinensia.primerprograma.basico;

import java.util.Random;

class GuessGame {
    private int numeroSecreto;
    static final int VIDAS = 3;

    public GuessGame() {
        /**
         * Generamos un número aleatorio en 1,10
         */
        numeroSecreto = new Random().nextInt(1, 11);
        IO.println("shhh el número secreto es: " + numeroSecreto);
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }

    public Estado verificarInput(String numero) {
        try {
            int numeroInt = Integer.parseInt(numero);
            if (numeroInt == getNumeroSecreto()) {
                return Estado.SUCCESS;
            } else {
                return Estado.FAILED;
            }

        } catch (Exception e) {
            return Estado.INVALID;
        }
    }
    public void play() {
        
    }
    enum Estado {
        SUCCESS,
        FAILED,
        INVALID
    }

}
