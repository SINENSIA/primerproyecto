package com.sinensia.primerprograma.poo.canciones;

public class Artista extends Persona {
    private String especialidad;
    
    public Artista(String nombre, String especialidad) {
        super(nombre);
        this.especialidad = especialidad;
    }

    @Override
    public void presentarse() {
        System.out.println("Soy " + nombre + ", un artista especializado en " + especialidad + ".");
    }
}
