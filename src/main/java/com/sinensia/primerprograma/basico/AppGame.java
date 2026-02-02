package com.sinensia.primerprograma.basico;

import java.util.Scanner;
import com.sinensia.primerprograma.basico.GuessGame.Estado;

/**
 * <b>Aplicación del Juego de Adivinar</b>
 * <p>
 * Lanzador para el juego {@code GuessGame}, manejando la interacción
 * vía consola y el flujo de estados utilizando {@link java.lang.IO}.
 * </p>
 * 
 * @author Sinensia
 */
public class AppGame {

    /**
     * Inicia una partida del juego de adivinanza.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        GuessGame juego = new GuessGame();

        IO.println("--- JUEGO: ADIVINA EL NÚMERO (1-10) ---");
        IO.println("Introduce tu apuesta: ");

        try (Scanner sc = new Scanner(System.in)) {
            String entrada = sc.next();
            Estado resultado = juego.verificarInput(entrada);

            switch (resultado) {
                case SUCCESS -> IO.println("¡ENHORABUENA! Has acertado.");
                case FAILED -> IO.println("Lo siento, no era ese número.");
                case INVALID -> IO.println("ERROR: Debes introducir un número entero válido.");
            }

        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}
