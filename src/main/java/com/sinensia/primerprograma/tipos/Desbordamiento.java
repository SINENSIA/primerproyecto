package com.sinensia.primerprograma.tipos;

/**
 * Ejemplo de desbordamiento de un byte
 */
public class Desbordamiento {
    /**
     * Ejemplo de desbordamiento de un byte.
     *
     * @param args parasm de la línea de comandos
     */
    public static void main(String[] args) {

        // Ejemplo de double a int
        double valorDouble = 2e12; // Un double grande
        int valorInt = (int) valorDouble; // Conversión de double a int
        // narrowing o estrechamiento de tipo
        System.out.println(valorInt); // 2147483647

        // Ejemplos desboradamiento de tipos
        byte b = -128;
        b--; // Java permite el incremento de una variable en una unidad
        System.out.println("b = " + b); // b = -128 desborde de byte
        // Sin embargo, b = 128 no es posible, error de compilación

        int valorInt2 = 2147483647; // Valor máximo de int
        valorInt2++; // Incremento de una unidad
        System.out.println("valorInt2 = " + valorInt2); // desbordamiento de int

    }
}
