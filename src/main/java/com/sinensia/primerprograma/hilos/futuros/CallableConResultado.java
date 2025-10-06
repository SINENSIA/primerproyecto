package com.sinensia.primerprograma.hilos.futuros;

import java.util.concurrent.Callable;

/**
 * Clase que implementa Callable para devolver un resultado.
 */
public class CallableConResultado implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(5000); // Simula una tarea costosa
        return "Resultado listo";
    }
}
