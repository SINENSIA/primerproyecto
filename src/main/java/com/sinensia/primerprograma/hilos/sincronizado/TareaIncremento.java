package com.sinensia.primerprograma.hilos.sincronizado;

public class TareaIncremento implements Runnable {
    private final Object contador;

    public TareaIncremento(Object contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (contador instanceof ContadorSinSync) {
                ((ContadorSinSync) contador).incrementar();
            } else if (contador instanceof ContadorConSync) {
                ((ContadorConSync) contador).incrementar();
            }
        }
    }
}
