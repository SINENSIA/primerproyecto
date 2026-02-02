package com.sinensia.primerprograma.ejercicios.banking;

public class Main {
    public static void main(String[] args) {
        Evento evento = new Evento();

        Asistente asistente1 = new Asistente("Carlos", "10:00");
        Asistente asistente2 = new Asistente("Pepe", "10:25");
        Asistente asistente3 = new Asistente("María", "10:13");

        evento.registrarAsistente(asistente1);
        evento.registrarAsistente(asistente2);
        evento.registrarAsistente(asistente3);

        evento.entrarCola(asistente1);
        evento.entrarCola(asistente2);
        evento.entrarCola(asistente3);

        IO.println("Asistentes registrados:");
        evento.listarAsistentes();

        IO.println("Atendiendo cola espera:");
        IO.println(evento.atenderSiguiente());
        IO.println(evento.atenderSiguiente());
        IO.println(evento.atenderSiguiente());
        IO.println(evento.atenderSiguiente());



    }

}
