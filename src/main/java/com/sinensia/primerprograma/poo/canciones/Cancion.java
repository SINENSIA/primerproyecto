package com.sinensia.primerprograma.poo.canciones;

import java.util.ArrayList;
import java.util.List;

public class Cancion {
    private String titulo;
    private Artista artista;
    private List<Oyente> oyentes;

    public Cancion(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
        this.oyentes = new ArrayList<>();
    }

    public void agregarOyente(Oyente oyente) {
        oyentes.add(oyente);
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.print("Artista: ");
        artista.presentarse();
        System.out.println("Oyentes:");
        for (Oyente o : oyentes) {
            o.presentarse();
        }
    }
}
