package com.sinensia.primerprograma.dates;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * Ejemplos de Manejo de fechas.
 *
 * @version 1.0.0
 * @since 2023
 * @see ManejoDeFechas
 * @see DateTimeFormatter
 * @author Sinensia
 * 
 */
public class FormateoFechas {

    /**
     * Ejemplos de manejo de fechas. Metodo main.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        LocalTime hora = LocalTime.of(10, 23, 45);
        System.out.println(hora.getSecond());
        Predicate<LocalTime> esAntesDe = hora::isBefore;
        System.out.println(esAntesDe.test(LocalTime.now()));

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Formateo de fechas");
        // Devuelve la fecha formateada según el patrón indicado
        System.out.println("Fecha formateada: " + formateador.format(LocalDateTime.now()));

        // parse convierte un String en un objeto LocalDateTime
        String textoFecha = "15/09/2023 14:30:00";
        LocalDateTime fechaHora = formateador.parse(textoFecha, LocalDateTime::from);
        // Devuelve la fecha formateada según el patrón indicado
        System.out.println("Fecha formateada: " + formateador.format(fechaHora));

        DateTimeFormatter formateadorConLocaleEs = formateador.withLocale(
                Locale.forLanguageTag("es-ES"));
        // o también ``formateador.withLocale(new Locale("es", "ES"));```
        System.out.println("Fecha formateada con Locale ES: "
                + formateadorConLocaleEs.format(fechaHora));

        ZoneId zonaHoraria = ZoneId.of("Europe/Madrid");
        DateTimeFormatter formateadorConZona = formateador.withZone(zonaHoraria);
        System.out.println("Fecha formateada con Zona Horaria: "
                + formateadorConZona.format(fechaHora) + " " + formateadorConZona.getZone());

    }

}
