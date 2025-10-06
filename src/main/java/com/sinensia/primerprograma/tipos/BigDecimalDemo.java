package com.sinensia.primerprograma.tipos;

import java.math.BigDecimal;

/**
 * <p>
 * Demo con BigDecimal
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.1"); // Se usa String para evitar errores
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal sum = a.add(b);

        System.out.println("0.1 + 0.2 con BigDecimal = " + sum); // 0.3
    }
}
