package com.sinensia.primerprograma.ejercicios.streams;

public class Animal {
    private final String nombre;
    private final int edad;
    private final double pesoKg;

    public Animal(String nombre, int edad, double pesoKg) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoKg = pesoKg;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + pesoKg + " kg)";
    }
}