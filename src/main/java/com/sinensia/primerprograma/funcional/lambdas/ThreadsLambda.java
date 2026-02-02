package com.sinensia.primerprograma.funcional.lambdas;

/**
 * Receta para crear hilos con lambdas.
 *
 */
public class ThreadsLambda {
    /**
     * Método principal para probar la receta.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {
        // Crear y ejecutar el primer hilo
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda desde el hilo 1 - Iteración " + (i + 1));
                try {
                    Thread.sleep(500); // Esperar 0.5 segundo
                } catch (InterruptedException e) {
                    System.out.println("El hilo "
                            + Thread.currentThread().getName()
                            + " ha sido interrumpido.");
                    Thread.currentThread().interrupt(); // Es una buena práctica
                }
            }
        });

        // Crear y ejecutar el segundo hilo
        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {

                System.out.println("Lambda desde el hilo 2 - Iteración " + (i + 1));
                try {
                    Thread.sleep(1000); // Esperar 1 segundo
                } catch (InterruptedException e) {
                    System.out.println("El hilo "
                            + Thread.currentThread().getName()
                            + " ha sido interrumpido.");
                    Thread.currentThread().interrupt(); // Es una buena práctica
                }
            }
        });

        // Iniciar ambos hilos
        hilo1.start();
        hilo2.start();
    }
}
