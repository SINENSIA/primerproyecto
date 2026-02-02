package com.sinensia.primerprograma.colecciones;

import java.util.LinkedList;
import java.util.Queue;

public class EjemploQueue {
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<>();
        cola.offer("A");
        cola.offer("B");
        cola.offer("C");
        
        System.out.println(cola.peek()); // A (primer elemento)
        System.out.println(cola.poll()); // A (se elimina)
        System.out.println(cola); // [B, C]
    }
}
