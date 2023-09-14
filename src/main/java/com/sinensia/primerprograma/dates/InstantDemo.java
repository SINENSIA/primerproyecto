package com.sinensia.primerprograma.dates;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class InstantDemo {
    public static void main(String[] args) {
        // Obtenemos el instante actual en UTC
        Instant now = Instant.now();

        // Devuelve el instante actual (epoch) en milisegundos
        // Es independiente de la zona horaria está en escalas de tiempo UTC / GMT
        System.out.println("Instante actual: " + now);

        // Podemos realizar operaciones de tiempo con Instant, como agregar un objeto
        // Duration
        Instant futuro = now.plusSeconds(3600); // Agrega 1 hora (3600 segundos)
        Duration duration = Duration.ofHours(1);
        futuro = futuro.plus(duration); // Agrega 1 hora con duration
        // 2 horas más: 1 hora de plusSeconds + 1 hora de duration
        System.out.println("Instante en 2 horas: " + futuro);
        try {
            Thread.sleep(3000); // 3000 milisegundos (3 segundos)
        } catch (InterruptedException e) {
            // Manejo de excepciones si la interrupción ocurre durante el retraso
            e.printStackTrace();
            Thread.currentThread().interrupt(); // Buena práctica reinterrumpir el hilo
        }
        // También puedes calcular la diferencia de tiempo entre dos Instants
        Instant otroInstant = Instant.now();
        TemporalUnit unidad = ChronoUnit.SECONDS;

        long segundosDeDiferencia = now.until(otroInstant, unidad);
        System.out.println("Diferencia en segundos: " + segundosDeDiferencia);
    }
}
