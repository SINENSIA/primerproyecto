package com.sinensia.primerprograma.hilos.ciclovida;

public class CicloDeVidaThread {
    public static void main(String[] args) throws InterruptedException {
        HiloControlado hilo = new HiloControlado();

        System.out.println("Antes de iniciar (estado): " + hilo.getState()); // NEW

        hilo.start(); // RUNNABLE

        Thread.sleep(1200);
        hilo.pausar(); // Espera activa

        Thread.sleep(2000);
        hilo.reanudar(); // Reanuda

        Thread.sleep(2000);
        hilo.detener(); // Finaliza

        hilo.join(); // Esperamos que termine

        System.out.println("Estado final del hilo: " + hilo.getState()); // TERMINATED
    }
}