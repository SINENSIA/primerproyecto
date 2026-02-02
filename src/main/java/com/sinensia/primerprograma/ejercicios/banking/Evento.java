package com.sinensia.primerprograma.ejercicios.banking;

import java.util.ArrayList;
import java.util.LinkedList;

public class Evento {
    private ArrayList<Asistente> registroAsistentes;
    private LinkedList<Asistente> colaAcceso;

    public Evento() {
        registroAsistentes = new ArrayList<>();
        colaAcceso = new LinkedList<>();
    }

    public void registrarAsistente(Asistente asistente) {
        registroAsistentes.add(asistente);
    }

    public void entrarCola(Asistente asistente) {
        colaAcceso.addLast(asistente);
    }

    public Asistente atenderSiguiente() {
        if (!colaAcceso.isEmpty()) {
            return colaAcceso.removeFirst();
        }
        return null;
    }

    public void listarAsistentes() {
        for (Asistente asistente : registroAsistentes) {
            IO.println(asistente);
        }
    }

}
