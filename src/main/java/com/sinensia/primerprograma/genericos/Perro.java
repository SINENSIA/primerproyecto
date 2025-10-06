package com.sinensia.primerprograma.genericos;

public class Perro {
    private String nombre;

    Perro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Perro: " + nombre;
    }

}
