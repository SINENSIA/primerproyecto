package com.sinensia.primerprograma.ejercicios.abril.flota;

public final class Turismo extends Vehiculo {

    private final int numeroPuertas;

    public Turismo(String matricula, String marca, Propietario propietario, int numeroPuertas) {
        super(matricula, marca, propietario);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    @Override
    public boolean superaInspeccion() {
        return numeroPuertas == 3 || numeroPuertas == 4 || numeroPuertas == 5;
    }

    @Override
    public String informeInspeccion() {
        String resultado = superaInspeccion() ? "APTO" : "NO APTO";
        return "Turismo matricula " + getMatricula() + ": " + resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Turismo))
            return false;
        return super.equals(o); // delegamos conscientemente al padre
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
