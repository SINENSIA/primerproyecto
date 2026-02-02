package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Concepto: Subdesbordamiento (Underflow)</b>
 * <p>
 * Clase ejemplo para mostrar qué sucede cuando un {@code int} disminuye
 * por debajo de su valor mínimo permitido (-2,147,483,648).
 * </p>
 * 
 * @author Sinensia
 * @see OverflowDemo
 */
public class UnderflowDemo {

    /**
     * Punto de entrada principal.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Valor mínimo que puede almacenar un entero de 32 bits.
        int min = Integer.MIN_VALUE; // -2.147.483.648

        // Al restar 1, el valor "salta" al extremo máximo.
        int underflow = min - 1;

        System.out.println("Valor mínimo de int: " + min);
        System.out.println("Valor después de restar 1 (Underflow): " + underflow);
        // Resultado: 2147483647 (Integer.MAX_VALUE)
    }
}
