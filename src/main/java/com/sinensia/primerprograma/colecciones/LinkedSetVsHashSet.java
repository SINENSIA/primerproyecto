package com.sinensia.primerprograma.colecciones;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedSetVsHashSet {

    public static void main(String[] args) {
        int n = 10000000; // Tamaño de la lista

        // Crear una ArrayList y una LinkedList
        Set<Integer> myhashSet = new HashSet<>();
        Set<Integer> myLinkedHashSet = new LinkedHashSet<>();

        // Medir el tiempo para agregar elementos al final de ArrayList
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myhashSet.add(i);
        }
        long endTime = System.nanoTime();
        long myhashSetAddTime = endTime - startTime;

        // Medir el tiempo para agregar elementos al final de LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myLinkedHashSet.add(i);
        }
        endTime = System.nanoTime();
        long myLinkedHashSetAddTime = endTime - startTime;

        // Medir el tiempo para consultar un elemento en ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            @SuppressWarnings("unused") boolean value = myhashSet.contains(i);
        }
        endTime = System.nanoTime();
        long myhashSetGetTime = endTime - startTime;

        // Medir el tiempo para consultar un elemento en LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            @SuppressWarnings("unused") boolean value = myLinkedHashSet.contains(i);
        }
        endTime = System.nanoTime();
        long myLinkedHashSetGetTime = endTime - startTime;

        // Medir el tiempo para quitar elementos al principio de ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myhashSet.remove(0);
        }
        endTime = System.nanoTime();
        long myhashSetRemoveTime = endTime - startTime;

        // Medir el tiempo para quitar elementos al principio de LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myLinkedHashSet.remove(0);
        }
        endTime = System.nanoTime();
        long myLinkedHashSetRemoveTime = endTime - startTime;

        // Imprimir los tiempos medidos
        System.out.println(
                "Tiempo para agregar elementos (HashSet): " + myhashSetAddTime / 1_000_000 + " nanosegundos");
        System.out.println(
                "Tiempo para agregar elementos (LinkedHashSet): " + myLinkedHashSetAddTime / 1_000_000
                        + " nanosegundos");
        System.out.println(
                "Tiempo para quitar elementos (HashSet): " + myhashSetRemoveTime / 1_000_000 + " nanosegundos");
        System.out
                .println("Tiempo para quitar elementos (LinkedHashSet): " + myLinkedHashSetRemoveTime / 1_000_000
                        + " nanosegundos");
        System.out.println(
                "Tiempo para consultar elementos (HashSet): " + myhashSetGetTime / 1_000_000 + " nanosegundos");
        System.out
                .println("Tiempo para consultar elementos (LinkedHastSet): " + myLinkedHashSetGetTime / 1_000_000
                        + " nanosegundos");
    }
}
