package com.sinensia.primerprograma.cleancode;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Ejemplo de código limpio.
 * 
 */
public class Ejemplo {

    private static final Logger logger = Logger.getLogger(Ejemplo.class.getName());

    /**
     * Ejemplo de código limpio.
     * 
     * <p>
     * Este ejemplo muestra cómo se puede mejorar el código de una clase
     * para que sea más fácil de leer y mantener.
     * </p>
     * 
     * <p>
     * Para más información, ver el libro "Clean Code" de Robert C. Martin.
     * </p>
     * 
     */

    public static void main(String[] args) {
        // Tanto Coche como Bicicleta son vehiculos y se comportan como tal
        Vehiculo coche = new Coche();
        Vehiculo bicicleta = new Bicicleta();

        // Los podemos trata como vehiculos (polimorfismo) y agregarlos a una lista
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(coche);
        listaVehiculos.add(bicicleta);

        // Podemos recorrer la lista y llamar a los métodos de Vehiculo
        for (Vehiculo vehiculo : listaVehiculos) {
            // Puedes acceder a los métodos de Vehiculo comunes aquí.

            Ejemplo.logger.info("Vehiculo: " + vehiculo.getClass().getSimpleName());
            vehiculo.iniciarMarcha();
        }

    }

}
