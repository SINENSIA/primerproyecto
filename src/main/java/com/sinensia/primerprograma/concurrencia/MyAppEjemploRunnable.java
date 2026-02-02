package com.sinensia.primerprograma.concurrencia;

public class MyAppEjemploRunnable {

    public static void main(String[] args) {
        Thread hilo = new Thread(new EjemploRunnable());
        hilo.start();
        Thread hilo2 = new Thread(new EjemploRunnable());
        hilo2.start();
        Thread hilo3 = new Thread(new EjemploRunnable());
        hilo3.start();
    }
}
