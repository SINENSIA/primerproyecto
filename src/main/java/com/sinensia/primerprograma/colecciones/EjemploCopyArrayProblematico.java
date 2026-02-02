package com.sinensia.primerprograma.colecciones;

/**
 * Demostración del problema de las copias por referencia en arrays.
 *
 * <p>
 * Problema:
 * Asignar un array a otra variable no crea una copia independiente,
 * solo otra referencia al mismo objeto en memoria.
 *
 * <p>
 * Ejemplo:
 * int[] copia = original;
 * 
 * <p>
 * Ambas variables apuntan al mismo array, por lo que
 * cualquier modificación en una afecta a la otra.
 *
 * <p>
 * Salida esperada:
 * Original: [99, 2, 3]
 * Copia: [99, 2, 3]
 *
 * <p>
 * Lección:
 * Para obtener independencia, es necesario clonar o copiar el array
 * explícitamente.
 * </p>
 */

public class EjemploCopyArrayProblematico {

    public static void main(String[] args) {
        int[] original = { 1, 2, 3 };
        int[] copia = original; // Solo copia la referencia

        copia[0] = 99; // Modifica el mismo array en memoria

        System.out.println("Original: " + java.util.Arrays.toString(original));
        System.out.println("Copia:    " + java.util.Arrays.toString(copia));
    }
}
