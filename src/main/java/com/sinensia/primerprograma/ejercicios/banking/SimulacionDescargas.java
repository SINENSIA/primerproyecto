package com.sinensia.primerprograma.ejercicios.banking;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Ejercicio: Simulación de descargas concurrentes.
 * 
 * Practica la creación de hilos, el uso de Runnable, start, join y sleep.
 */
public class SimulacionDescargas {

    // Clase interna que representa una tarea de descarga
    static class TareaDescarga implements Runnable {
        private final String nombreServidor;

        public TareaDescarga(String nombreServidor) {
            this.nombreServidor = nombreServidor;
        }

        @Override
        public void run() {
            try {
                System.out.println(nombreServidor + " comienza la descarga...");

                // Simula tiempo de descarga aleatorio entre 400 y 800 ms
                int tiempo = ThreadLocalRandom.current().nextInt(400, 801);
                Thread.sleep(tiempo);

                System.out.println(nombreServidor + " descarga completada en " + tiempo + " ms");
            } catch (InterruptedException _) {
                
                Thread.currentThread().interrupt();
                System.out.println(nombreServidor + " interrumpido durante la descarga.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando simulación de descargas...\n");

        long inicio = System.currentTimeMillis();

        // Creamos las tareas para tres servidores
        Thread servidorA = new Thread(new TareaDescarga("Servidor A"));
        Thread servidorB = new Thread(new TareaDescarga("Servidor B"));
        Thread servidorC = new Thread(new TareaDescarga("Servidor C"));

        // Lanzamos los hilos concurrentemente
        servidorA.start();
        servidorB.start();
        servidorC.start();

        // Esperamos a que todos terminen
        servidorA.join();
        servidorB.join();
        servidorC.join();

        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("\nTodas las descargas han finalizado.");
        System.out.println("Duración total: " + duracion + " ms");
    }
}
