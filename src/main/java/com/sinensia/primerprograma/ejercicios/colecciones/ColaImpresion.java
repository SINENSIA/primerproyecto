package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.*;

public class ColaImpresion {

    public static void main(String[] args) {
        LinkedList<String> colaImpresion = new LinkedList<>();
        @SuppressWarnings("unused")
        List<String> miLista = new ArrayList<>();

        // Llegan trabajos normales
        colaImpresion.addLast("DocA");
        colaImpresion.addLast("DocB");
        colaImpresion.addLast("DocC");

        System.out.println("Cola inicial: " + colaImpresion);

        // Atender dos trabajos
        atenderSiguiente(colaImpresion);
        atenderSiguiente(colaImpresion);

        // Llega un urgente
        System.out.println("Llega urgente al principio: UrgenteX");
        colaImpresion.addFirst("UrgenteX");
        System.out.println("Estado actual: " + colaImpresion);

        // Atender hasta vaciar
        while (!colaImpresion.isEmpty()) {
            atenderSiguiente(colaImpresion);
        }
        System.out.println("Cola vacía: " + colaImpresion);
    }

    /**
     * Atiende el siguiente trabajo de impresión si existe.
     *
     * <p>
     * <b>Idea:</b> peekFirst permite ver quién va primero sin retirarlo, y
     * pollFirst
     * lo retira devolviéndolo. Usar ambos ayuda a mostrar mensajes claros.
     * </p>
     *
     * @param cola cola de impresión representada con LinkedList
     */
    private static void atenderSiguiente(LinkedList<String> cola) {
        String siguiente = cola.peekFirst();
        if (siguiente == null) {
            System.out.println("No hay trabajos en la cola.");
            return;
        }
        System.out.println("Atendiendo: " + siguiente);
        cola.pollFirst(); // Retira el primero
        System.out.println("Estado tras atender: " + cola);
    }
}
