package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Ejemplo de uso de ArrayList.
 *
 * @version 1.0 desde 1.0
 * @since 1.0
 * @see java.util.ArrayList
 * @see java.util.List
 * @author Sinensia
 */

public class MiArrayList {
    /**
     * Método principal.
     *
     * @param args parametros de consola
     */
    public static void main(String[] args) {

        List<Integer> miLista = new ArrayList<>(); // Crea una lista de enteros vacía.
        miLista.add(1); // 0
        miLista.add(2); // 1
        miLista.add(3); // 2
        miLista.add(4);
        miLista.add(5);

        int miValor = miLista.get(2);
        System.out.println(miValor); // Imprime 3

        // Supongamos que deseamos eliminar el elemento en el índice 2 (el número 3)
        int indiceAeliminar = 2;
        System.out.println(miLista.toString());

        // Comprueba que el índice sea válido
        if (indiceAeliminar >= 0 && indiceAeliminar < miLista.size()) {
            miLista.remove(indiceAeliminar);

            // Imprime el ArrayList actualizado
            for (int elemento : miLista) {
                System.out.println("Elemento: " + elemento);
            }
        } else {
            System.out.println("El índice es inválido.");
        }

        // Ordenación de la lista

        miLista.sort((a, b) -> b - a);
        System.out.println(" ArrayList sort a - b --------------------");
        System.out.println(miLista.toString()); // Ordena la lista de menor a mayor
        System.out.println("--------------------");

        System.out.println("Collections sort --------------------");
        Collections.sort(miLista); // Ordena la lista de menor a mayor
        System.out.println(miLista.toString());
        System.out.println("--------------------");

        System.out.println(" ArrayList sort b - a --------------------");
        miLista.sort((a, b) -> b - a); // Ordena la lista de mayor a menor (inverso)
        System.out.println(miLista.toString());
        System.out.println("--------------------");

        System.out.println(" ArrayList sort null --------------------");
        miLista.sort(null); // Ordena la lista de menor a mayor
        System.out.println(miLista.toString());
        System.out.println("--------------------");

        System.out.println("Collections reverse --------------------");
        Collections.reverse(miLista); // Revierte el orden
        System.out.println(miLista.toString());
        System.out.println("--------------------");

        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Zulema");
        nombres.add("Carlos");

        nombres.sort(null);
        System.out.println(" ArrayList nombre sort --------------------");
        System.out.println(nombres.toString()); // Ordena la lista de menor a mayor
        System.out.println("--------------------");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        nombres.remove("Bob"); // Elimina el elemento "Bob" de la lista
        nombres.remove(1); // Elimina el elemento en el índice 1 (Carlos)
        System.out.println(nombres.toString());

        List<Double> miListaDoubles = new ArrayList<>(); // Crea una lista de enteros vacía.

        double test = 5;

        miListaDoubles.add(1d);
        miListaDoubles.add(2d);
        miListaDoubles.add(3d);
        miListaDoubles.add(4d);
        miListaDoubles.add(test);

        miListaDoubles.remove(test);
        // o miListaDoubles.remove(2.0); por valor
        System.out.println(miListaDoubles.toString());

        miListaDoubles.remove(2);
        // por indice, como hemos eliminado el 2d, ahora el 4d pasa a ser el índice 2
        System.out.println(miListaDoubles.toString());

        System.out.println(nombres.contains("Carlos"));
        // false: Ya no está debido a que lo eliminamos antes
        System.out.println(nombres.contains("Alice"));
        // true: Sí está

        int longList = nombres.size(); // Obtiene el tamaño de la lista
        int indiceCarlos = nombres.indexOf("Carlos");
        // Obtiene el índice del elemento "Carlos" (-1)
        int indiceAlice = nombres.indexOf("Alice");
        // Obtiene el índice del elemento "Carlos" (2)
        System.out.println("El indice de carlos es: " + indiceCarlos); // Imprime -1
        System.out.println("El indice de alice es: " + indiceAlice); // Imprime 1

        System.out.println("El List ahora tiene: " + longList); // Imprime 2

        ArrayList<String> copia = new ArrayList<>(nombres); // Copia los elementos a otro ArrayList
        System.out.println(copia.toString());

        String[] arrayDeNombres = nombres.toArray(new String[0]); // Convierte a un array de String
        System.out.println(Arrays.toString(arrayDeNombres));

    }
}
