package com.sinensia.primerprograma.tipos;

import java.math.BigDecimal;

public class PrecisionComparacion {
    public static void main(String[] args) {
        float f = 0.1f + 0.2f;
        double d = 0.1 + 0.2;
        BigDecimal bd = new BigDecimal("0.1").add(new BigDecimal("0.2"));

        System.out.println("float: " + f); // Error NO evidente
        System.out.println("double: " + d); // Error evidente
        System.out.println("BigDecimal: " + bd); // Correcto

        PrecisionComparacion.demoErorres();
    }

    private static void demoErorres() {
        float sumaFloat = 0.0f;
        double sumaDouble = 0.0;
        BigDecimal sumaBigDecimal = BigDecimal.ZERO;
        BigDecimal incremento = new BigDecimal("0.1");

        for (int i = 0; i < 10; i++) {
            sumaFloat += 0.1f;
            sumaDouble += 0.1;
            sumaBigDecimal = sumaBigDecimal.add(incremento);
        }

        System.out.println("Suma con float (debería ser 1.0): " + sumaFloat);
        System.out.println("Suma con double (debería ser 1.0): " + sumaDouble);
        System.out.println("Suma con BigDecimal (exacta): " + sumaBigDecimal);
    }
}
