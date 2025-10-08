package com.sinensia.primerprograma.basico;

import java.util.Scanner;

import com.sinensia.primerprograma.basico.GuessGame.Estado;

public class AppGame {
    public static void main(String[] args) {

        GuessGame myGame = new GuessGame();

        IO.println("Di un número de 1 al 10: ");

        try (Scanner scanner = new Scanner(System.in)) {
            String numero = scanner.next();
            Estado resultado = myGame.verificarInput(numero);
            switch (resultado) {
                case SUCCESS -> IO.println("Enhorabuena!");
                case FAILED -> IO.println("No es ese...");
                case INVALID -> IO.println("Error: debes pone run número...");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
