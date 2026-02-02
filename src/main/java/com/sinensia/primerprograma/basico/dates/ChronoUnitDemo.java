package com.sinensia.primerprograma.basico.dates;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * <b>Cálculo de intervalos con ChronoUnit</b>
 * <p>
 * Esta clase demuestra el uso de la enumeración
 * {@link java.time.temporal.ChronoUnit}
 * para obtener diferencias precisas entre fechas en diversas unidades (Horas,
 * Días, Meses, etc.).
 * </p>
 * 
 * @author Sinensia
 */
public class ChronoUnitDemo {

    /**
     * Punto de entrada principal.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Definimos un intervalo de tiempo en una zona horaria específica
        ZonedDateTime inicio = ZonedDateTime.of(2023, 9, 20, 9, 0, 0, 0, ZoneId.of("Europe/Madrid"));
        ZonedDateTime fin = ZonedDateTime.of(2023, 10, 20, 18, 0, 0, 0, ZoneId.of("Europe/Madrid"));

        System.out.println("Inicio: " + inicio);
        System.out.println("Fin:    " + fin);

        // El método between es la forma más directa de calcular distancias temporales
        long horas = ChronoUnit.HOURS.between(inicio, fin);
        long dias = ChronoUnit.DAYS.between(inicio, fin);
        long meses = ChronoUnit.MONTHS.between(inicio, fin);

        System.out.println("\nResultados de ChronoUnit:");
        System.out.println("- Horas de diferencia: " + horas); // Diferencia horaria total
        System.out.println("- Días de diferencia:  " + dias); // Días completos
        System.out.println("- Meses de diferencia: " + meses); // Meses naturales completos
    }
}
