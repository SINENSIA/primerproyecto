package com.sinensia.primerprograma.patrones.adaptadores;

// Simulación del uso
public class Main {
    public static void main(String[] args) {
        TarjetaSd sd = new TarjetaSd();
        DispositivoUsb adaptador = new AdaptadorSDaUSB(sd);
        System.out.println("\r\nConectando la tarjeta SD al sistema...");
        adaptador.conectarUsb(); // El sistema cree que es un USB, pero es una SD adaptada
    }
}