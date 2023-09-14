package com.sinensia.primerprograma.texto;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;


/**
 * Ejemplo de rendimiento de String vs StringBuilder.
 *
 * @see String
 * @see StringBuilder
 */
public class RendimientoStringVsStringBuilderConDuration {
    /**
     * Ejemplo de rendimiento de String vs StringBuilder.
     * Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    @SuppressWarnings({ "unused", "java:S1643" })
    public static void main(String[] args) {
        int iterations = 10000;
        Instant startTime;
        Instant endTime;

        // Usando String para concatenar
        String strConcatenated = "";
        startTime = Instant.now();

        for (int i = 0; i < iterations; i++) {

            strConcatenated += "Hola";
        }
        endTime = Instant.now();

        Duration stringDuration = Duration.between(startTime, endTime);

        DecimalFormat decimalFormatString = new DecimalFormat("#,###.######");
        double stringTime = stringDuration.toNanos() / 1e6;

        String stringTimeFormatted = decimalFormatString.format(stringTime);
        System.out.println(
                "Tiempo usando String: "
                        + stringTimeFormatted + " milisegundos");

        // Usando StringBuilder para concatenar
        StringBuilder stringBuilder = new StringBuilder();
        startTime = Instant.now();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("Hola");
        }
        endTime = Instant.now();
        Duration stringBuilderDuration = Duration.between(startTime, endTime);
        DecimalFormat decimalFormatStringBuilder = new DecimalFormat("#,###.#########");
        Double stringBuilderTime = stringBuilderDuration.toNanos() / 1e6;
        String stringBuilderTimeFormatted = decimalFormatStringBuilder.format(
                stringBuilderTime);
        System.out.println(
                "Tiempo usando StringBuilder: "
                        + stringBuilderTimeFormatted + " milisegundos");
    }
}
