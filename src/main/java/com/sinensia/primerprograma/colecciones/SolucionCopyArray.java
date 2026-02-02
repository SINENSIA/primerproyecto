package com.sinensia.primerprograma.colecciones;

import java.util.Arrays;

/**
 * Ejemplo de copia superficial correcta de un array.
 *
 * <p>
 * Solución:
 * Usa Arrays.copyOf() o clone() para crear un nuevo array
 * con los mismos elementos que el original.
 *
 * <p>
 * Ambos métodos generan una copia superficial: si el array contiene objetos,
 * las referencias internas no se duplican (solo se copian).
 *
 * <p>
 * Ejemplo:
 * int[] copia = Arrays.copyOf(original, original.length);
 *
 * <p>
 * Salida esperada:
 * Original: [1, 2, 3]
 * Copia: [99, 2, 3]
 *
 * <p>
 * Lección:
 * Ahora ambas variables apuntan a instancias distintas en memoria.
 */

public class SolucionCopyArray {
    public static void main(String[] args) {
        int[] original = { 1, 2, 3 };
        int[] copia = Arrays.copyOf(original, original.length);
        // También valdría: int[] copia = original.clone();

        copia[0] = 99; // Modifica solo la copia

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copia:    " + Arrays.toString(copia));
    }
}
