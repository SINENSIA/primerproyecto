package com.sinensia.primerprograma.funcional.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsWorkflow {

        public static void main(String[] args) {

                List<String> nombres = List.of("Ana", "Luis", "Beatriz", "Rodrigo", "Alberto", "Natalia", "José");

                Stream<String> stream = nombres.stream();

                Stream<String> filtrado = stream.filter(n -> n.length() > 4);

                List<String> resultado = filtrado.map(String::toUpperCase).toList();

                IO.println(resultado);

                List<String> resultadoStream = List
                                .of("Ana", "Luis", "Beatriz", "Rodrigo", "Alberto", "Natalia", "José")
                                .stream()
                                .filter(n -> n.length() > 4)
                                .map(String::toUpperCase)
                                .toList();

                IO.println(resultadoStream);

                List<String> resultadoStream2 = List
                                .of("Ana", "Luis", "Beatriz", "Rodrigo", "Alberto", "Natalia", "José")
                                .stream()
                                .filter(n -> n.length() > 4)
                                .map(String::toUpperCase)
                                .toList();

                Predicate<String> empiezanPorA = nombre -> nombre.startsWith("A");

                IO.println((resultadoStream2.stream().anyMatch(empiezanPorA)) ? "Hay nombres que empiezan por A"
                                : "Ningún nombre empieza por A");

        }

}
