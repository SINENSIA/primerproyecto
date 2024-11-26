package com.sinensia.primerprograma.patrones.factory;

/**
 * Representa un concesionario de barcos que crea vehículos tipo barco.
 * Esta clase extiende la clase Concesionario y sobrescribe
 * el método crearVehiculo para crear específicamente objetos Barco.
 */
public class ConcesionarioBarcos extends Concesionario {

    /**
     * Crea un nuevo vehículo tipo Barco.
     * Este método sobrescribe el método de la clase padre para retornar una
     * instancia de Barco.
     *
     * @return Un nuevo objeto Vehiculo de tipo Barco
     */
    @Override
    public Vehiculo crearVehiculo() {
        return new Barco();
    }
}
