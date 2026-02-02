package com.sinensia.primerprograma.colecciones;

import java.util.*;

public class EjemploConcurrentModification {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(List.of("Ana", "Luis", "Pedro", "Maria"));

        // Error: modificar durante la iteración
        for (String nombre : nombres) {
            if (nombre.equals("Luis")) {
                nombres.remove(nombre); // ConcurrentModificationException
            }
        }
    }
}
