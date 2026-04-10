package com.sinensia.primerprograma.ejercicios.abril.flota;

public final class Furgoneta extends Vehiculo {

    private final double cargaMaximaKg;

    public Furgoneta(String matricula, String marca, Propietario propietario, double cargaMaximaKg) {
        super(matricula, marca, propietario);
        this.cargaMaximaKg = cargaMaximaKg;
    }

    public double getCargaMaximaKg() {
        return cargaMaximaKg;
    }

    @Override
    public boolean superaInspeccion() {
        return cargaMaximaKg > 0 && cargaMaximaKg <= 3500.0;
    }

    @Override
    public String informeInspeccion() {
        String resultado = superaInspeccion() ? "APTO" : "NO APTO";
        return "Furgoneta matricula " + getMatricula() + ": " + resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Furgoneta))
            return false;
        return super.equals(o); // delegamos conscientemente al padre
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
