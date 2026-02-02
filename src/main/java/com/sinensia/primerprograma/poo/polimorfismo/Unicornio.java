package com.sinensia.primerprograma.poo.polimorfismo;

public class Unicornio extends Caballo {
    @Override
    public void montar() {
        System.out.println("El unicornio ya tiene la silla ajustada. ¡Galopa mágicamente!");
    }

    public void volar() {
        System.out.println("¡Vuela mágicamente!");
    }
}
