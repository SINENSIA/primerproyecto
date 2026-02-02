package com.sinensia.primerprograma.basico;

import java.util.Random;

/**
 * <b>Lógica del Juego de Adivinanza (GuessGame)</b>
 * <p>
 * Encapsula el estado del juego sencillo (un solo turno por ejecución).
 * </p>
 * 
 * @author Sinensia
 */
class GuessGame {
    private int numeroSecreto;

    /** Constante con el número máximo de vidas permitido */
    static final int VIDAS = 3;

    /**
     * Crea un nuevo juego generando un número secreto aleatorio (1-10).
     */
    public GuessGame() {
        numeroSecreto = new Random().nextInt(1, 11);
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }

    /**
     * Verifica si la entrada del usuario es correcta.
     * 
     * @param numero Texto con el número apostado
     * @return {@link Estado} de la apuesta
     */
    public Estado verificarInput(String numero) {
        try {
            int apuesta = Integer.parseInt(numero);
            return (apuesta == numeroSecreto) ? Estado.SUCCESS : Estado.FAILED;
        } catch (NumberFormatException e) {
            return Estado.INVALID;
        }
    }

    /**
     * Posibles estados del resultado de una jugada.
     */
    enum Estado {
        SUCCESS,
        FAILED,
        INVALID
    }
}
