package com.sinensia.primerprograma.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Ejemplos de Manejo de fechas.
 */
public class ManejoDeFechas {

    /**
     * Ejemplos de manejo de fechas. Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        LocalTime ahora = LocalTime.now();
        System.out.println("LocalTime Hora actual: " + ahora);

        LocalTime masTarde = ahora.plusHours(2);
        System.out.println("LocalTime  Dentro de dos horas serán las: " + masTarde);

        LocalTime antes = ahora.minusHours(2);
        System.out.println("LocalTime  Hace dos horas eran las: " + antes);

        LocalTime test = ahora.withHour(07).withMinute(30).withSecond(00);
        System.out.println("LocalTime  Cambiando la hora actual: " + test);

        LocalTime horaEspecifica = LocalTime.of(10, 23); // Representa las 17:23 PM
        System.out.println("LocalTime Hora específica: " + horaEspecifica);

        int hora = ahora.getHour();
        int minuto = ahora.getMinute();
        int segundo = ahora.getSecond();

        System.out.println("LocalTime  Hora: "
                + hora
                + " Minuto: "
                + minuto
                + " Segundo: "
                + segundo);

        boolean esAntesDe = ahora.isBefore(horaEspecifica);
        boolean esDespuesDe = ahora.isAfter(horaEspecifica);
        System.out.println("LocalTime  ¿Es antes de las 10:23? " + esAntesDe);
        System.out.println("LocalTime  ¿Es después de las 10:23? " + esDespuesDe);

        LocalDate hoy = LocalDate.now();
        System.out.println("LocalDate Día actual: " + hoy);

        LocalDate dosSemanasMasTarde = hoy.plusWeeks(2);
        System.out.println("LocalDate Dentro de una semana será: " + dosSemanasMasTarde);

        LocalDate tresDiasMasTarde = hoy.plusDays(3);
        System.out.println("LocalDate Dentro de tres días será: " + tresDiasMasTarde);

        LocalDate unMesMasTarde = hoy.plusMonths(1);
        System.out.println("LocalDate Dentro de un mes será: " + unMesMasTarde);

        LocalDate unAnyoMasTarde = hoy.plusYears(1);
        System.out.println("LocalDate Dentro de un año será: " + unAnyoMasTarde);

        LocalDate ayer = hoy.minusDays(1);
        System.out.println("LocalDate Ayer fue: " + ayer);

        LocalDate haceUnAnyo = hoy.minusYears(1);
        System.out.println("LocalDate Hace un año fue: " + haceUnAnyo);

        LocalDate fechaEspecifica = LocalDate.of(2023, 07, 30);
        System.out.println("LocalDate Fecha específica: " + fechaEspecifica);

        int dia = fechaEspecifica.getDayOfMonth();

        int mes = fechaEspecifica.getMonthValue();
        int anyo = fechaEspecifica.getYear();
        System.out.println("LocalDate Día: "
                + dia
                + " Mes: "
                + mes
                + " Año: "
                + anyo);

        boolean esAntesDe2 = hoy.isBefore(fechaEspecifica);
        boolean esDespuesDe2 = hoy.isAfter(fechaEspecifica);
        System.out.println("LocalDate ¿Es antes del 30/07/2023? " + esAntesDe2);
        System.out.println("LocalDate ¿Es después del 30/07/2023? " + esDespuesDe2);

        // Primer día del mes
        System.out.println(fechaEspecifica.withDayOfMonth(1));
        // Último día del mes
        System.out.println(fechaEspecifica.withDayOfMonth(fechaEspecifica.lengthOfMonth()));

        LocalDateTime hoyYahora = LocalDateTime.now();
        System.out.println("LocalDateTime Fecha y hora actual: " + hoyYahora);

        LocalDateTime dentroDeUnaHora = hoyYahora.plusHours(1);
        System.out.println("LocalDateTime Dentro de una hora será: " + dentroDeUnaHora);

        LocalDateTime dentroDeUnAnyo = hoyYahora.plusYears(1);
        System.out.println("LocalDateTime Dentro de un año será: " + dentroDeUnAnyo);

        LocalDateTime dentroDeUnMes = hoyYahora.plusMonths(1);
        System.out.println("LocalDateTime Dentro de un mes será: " + dentroDeUnMes);

        LocalDateTime dentroDeUnaSemana = hoyYahora.plusWeeks(1);
        System.out.println("LocalDateTime Dentro de una semana será: " + dentroDeUnaSemana);

        LocalDateTime dentroDeUnDia = hoyYahora.plusDays(1);
        System.out.println("LocalDateTime Dentro de un día será: " + dentroDeUnDia);

        LocalDateTime haceUnaHora = hoyYahora.minusHours(1);
        System.out.println("LocalDateTime Hace una hora fue: " + haceUnaHora);

        LocalDateTime haceUnAnyo2 = hoyYahora.minusYears(1);
        System.out.println("LocalDateTime Hace un año fue: " + haceUnAnyo2);

        LocalDateTime haceUnMes = hoyYahora.minusMonths(1);
        System.out.println("LocalDateTime Hace un mes fue: " + haceUnMes);

        LocalDateTime haceUnaSemana = hoyYahora.minusWeeks(1);
        System.out.println("LocalDateTime Hace una semana fue: " + haceUnaSemana);

        LocalDateTime haceUnDia = hoyYahora.minusDays(1);
        System.out.println("LocalDateTime Hace un día fue: " + haceUnDia);

        LocalDateTime fechaYhoraEspecifica = LocalDateTime.of(2023, 07, 30, 10, 23);
        System.out.println("LocalDateTime Fecha y hora específica: " + fechaYhoraEspecifica);

        int dia2 = fechaYhoraEspecifica.getDayOfMonth();
        int mes2 = fechaYhoraEspecifica.getMonthValue();
        int anyo2 = fechaYhoraEspecifica.getYear();
        int hora2 = fechaYhoraEspecifica.getHour();
        int minuto2 = fechaYhoraEspecifica.getMinute();
        int segundo2 = fechaYhoraEspecifica.getSecond();
        System.out.println("LocalDateTime Día: "
                + dia2
                + " Mes: "
                + mes2
                + " Año: "
                + anyo2
                + " Hora: "
                + hora2
                + " Minuto: "
                + minuto2
                + " Segundo: "
                + segundo2);

        // Convertir LocalDate a LocalDateTime y obtener el inicio del día
        LocalDateTime inicioDelDia = fechaEspecifica.atStartOfDay();
        System.out.println("LocalDateTime inicio  del dia Fecha específica: " + inicioDelDia);

        // Convertir de String a LocalDateTime
        LocalDateTime fechaYHora = LocalDateTime.parse("2023-07-30T10:23:00");
        System.out.println("LocalDateTime Fecha y hora: " + fechaYHora);


        fechaYHora.toLocalDate();

        fechaYHora.toLocalTime();

    }
}
