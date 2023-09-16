package com.sinensia.primerprograma.felinos;

/**
 * Clase para para peluquería de felinos.
 */
public class Peluqueria<T extends Felino> {

    T felino;

    public Peluqueria(T felino) {
        this.felino = felino;
    }

    /**
     * Método para cortar el pelo a un felino.
     *
     */
    public void limpiarCortar() {
        System.out.println("Cortando el pelo a " + felino);
    }

}
