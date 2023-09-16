package com.sinensia.primerprograma.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Receta para leer un fichero con lambdas.
 * 
 */
public class AccesoFichero {
    /**
     * Método principal para probar la receta.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {

        // try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("sinensia.txt"))) {
            br.lines().forEach(linea -> System.out.println(linea)); // O también System.out::println
        } catch (IOException e) { // por si no existe el fichero
            e.printStackTrace();
        }

    }
}
