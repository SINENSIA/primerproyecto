package com.sinensia.primerprograma.poo.canciones;

public class Oyente extends Persona {
    private String generoFavorito;

    public Oyente(String nombre, String generoFavorito) {
        super(nombre);
        this.generoFavorito = generoFavorito;
    }

    @Override
    public void presentarse() {
        System.out.println("Hola, soy " + nombre + ", y me encanta escuchar " + generoFavorito + ".");
    }
}
