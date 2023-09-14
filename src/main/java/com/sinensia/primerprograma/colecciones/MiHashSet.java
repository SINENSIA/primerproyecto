package com.sinensia.primerprograma.colecciones;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Ejemplo de uso de HashSet.
 *
 * @version 1.0 desde 1.0
 * @since 1.0
 * @see java.util.HashSet
 * @see java.util.Set
 * @author Sinensia
 */
public class MiHashSet {
    /**
     * Método principal.
     *
     * @param args parametros de consola
     */
    public static void main(String[] args) {

        Set<Integer> miLista = new HashSet<>(); // Crea una lista de enteros vacía.
        miLista.add(1);
        miLista.add(2);
        miLista.add(3);
        miLista.add(4);
        miLista.add(5);

        int miValor = miLista.contains(2) ? 2 : 0; // Contains devuelve true o false
        System.out.println(miValor); // Imprime 2

        // Supongamos que deseamos eliminar el elemento en el índice 2 (el número 3)
        int valorAeliminar = 2;
        System.out.println(miLista.toString()); // Tenemos toString para imprimir el HashSet

        if (miLista.contains(valorAeliminar)) {
            miLista.remove(valorAeliminar);

            // Imprime cada valor de la lista
            for (int elemento : miLista) {
                System.out.println("Elemento: " + elemento);
            }
        } else {
            System.out.println("El índice es inválido.");
        }

        Set<String> nombres = new HashSet<>();
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Carlos");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        nombres.remove("Bob"); // Elimina el elemento "Bob" de la lista
        // nombres.remove(1); // Aqui no hay indices
        System.out.println(nombres.toString());

        Set<Double> miListaDoubles = new HashSet<>(); // Crea una lista de enteros vacía.

        double test = 5;

        miListaDoubles.add(1d);
        miListaDoubles.add(2d);
        miListaDoubles.add(3d);
        miListaDoubles.add(4d);
        miListaDoubles.add(test);

        miListaDoubles.remove(2d);
        // o miListaDoubles.remove(2.0); por valor
        System.out.println(miListaDoubles.toString());

        // miListaDoubles.remove(2); // Aqui no hay indices
        // System.out.println(miListaDoubles.toString());

        System.out.println(nombres.contains("Carlos")); // true
        System.out.println(nombres.contains("Alice")); // true: Sí está

        int longList = nombres.size(); // Obtiene el tamaño de la lista
        // int indiceCarlos = nombres.indexOf("Carlos"); // Aqui no hay indices
        // int indiceAlice = nombres.indexOf("Alice"); // Aqui no hay indices
        // System.out.println("El indice de carlos es: " + indiceCarlos); // Aqui no hay
        // indices
        // System.out.println("El indice de alice es: " + indiceAlice); // Aqui no hay
        // indices

        System.out.println("El List ahora tiene: " + longList); // Imprime 2

        Set<String> copia = new HashSet<>(nombres); // Copia los elementos a otro ArrayList
        System.out.println(copia.toString());

        String[] arrayDeNombres = nombres.toArray(new String[0]); // Convierte a un array de String
        System.out.println(Arrays.toString(arrayDeNombres));

    }
}
