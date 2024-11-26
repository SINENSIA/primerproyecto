package com.sinensia.primerprograma.arrays;

import java.util.Arrays;

public class Matrices {

    /**
     * El punto de entrada principal del programa.
     * Este método demuestra la creación de un array de enteros e imprime su
     * longitud.
     *
     * @param args Un array de argumentos de línea de comandos pasados al programa.
     *             En este caso, no se esperan ni se utilizan argumentos.
     */
    public static void main(String[] args) {

        String[] simios = { "chimpancé", "babuino", "gorila" };

        System.out.println("--- Con Arrays.toString ----");
        System.out.println(Arrays.toString(simios));

        System.out.println("--- Con bucke for ----");
        for (String simio : simios) {
            System.out.println(simio);
        }

        System.out.println("--- Con streams ----");
        Arrays.stream(simios).forEach(System.out::println);
    }

}
