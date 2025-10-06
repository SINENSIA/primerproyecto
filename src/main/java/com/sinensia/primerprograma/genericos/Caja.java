package com.sinensia.primerprograma.genericos;

/**
 * Clase que representa una caja que puede contener cualquier tipo de objeto.
 *
 * @param <T> Tipo de objeto que contiene la caja.
 * @see com.sinensia.primerprograma.genericos.MyClass
 */
public class Caja<T> {
    
    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public void imprimirTipo() {
        System.out.println("Tipo de T: " + contenido.getClass().getName());
    }
}
