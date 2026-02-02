package com.sinensia.primerprograma.colecciones;

import java.util.Arrays;

/**
 * Ejemplo de copia profunda en un array bidimensional.
 *
 * <p>
 * Problema:
 * Arrays.copyOf() o clone() solo hacen copias superficiales.
 * En arrays de arrays (o de objetos), los subelementos siguen compartiendo
 * referencias.
 *
 * <p>
 * Solución:
 * Recorrer manualmente el array y copiar cada subarray individualmente.
 * De este modo cada nivel de la estructura es independiente.
 *
 * <p>
 * Ejemplo:
 * for (int i = 0; i < original.length; i++) {
 * copia[i] = Arrays.copyOf(original[i], original[i].length);
 * }
 *
 * <p>
 * Salida esperada:
 * Original: [[1, 2], [3, 4]]
 * Copia: [[99, 2], [3, 4]]
 *
 * <p>
 * Lección:
 * La copia profunda garantiza independencia total entre niveles del array.
 */
public class Solucion2CopyArray {
    public class CopiaArrayProfunda {
        public static void main(String[] args) {
            int[][] original = { { 1, 2 }, { 3, 4 } };
            int[][] copia = new int[original.length][];

            // 🔁 Copia profunda: duplicamos cada subarray
            for (int i = 0; i < original.length; i++) {
                copia[i] = Arrays.copyOf(original[i], original[i].length);
            }

            copia[0][0] = 99;

            System.out.println("Original: " + Arrays.deepToString(original));
            System.out.println("Copia:    " + Arrays.deepToString(copia));
        }
    }
}
