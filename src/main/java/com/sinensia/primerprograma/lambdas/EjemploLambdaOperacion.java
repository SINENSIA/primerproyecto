package com.sinensia.primerprograma.lambdas;

/**
 * Clase ejemplo usa interfaz funcional Operacion.
 */
public class EjemploLambdaOperacion {
    public static void main(String[] args) {

        // Usamos una lambda para implementar la interfaz Operacion
        Operacion suma = (a, b) -> a * b;

        int resultado = suma.aplicar(3, 4);
        System.out.println("\n\nResultado: " + resultado); // 7
    }
}
