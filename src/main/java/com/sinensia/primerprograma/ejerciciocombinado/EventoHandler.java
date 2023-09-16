package com.sinensia.primerprograma.ejerciciocombinado;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Clase para manejar los eventos.
 * Demostración de uso de hilos.
 */
public class EventoHandler {
    /**
     * Método main. Demostración de uso de hilos.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        EventoRepository eventoRepository = new EventoRepository();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Crear y registrar eventos concurrentemente
        executorService.submit(() -> eventoRepository.registrarEvento(
                "Reunión de equipo", ZonedDateTime.of(2023, 8, 15, 10, 0, 0, 0,
                        ZoneId.of("Europe/Madrid"))));

        executorService.submit(() -> eventoRepository.registrarEvento("Presentación del proyecto",
                ZonedDateTime.of(2023, 9, 20, 15, 30, 0, 0, ZoneId.of("Europe/Paris"))));

        executorService.submit(() -> eventoRepository.registrarEvento(
                "Entrevista de trabajo",
                ZonedDateTime.of(2023, 9, 25, 9, 0, 0, 0, ZoneId.of("Europe/Madrid"))));

        // Intentar registrar un evento con una fecha incorrecta
        try {
            executorService.submit(() -> eventoRepository.registrarEvento("Evento inválido",
                    ZonedDateTime.parse("2023-09-40T12:00:00", DateTimeFormatter.ISO_DATE_TIME)));
        } catch (DateTimeParseException e) {
            System.err.println("Error: Fecha y hora en formato incorrecto.");
        }

        // Mostrar eventos futuros
        ZonedDateTime fechaActual = ZonedDateTime.now();
        Future<List<Evento>> future = executorService
                .submit(() -> eventoRepository.obtenerEventosFuturos(fechaActual));

        try {
            // Obtener el resultado de la tarea
            List<Evento> eventosFuturos = future.get();

            // Mostrar eventos futuros
            System.out.println("Eventos futuros a partir de " + fechaActual + ":");
            for (Evento evento : eventosFuturos) {
                System.out.println(evento);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // Si se produce una excepcion en el main, se debe interrumpir el hilo
            Thread.currentThread().interrupt();
        } finally {
            // Cancelar la tarea si no se ha completado
            if (!future.isDone()) {
                future.cancel(true);
            }
        }

        // Apagar el ExecutorService una vez que no se enviarán más tareas
        executorService.shutdown();

        try {
            // Esperar a que todas las tareas se completen
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Si se produce una excepcion en el main, se debe interrumpir el hilo
            Thread.currentThread().interrupt();
        }
    }
}
