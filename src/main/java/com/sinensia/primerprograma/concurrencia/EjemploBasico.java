package com.sinensia.primerprograma.concurrencia;

/**
 * run()contiene la lógica del hilo.
 * start()lo lanza en paralelo.
 * Si llamas a run()directamente,no crea un hilo nuevo:se ejecuta en el mismo.
 */
public class EjemploBasico {
    public static void main(String[] args) {
        System.out.println("Ejecutando en: " + Thread.currentThread().getName()); // "main"
        otroHilo();
    }

    public static void otroHilo() {
        MiHilo otroHilo = new MiHilo();
        otroHilo.start();
    }
}

class MiHilo extends Thread {
    @Override
    public void run() {
        System.out.println("Ejecutando en: " + Thread.currentThread().getName());
    }
}
