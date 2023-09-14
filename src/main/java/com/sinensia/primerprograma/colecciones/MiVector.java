package com.sinensia.primerprograma.colecciones;

import java.util.Arrays;
import java.util.Vector;
import java.util.List;

public class MiVector {

    public static void main(String[] args) {

        Vector<Integer> miLista = new Vector<>(); // Crea una lista de enteros vacía.
        miLista.add(1);
        miLista.add(2);
        miLista.add(3);
        miLista.add(4);
        miLista.add(5);

        int miValor = miLista.get(2);
        System.out.println(miValor); // Imprime 3

        // Supongamos que deseamos eliminar el elemento en el índice 2 (el número 3)
        int indiceAEliminar = 2;
        System.out.println(miLista.toString());

        if (indiceAEliminar >= 0 && indiceAEliminar < miLista.size()) {
            miLista.remove(indiceAEliminar);

            // Imprime el ArrayList actualizado
            for (int elemento : miLista) {
                System.out.println("Elemento: " + elemento);
            }
        } else {
            System.out.println("El índice es inválido.");
        }

        Vector<String> nombres = new Vector<>();
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Carlos");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        nombres.remove("Bob"); // Elimina el elemento "Bob" de la lista
        nombres.remove(1); // Elimina el elemento en el índice 1 (Carlos)
        System.out.println(nombres.toString());

        List<Double> miListaDoubles = new Vector<>(); // Crea una lista de enteros vacía.

        double test = 5;

        miListaDoubles.add(1d);
        miListaDoubles.add(2d);
        miListaDoubles.add(3d);
        miListaDoubles.add(4d);
        miListaDoubles.add(test);

        miListaDoubles.remove(2d);
        // o miListaDoubles.remove(2.0); por valor
        System.out.println(miListaDoubles.toString());

        miListaDoubles.remove(2); // por indice, como hemos eliminado el 2d, ahora el 4d pasa a ser el índice 2
        System.out.println(miListaDoubles.toString());

        System.out.println(nombres.contains("Carlos")); // false: Ya no está debido a que lo eliminamos antes
        System.out.println(nombres.contains("Alice")); // true: Sí está

        int longList = nombres.size(); // Obtiene el tamaño de la lista
        int indiceCarlos = nombres.indexOf("Carlos"); // Obtiene el índice del elemento "Carlos" (-1)
        int indiceAlice = nombres.indexOf("Alice"); // Obtiene el índice del elemento "Carlos" (2)
        System.out.println("El indice de carlos es: " + indiceCarlos); // Imprime -1
        System.out.println("El indice de alice es: " + indiceAlice); // Imprime 1

        System.out.println("El List ahora tiene: " + longList); // Imprime 1

        Vector<String> copia = new Vector<>(nombres); // Copia los elementos a otro ArrayList
        System.out.println(copia.toString());

        String[] arrayDeNombres = nombres.toArray(new String[0]); // Convierte a un array de String
        System.out.println(Arrays.toString(arrayDeNombres));

    }
}
