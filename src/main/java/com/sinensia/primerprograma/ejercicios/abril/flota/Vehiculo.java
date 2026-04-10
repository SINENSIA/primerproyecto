package com.sinensia.primerprograma.ejercicios.abril.flota;

import java.util.Objects;

public abstract sealed  class Vehiculo implements Inspeccionable
        permits Turismo, Motocicleta, Furgoneta {

    private final String matricula;
    private final String marca;
    private final Propietario propietario;

    protected Vehiculo(String matricula, String marca, Propietario propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.propietario = propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    // Dos vehiculos son el mismo si tienen la misma matricula
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Vehiculo v))
            return false;
        return Objects.equals(matricula, v.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Vehiculo[matricula=" + matricula +
                ", marca=" + marca +
                ", propietario=" + propietario + "]";
    }
}