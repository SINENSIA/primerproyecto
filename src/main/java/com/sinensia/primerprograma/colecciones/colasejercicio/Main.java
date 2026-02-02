package com.sinensia.primerprograma.colecciones.colasejercicio;

public class Main {
    public static void main(String[] args) {
        System.out.println("Proyecto base listo.");

        Paso1.demo();
        Paso2.demoBasica();
        Paso2.demoMaximoPrimero();
        Paso2.demoTareas();
        Paso3.demo();
        Paso4.demo();
        Paso5.demo();
        Paso6.demo();
    }

    // Utilidad simple para medir tiempos (no sustituye a JMH)
    static long medirMillis(Runnable r) {
        long t0 = System.currentTimeMillis();
        r.run();
        return System.currentTimeMillis() - t0;
    }
}
