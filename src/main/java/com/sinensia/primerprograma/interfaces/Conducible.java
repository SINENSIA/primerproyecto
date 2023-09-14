package com.sinensia.primerprograma.interfaces;

public interface Conducible {

    // Todos los conducibles por tierra deben llevar ruedas
    // como máximo 24 de un camión de 6 ejes
    int NUMERO_MAXIMO_RUEDAS = 24; // implícitamente es "public static final"

    void conducir();

    // Método por defecto
    default void desplazar() {
        System.out.println("El conducible está se está desplazando.");
    }
}
