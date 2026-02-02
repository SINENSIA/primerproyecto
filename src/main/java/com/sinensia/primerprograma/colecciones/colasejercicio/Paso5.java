package com.sinensia.primerprograma.colecciones.colasejercicio;

import java.util.*;

class Paso5 {

    private Paso5() {

    }

    static void demo() {
        // LinkedList permite null
        Queue<String> q1 = new LinkedList<>();
        q1.add(null); // permitido
        System.out.println(q1.peek()); // null
        // System.out.println(q1.peek().toUpperCase()); // descomentar:
        // NullPointerException

        // ArrayDeque y PriorityQueue NO permiten null
        Queue<String> q2 = new ArrayDeque<>();
        try {
            q2.add(null); // lanza NullPointerException
        } catch (NullPointerException e) {
            System.out.println("ArrayDeque no acepta null");
        }

        Queue<String> q3 = new PriorityQueue<>();
        try {
            q3.add(null); // lanza NullPointerException
        } catch (NullPointerException _) {
            System.out.println("PriorityQueue no acepta null");
        }
    }
}
