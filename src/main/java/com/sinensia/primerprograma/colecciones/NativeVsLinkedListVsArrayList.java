package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Ejemplo de uso de ArrayList. Rendimiento de ArrayList, LinkedList y array
 * Suprmmir warnings con @SuppressWarnings("all") ya que no usamos las variables
 * y separamos las declaraciones mucho para que quede más claro
 *
 * @version 1.0 desde 1.0
 * @since 1.0
 * @see java.util.ArrayList
 * @see java.util.List
 * @see java.util.LinkedList
 * 
 */
public class NativeVsLinkedListVsArrayList {
    /**
     * Ejemplo de uso de ArrayList. Rendimiento de ArrayList, LinkedList y array.
     *
     * @param args parametros de consola (String[] args)
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int n = 1_000_000; // Tamaño de la lista

        // Crear una ArrayList y una LinkedList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Integer[] myNativeArray = new Integer[n];

        // Medir el tiempo para agregar elementos al final de ArrayList
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long arrayListAddTime = endTime - startTime;

        // Medir el tiempo para agregar elementos al final de Array
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myNativeArray[i] = i;
        }
        endTime = System.nanoTime();
        long myNativeArrayAddTime = endTime - startTime;

        // Medir el tiempo para agregar elementos al final de LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        long linkedListAddTime = endTime - startTime;

        // Medir el tiempo para consultar un elemento en myNativeArray
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int value = myNativeArray[i];
        }
        endTime = System.nanoTime();
        long myNativeArrayGetTime = endTime - startTime;

        // Medir el tiempo para consultar un elemento en ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int value = arrayList.get(i);
        }
        endTime = System.nanoTime();
        long arrayListGetTime = endTime - startTime;

        // Medir el tiempo para consultar un elemento en LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int value = linkedList.get(i);
        }
        endTime = System.nanoTime();
        long linkedListGetTime = endTime - startTime;

        // Medir el tiempo para quitar elementos al principio de myNativeArray
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myNativeArray[i] = null;
        }
        endTime = System.nanoTime();
        long myNativeArrayRemoveTime = endTime - startTime;

        // Medir el tiempo para quitar elementos al principio de ArrayList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.remove(0);
        }
        endTime = System.nanoTime();
        long arrayListRemoveTime = endTime - startTime;

        // Medir el tiempo para quitar elementos al principio de LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.remove(0);
        }
        endTime = System.nanoTime();
        long linkedListRemoveTime = endTime - startTime;

        // Imprimir los tiempos medidos
        System.out.println(
                "Tiempo para agregar elementos (myNativeArray): "
                        + myNativeArrayAddTime / 1_000_000
                        + " milisegundos");
        System.out.println(
                "Tiempo para agregar elementos (ArrayList): "
                        + arrayListAddTime / 1_000_000
                        + " milisegundos");
        System.out.println(
                "Tiempo para agregar elementos (LinkedList): "
                        + linkedListAddTime / 1_000_000
                        + " milisegundos");
        System.out.println("Tiempor para quitar elementos (myNativeArray): "
                + myNativeArrayRemoveTime / 1_000_000
                + " milisegundos");
        System.out.println(
                "Tiempo para quitar elementos (ArrayList): "
                        + arrayListRemoveTime / 1_000_000
                        + " milisegundos");
        System.out
                .println("Tiempo para quitar elementos (LinkedList): "
                        + linkedListRemoveTime / 1_000_000
                        + " milisegundos");
        System.out.println("Tiempo para consultar elementos (myNativeArray): "
                + myNativeArrayGetTime / 1_000_000
                + " milisegundos");
        System.out.println(
                "Tiempo para consultar elementos (ArrayList): "
                        + arrayListGetTime / 1_000_000
                        + " milisegundos");
        System.out
                .println("Tiempo para consultar elementos (LinkedList): "
                        + linkedListGetTime / 1_000_000
                        + " milisegundos");

    }
}
