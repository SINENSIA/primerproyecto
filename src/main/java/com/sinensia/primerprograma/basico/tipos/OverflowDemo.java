package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Concepto: Desbordamiento Positivo (Overflow)</b>
 * <p>
 * Clase ejemplo para mostrar qué sucede cuando un {@code int} supera
 * su valor máximo permitido (2,147,483,647).
 * </p>
 * 
 * @author Sinensia
 * @see UnderflowDemo
 */
public class OverflowDemo {

    /**
     * Punto de entrada principal.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Valor máximo que puede almacenar un entero de 32 bits.
        int max = Integer.MAX_VALUE; // 2.147.483.647

        // Al sumar 1, el bit de signo cambia y el valor "salta" al mínimo.
        int overflow = max + 1;

        System.out.println("Valor máximo de int: " + max);
        System.out.println("Valor después de sumar 1 (Overflow): " + overflow);
        // Resultado: -2147483648 (Integer.MIN_VALUE)
    }
}
