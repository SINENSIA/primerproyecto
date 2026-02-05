package com.sinensia.primerprograma.ejercicios.streams;

import java.util.Comparator;
import java.util.List;

public class SolucionStreams {

    public static void main(String[] args) {

        List<Animal> animales = List.of(
                new Animal("Tigre", 5, 220),
                new Animal("Leon", 8, 190),
                new Animal("Lince", 3, 25),
                new Animal("Oso", 12, 350),
                new Animal("Lobo", 6, 45));

        // 1. Mostrar todos los animales
        animales.stream()
                .forEach(IO::println);

        // 2. Contar animales con peso > 100 kg
        long pesados = animales.stream()
                .filter(a -> a.getPesoKg() > 100)
                .count();
        IO.println("Animales > 100kg: " + pesados);

        // 3. Obtener el animal más viejo
        Animal masViejo = animales.stream()
                .max(Comparator.comparingInt(Animal::getEdad))
                .orElseThrow();
        IO.println("Más viejo: " + masViejo);

        // 4. Lista de animales jóvenes (edad < 6)
        List<Animal> jovenes = animales.stream()
                .filter(a -> a.getEdad() < 6)
                .toList();
        IO.println(jovenes);

        // 1. Nombres ordenados alfabéticamente
        List<String> nombres = animales.stream()
                .map(Animal::getNombre)
                .sorted()
                .toList();

        // 2. Peso medio
        Double pesoMedio = animales.stream()
                .mapToDouble(Animal::getPesoKg)
                .average()
                .orElse(0);

        // 3. ¿Algún animal > 300 kg?
        boolean hayMuyPesado = animales.stream()
                .anyMatch(a -> a.getPesoKg() > 300);

        IO.println("Nombre de animales -> " + nombres);
        IO.println("Peso medio " + pesoMedio + "Kg");
        IO.println("Hay mas de 300 kg? " + hayMuyPesado);
    }
}
