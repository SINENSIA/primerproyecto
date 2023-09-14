package com.sinensia.primerprograma.abstraccion;

import com.sinensia.primerprograma.interfaces.Conducible;
import com.sinensia.primerprograma.interfaces.Navegable;

public class Coche extends Vehiculo implements Conducible {

    private static final int NUM_RUEDAS = 4;

    public Coche() {
        super(); // Esta llamada es opcional.
    }

    public Coche(String matricula, String modelo) {
        super(matricula, modelo);
    }

    @Override
    public void arrancar() {
        // super.arrancar(); // Llamar al método de la clase padre
        System.out.println("Arranco el coche"); // Añadir más funcionalidad
    }

    @Override
    public void conducir() {
        System.out.println("Conduzco el coche");
    }

    @Override
    public int getNumRuedas() {
        return NUM_RUEDAS;
    }

    public double nudosToKmh(double nudos) {

        return Navegable.nudosToKmh(nudos);

    }

}
