package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplo de uso de ArrayList.
 *
 * @version 1.0 desde 1.0
 * @since 1.0
 * @see java.util.ArrayList
 * @see java.util.List
 * 
 */
public class ArrayListToArray {
    /**
     * Método principal. Operaciones con ArrayList.
     *
     * @param args parametros de consola (String[] args)
     */
    public static void main(String[] args) {
        // Crear un ArrayList de tipo Integer
        List<Integer> arrayList = new ArrayList<>();

        // Agregar elementos al ArrayList
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // Convertir el ArrayList a un array de tipo Integer
        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);

        // Imprimir los elementos del array
        for (Integer num : array) {
            System.out.println(num);
        }
    }
}
