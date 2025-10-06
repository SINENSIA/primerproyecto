package com.sinensia.primerprograma.hilos.sincronizado;

public class ContadorSinSync {
    private int valor = 0;

    public void incrementar() {
        valor++; // No es atómico
    }

    public int getValor() {
        return valor;
    }
}