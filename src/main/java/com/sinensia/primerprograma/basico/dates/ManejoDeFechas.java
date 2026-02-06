package com.sinensia.primerprograma.basico.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <b>Manejo de Fechas y Horas (Java 8+ API)</b>
 * <p>
 * Esta clase introduce los conceptos fundamentales de la nueva API de tiempo de
 * Java:
 * <ul>
 * <li>{@link java.time.LocalDate}: Representa una fecha (sin hora).</li>
 * <li>{@link java.time.LocalTime}: Representa una hora (sin fecha).</li>
 * <li>{@link java.time.LocalDateTime}: Representa fecha y hora.</li>
 * </ul>
 * <b>Nota:</b> Estas clases son inmutables y "thread-safe".
 * </p>
 * 
 * @author Sinensia
 */
public class ManejoDeFechas {

        /**
         * Punto de entrada principal para la demostración.
         *
         * @param args No se utiliza.
         */
        public static void main(String[] args) {

                // --- 1. LOCALTIME (Solo Hora) ---
                LocalTime ahora = LocalTime.now();
                System.out.println("Hora actual: " + ahora);

                // Operaciones aritméticas (siempre devuelven una nueva instancia)
                LocalTime masTarde = ahora.plusHours(2);
                LocalTime antes = ahora.minusHours(2);
                System.out.println("2 horas después: " + masTarde);
                System.out.println("2 horas antes:   " + antes);

                // Atajos para establecer valores específicos (with)
                LocalTime test = ahora.withHour(7).withMinute(30).withSecond(0);
                System.out.println("Hora forzada (7:30): " + test);

                // Creación manual
                LocalTime horaEspecifica = LocalTime.of(10, 23);
                System.out.println("Hora específica: " + horaEspecifica);

                // --- 2. LOCALDATE (Solo Fecha) ---
                LocalDate hoy = LocalDate.now();
                System.out.println("\nFecha actual: " + hoy);

                LocalDate dosSemanasMasTarde = hoy.plusWeeks(2);
                LocalDate ayer = hoy.minusDays(1);
                System.out.println("En dos semanas: " + dosSemanasMasTarde);
                System.out.println("Ayer fue:       " + ayer);

                // Creación manual (Año, Mes, Día)
                LocalDate fechaEspecifica = LocalDate.of(2026, 7, 30);
                System.out.println("Fecha específica: " + fechaEspecifica);

                // Consultas comparativas
                boolean esAntesDe = hoy.isBefore(fechaEspecifica);
                System.out.println("¿Hoy es antes del 30/07/2023? " + esAntesDe);

                // --- 3. LOCALDATETIME (Fecha + Hora) ---
                LocalDateTime hoyYahora = LocalDateTime.now();
                System.out.println("\nFecha y hora actual: " + hoyYahora);

                LocalDateTime dentroDeUnaHora = hoyYahora.plusHours(1);
                System.out.println("En una hora: " + dentroDeUnaHora);

                LocalDateTime fechaYhoraEspecifica = LocalDateTime.of(2023, 7, 30, 10, 23);
                System.out.println("Fecha y hora específica: " + fechaYhoraEspecifica);

                // Conversión y extracción
                System.out.println("Solo la fecha: " + fechaYhoraEspecifica.toLocalDate());
                System.out.println("Solo la hora:  " + fechaYhoraEspecifica.toLocalTime());

                // Parsing desde String (Formato ISO por defecto)
                LocalDateTime fechaParseada = LocalDateTime.parse("2023-07-30T10:23:00");
                System.out.println("Fecha parseada: " + fechaParseada);
        }
}
