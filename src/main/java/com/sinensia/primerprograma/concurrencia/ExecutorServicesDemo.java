package com.sinensia.primerprograma.concurrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejemplos de manejo de ExecutorServices.
 * 
 */
public class ExecutorServicesDemo {
    /**
     * Ejemplos de manejo de ExecutorServices. Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        // Crea un Executor con 5 hilos
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new ContadorRunnable(100, 100));
        executorService.submit(new ContadorRunnable(100, 10));
        executorService.submit(new ContadorRunnable(100, 27));
        executorService.submit(new ContadorRunnable(100, 4));
        // Este hilos se ejecutarán cuando haya un hilo libre
        executorService.submit(new ContadorRunnable(100, 20));

        // Apaga el ExecutorService una vez que no se enviarán más tareas
        executorService.shutdown();
    }

}
