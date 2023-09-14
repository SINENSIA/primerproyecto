package com.sinensia.primerprograma.sobrecarga;

public class Calculadora {

    int x;
    int y;

    public Calculadora() {
        /* Inicialización por defecto del constructor */
    }

    public Calculadora(int x, int y) {
        /* Valores por defeto para operandos */
        this.x = x;
        this.y = y;
    }

    public int suma(int x, int y) {
        return x + y;
    }

    public double suma(double x, double y) {
        return x + y;
    }

    /* Mal uso de sobrecarga, métodos que admiten valores convertibles entre sí */
    public String devolverValor(int x) {
        return ("Entero: " + x);
    }

    public String devolverValor(double y) {
        return ("Decimal: " + y);
    }

}
