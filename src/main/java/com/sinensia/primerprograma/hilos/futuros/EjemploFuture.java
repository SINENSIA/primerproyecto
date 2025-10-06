package com.sinensia.primerprograma.hilos.futuros;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Clase que muestra el uso de Future.
 * 
 */
public class EjemploFuture {
    /**
     * Clase main para demostrar uso de Future.
     * 
     */
    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        ExecutorService ejecutor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = new CallableConResultado();
        Future<String> futuro = ejecutor.submit(tarea); // Se ejecuta en segundo plano

        System.out.println("Tarea enviada. Haciendo otras cosas...");
        // Hilo para esperar el resultado y mostrarlo tan pronto como esté disponible
        new Thread(() -> {
            try {
                String resultado = futuro.get();
                System.out.println("\nResultado recibido: " + resultado);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        List<Integer> listadoNumeros = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            listadoNumeros.add(i);
            System.out.print("\rañadido número..." + String.valueOf(i));
            System.out.flush();
        }

        String resultado = futuro.get(); // Espera (bloquea) hasta que el resultado esté disponible
        System.out.println("Resultado recibido: " + resultado);

        ejecutor.shutdown();
    }
}
