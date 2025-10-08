package com.sinensia.primerprograma.basico;

import java.util.Scanner;

class Game {
    private int numSecreto;

    private Game() {
        numSecreto = SingletonRandom.getInstance().nextInt(1, 11);
        System.out.println(numSecreto);
    }

    public static void main(String[] args) {

        String respuesta = "";
        System.out.println("Bienvenido al Juego!");

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                Game myGame = new Game();

                int maxIntentos = 3;

                myGame.play(scanner, maxIntentos);
                System.out.println("Otra partida? (s/n)");
                respuesta = scanner.next();

            } while (!respuesta.equalsIgnoreCase("n"));

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error ");
            e.printStackTrace();
        }
    }

    public Resultados comprobarResultado(String num) {
        try {
            int valor = Integer.parseInt(num);
            if (valor == numSecreto) {
                System.out.println("Acierto! ");
                return Resultados.SUCCESS;
            } else {
                System.out.println("No ese no es! ");
                return Resultados.FAILED;
            }

        } catch (Exception e) {
            System.out.println("--- ERROR: Escribe un número entero. ---");
            return Resultados.INVALID;

        }
    }

    public void play(Scanner scanner, int maxIntentos) {

        boolean acierto = false;
        int numIntentos = 0;
        while (!acierto && numIntentos < maxIntentos) {
            System.out.println("Adivina el número secreto: ");
            String num = scanner.next();
            Resultados resultado = this.comprobarResultado(num);
            if (resultado == Resultados.INVALID) {
                // continue; no hace falta
            } else if (resultado == Resultados.SUCCESS) {
                System.out.println("Enhorabuena! ");
                acierto = true;
            } else {
                numIntentos++;
                if (numIntentos < maxIntentos) {
                    System.out.println("No es ese, intenta de nuevo!");
                } else {
                    System.out.println("Ya no hay más intentos. Buena suerte la próxima vez! El númeor era: "
                            + this.numSecreto);
                }

            }
        }

    }

    public enum Resultados {
        SUCCESS,
        FAILED,
        INVALID
    }
}