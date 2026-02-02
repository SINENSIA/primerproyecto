package com.sinensia.primerprograma.colecciones;

import java.util.ArrayDeque;
import java.util.Deque;

public class EjemploDeque {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("A");
        deque.addLast("B");
        deque.addLast("C");
        deque.addFirst("Z");

        System.out.println(deque); // [Z, A, B, C]
        System.out.println(deque.removeLast()); // C
        System.out.println(deque.peekFirst()); // Z
    }
}
