package com.sinensia.primerprograma.tipos;

/**
 *
 * <p>
 * Clase ejemplo para mostarar desbordamiento.
 * </p>
 */
public class OverflowDemo {
    /**
     * Main.
     *
     * @param args parametros iniciales.
     */
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE; // 2147483647
        int overflow = max + 1; // Esto genera un desbordamiento

        System.out.println("Valor máximo de int: " + max);
        System.out.println("Después del desbordamiento: " + overflow); // -2147483648 (valor mínimo)
    }
}
