package com.sinensia.primerprograma.abstraccion;

import com.sinensia.primerprograma.interfaces.Conducible;
import com.sinensia.primerprograma.interfaces.Navegable;

/*
 * Clase Anfibio que hereda de Vehiculo e implementa las interfaces Navegable y Conducible
 * @autor Sinensia IT Solutions
 */
public class Anfibio extends Vehiculo implements Navegable, Conducible {

    protected Anfibio(String matricula, String color) {
        super(matricula, color);

    }

    @Override
    public void conducir() {
        System.out.println("Conduzco en tierra firme");
    }

    @Override
    public void navegar() {

        System.out.println("Navego en el agua");
    }

    /**
     * Obtiene el número de ruedas del vehículo.
     *
     * @return int
     */
    @Override
    public int getNumRuedas() {

        throw new UnsupportedOperationException("Unimplemented method 'getNumRuedas'");
    }

}
