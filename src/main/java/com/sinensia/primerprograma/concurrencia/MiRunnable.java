package com.sinensia.primerprograma.concurrencia;

public class MiRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hola desde el hilo "
                + Thread.currentThread().getName());
    }

}
