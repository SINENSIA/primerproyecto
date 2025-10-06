package com.sinensia.primerprograma.hilos.sincronizado;

public class PruebaContadores {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Prueba sin sincronización ===");
        probarContador(new ContadorSinSync());

        System.out.println("\n=== Prueba con sincronización ===");
        probarContador(new ContadorConSync());
    }

    private static void probarContador(Object contador) throws InterruptedException {
        Thread[] hilos = new Thread[10];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new TareaIncremento(contador));
        }

        for (Thread hilo : hilos) {
            hilo.start();
        }

        for (Thread hilo : hilos) {
            hilo.join();
        }

        int resultado = (contador instanceof ContadorSinSync)
                ? ((ContadorSinSync) contador).getValor()
                : ((ContadorConSync) contador).getValor();

        System.out.println("Valor final esperado: 10000");
        System.out.println("Valor final obtenido: " + resultado);
    }
}
