package com.sinensia.primerprograma.ejercicios.abril.flota;

public final class Motocicleta extends Vehiculo {

    private final int cilindrada;

    public Motocicleta(String matricula, String marca, Propietario propietario, int cilindrada) {
        super(matricula, marca, propietario);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public boolean superaInspeccion() {
        return cilindrada >= 50 && cilindrada <= 1200;
    }

    @Override
    public String informeInspeccion() {
        String resultado = superaInspeccion() ? "APTO" : "NO APTO";
        return "Motocicleta matricula " + getMatricula() + ": " + resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Motocicleta))
            return false;
        return super.equals(o); // delegamos conscientemente al padre
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}