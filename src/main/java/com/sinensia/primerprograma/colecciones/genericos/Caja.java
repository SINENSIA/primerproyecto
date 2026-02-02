package com.sinensia.primerprograma.colecciones.genericos;

/**
 * Clase que representa una caja que puede contener cualquier tipo de objeto.
 *
 * @param <T> Tipo de objeto que contiene la caja.
 * @see com.sinensia.primerprograma.genericos.MyClass
 */
public class Caja<T> {
    
    private T contenido;

    /**
     * Creates a new box with the provided content.
     *
     * @param contenido element stored in the box
     */
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtains the current content stored in the box.
     *
     * @return current content
     */
    public T getContenido() {
        return contenido;
    }

    /**
     * Replaces the content stored in the box.
     *
     * @param contenido new element to store
     */
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    /**
     * Prints the runtime type held inside the box.
     */
    public void imprimirTipo() {
        System.out.println("Tipo de T: " + contenido.getClass().getName());
    }
}

