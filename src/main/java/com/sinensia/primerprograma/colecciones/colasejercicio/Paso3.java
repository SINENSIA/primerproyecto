package com.sinensia.primerprograma.colecciones.colasejercicio;

import java.util.*;

class Paso3 {

    private Paso3() {
    }

    static class Navegador {
        private final Deque<String> atras = new ArrayDeque<>();
        private final Deque<String> adelante = new ArrayDeque<>();
        private String actual = "home";

        void visitar(String url) {
            atras.push(actual); // LIFO
            actual = url;
            adelante.clear(); // al visitar nueva URL, se invalida la pila de adelante
        }

        boolean puedeAtras() {
            return !atras.isEmpty();
        }

        boolean puedeAdelante() {
            return !adelante.isEmpty();
        }

        void irAtras() {
            if (puedeAtras()) {
                adelante.push(actual);
                actual = atras.pop();
            }
        }

        void irAdelante() {
            if (puedeAdelante()) {
                atras.push(actual);
                actual = adelante.pop();
            }
        }

        String paginaActual() {
            return actual;
        }
    }

    static void demo() {
        Navegador n = new Navegador();
        n.visitar("/articulo");
        n.visitar("/contacto");
        System.out.println(n.paginaActual()); // /contacto
        n.irAtras();
        System.out.println(n.paginaActual()); // /articulo
        n.irAdelante();
        System.out.println(n.paginaActual()); // /contacto
    }
}
