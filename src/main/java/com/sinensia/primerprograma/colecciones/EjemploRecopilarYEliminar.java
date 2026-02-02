package com.sinensia.primerprograma.colecciones;

import java.util.*;

public class EjemploRecopilarYEliminar {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>(List.of("Ana", "Luis", "Pedro", "Maria"));

        // recopilo los que quiero eliminar
        List<String> aEliminar = new ArrayList<>();
        for (String nombre : nombres) {
            if (nombre.equals("Luis")) {
                aEliminar.add(nombre);
            }
        }

        nombres.removeAll(aEliminar);
        System.out.println(nombres); // [Ana, Pedro, Maria]
    }
}
