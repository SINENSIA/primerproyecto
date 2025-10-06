package com.sinensia.primerprograma.hilos.sincronizado;

public class ContadorConSync {
    private int valor = 0;

    public synchronized void incrementar() {
        valor++; // Acceso sincronizado
    }

    public synchronized int getValor() {
        return valor;
    }
}
