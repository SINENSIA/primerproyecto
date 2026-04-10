package com.sinensia.primerprograma.ejercicios.abril.flota;

public class Propietario {

    private final String nombre;
    private final String dni;

    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Propietario[nombre=" + nombre + ", dni=" + dni + "]";
    }
}