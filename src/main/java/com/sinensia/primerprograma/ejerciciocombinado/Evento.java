package com.sinensia.primerprograma.ejerciciocombinado;

import java.time.ZonedDateTime;
import java.util.Objects;

class Evento implements Comparable<Evento> {
    private String nombre;
    private ZonedDateTime fechaHora;

    public Evento(String nombre, ZonedDateTime fechaHora) {

        this.nombre = nombre;
        this.fechaHora = fechaHora;
    }

    public String getNombre() {
        return nombre;
    }

    public ZonedDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return nombre + " - " + fechaHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Evento)) {
            return false;
        }
        Evento evento = (Evento) o;
        return Objects.equals(nombre, evento.nombre) && Objects.equals(fechaHora, evento.fechaHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaHora);
    }

    @Override
    public int compareTo(Evento evento) {
        if (fechaHora.compareTo(evento.fechaHora) == 0) {
            return nombre.compareTo(evento.nombre);
        }
        return fechaHora.compareTo(evento.fechaHora);
    }

}
