package com.sinensia.primerprograma.genericos;

public class Caja<T> {
    private T contenido;

    public void guardar(T item) {

        this.contenido = item;
    }

    public T obtener() {
        return contenido;
    }

    public boolean estaVacia() {
        return contenido == null;
    }
}
