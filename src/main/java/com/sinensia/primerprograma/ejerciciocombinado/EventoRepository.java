package com.sinensia.primerprograma.ejerciciocombinado;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Repositorio de eventos. Se encarga de registrar eventos y mostrar los eventos
 *
 * @version 1.0.0
 * @since 2023
 * @see Evento
 * @see ZonedDateTime
 * @see SyncronizedSortedSet
 * @see EventoHandler
 * @author Sinensia
 */
public class EventoRepository {
    private final SortedSet<Evento> eventos = Collections.synchronizedSortedSet(new TreeSet<>());

    /**
     * Registra un evento en el repositorio.
     *
     * @param nombre    Nombre del evento.(String)
     * @param fechaHora Fecha y hora del evento.(ZonedDateTime)
     */
    public void registrarEvento(String nombre, ZonedDateTime fechaHora) {

        Evento evento = new Evento(nombre, fechaHora);
        eventos.add(evento);

    }

    /**
     * Muestra los eventos futuros a partir de una fecha.
     *
     * @param fecha Fecha a partir de la cual se muestran los eventos
     *              futuros.(ZonedDateTime)
     * @see ZonedDateTime
     * @see Evento
     */
    public List<Evento> obtenerEventosFuturos(ZonedDateTime fecha) {

        return eventos.stream()
                .filter(evento -> evento.getFechaHora().isAfter(fecha))
                .collect(Collectors.toList());

    }
}
