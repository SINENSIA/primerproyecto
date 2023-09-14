package com.sinensia.primerprograma.ejercicios;

/**
 * Ejercicio 2: Operadores.
 */
@SuppressWarnings("java:S1854")
public class OperadoresDemo {
    /**
     * Método main para probar la clase OperadoresDemo.
     *
     * @param args argumentos de la línea de comandos
     */

    public static void main(String[] args) {

        int comida = 5;
        int propina = 2;
        var total = comida + (comida > 6 ? propina++ : propina--);
        System.out.println("Total: " + total);

    }
}
