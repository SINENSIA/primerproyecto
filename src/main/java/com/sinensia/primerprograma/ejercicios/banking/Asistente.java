package com.sinensia.primerprograma.ejercicios.banking;

public class Asistente implements Comparable<Asistente> {

    private String nombre;
    private String horaLlegada;

    public Asistente(String nombre, String horaLlegada) {
        this.nombre = nombre;
        this.horaLlegada = horaLlegada;

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraLlegada() {
        return this.horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return nombre + " - Llegó a las " + horaLlegada;
    }

    @Override
    public int compareTo(Asistente otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

}
