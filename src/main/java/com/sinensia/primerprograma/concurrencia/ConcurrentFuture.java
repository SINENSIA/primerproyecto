package com.sinensia.primerprograma.concurrencia;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Ejemplos de manejo de ExecutorServices Callable
 * con Future.
 *
 * @see com.sinensia.primerprograma.hilos.ContadorCallable
 * @see com.sinensia.primerprograma.hilos.ContadorRunnable
 * @version 1.0.0
 * @since 2023
 * @author Sinensia
 */
public class ConcurrentFuture {

    /**
     * Ejemplos de manejo de ExecutorServices. Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        // Crea un Executor con 5 hilos
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new ContadorRunnable(200, 5)); // Runnable -> hilo paralelo

        try {

            System.out.println("Contando... ");
            Future<Integer> futurible = executorService.submit(new ContadorCallable(50, 100));
            System.out.println("Sigo con el hilo paralelo mientras espero el resultado...");

            // Apaga el ExecutorService una vez que no se enviarán más tareas
            System.out.println("El resultado es: " + futurible.get());
        } catch (InterruptedException | ExecutionException ex) {
            System.err.println("Error al obtener el resultado");
            Thread.currentThread().getName();
            Thread.currentThread().interrupt(); // Buena práctica reinterrumpir el hilo
        } finally {

            System.out.println(Thread.currentThread().getName() + " FINALLY---------------------");
            Thread.currentThread().interrupt();
        }

    }

}
