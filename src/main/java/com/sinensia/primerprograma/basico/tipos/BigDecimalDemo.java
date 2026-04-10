package com.sinensia.primerprograma.basico.tipos;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <b>Concepto: Precisión Arbitraria con BigDecimal</b>
 * <p>
 * Esta clase demuestra por qué {@link java.math.BigDecimal} es esencial para
 * cálculos
 * financieros o científicos donde la precisión de coma flotante de
 * {@code double} o
 * {@code float} es insuficiente.
 * </p>
 * 
 * @author Sinensia
 */
public class BigDecimalDemo {

    /**
     * Ejemplo práctico de suma con BigDecimal.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // MUY IMPORTANTE: Se recomienda usar el constructor con String para evitar
        // la imprecisión inherente de los literales double.
        BigDecimal mal = new BigDecimal(0.1); // hereda el error del double
        System.out.println("BigDecimal(0.1)   = " + mal);

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");

        // Los objetos BigDecimal son inmutables.
        // Las operaciones devuelven un NUEVO objeto.
        BigDecimal sum = a.add(b);

        System.out.println("Suma exacta (0.1 + 0.2) con BigDecimal = " + sum); // Resultado: 0.3

        // Comparación con double convencional:
        double d1 = 0.1;
        double d2 = 0.2;
        System.out.println("Suma imprecisa (0.1 + 0.2) con double = " + (d1 + d2));
        // Resultado esperado: 0.30000000000000004

        // --- SUMA ---
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.2");
        BigDecimal suma = num1.add(num2);
        System.out.println("0.1 + 0.2 = " + suma);
        // 0.3 ✅
        // --- COMPARACIÓN (usar compareTo, NO equals) ---
        // equals también compara escala: 0.3 != 0.30
        System.out.println(suma.compareTo(new BigDecimal("0.3")) == 0);
        // true ✅

        // --- ACUMULACIÓN ---
        BigDecimal acum = BigDecimal.ZERO;
        for (int i = 0; i < 10; i++) {
            acum = acum.add(new BigDecimal("0.1"));
        }
        System.out.println("0.1 x 10 = " + acum);
        // 1.0 ✅

        // --- ESCENARIO REAL: factura ---
        BigDecimal precio = new BigDecimal("19.90");
        BigDecimal descuento = new BigDecimal("0.10");
        BigDecimal total = precio.subtract(descuento);
        System.out.println("19.90 - 0.10 = " + total);
        // 19.80 ✅

        // --- DIVISIÓN con escala y redondeo bancario ---
        BigDecimal dividendo = new BigDecimal("10.00");
        BigDecimal divisor = new BigDecimal("3");
        BigDecimal resultado = dividendo.divide(divisor, 2, RoundingMode.HALF_EVEN);
        System.out.println("10 / 3 = " + resultado);
        // 3.33 ✅ (sin escala lanzaría ArithmeticException)
    }
}
