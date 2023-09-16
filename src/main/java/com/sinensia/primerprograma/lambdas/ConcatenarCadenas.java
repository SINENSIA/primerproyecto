package com.sinensia.primerprograma.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Receta para concatenar cadenas con lambdas.
 *
 */
public class ConcatenarCadenas {
    /**
     * Método principal para probar la receta.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {

        List<String> palabras = Arrays.asList("Escuela", "Java", "Sinensia");

        // Concatenar las palabras con un espacio como separador
        String resultado = palabras.stream()
                .collect(Collectors.joining(" "));
        System.out.println(resultado);
        // Breakpoint
    }
}
