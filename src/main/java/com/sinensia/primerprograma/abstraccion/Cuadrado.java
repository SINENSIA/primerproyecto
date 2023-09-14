package com.sinensia.primerprograma.abstraccion;

public class Cuadrado extends Forma {
    double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    // Implementación del método abstracto
    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
