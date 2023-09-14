package com.sinensia.primerprograma.dates;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Ejemplos de Manejo de fechas.
 * 
 * @version 1.0.0
 * @since 2023
 * @see ManejoDeFechas
 * @see ZonedDateTime
 */
public class ZonedDatetimeDemo {

    /**
     * Ejemplos de manejo de fechas. Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        ZoneId zonaHoraria = ZoneId.of("Europe/Madrid");
        ZonedDateTime fechaHoraActual = ZonedDateTime.now(zonaHoraria);

        System.out.println("Fecha y hora actual: " + fechaHoraActual);
        // Fecha y hora actual: 2023-09-15T14:30:00.000+02:00[Europe/Paris]

        ZoneId zonaHorariaLondres = ZoneId.of("America/New_York");
        ZonedDateTime fechaHoraActualLondres = fechaHoraActual
                .withZoneSameInstant(zonaHorariaLondres);

        System.out.println("Fecha y hora actual en Nueva York: " + fechaHoraActualLondres);
        // Fecha y hora actual en Londres: 2023-09-15T13:30:00.000+01:00[Europe/London]

        // Instanciar en una fecha específica
        ZonedDateTime fechaHora = ZonedDateTime
                .of(2023, 9, 15, 14, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
        System.out.println("Fecha y hora en Tokyo: " + fechaHora);

        // Comparte otros métodos con LocalDateTime como por ejemplo
        // plusHours, plusMinutes, plusSeconds, plusNanos, minusHours, minusMinutes,
        ZonedDateTime dentroDeDosHorasEnTokio = fechaHora.plusHours(2);
        System.out.println("Fecha y hora en Tokyo dentro de dos horas: " + dentroDeDosHorasEnTokio);
        ZonedDateTime dosSemanasAntesEnTokio = fechaHora.minusWeeks(2);
        System.out.println("Fecha y hora en Tokyo dos semanas antes: " + dosSemanasAntesEnTokio);

        // sameInstant, sameLocalDate, sameLocalTime, toLocalDate, toLocalDateTime,
        // toLocalTime, toOffsetDateTime, toOffsetTime, toZonedDateTime
        ZonedDateTime fechaHoraMadrid = dosSemanasAntesEnTokio.withZoneSameInstant(zonaHoraria);
        System.out.println("Fecha y hora en Madrid respecto a dos semanas antes en tokio: "
                + fechaHoraMadrid);

        // Crear el ZonedDateTime original en Madrid (horario de verano)
        ZonedDateTime madridDateTime = ZonedDateTime.of(2023, 9, 23, 14, 0, 0, 0, ZoneId.of("Europe/Madrid"));
        // Convertir a la zona horaria de Nueva York manteniendo el mismo instante
        ZonedDateTime newYorkDateTimeSameInstant = madridDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Hora en Nueva York (Mismo Instante): " + newYorkDateTimeSameInstant);

        // Convertir a la zona horaria de Nueva York manteniendo la misma hora local
        ZonedDateTime newYorkDateTimeSameLocal = madridDateTime.withZoneSameLocal(ZoneId.of("America/New_York"));

        System.out.println("Hora en Nueva York (Misma Hora Local): " + newYorkDateTimeSameLocal);

    }
}
