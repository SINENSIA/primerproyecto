package com.sinensia.primerprograma.ejercicios.banking;

import java.util.Comparator;

public class ComparadorPorHora implements Comparator<Asistente> {
    @Override
    public int compare(Asistente asistente1, Asistente asistente2) {
        return asistente1.getHoraLlegada().compareTo(asistente2.getHoraLlegada());
    }

}
