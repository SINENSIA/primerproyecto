package com.sinensia.primerprograma.basico;

import java.util.Scanner;

class Game {
    private int numSecreto;

    private Game() {
        numSecreto = SingletonRandom.getInstance().nextInt(1, 11);

    }

    public static void main(String[] args) {

        String respuesta = "";
        System.out.println("Bienvenido al Juego!");

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                Game myGame = new Game();
                System.out.println("Adivina el número secreto: ");
                String num = scanner.next();
                Resultados resultado = myGame.comprobarResultado(num);
                if (resultado == Resultados.INVALID) {
                    continue;
                } else if (resultado == Resultados.SUCCESS) {
                    System.out.println("Enhorabuena! ");
                } else {
                    System.out.println("Suerte la próxima vez! ");
                }
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

    public enum Resultados {
        SUCCESS,
        FAILED,
        INVALID
    }
}