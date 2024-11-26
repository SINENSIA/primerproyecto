package com.sinensia.primerprograma.patrones.factory;

/**
 * Represents an abstract Concesionario (Dealership) class.
 * <p>
 * This class defines the structure for different types of vehicle dealerships.
 * It provides an abstract method for creating vehicles and a concrete method
 * for processing vehicle sales.
 * </p>
 */
public abstract class Concesionario {
    /**
     * Creates a vehicle instance.
     *
     * @return An instance of IVehiculo representing the created vehicle.
     */
    public abstract Vehiculo crearVehiculo();

    /**
     * Processes the sale of a vehicle.
     * <p>
     * This method creates a vehicle using the crearVehiculo method,
     * displays its information, and performs other common sale processes.
     * </p>
     */
    public void procesarVenta() {
        Vehiculo vehiculo = crearVehiculo();
        vehiculo.mostrarInformacion();
        // Otros procesos comunes de venta
    }
}
