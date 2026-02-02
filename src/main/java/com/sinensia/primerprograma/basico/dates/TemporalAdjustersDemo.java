package com.sinensia.primerprograma.basico.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * <b>TemporalAdjusters: Ajustes lógicos de fechas</b>
 * <p>
 * Muestra cómo utilizar {@link java.time.temporal.TemporalAdjusters} para
 * realizar
 * cálculos relativos como "el último día de este mes" o "el próximo lunes",
 * evitando cálculos matemáticos manuales propensos a errores.
 * </p>
 * 
 * @author Sinensia
 */
public class TemporalAdjustersDemo {

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();

        // 1. Obtener extremos del mes
        LocalDate primeroMes = hoy.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate ultimoMes = hoy.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("Fecha de referencia (hoy): " + hoy);
        System.out.println("Primer día del mes actual: " + primeroMes);
        System.out.println("Último día del mes actual: " + ultimoMes);

        // 2. Navegación por días de la semana
        LocalDate proximoDomingo = hoy.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("\nEl próximo domingo será:  " + proximoDomingo);

        // 3. Consultas sobre enums Month/DayOfWeek
        System.out.println("\nDatos sobre Meses:");
        System.out.println("- Nombre: " + Month.AUGUST.name());
        System.out.println("- Mes de inicio del trimestre de Mayo: " + Month.MAY.firstMonthOfQuarter());
    }
}
