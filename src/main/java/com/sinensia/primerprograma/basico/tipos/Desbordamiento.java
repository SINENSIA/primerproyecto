package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Concepto: Desbordamiento (Overflow)</b>
 * <p>
 * Esta clase muestra qué ocurre cuando un tipo de dato numérico supera su valor
 * máximo o mínimo permitido. En Java, esto no lanza una excepción, sino que el
 * valor
 * "da la vuelta" (comportamiento de complemento a dos).
 * </p>
 * 
 * @author Sinensia
 */
public class Desbordamiento {

    /**
     * Demostración de desbordamiento en tipos byte e int.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // 1. Estrechamiento (Narrowing) extremo:
        double valorDouble = 2e12; // Un valor mucho mayor que el máximo de un int
        int valorInt = (int) valorDouble;

        System.out.println("Double original: " + valorDouble);
        System.out.println("Convertido a int (se trunca al máximo): " + valorInt); // 2147483647 (Integer.MAX_VALUE)

        // 2. Desbordamiento de byte (Rango: -128 a 127):
        byte b = -128;
        b--; // Intentamos ir por debajo del mínimo
        System.out.println("\nByte: -128 restando 1 resulta en: " + b); // Resultado: 127
        // Explicación: El valor "salta" al extremo opuesto (máximo).

        // 3. Desbordamiento de int (Rango: -2^31 a 2^31-1):
        int valorInt2 = 2147483647; // Valor máximo de int
        System.out.println("\nInt máximo: " + valorInt2);
        valorInt2++; // Incremento más allá del límite
        System.out.println("Int máximo aumentando 1 resulta en: " + valorInt2);
        // Resultado: -2147483648 (Integer.MIN_VALUE)
    }
}
