package com.sinensia.primerprograma.ejercicios.streams;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Clase que representa una reunión.
 */
public class Reunion {
    private int id;
    private String tema;
    private LocalDateTime fechaHora;
    private Duration duracion;
    private ZoneId zona;

    /**
     * Constructor de la clase Reunion.
     *
     * @param id        identificador de la reunión
     * @param tema      tema de la reunión
     * @param fechaHora fecha y hora de inicio de la reunión
     * @param duracion  duración de la reunión
     * @param zona      zona horaria de la reunión
     */
    public Reunion(
            int id,
            String tema,
            LocalDateTime fechaHora,
            Duration duracion,
            ZoneId zona) {
        this.id = id;
        this.tema = tema;
        this.fechaHora = fechaHora;
        this.duracion = duracion;
        this.zona = zona;
    }

    public int getId() {
        return id;
    }

    public ZonedDateTime getInicioZoned() {
        return ZonedDateTime.of(fechaHora, zona);
    }

    public ZonedDateTime getFinZoned() {
        return getInicioZoned().plus(duracion);
    }

    public ZoneId getZona() {
        return zona;
    }

    /**
     * Muestra un resumen de la reunión.
     */
    public void mostrarResumen() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(zona);
        System.out.println("ID de Reunión: " + id);
        System.out.println("Tema: " + tema);
        System.out.println("Inicio: " + formato.format(getInicioZoned()) + " - " + zona);
        System.out.println("Fin: " + formato.format(getFinZoned()) + " - " + zona);
        System.out.println("Duración (min): " + duracion.toMinutes());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Reunion) {
            Reunion otra = (Reunion) obj;
            return this.id == otra.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}