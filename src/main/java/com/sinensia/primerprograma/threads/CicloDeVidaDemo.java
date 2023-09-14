package com.sinensia.primerprograma.threads;

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

/**
 * Clase MiThread que extiende de Thread.
 * Simula un thread que se ejecuta durante un tiempo y luego se interrumpe.
 *
 * @see Thread
 * @since 2023
 * @version 1.0.0
 * @author Sinensia
 */

class MiThread extends Thread {

    private static final int MAX_MENSAJES = 5;

    public void run() {
        System.out.println("Nuevo: El thread ha sido creado.");
        int contador = 0;
        // Entrar en un ciclo infinito para mantener el thread en ejecución
        while (MAX_MENSAJES > contador) {
            contador++;
            System.out.println(Thread.currentThread().getName()
                    + " En Ejecución: El thread está en ejecución.");

            // Introducir una pausa de 2 segundos para simular el trabajo del thread
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                System.out.println("Interrumpido: El thread ha sido interrumpido."
                        + "contador: " + contador);
                Thread.currentThread().interrupt(); // Buena práctica reinterrumpir el hilo
                break; // Salimos del ciclo while para que no se siga ejecutando

            }
        }

        System.out.println("Terminado: El thread ha finalizado su ejecución.");
    }
}