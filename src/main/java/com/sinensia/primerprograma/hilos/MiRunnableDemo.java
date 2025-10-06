package com.sinensia.primerprograma.hilos;

public class MiRunnableDemo {
    /**
     * Método main.
     * @param args
     */
    public static void main(String[] args) {
        // Crear un hilo
        Thread hilo = new Thread(new MiRunnable());
        Thread hilo2 = new Thread(() -> System.out.println("Hola desde el hilo 2 "
                + Thread.currentThread().getName()));

        // Iniciar el hilo
        hilo2.start();
        hilo.start();
    }

}
