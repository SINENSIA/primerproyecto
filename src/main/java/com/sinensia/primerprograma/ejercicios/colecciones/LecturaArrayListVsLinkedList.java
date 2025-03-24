package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.*;

public class LecturaArrayListVsLinkedList {
    public static void main(String[] args) {
        final int ELEMENTOS = 100_000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < ELEMENTOS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long t1 = System.nanoTime();
        for (int i = 0; i < ELEMENTOS; i++) {
            int x = arrayList.get(i);
        }
        long t2 = System.nanoTime();
        System.out.println("Tiempo lectura ArrayList: " + (t2 - t1) / 100_000 + " ms");

        t1 = System.nanoTime();
        for (int i = 0; i < ELEMENTOS; i++) {
            int x = linkedList.get(i);
        }
        t2 = System.nanoTime();
        System.out.println("Tiempo lectura LinkedList: " + (t2 - t1) / 100_000 + " ms");
    }
}