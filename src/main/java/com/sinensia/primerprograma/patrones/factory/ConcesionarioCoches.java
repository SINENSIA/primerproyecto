package com.sinensia.primerprograma.patrones.factory;

/**
 * Representa un concesionario de coches.
 * Esta clase es responsable de gestionar las operaciones relacionadas con coches
 * en un concesionario.
 */
public class ConcesionarioCoches extends Concesionario {

    /**
     * Crea una nueva instancia de vehículo específica para este concesionario de coches.
     * Este método sobrescribe el método abstracto en la clase padre para proporcionar
     * una implementación concreta para crear un coche.
     *
     * @return Una nueva instancia de Vehiculo que representa un coche (Coche)
     */
    @Override
    public Vehiculo crearVehiculo() {
        return new Coche();
    }
}

