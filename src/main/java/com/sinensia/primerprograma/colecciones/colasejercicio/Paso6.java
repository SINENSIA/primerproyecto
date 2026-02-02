package com.sinensia.primerprograma.colecciones.colasejercicio;

import java.util.*;

class Paso6 {
    static void demo() {
        final int N = 2_000_00; // 200k

        long tArrayDeque = Main.medirMillis(() -> {
            Deque<Integer> d = new ArrayDeque<>();
            for (int i = 0; i < N; i++)
                d.addLast(i);
            while (!d.isEmpty())
                d.removeFirst();
        });

        long tLinkedList = Main.medirMillis(() -> {
            Deque<Integer> d = new LinkedList<>();
            for (int i = 0; i < N; i++)
                d.addLast(i);
            while (!d.isEmpty())
                d.removeFirst();
        });

        System.out.println("ArrayDeque ms: " + tArrayDeque);
        System.out.println("LinkedList ms: " + tLinkedList);
    }
}
