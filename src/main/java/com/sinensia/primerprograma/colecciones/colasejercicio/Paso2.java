package com.sinensia.primerprograma.colecciones.colasejercicio;

import java.util.*;

class Paso2 {

    private Paso2() {
    }

    static void demoBasica() {
        Queue<Integer> pq = new PriorityQueue<>(); // min-heap
        Collections.addAll(pq, 5, 1, 3, 2);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // 1 2 3 5
        }
        System.out.println();
    }

    static void demoMaximoPrimero() {
        Queue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.addAll(maxpq, 5, 1, 3, 2);
        while (!maxpq.isEmpty()) {
            System.out.print(maxpq.poll() + " "); // 5 3 2 1
        }
        System.out.println();
    }

    // Modelo de tarea con prioridad
    static class Tarea {
        final String nombre;
        final int prioridad; // menor = más urgente

        Tarea(String nombre, int prioridad) {
            this.nombre = nombre;
            this.prioridad = prioridad;
        }

        @Override
        public String toString() {
            return nombre + "(p=" + prioridad + ")";
        }
    }

    static void demoTareas() {
        Queue<Tarea> tareas = new PriorityQueue<>(Comparator.comparingInt(t -> t.prioridad));
        tareas.offer(new Tarea("backup", 3));
        tareas.offer(new Tarea("parche-seg", 1));
        tareas.offer(new Tarea("report", 2));
        while (!tareas.isEmpty()) {
            System.out.println(tareas.poll()); // orden: prioridad 1,2,3
        }
    }
}
