package com.sinensia.primerprograma.genericos;

/**
 * Representa a un perro utilizado en los ejemplos de genericos.
 */
public class Perro {
    private String nombre;

    /**
     * Crea un nuevo perro con el nombre indicado.
     *
     * @param nombre identificador del perro
     */
    Perro(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nombre del perro.
     *
     * @return nombre del perro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene una representacion textual del perro.
     *
     * @return descripcion del perro
     */
    @Override
    public String toString() {
        return "Perro: " + nombre;
    }

}

