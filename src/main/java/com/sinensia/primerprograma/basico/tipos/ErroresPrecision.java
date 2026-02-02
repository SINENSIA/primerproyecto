package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Concepto: Errores de Precisión en Punto Flotante</b>
 * <p>
 * Demuestra las limitaciones de los tipos {@code double} y {@code float}
 * al representar literales decimales según el estándar IEEE 754.
 * </p>
 * 
 * @author Sinensia
 * @see BigDecimalDemo
 */
public class ErroresPrecision {

    /**
     * Ejemplo clásico de imprecisión en aritmética de punto flotante.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // En binario, los valores como 0.1 o 0.2 no se pueden representar de forma
        // exacta.
        double a = 0.1;
        double b = 0.2;
        double sum = a + b;

        System.out.println("Operación: 0.1 + 0.2");
        System.out.println("Resultado real en Java (double): " + sum);
        // Muestra: 0.30000000000000004

        System.out.println("\nCONCLUSIÓN: No uses 'double' para moneda o cálculos de alta precisión.");
    }
}
