package com.sinensia.primerprograma.texto;

import java.text.DecimalFormat;


/**
 * Ejemplo de rendimiento de String vs StringBuilder.
 *
 * @see String
 * @see StringBuilder
 */
public class RendimientoStringVsStringBuilder {
    /**
     * Ejemplo de rendimiento de String vs StringBuilder.
     * Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    @SuppressWarnings({ "unused", "java:S1643" })
    public static void main(String[] args) {
        int iterations = 10000;
        long startTime;
        long endTime;

        // Usando String para concatenar
        String strConcatenated = "";
        startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {

            strConcatenated += "Hola";
        }
        endTime = System.nanoTime();
        double stringTime = (endTime - startTime) / 1_000_000.0; // pasamos a milisegundos
        DecimalFormat decimalFormatString = new DecimalFormat("#,###.###");
        String stringTimeFormatted = decimalFormatString.format(stringTime);
        System.out.println(
                "Tiempo usando String: "
                        + stringTimeFormatted + " milisegundos");

        // Usando StringBuilder para concatenar
        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("Hola");
        }
        endTime = System.nanoTime();
        double stringBuilderTime = (endTime - startTime) / 1_000_000.0; // pasamos a milisegundos
        DecimalFormat decimalFormatStringBuilder = new DecimalFormat("#,###.###");
        String stringBuilderTimeFormatted = decimalFormatStringBuilder.format(stringBuilderTime);
        System.out.println(
                "Tiempo usando StringBuilder: "
                        + stringBuilderTimeFormatted + " milisegundos");
    }
}
