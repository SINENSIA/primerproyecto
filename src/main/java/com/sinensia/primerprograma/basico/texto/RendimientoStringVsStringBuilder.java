package com.sinensia.primerprograma.basico.texto;

import java.text.DecimalFormat;

/**
 * <b>Benchmarking: String vs StringBuilder</b>
 * <p>
 * Este test de rendimiento (micro-benchmark) visualiza la inmensa diferencia de
 * velocidad entre concatenar con el operador {@code +} (que crea miles de
 * objetos temporales)
 * y usar {@link java.lang.StringBuilder}.
 * </p>
 * 
 * @author Sinensia
 */
public class RendimientoStringVsStringBuilder {

    /**
     * Realiza 100,000 concatenaciones y mide el tiempo consumido.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        int iteraciones = 100_000;
        DecimalFormat df = new DecimalFormat("#,###.###");

        System.out.println("Iniciando test de rendimiento (" + iteraciones + " iteraciones)...");

        // --- 1. Test con String (Operador +) ---
        // ADVERTENCIA: Esta operación es O(n^2) debido a la creación constante de
        // objetos
        String bufferString = "";
        long inicioStr = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            bufferString += "x";
        }
        long finStr = System.nanoTime();
        double tiempoStr = (finStr - inicioStr) / 1_000_000.0;

        System.out.println("Tiempo con String (inmutable):        " + df.format(tiempoStr) + " ms");
        System.out.println("Caracteres procesados:                " + df.format(bufferString.length()));

        // --- 2. Test con StringBuilder (Append) ---
        // Esta operación es O(n) ya que el buffer interno crece dinámicamente
        StringBuilder bufferBuilder = new StringBuilder();
        long inicioSb = System.nanoTime();
        for (int i = 0; i < iteraciones; i++) {
            bufferBuilder.append("x");
        }
        long finSb = System.nanoTime();
        double tiempoSb = (finSb - inicioSb) / 1_000_000.0;

        System.out.println("Tiempo con StringBuilder (mutable):   " + df.format(tiempoSb) + " ms");
        System.out.println("Caracteres procesados:                " + df.format(bufferBuilder.length()));

        System.out.println("\nCONCLUSIÓN: Para concatenaciones masivas, usa SIEMPRE StringBuilder.");
    }
}
