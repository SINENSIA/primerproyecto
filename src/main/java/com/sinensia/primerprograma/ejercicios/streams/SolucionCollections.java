package com.sinensia.primerprograma.ejercicios.streams;

import java.util.ArrayList;
import java.util.List;

public class SolucionCollections {

    public static void main(String[] args) {

        List<Animal> animales = List.of(
                new Animal("Tigre", 5, 220),
                new Animal("Leon", 8, 190),
                new Animal("Lince", 3, 25),
                new Animal("Oso", 12, 350),
                new Animal("Lobo", 6, 45));

        // 1. Mostrar todos los animales
        for (Animal a : animales) {
            IO.println(a);
        }

        // 2. Contar animales con peso > 100 kg
        int contador = 0;
        for (Animal a : animales) {
            if (a.getPesoKg() > 100) {
                contador++;
            }
        }
        IO.println("Animales > 100kg: " + contador);

        // 3. Obtener el animal más viejo
        Animal masViejo = animales.get(0);
        for (Animal a : animales) {
            if (a.getEdad() > masViejo.getEdad()) {
                masViejo = a;
            }
        }
        IO.println("Más viejo: " + masViejo);

        // 4. Lista de animales jóvenes (edad < 6)
        List<Animal> jovenes = new ArrayList<>();
        for (Animal a : animales) {
            if (a.getEdad() < 6) {
                jovenes.add(a);
            }
        }
        IO.println(jovenes);
    }
}