package com.sinensia.primerprograma.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
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

        Predicate<String> empiezaConA = s -> s.startsWith("A");
        System.out.println(empiezaConA.test("Pedro"));

        Function<String, Integer> longitud = s -> s.length();
        System.out.println(longitud.apply("Hola"));

        Consumer<String> imprimir = s -> System.out.println("#>: " + s);
        imprimir.accept("hola");

        Supplier<Double> generador = () -> Math.random();
        System.out.println(generador.get());

        UnaryOperator<Integer> cuadrado = s -> s * s;
        System.out.println(cuadrado.apply(5));

        BinaryOperator<Integer> suma = (a, b) -> a + b;
        System.out.println(suma.apply(5, 7));
    }

}
