package com.sinensia.primerprograma.colecciones;

import java.util.Arrays;
import java.util.List;

/**
 * Clase para demostrar el uso de arrays nativos en Java.
 *
 * @version 1.0 desde 1.0
 * @since 1.0
 * @see java.util.Arrays
 * @see java.util.List
 * @see java.util.ArrayList
 * @see java.util.LinkedList
 * @see java.util.Vector
 * 
 */
public class ArrayNativo {
    /**
     * Ejemplos de uso de arrays nativos en Java.
     *
     */
    public static void main(String[] args) {
        // Declarar un array
        int[] miArray = new int[5]; // Crea un array de enteros con capacidad para 5 elementos.

        // Inicializa un array de enteros con valores.
        int[] numeros = { 1, 2, 3, 4, 5 };

        // longitud
        int longitud = miArray.length; // Obtiene la longitud del array.
        System.out.println(longitud);

        // Acceso
        int primerElemento = miArray[0]; // Accede al primer elemento (índice 0) del array.
        int ultimoElemento = miArray[miArray.length - 1]; // Accede al último elemento del array.
        // Si accedemos con longitud tendremos un OutofBoundsException.
        // ***ultimoElemento = miArray[longitud];***
        System.out.println("El primer elemento del array es: " + primerElemento);
        System.out.println("El último elemento del array es: " + ultimoElemento);
        // Modificación
        miArray[numeros.length - 1] = 20; // Modifica el último elemento del array.
        miArray[0] = 10; // Modifica el primer elemento del array.

        // Itereacion
        for (int i = 0; i < miArray.length; i++) {
            int elemento = miArray[i];
            // Haz algo con el elemento, como imprimirlo.
            System.out.println("Elemento en el índice " + i + ": " + elemento);
        }

        // Iteración con for-each
        for (int elemento : miArray) {
            // Haz algo con el elemento, como imprimirlo.
            System.out.println("Elemento: " + elemento);
        }

        int indice = 7; // El índice está fuera de los límites válidos del array miArray

        try {
            if (indice >= 0 && indice < miArray.length) {
                int elemento = miArray[indice];
                System.out.println("Elemento en el índice " + indice + ": " + elemento);
            } else {
                System.out.println("El índice está fuera de los límites del array.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de los límites del array.");
        }

        // Fusionar dos array (merge)
        int[] array1 = { 1, 2, 3 };
        int[] array2 = { 4, 5, 6 };
        int[] fusionado = new int[array1.length + array2.length];

        System.arraycopy(array1, 0, fusionado, 0, array1.length);
        System.arraycopy(array2, 0, fusionado, array1.length, array2.length);

        // Ordenar un array
        int[] array = { 3, 1, 2 }; // Array desordenado
        Arrays.sort(array); // Ordena el array

        // Buscar un elemento en un array
        int index = Arrays.binarySearch(array, 2); // Busca el elemento 2 en el array
        System.out.println(index); // Imprime 1, ya que el elemento 2 está en el índice 1 del array

        // Convertir un array a String
        String arrayAsString = Arrays.toString(array); // Convierte el array a String

        // Convertir un String a array
        String[] arrayFromString = arrayAsString.split(","); // Convierte el String a array

        // Convertir un array a List
        List<String> list = Arrays.asList(arrayFromString); // Convierte el array a List

        // Convertir un List a array
        String[] arrayFromList = list.toArray(new String[0]); // Convierte el List a array

        // Copiar un array
        String[] arrayCopia = Arrays.copyOf(arrayFromList, arrayFromList.length); // Copia el array
        System.out.println(Arrays.toString(arrayCopia)); // Imprime [1, 2, 3]

        // Otra opción con System.arraycopy
        System.arraycopy(arrayFromList, 0, arrayCopia, 0, arrayFromList.length);

        // Comrueba si dos arrays son iguales
        boolean sonIguales = Arrays.equals(arrayFromList, arrayCopia); // Comprueba si son iguales
        System.out.println(sonIguales); // Imprime true
    }
}
