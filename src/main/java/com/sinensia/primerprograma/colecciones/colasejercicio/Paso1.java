package com.sinensia.primerprograma.colecciones.colasejercicio;

import java.util.*;

class Paso1 {
    private Paso1() {
        // Private constructor to hide the implicit public one
    }

    static void demo() {
        Queue<String> colaImpresion = new LinkedList<>();
        colaImpresion.offer("doc-1");
        colaImpresion.offer("doc-2");
        colaImpresion.offer("doc-3");

        System.out.println(colaImpresion.peek()); // doc-1
        System.out.println(colaImpresion.poll()); // doc-1
        System.out.println(colaImpresion.poll()); // doc-2
        System.out.println(colaImpresion.poll()); // doc-3
        System.out.println(colaImpresion.poll()); // null (vacía)
    }
}
