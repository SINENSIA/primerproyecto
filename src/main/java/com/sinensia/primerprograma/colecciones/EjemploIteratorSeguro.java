package com.sinensia.primerprograma.colecciones;

import java.util.*;

public class EjemploIteratorSeguro {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(List.of("Ana", "Luis", "Pedro", "Maria"));

        Iterator<String> it = nombres.iterator();
        while (it.hasNext()) {
            String nombre = it.next();
            if (nombre.equals("Luis")) {
                it.remove(); // forma segura
            }
        }

        System.out.println(nombres); // [Ana, Pedro, Maria]
    }
}
