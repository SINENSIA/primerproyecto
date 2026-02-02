package com.sinensia.primerprograma.basico.tipos;

import java.math.BigDecimal;

/**
 * <b>Comparativa de Precisión Numérica</b>
 * <p>
 * Esta clase compara cómo se comportan los tipos {@code float}, {@code double}
 * y {@code BigDecimal} al realizar cálculos acumulativos.
 * </p>
 * 
 * @author Sinensia
 */
public class PrecisionComparacion {

    /**
     * Ejecuta una serie de demostraciones sobre la precisión decimal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Ejemplo simple de suma decimal
        float f = 0.1f + 0.2f;
        double d = 0.1 + 0.2;
        BigDecimal bd = new BigDecimal("0.1").add(new BigDecimal("0.2"));

        System.out.println("--- SUMA SIMPLE: 0.1 + 0.2 ---");
        System.out.println("Resultado con float:      " + f);
        System.out.println("Resultado con double:     " + d);
        System.out.println("Resultado con BigDecimal: " + bd);

        System.out.println("\n--- SUMA ACUMULATIVA (0.1 sumado 10 veces) ---");
        demoErrores();
    }

    /**
     * Realiza un bucle para sumar 0.1 diez veces y mostrar el error acumulado.
     */
    private static void demoErrores() {
        float sumaFloat = 0.0f;
        double sumaDouble = 0.0;
        BigDecimal sumaBigDecimal = BigDecimal.ZERO;
        BigDecimal incremento = new BigDecimal("0.1");

        for (int i = 0; i < 10; i++) {
            sumaFloat += 0.1f;
            sumaDouble += 0.1;
            sumaBigDecimal = sumaBigDecimal.add(incremento);
        }

        System.out.println("Suma con float (debería ser 1.0):      " + sumaFloat);
        System.out.println("Suma con double (debería ser 1.0):     " + sumaDouble);
        System.out.println("Suma con BigDecimal (exacta):          " + sumaBigDecimal);
    }
}
