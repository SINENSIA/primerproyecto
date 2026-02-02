package com.sinensia.primerprograma.basico.dates;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Period;

/**
 * <b>Duration vs Period</b>
 * <p>
 * Diferencia fundamental:
 * <ul>
 * <li>{@link java.time.Duration}: Tiempo basado en máquina (nanosegundos).
 * Ideal para horas, minutos, segundos.</li>
 * <li>{@link java.time.Period}: Tiempo basado en humanos (calendario). Ideal
 * para años, meses, días.</li>
 * </ul>
 * </p>
 * 
 * @author Sinensia
 */
public class DurationDemo {

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        // --- 1. DURATION (Tiempo corto/técnico) ---
        Duration ochoHoras = Duration.ofHours(8);
        Duration quinceMinutos = Duration.ofMinutes(15);

        // Las duraciones se pueden sumar o restar
        Duration total = ochoHoras.plus(quinceMinutos);
        System.out.println("Duración total (ISO-8601): " + total); // P8H15M

        // Extracción de partes o conversión total
        Duration dComplex = Duration.ofMinutes(5).plusSeconds(30).plusNanos(5000);
        System.out.println("\nPartes de la duración:");
        System.out.println("- Segundos totales: " + dComplex.toSeconds());
        System.out.println("- Segundos sueltos: " + dComplex.toSecondsPart());
        System.out.println("- Nanosegundos:    " + dComplex.getNano());

        // --- 2. PERIOD (Tiempo largo/calendario) ---
        Period periodo = Period.of(2, 3, 5); // 2 años, 3 meses, 5 días
        Period aumento = Period.ofYears(1);

        Period resultado = periodo.plus(aumento);

        System.out.println("\nPeriodo acumulado:");
        System.out.println("- Años:  " + resultado.getYears());
        System.out.println("- Meses: " + resultado.getMonths());
        System.out.println("- Días:  " + resultado.getDays());

        // --- 3. Utilidades: Formateo Decimal ---
        double seg = (double) dComplex.toNanos() / 1_000_000_000;
        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println("\nSegundos precisos formateados: " + df.format(seg));
    }
}
