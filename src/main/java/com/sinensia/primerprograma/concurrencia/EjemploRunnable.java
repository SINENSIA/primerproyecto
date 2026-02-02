package com.sinensia.primerprograma.concurrencia;

public class EjemploRunnable implements Runnable {

    public void run() {
        System.out.println("Hilo: " + Thread.currentThread().getName());
    }
}
