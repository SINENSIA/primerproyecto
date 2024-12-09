package com.sinensia.primerprograma.dates;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitDemo {
    /**
     * Ejemplos de manejo de fechas. Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        ZonedDateTime fechaInicio = ZonedDateTime.of(2023, 9, 20, 9, 0, 0, 0,
                ZoneId.of("Europe/Madrid"));
        ZonedDateTime fechaFin = ZonedDateTime.of(2023, 9, 20, 18, 0, 0, 0,
                ZoneId.of("Europe/Madrid"));

        System.out.println("Fecha inicio: " + fechaInicio);
        System.out.println("Fecha fin: " + fechaFin);

        // Calcular la diferencia en horas entre las dos fechas
        long horasDeDiferencia = ChronoUnit.HOURS.between(fechaInicio, fechaFin);
        // Impresión de la diferencia en horas
        System.out.println("Diferencia en horas: " + horasDeDiferencia);

        // Calcular la diferencia en meses entre las dos fechas
        long mesesDeDiferencia = ChronoUnit.MONTHS.between(fechaInicio, fechaFin);
        System.out.println("Diferencia en meses: " + mesesDeDiferencia);
    }
}
