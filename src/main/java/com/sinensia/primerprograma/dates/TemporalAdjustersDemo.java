package com.sinensia.primerprograma.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersDemo {
    public static void main(String[] args) {
        // Obtener el primer día del mes
        LocalDate fechaEspecifica = LocalDate.of(2023, 10, 7);
        // Devuelve el último día del mes
        LocalDate ultimoDiaDeMes = fechaEspecifica.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Último día de mes: " + ultimoDiaDeMes);

        // Fecha actual <- ejemplo comentario inútil, la variable ya lo dice (semántica)
        LocalDate fechaActual = LocalDate.now();
        // Devuelve el próximo domingo
        LocalDate proximoDomingo = fechaActual.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("Próximo Domingo: " + proximoDomingo);
        System.out.println("Primer mes del trimestre" + Month.MAY.firstMonthOfQuarter());

        String nombreDelMes = Month.AUGUST.name();
        System.out.println("Nombre del mes: " + nombreDelMes);

    }
}
