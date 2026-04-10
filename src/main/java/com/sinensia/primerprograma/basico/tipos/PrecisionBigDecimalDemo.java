package com.sinensia.primerprograma.basico.tipos;

public class PrecisionBigDecimalDemo {
    public static void main() {

        // --- SUMA SIMPLE ---
        double a = 0.1;
        double b = 0.2;
        System.out.println("0.1 + 0.2 = " + (a + b));
        // Esperado: 0.3
        // Obtenido: 0.30000000000000004 ← ¡sorpresa!

        // --- COMPARACIÓN ---
        System.out.println((a + b) == 0.3);
        // false ← un bug gravísimo en código financiero

        // --- ACUMULACIÓN DE ERROR ---
        double suma = 0.0;
        for (int i = 0; i < 1000; i++) {
            suma += 0.1;
        }
        System.out.println("0.1 x 10 = " + suma);
        // Esperado: 1.0
        // Obtenido: 0.9999999999999999

        // --- DINERO cenario real ---
        double precio = 9.90;
        double descuento = 0.10;
        double total = precio - descuento;
        System.out.println("19.90 - 0.10 = " + total);
        // Esperado: 19.80
        // Obtenido: 19.799999999999997

    }
}