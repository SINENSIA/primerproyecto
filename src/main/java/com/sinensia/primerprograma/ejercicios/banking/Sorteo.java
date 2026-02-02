package com.sinensia.primerprograma.ejercicios.banking;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sorteo {

    public static void main(String[] args) {
        Set<String> participantes = new HashSet<>();

        participantes.add("Juana");
        participantes.add("Pedro");
        participantes.add("Pepe");
        participantes.add("Juan pedro");
        participantes.add("Mario");
        participantes.add("Pedro");

        IO.println("HashSet (sin orden garantizado): " + participantes);

        Set<String> participantesConOrdenInsercion = new LinkedHashSet<>(participantes);
        participantesConOrdenInsercion.add("Juan");
        IO.println(participantesConOrdenInsercion);

        Set<String> participantesOrdenados = new TreeSet<>(participantes);
        IO.println(participantesOrdenados);

    }

}
