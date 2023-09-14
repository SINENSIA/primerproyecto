package com.sinensia.primerprograma.threads;

import java.util.concurrent.Callable;

public class ContadorCallable implements Callable<Integer> {

    private int contador;
    private int retardo;
    private int valor;

    /**
     * Constructor de la clase ContadorRunnable.
     *
     * @param retardo tiempo de retardo
     * @param valor   valor máximo del contador
     */
    public ContadorCallable(int retardo, int valor) {
        this.contador = 0;
        this.retardo = retardo;
        this.valor = valor;
    }

    @Override
    public Integer call() throws Exception {

        while (contador < valor) {
            contador++;

            try {
                Thread.sleep(retardo);
            } catch (InterruptedException ex) {
                System.err.println("Error al parar el hilo");
                Thread.currentThread().interrupt(); // Buena práctica reinterrumpir el hilo
            }
            // Todo lo demás es un bug
        }
        return contador;
    }

}
