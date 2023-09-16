package com.sinensia.primerprograma.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Receta para filtrar numeros pares con lambdas.
 */
public class FiltrarNumerosPares {
    /**
     * Método principal para probar la receta.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(23, 27, 34, 56, 77, 82, 96, 8, 31);

        // Filtrar números pares y almacenarlos en una nueva lista
        List<Integer> numerosPares = numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(numerosPares);
    }

}
