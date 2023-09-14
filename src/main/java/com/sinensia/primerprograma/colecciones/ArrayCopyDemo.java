package com.sinensia.primerprograma.colecciones;

import java.util.Arrays;

/**
 * Clase para demostrar el uso de System.arraycopy y Arrays.copyOf.
 */
public class ArrayCopyDemo {
    /**
     * Método principal. Operaciones para copiar arrays y medir el tiempo.
     *
     * @param args parametros de consola (String[] args)
     */
    public static void main(String[] args) {
        // Tamaño del array
        int size = 1000000;

        // Crear un array de origen con elementos
        int[] sourceArray = new int[size];
        for (int i = 0; i < size; i++) {
            sourceArray[i] = i;
        }

        // Copiar el array utilizando System.arraycopy
        int[] destArray1 = new int[size];
        long startTime1 = System.nanoTime();
        System.arraycopy(sourceArray, 0, destArray1, 0, size);
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;

        // Copiar el array utilizando Arrays.copyOf
        long startTime2 = System.nanoTime();
        int[] destArray2 = Arrays.copyOf(sourceArray, size);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;

        // Verificar si los arrays son iguales
        boolean arraysEqual = Arrays.equals(destArray1, destArray2);

        // Imprimir resultados
        System.out.println("System.arraycopy Tiempo: " + duration1 + " nanosegundos");
        System.out.println("Arrays.copyOf Tiempo: " + duration2 + " nanosegundos");
        System.out.println("Los arrays son iguales: " + arraysEqual);
    }
}
