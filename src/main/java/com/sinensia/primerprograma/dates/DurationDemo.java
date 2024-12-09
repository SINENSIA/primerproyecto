package com.sinensia.primerprograma.dates;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Period;

public class DurationDemo {

    public static void main(String[] args) {
        // Crear una Duration de 8 horas
        Duration ochoHoras = Duration.ofHours(8);

        // Crear una Duration de 30 minutos
        Duration quinceMinutos = Duration.ofMinutes(15);

        // Sumar las Durations
        Duration resultado = ochoHoras.plus(quinceMinutos);

        System.out.println("Resultado: " + resultado);

        // getNanos
        Duration duracion = Duration.ofMinutes(5).plusSeconds(30).plusNanos(5000);

        double segundos1 = duracion.toSeconds(); // Devuelve 330.005
        double segundos2 = duracion.getSeconds(); // Devuelve 330
        double segundos3 = duracion.toSecondsPart(); // Devuelve 30

        System.out.println("----toSeconds: " + segundos1);
        System.out.println("----getSeconds: " + segundos2);
        System.out.println("----toSecondsPart: " + segundos3);
        double minutos1 = duracion.toMinutes(); // Devuelve 5.500083333333333
        double minutos2 = duracion.toMinutesPart(); // Devuelve 5
        double minutos3 = duracion.toHours(); // Devuelve 0.09166805555555555
        System.out.println("----toMinutes: " + minutos1);
        System.out.println("----toMinutesPart: " + minutos2);
        System.out.println("----toHours: " + minutos3);

        double segundos = (double) duracion.toNanos() / 1_000_000_000; // Devuelve 330
        System.out.println("---Segundos precisos: " + segundos); // Devuelve 330.005

        double segundosDecimal = duracion.toSeconds();
        System.out.println("Segundos: " + segundosDecimal);
        // Define un patrón de formato para mostrar más decimales
        // Aquí se puede ajustar la cantidad de decimales que deseas mostrar
        String patron = "0.00000"; 

        // Crea un objeto DecimalFormat con el patrón
        DecimalFormat formato = new DecimalFormat(patron);

        // Formatea el número usando el formato y muestra el resultado
        String numeroFormateado = formato.format(segundosDecimal);
        System.out.println(numeroFormateado);

        // Crear un Period de 2 años, 3 meses y 5 días
        Period periodo = Period.of(2, 3, 5);

        // Sumar otro Period de 1 año, 2 meses y 10 días
        Period otroPeriodo = Period.of(1, 2, 10);
        Period resultadoPeriodo = periodo.plus(otroPeriodo);

        // Mostrar el resultado
        System.out.println("Período total: " + resultadoPeriodo.getYears() + " años, " +
                resultadoPeriodo.getMonths() + " meses, " +
                resultadoPeriodo.getDays() + " días");

    }

}
