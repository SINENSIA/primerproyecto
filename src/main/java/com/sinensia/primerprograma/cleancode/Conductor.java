package com.sinensia.primerprograma.cleancode;

/**
 * Clase que representa a un conductor de vehiculos.
 */
public class Conductor {
    private Vehiculo vehiculo;

    public Conductor(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Conduce el vehiculo.
     * Si el vehiculo es de motor, se arranca antes de iniciar la marcha.
     * Si no es de motor, se inicia la marcha directamente.
     */
    public void conducir() {
        vehiculo.iniciarMarcha();

    }

}
