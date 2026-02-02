package com.sinensia.primerprograma.basico;

import java.util.Scanner;

/**
 * <b>Juego de Adivinanza (Versión con Intentos)</b>
 * <p>
 * Demuestra lógica de bucles, condicionales y uso de {@code Enums} para
 * gestionar el resultado de una partida con múltiples intentos, utilizando
 * la API {@link java.lang.IO} de Java 25.
 * </p>
 * 
 * @author Sinensia
 */
class Game {
    private int numSecreto;

    /**
     * Constructor privado: Inicializa el número secreto usando un
     * {@code Singleton}.
     */
    private Game() {
        // Generamos un número entre 1 y 10.
        numSecreto = SingletonRandom.getInstance().nextInt(1, 11);
    }

    /**
     * Ejecuta el bucle principal de partidas.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        String respuesta;
        IO.println("--- BIENVENIDO AL JUEGO DEL NÚMERO SECRETO ---");

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                Game partida = new Game();
                partida.play(scanner, 3); // Máximo 3 intentos

                IO.println("\n¿Quieres jugar otra partida? (s/n): ");
                respuesta = scanner.next();

            } while (!respuesta.equalsIgnoreCase("n"));

        } catch (Exception e) {
            System.err.println("Ha ocurrido un error en el sistema.");
        }
    }

    /**
     * Comprueba si el texto introducido coincide con el número secreto.
     * 
     * @param num Texto a comprobar
     * @return El estado resultante (SUCCESS, FAILED, INVALID)
     */
    public Resultados comprobarResultado(String num) {
        try {
            int valor = Integer.parseInt(num);
            if (valor == numSecreto) {
                return Resultados.SUCCESS;
            } else {
                return Resultados.FAILED;
            }
        } catch (NumberFormatException e) {
            IO.println("ERROR: Formato no válido. Introduce un número.");
            return Resultados.INVALID;
        }
    }

    /**
     * Lógica de la partida.
     * 
     * @param scanner     Fuente de entrada
     * @param maxIntentos Número de oportunidades
     */
    public void play(Scanner scanner, int maxIntentos) {
        boolean acierto = false;
        int intentosRealizados = 0;

        while (!acierto && intentosRealizados < maxIntentos) {
            IO.print("Introduce el número secreto: ");
            String entrada = scanner.next();
            Resultados res = comprobarResultado(entrada);

            if (res == Resultados.SUCCESS) {
                IO.println("¡INCREÍBLE! Has ganado.");
                acierto = true;
            } else if (res == Resultados.FAILED) {
                intentosRealizados++;
                if (intentosRealizados < maxIntentos) {
                    IO.println("No es correcto. Te quedan " + (maxIntentos - intentosRealizados) + " intentos.");
                } else {
                    IO.println("GAME OVER. El número era: " + numSecreto);
                }
            }
        }
    }

    /**
     * Posibles estados de una comprobación.
     */
    public enum Resultados {
        SUCCESS,
        FAILED,
        INVALID
    }
}
