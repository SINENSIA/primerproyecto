package com.sinensia.primerprograma.patrones.adaptadores;

// Este es el adaptador que convierte una tarjeta SD en un dispositivo USB
public class AdaptadorSDaUSB implements DispositivoUsb {
    private TarjetaSd tarjeta;

    public AdaptadorSDaUSB(TarjetaSd tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public void conectarUsb() {
        tarjeta.insertar(); // Adaptamos la interfaz
    }
}
