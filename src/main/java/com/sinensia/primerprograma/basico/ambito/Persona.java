package com.sinensia.primerprograma.basico.ambito;

public class Persona {

    public String nombre;

    public Persona(String nombre) {

        this.nombre = nombre;

    }

    public void modificarReferencia(Persona p) {

        p.nombre = "Pedro"; // Modifica el objeto original
        IO.println("Dentro: " + p.nombre); // "Pedro"
    }

    public void prueba() {
        Persona persona = new Persona("Juan");
        modificarReferencia(persona);
        IO.println("Fuera: " + persona.nombre); // "Pedro" - SÍ cambió
    }

    public static void main(String[] args) {
        Persona miPersona = new Persona("Carlos");
        IO.println(miPersona.nombre);
        miPersona.modificarReferencia(miPersona);
        miPersona.prueba();
    }
}
