package com.sinensia.primerprograma.ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Ejercicio de colecciones.
 *
 */
public class ColeccionesEjercicio {
    /**
     * Ejercicio de colecciones.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {
        // 1 Crear un array nativo
        String[] arrayNativo = { "Gato", "Tigre", "Lince", "Jaguar", "León" };

        // 2 Convertirlo en un ArrayList
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arrayNativo));

        // 3 Convertirlo en un LinkedList
        LinkedList<String> linkedList = new LinkedList<>(arrayList);

        // 4 Convertirlo en un HashSet
        HashSet<String> hashSet = new HashSet<>(linkedList);

        // Paso 5: Convertirlo en un Map (Usando un LinkedHashMap para mantener el
        // orden)
        Map<Integer, String> map = new LinkedHashMap<>();
        int index = 0;
        for (String item : hashSet) {
            map.put(index, item);
            index++;
        }

        // Imprimir el Map resultante
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
    }
}
