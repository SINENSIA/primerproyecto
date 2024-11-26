package com.sinensia.primerprograma.patrones.factory;

/**
 * Clase que representa un Coche.
 * Implementa la interfaz IVehiculo.
 */
public class Coche implements Vehiculo {
    /**
     * Muestra información sobre el coche.
     * Este método imprime un mensaje indicando que se trata de un coche.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Coche vendido y entregado.");
    }
}
