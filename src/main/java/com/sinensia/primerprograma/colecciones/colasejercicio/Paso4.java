package com.sinensia.primerprograma.colecciones.colasejercicio;

import java.util.*;
import java.util.stream.*;

class Paso4 {
    static void demo() {
        Deque<String> comandos = new ArrayDeque<>();
        comandos.add("run:backup");
        comandos.add("noop");
        comandos.add("run:report");

        List<String> lista = comandos.stream()
                .filter(s -> s.startsWith("run:"))
                .map(s -> s.substring(4).toUpperCase())
                .collect(Collectors.toList()); // mejor toList() ya

        System.out.println(lista); // [BACKUP, REPORT]

        // Procesamiento por prioridad real (no con stream de iteración):
        Queue<Integer> pq = new PriorityQueue<>();
        Collections.addAll(pq, 4, 1, 3);
        List<Integer> ordenPrioridad = new ArrayList<>();
        while (!pq.isEmpty())
            ordenPrioridad.add(pq.poll());
        System.out.println(ordenPrioridad); // [1, 3, 4]
    }
}
