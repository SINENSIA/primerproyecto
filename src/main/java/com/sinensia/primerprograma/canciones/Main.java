package com.sinensia.primerprograma.canciones;

public class Main {
    public static void main(String[] args) {
        Artista artista = new Artista("María", "rock alternativo");
        Cancion cancion = new Cancion("Sombras del Tiempo", artista);

        Oyente oyente1 = new Oyente("Carlos", "rock");
        Oyente oyente2 = new Oyente("Lucía", "pop");
        cancion.agregarOyente(oyente1);
        cancion.agregarOyente(oyente2);

        cancion.mostrarInformacion();
    }
}