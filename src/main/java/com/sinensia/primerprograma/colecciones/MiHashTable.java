package com.sinensia.primerprograma.colecciones;

import java.util.Hashtable;

public class MiHashTable {
    public static void main(String[] args) {
        // Crear una instancia de Hashtable
        Hashtable<Integer, String> tabla = new Hashtable<>();

        // Agregar elementos (clave-valor) a la Hashtable
        tabla.put(1, "Rivendel");
        tabla.put(2, "Gondor");
        tabla.put(3, "Rohan");
        tabla.put(4, "Mordor");

        // Acceder a un valor por su clave
        String valor = tabla.get(2);
        System.out.println("El valor asociado a 2 es: " + valor);

        // Verificar si una clave existe en la Hashtable
        boolean existe = tabla.containsKey(4);
        System.out.println("¿Existe la clave 4? " + existe);

        // Eliminar un elemento por su clave
        tabla.remove(4);

        // Iterar a través de las claves y valores en la Hashtable
        System.out.println("Elementos en la Hashtable:");
        for (Integer clave : tabla.keySet()) {
            String val = tabla.get(clave);
            System.out.println(clave + ": " + val);
        }
    }
}
