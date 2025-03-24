package com.sinensia.primerprograma.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class GuiaLambdas {

    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(
                Arrays.asList("Juan", "Ana", "Pepe", "Luis", "Elena"));

        // Recorrer la lista con un bucle for
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        nombres.forEach((String nombre) -> System.out.println(nombre));
        // nombres.forEach(nombre -> System.out.println(nombre)); // Se puede omitir el
        // tipo de dato
        nombres.forEach(System.out::println);

        Predicate<String> empiezaConA = s -> s.startsWith("A");
        System.out.println(empiezaConA.test("Alfa")); // true

        Function<String, Integer> longitud = s -> s.length();
        System.out.println(longitud.apply("Lambda")); // 6

        Consumer<String> imprimir = s -> System.out.println("Mensaje: " + s);
        imprimir.accept("Hola");

        Supplier<Double> generador = () -> Math.random();
        System.out.println(generador.get());

        UnaryOperator<Integer> cuadrado = x -> x * x;
        System.out.println(cuadrado.apply(5)); // 25

        BinaryOperator<Integer> suma = (a, b) -> a + b;
        System.out.println(suma.apply(3, 4)); // 7
    }

}
