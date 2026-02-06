package com.sinensia.primerprograma.ejercicios.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDatasetDemo {

        // Comparable: orden natural por nombre (y desempate por id)
        public static final class Animal implements Comparable<Animal> {
                private final int id;
                private final String nombre;
                private final String especie;
                private final int edad;
                private final double pesoKg;
                private final boolean peligroso;

                public Animal(int id, String nombre, String especie, int edad, double pesoKg, boolean peligroso) {
                        this.id = id;
                        this.nombre = Objects.requireNonNull(nombre);
                        this.especie = Objects.requireNonNull(especie);
                        this.edad = edad;
                        this.pesoKg = pesoKg;
                        this.peligroso = peligroso;
                }

                public int getId() {
                        return id;
                }

                public String getNombre() {
                        return nombre;
                }

                public String getEspecie() {
                        return especie;
                }

                public int getEdad() {
                        return edad;
                }

                public double getPesoKg() {
                        return pesoKg;
                }

                public boolean isPeligroso() {
                        return peligroso;
                }

                @Override
                public int compareTo(Animal other) {
                        int c = this.nombre.compareToIgnoreCase(other.nombre);
                        if (c != 0)
                                return c;
                        return Integer.compare(this.id, other.id);
                }

                @Override
                public String toString() {
                        return "%s{id=%d, especie=%s, edad=%d, peso=%.1f, peligroso=%s}"
                                        .formatted(nombre, id, especie, edad, pesoKg, peligroso);
                }

                @Override
                public boolean equals(Object obj) {
                        if (this == obj)
                                return true;
                        if (obj == null || getClass() != obj.getClass())
                                return false;
                        Animal other = (Animal) obj;
                        return this.id == other.id && this.nombre.equalsIgnoreCase(other.nombre);
                }

                @Override
                public int hashCode() {
                        return Objects.hash(id, nombre.toLowerCase());
                }
        }

        public static void main(String[] args) {

                List<Animal> animales = List.of(
                                new Animal(1, "Tigre", "Felino", 5, 220.0, true),
                                new Animal(2, "Leon", "Felino", 8, 190.0, true),
                                new Animal(3, "Lince", "Felino", 3, 25.0, false),
                                new Animal(4, "Oso", "Ursido", 12, 350.0, true),
                                new Animal(5, "Lobo", "Canido", 6, 45.0, true),
                                new Animal(6, "Piton", "Reptil", 4, 18.5, true),
                                new Animal(7, "Jaguar", "Felino", 7, 96.0, true),
                                new Animal(8, "Koala", "Marsupial", 2, 12.0, false),
                                new Animal(9, "Tejon", "Mustelido", 5, 14.0, false),
                                new Animal(10, "Hiena", "Hienido", 9, 60.0, true));

                // Predicate (reutilizable): animales "pesados" y "no peligrosos"
                Predicate<Animal> esPesado = a -> a.getPesoKg() > 100;
                Predicate<Animal> noPeligroso = a -> !a.isPeligroso();
                Predicate<Animal> esFelino = a -> a.getEspecie().equalsIgnoreCase("Felino");

                // 1) forEach (efecto)
                System.out.println("\n1) Todos:");
                animales.forEach(System.out::println);
                // O (no es necesario strema aquí no hay pipeline)
                animales.stream().forEach(System.out::println);

                // 2) filter (con Predicate)
                System.out.println("\n2) Pesados (>100kg):");
                animales.stream()
                                .filter(esPesado)
                                .forEach(System.out::println);

                // 3) map (proyección: Animal -> nombre)
                System.out.println("\n3) Nombres:");
                List<String> nombres = animales.stream()
                                .map(Animal::getNombre)
                                .toList();
                System.out.println(nombres);

                // 4) mapToDouble + average (primitivos)
                double pesoMedio = animales.stream()
                                .mapToDouble(Animal::getPesoKg)
                                .average()
                                .orElse(0.0);
                System.out.println("\n4) Peso medio: " + pesoMedio);

                // 5) max/min (Comparator) — más viejo y más ligero
                Animal masViejo = animales.stream()
                                .max(Comparator.comparingInt(Animal::getEdad))
                                .orElseThrow();
                Animal masLigero = animales.stream()
                                .min(Comparator.comparingDouble(Animal::getPesoKg))
                                .orElseThrow();
                System.out.println("\n5) Más viejo: " + masViejo);
                System.out.println("5) Más ligero: " + masLigero);

                // 6) sorted con Comparable (orden natural por nombre)
                System.out.println("\n6) Orden natural (Comparable: nombre):");
                animales.stream()
                                .sorted() // usa compareTo
                                .forEach(System.out::println);

                // 7) sorted con Comparator (por edad desc, y luego nombre)
                System.out.println("\n7) Orden por edad desc, luego nombre:");
                animales.stream()
                                .sorted(Comparator.comparingInt(Animal::getEdad).reversed()
                                                .thenComparing(Animal::getNombre, String.CASE_INSENSITIVE_ORDER))
                                .forEach(System.out::println);

                // 8) anyMatch / allMatch / noneMatch
                boolean hayNoPeligrosos = animales.stream().anyMatch(noPeligroso);
                boolean todosPesanMasDe10 = animales.stream().allMatch(a -> a.getPesoKg() > 10);
                boolean ningunoPesaMasDe500 = animales.stream().noneMatch(a -> a.getPesoKg() > 500);
                System.out.println("\n8) anyMatch noPeligroso: " + hayNoPeligrosos);
                System.out.println("8) allMatch peso>10: " + todosPesanMasDe10);
                System.out.println("8) noneMatch peso>500: " + ningunoPesaMasDe500);

                // 9) count (cuántos felinos)
                long totalFelinos = animales.stream().filter(esFelino).count();
                System.out.println("\n9) Total felinos: " + totalFelinos);

                // 10) reduce (acumulación) — peso total (ejemplo intencional)
                double pesoTotal = animales.stream()
                                .map(Animal::getPesoKg)
                                .reduce(0.0, Double::sum);
                System.out.println("\n10) Peso total (reduce): " + pesoTotal);

                // 11) collect groupingBy — agrupar por especie y contar
                Map<String, Long> conteoPorEspecie = animales.stream()
                                .collect(Collectors.groupingBy(Animal::getEspecie, Collectors.counting()));
                System.out.println("\n11) Conteo por especie: " + conteoPorEspecie);

                // 12) collect partitioningBy — separar peligrosos / no peligrosos
                Map<Boolean, List<Animal>> porPeligrosidad = animales.stream()
                                .collect(Collectors.partitioningBy(Animal::isPeligroso));
                System.out.println("\n12) Peligrosos:");
                porPeligrosidad.get(true).forEach(System.out::println);
                System.out.println("\n12) No peligrosos:");
                porPeligrosidad.get(false).forEach(System.out::println);

                // 13) Composición de Predicates (and/or/negate)
                System.out.println("\n13) Pesados Y no peligrosos (esPesado.and(noPeligroso)):");
                animales.stream()
                                .filter(esPesado.and(noPeligroso))
                                .forEach(System.out::println);
        }
}
