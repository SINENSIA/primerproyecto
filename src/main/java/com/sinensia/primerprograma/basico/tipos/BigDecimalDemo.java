package com.sinensia.primerprograma.basico.tipos;

import java.math.BigDecimal;

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
    }
}
