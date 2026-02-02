package com.sinensia.primerprograma.funcional.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Receta para calcular el promedio de una lista de números con lambdas.
 * 
 */
public class CalculadoraPromedios {
    /**
     * Método principal para probar la receta.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {
        List<Double> datos = Arrays.asList(7d, 22d, 36d, 40d, 53d, 68d, 71d, 18d, 96d);
        Double resultado = datos
                .stream()
                .mapToDouble(Double::valueOf)
                .map(Math::round)
                .average()
                .orElse(0d);

        resultado = Math.round(resultado * 100d) / 100d;

        System.out.println("El promedio es: " + resultado);
    }

}
