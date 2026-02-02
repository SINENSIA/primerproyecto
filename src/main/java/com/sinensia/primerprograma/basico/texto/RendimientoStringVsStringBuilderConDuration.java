package com.sinensia.primerprograma.basico.texto;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;

/**
 * <b>Benchmarking con API de Tiempo Moderna</b>
 * <p>
 * Similar a {@link RendimientoStringVsStringBuilder}, pero utiliza la clase
 * {@link java.time.Instant} y {@link java.time.Duration} para medir los
 * intervalos
 * de tiempo de forma más expresiva.
 * </p>
 * 
 * @author Sinensia
 */
public class RendimientoStringVsStringBuilderConDuration {

    /**
     * Realiza las mediciones y las muestra formateadas.
     * 
     * @param args No se utiliza.
     */
    @SuppressWarnings({ "unused", "java:S1643" })
    public static void main(String[] args) {
        int limite = 100_000;
        DecimalFormat df = new DecimalFormat("#,###.######");

        System.out.println("--- Test de Rendimiento Acumulativo ---");

        // --- 1. Medición String ---
        String s = "";
        Instant i1 = Instant.now();
        for (int i = 0; i < limite; i++) {
            s += "a";
        }
        Instant i2 = Instant.now();
        double t1 = Duration.between(i1, i2).toNanos() / 1_000_000.0;
        System.out.println("String (+):        " + df.format(t1) + " ms");

        // --- 2. Medición StringBuilder ---
        StringBuilder sb = new StringBuilder();
        Instant i3 = Instant.now();
        for (int i = 0; i < limite; i++) {
            sb.append("a");
        }
        Instant i4 = Instant.now();
        double t2 = Duration.between(i3, i4).toNanos() / 1_000_000.0;
        System.out.println("StringBuilder:     " + df.format(t2) + " ms");
    }
}
