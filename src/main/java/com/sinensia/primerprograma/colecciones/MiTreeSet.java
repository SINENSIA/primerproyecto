package com.sinensia.primerprograma.colecciones;

import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Ejemplo de TreeSet en Java.
 * Un TreeSet es una colección que mantiene los elementos ordenados.
 *
 * @version 1.0.0
 * @since 2023
 */
public class MiTreeSet {
    /**
     * Ejemplo de TreeSet en Java.
     *
     * @param args Argumentos de la aplicación.
     */
    public static void main(String[] args) {

        Set<String> nombres = new HashSet<>();
        nombres.add("Rivendel");
        nombres.add("Gondor");
        nombres.add("Rohan");
        nombres.add("Amon Hen");
        nombres.add("Gondor"); // Duplicado!

        System.out.println(nombres); // Resultado: [Gondor, Mina Tirith, Rivendel, Rohan]
        // Convertir HashSet a TreeSet
        Set<String> nombresOrdenados = new TreeSet<>(nombres);

        // Ahora nombresOrdenados es un TreeSet que mantiene los nombres en orden
        System.out.println(nombresOrdenados); // Resultado: [Amon Hen, Gondor, Rivendel, Rohan]

        NavigableSet<Integer> numeros = new TreeSet<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);

        System.out.println(numeros.size()); // Resultado: 3
        System.out.println(numeros.contains(20)); // Resultado: true
        System.out.println(numeros.contains(50)); // Resultado: false
        System.out.println(numeros.remove(40)); // Resultado: true
        System.out.println(numeros.isEmpty()); // Resultado: false
        System.out.println(numeros); // Resultado: [10, 20, 30]
        // numeros.clear(); // Resultado: void (vacía el TreeSet)

        System.out.println(numeros.first()); // Resultado: 10
        System.out.println(numeros.lower(20)); // Resultado: 10
        System.out.println(numeros.higher(20)); // Resultado: 30
        System.out.println(numeros.floor(29)); // Resultado: 20
        System.out.println(numeros.ceiling(28)); // Resultado: 50
        numeros.iterator().forEachRemaining(System.out::println); // Resultado: 10, 20, 30

        numeros.subSet(20, true, 40, true);
    }

}
