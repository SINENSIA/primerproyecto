package com.sinensia.primerprograma.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase ejemplo de uso de streams.
 *
 * @version 1.0
 * @since 2023
 * @see java.util.stream.Stream
 *
 */
public class MyStreams {

        /**
         * Método principal de la clase.
         *
         * @param args parámetros de la línea de comandos
         */
        public static void main(String[] args) {

                // Creamos una lista de números
                List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

                // Usamos filter para seleccionar solo los números pares
                List<Integer> numerosPares = numeros.stream()
                                .filter(numero -> numero % 2 == 0)
                                .toList();
                // Imprimimos los resultados
                System.out.println("Números pares: " + numerosPares);

                // Usamos map para multiplicar cada número par por 2
                List<Integer> numerosDobles = numerosPares.stream()
                                .map(numero -> numero * 2)
                                .toList();

                // Imprimimos los resultados
                System.out.println("Números dobles: " + numerosDobles);

                // Con predicado (hay que llamar test() salvo cuando trabajamos con String)
                IntPredicate esMayorQue3 = num -> (num > 3);
                List<Integer> mayoresQue3 = numeros.stream()
                                .filter(esMayorQue3::test)
                                .toList();
                // Imprimimos los resultados
                System.out.println("Mayores que 3: " + mayoresQue3);

                Set<String> nombres = new TreeSet<>(Arrays.asList(
                                "Ana", "Carlos", "David", "Beatriz", "Armando"))
                                .stream()
                                .filter(nombre -> nombre.startsWith("A"))
                                .collect(Collectors.toSet());
                System.out.println("Nombres que empiezan por A: " + nombres);
                // resultado Nombres que empiezan por A: [Ana, Armando]

                // Ejemplo de uso de streams con strings y expresiones lambda
                List<String> empiezanPorA = nombres.stream()
                                .filter(nombre -> nombre.startsWith("A"))
                                .toList();

                System.out.println(empiezanPorA);

                // El mismo ejemplo anterior, con string pero usando predicados y referencias a
                // métodos
                Predicate<String> empiezaPorA = nombre -> nombre.startsWith("A");

                nombres.stream()
                                .filter(empiezaPorA)
                                .forEach(System.out::println);

                // MAP
                Stream<String> input = Arrays.stream(new String[] { "Rohan", "Mordor", "elandir" });

                // Mapear la función toUpperCase() a cada elemento de la lista
                System.out.println(input.map(String::toUpperCase).toList());
                // Resultado: [ROHAN, MORDOR, ELANDIR]

                // DISITNC
                List<String> nombresRepetidos = Arrays.asList(
                                "Ana", "Carlos", "David", "Beatriz", "Armando", "Ana", "Carlos");
                System.out.println(nombresRepetidos.stream().distinct().toList());
                // Resultado: [Ana, Carlos, David, Beatriz, Armando]

                // SORTED
                List<String> nombresDesordenados = Arrays.asList(
                                "Ana", "Carlos", "David", "Beatriz", "Armando");
                System.out.println(
                                nombresDesordenados
                                                .stream()
                                                .sorted()
                                                .toList());
                // Resultado: [Ana, Armando, Beatriz, Carlos, David]

                // SORTED CON función de comparación
                System.out.println(
                                nombresDesordenados
                                                .stream()
                                                .sorted(Comparator.comparing(String::length))
                                                .toList());
                // Resultado: [Ana, David, Carlos, Beatriz, Armando]

                // LIMIT
                List<Integer> notas = Arrays.asList(5, 2, 8, 7, 6, 7, 4, 3, 10);

                // Utilizamos limit para obtener los primeros tres elementos
                List<Integer> primerasTresNotas = notas.stream()
                                .limit(3)
                                .toList();

                // Imprimimos los primeros tres números
                System.out.println("Primeras tres notas: ");
                primerasTresNotas.forEach(System.out::println);
                // Resultado: 5 2 8

                List<Integer> restantesNotas = notas.stream()
                                .skip(3)
                                .toList();
                System.out.println("Restantes notas: ");
                System.out.println(restantesNotas);
                // Resultado: [7, 6, 7, 4, 3, 10]

                // Utilizamos reduce para sumar las notas en la lista
                Optional<Integer> suma = notas.stream()
                                .reduce((a, b) -> a + b);

                // Imprimimos el resultado si está presente
                suma.ifPresent(System.out::println); // Output: 15

                // MIN
                Optional<Integer> min = notas.stream()
                                .min(Comparator.comparing(Integer::valueOf));
                // Imprime el valor mínimo si está presente
                min.ifPresent(System.out::println); // Output: 2

                // MAX
                Optional<Integer> max = notas.stream()
                                .max(Comparator.comparing(Integer::valueOf));
                // Imprime el valor máximo si está presente
                max.ifPresent(System.out::println); // Output: 10

                // Calcular la media
                double media = notas.stream()
                                .mapToDouble(Double::valueOf)
                                .average()
                                .orElse(0.0); // Valor predeterminado si no hay elementos

                System.out.println("Media: " + media);

                // Calcular la desviación típica
                double desviacionTipica = Math.sqrt(
                                notas.stream()
                                                .mapToDouble(Double::valueOf)
                                                .map(nota -> Math.pow(nota - media, 2))
                                                .average()
                                                .orElse(0.0) // Valor predeterminado si no hay elementos
                );

                System.out.println("Desviación Típica: " + desviacionTipica);

                // COUNT
                long numeroDeNotas = notas.stream().count();
                System.out.println("Número de notas: " + numeroDeNotas);
                // Resultado: 9

                // ANYMATCH
                boolean hayNotasSobresalientes = notas.stream()
                                .anyMatch(nota -> nota >= 9);
                System.out.println("Hay notas sobresalientes: " + hayNotasSobresalientes);
                //

        }
}
