package com.sinensia.primerprograma.concurrencia;

public class EjemploRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hilo: " + Thread.currentThread().getName());
    }
}
