package com.sinensia.primerprograma.patrones.factory;

/**
 * Clase que representa un barco.
 * Implementa la interfaz IVehiculo.
 */
public class Barco implements Vehiculo {
    /**
     * Muestra información sobre el barco.
     * Este método imprime un mensaje indicando que el objeto es un barco.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Barco vendido y entregado.");
    }
}
