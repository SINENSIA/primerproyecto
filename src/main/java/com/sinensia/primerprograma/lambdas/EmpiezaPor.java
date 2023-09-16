package com.sinensia.primerprograma.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Receta para filtrar cadenas con lambdas.
 * 
 */
public class EmpiezaPor {
    /**
     * Método principal para probar la receta.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {

        List<String> nombres = Arrays.asList(
                "Madrid", "Barcelona", "Salamanca", "Málaga", "Orense");

        // Filtrar nombres que empiecen con "M" y almacenarlos en una nueva lista
        List<String> empiezanPorMaOrSa = nombres.stream()
                .filter(nombre -> nombre.startsWith("Ma") || nombre.startsWith("Sa"))
                .collect(Collectors.toList());
        System.out.println(empiezanPorMaOrSa);
    }

}
