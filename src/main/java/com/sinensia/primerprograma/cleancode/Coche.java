package com.sinensia.primerprograma.cleancode;

/**
 * Esta clase representa un coche.
 *
 * @version 1.0.0
 * @since 2023
 * @see Vehiculo
 * @see Motorizable
 */
public class Coche extends Vehiculo implements Motorizable {
    private Motor motor;

    public Coche() {
        this.motor = new Motor();
    }

    @Override
    public Motor motor() {
        return motor;
    }

    /**
     * Inicia la marcha del coche.
     * Si el coche no está arrancado, lo arranca antes de iniciar la marcha.
     */
    @Override
    public void iniciarMarcha() {
        this.arrancar();
        System.out.println("Coche iniciando marcha.");
    }

    /**
     * Arranca el coche.
     * Si el coche ya está arrancado, no hace nada.
     */
    @Override
    public void arrancar() {
        motor.encender();
        System.out.println("Coche arrancado.");
    }

    @Override
    public void detener() {
        motor.apagar();
        System.out.println("Coche detenido.");
    }
}
