package com.sinensia.primerprograma.funcional.lambdas;

import java.util.*;
import java.util.function.Predicate;

/**
 * Representa a un jugador del juego GuessGame.
 */
class Jugador {
    private String nombre;
    private List<Integer> intentos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.intentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getIntentos() {
        return intentos;
    }

    public void agregarIntento(int numero) {
        intentos.add(numero);
    }

    @Override
    public String toString() {
        return nombre + " -> intentos: " + intentos;
    }
}

/**
 * Clase principal con el uso de Streams.
 */
public class GuessGameStream {
    public static void main(String[] args) {
        // Paso 1: Crear jugadores
        Jugador ana = new Jugador("Ana");
        ana.agregarIntento(12);
        ana.agregarIntento(85);
        ana.agregarIntento(47);

        Jugador luis = new Jugador("Luis");
        luis.agregarIntento(65);
        luis.agregarIntento(98);

        Jugador marta = new Jugador("Marta");
        marta.agregarIntento(32);
        marta.agregarIntento(49);
        marta.agregarIntento(10);

        Jugador carlos = new Jugador("Carlos");
        carlos.agregarIntento(70);
        carlos.agregarIntento(99);

        List<Jugador> jugadores = Arrays.asList(ana, luis, marta, carlos);

        // Paso 2: Predicate para filtrar jugadores con algún intento < 50
        Predicate<Jugador> tieneIntentoBajo = jugador -> jugador.getIntentos().stream().anyMatch(i -> i < 50);

        // Paso 3: Procesar con Streams
        List<Jugador> seleccionados = jugadores.stream()
                .filter(tieneIntentoBajo) // aplica Predicate
                .sorted(Comparator.comparingInt(jugador -> jugador.getIntentos().size())) // ordena por número de
                                                                                          // intentos
                .toList();

        // Paso 4: Imprimir nombres transformados a mayúsculas con referencia a método
        System.out.println("Jugadores con intentos menores de 50:");
        seleccionados.stream()
                .map(Jugador::getNombre) // referencia a método
                .map(String::toUpperCase) // transforma nombres
                .forEach(System.out::println); // imprime

        // Paso 5: Estadísticas adicionales
        double promedioIntentos = jugadores.stream()
                .mapToInt(jugador -> jugador.getIntentos().size())
                .average()
                .orElse(0);

        long totalIntentos = jugadores.stream()
                .flatMap(jugador -> jugador.getIntentos().stream())
                .count();

        System.out.println("\nPromedio de intentos por jugador: " + promedioIntentos);
        System.out.println("Total de intentos realizados: " + totalIntentos);
    }
}
