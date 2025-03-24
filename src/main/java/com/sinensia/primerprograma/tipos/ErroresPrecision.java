
package com.sinensia.primerprograma.tipos;

/**
 * <p>Ejemplos con p´redidas de precisión
 */
public class ErroresPrecision {
    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;

        System.out.println("0.1 + 0.2 = " + sum); // 0.30000000000000004
    }
}
