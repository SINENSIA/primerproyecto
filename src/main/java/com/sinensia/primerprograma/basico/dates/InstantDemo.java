package com.sinensia.primerprograma.basico.dates;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * <b>Clase Instant: Tiempo en escala de máquina</b>
 * <p>
 * {@link java.time.Instant} representa un punto específico en la línea de
 * tiempo
 * (Epoch), expresado en milisegundos o nanosegundos desde el 1 de enero de 1970
 * UTC.
 * <br>
 * Ideal para logs de servidores, marcas de tiempo en bases de datos y cálculo
 * de
 * rendimiento (benchmarking).
 * </p>
 * 
 * @author Sinensia
 */
public class InstantDemo {

    /**
     * Punto de entrada principal.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Obtenemos el instante actual siempre en UTC (independiente de la zona local)
        Instant inicio = Instant.now();
        System.out.println("Instante de inicio (UTC): " + inicio);

        // Operaciones de tiempo
        Instant futuro = inicio.plusSeconds(3600); // +1 hora
        Instant masFuturo = futuro.plus(Duration.ofHours(1)); // +otra hora con Duration

        System.out.println("Instante en 2 horas:     " + masFuturo);

        // Simulación de un proceso que tarda tiempo
        System.out.println("\nSimulando espera de 2 segundos...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Instant fin = Instant.now();

        // Cálculo de diferencia (intervalos)
        long segundosTranscurridos = inicio.until(fin, ChronoUnit.SECONDS);
        long milisTranscurridos = Duration.between(inicio, fin).toMillis();

        System.out.println("Diferencia calculada:");
        System.out.println("- Segundos:     " + segundosTranscurridos);
        System.out.println("- Milisegundos: " + milisTranscurridos);
    }
}
