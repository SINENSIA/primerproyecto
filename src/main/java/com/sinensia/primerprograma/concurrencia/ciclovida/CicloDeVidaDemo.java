package com.sinensia.primerprograma.concurrencia.ciclovida;

/**
 * Ejemplos de manejo de Threads.
 */

public class CicloDeVidaDemo {
    /**
     * Ejemplos de manejo de Threads. Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        // Crear un nuevo miThread
        MiThread miThread = new MiThread();

        // Iniciar el thread
        miThread.start();

        // Esperar un momento y luego interrumpir el thread
        try {
            Thread.sleep(5000); // Esperar 3 segundos
            miThread.interrupt(); // Interrumpir el thread
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt(); // Buena práctica reinterrumpir el hilo

        }
    }
}

