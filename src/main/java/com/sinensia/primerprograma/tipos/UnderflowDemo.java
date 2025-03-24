package com.sinensia.primerprograma.tipos;

/**
 *
 * <p>
 * Clase ejemplo para mostrar el underflow
 * </p>
 */
public class UnderflowDemo {
    /**
     * Main.
     *
     * @param args params.
     */
    public static void main(String[] args) {
        int min = Integer.MIN_VALUE; // -2147483648
        int underflow = min - 1; // Se desborda al valor máximo

        System.out.println("Valor mínimo de int: " + min);
        System.out.println("Después del subdesbordamiento: "
                + underflow); // 2147483647 (valor máximo)
    }
}