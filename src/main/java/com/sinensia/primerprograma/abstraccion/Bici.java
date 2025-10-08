package com.sinensia.primerprograma.abstraccion;

import com.sinensia.primerprograma.interfaces.Conducible;
import java.util.Objects;

/**
 * Clase Bici que hereda de Vehiculo e implementa la interfaz Conducible.
 *
 * @author Sinensia IT Solutions
 */
public class Bici extends Vehiculo implements Conducible {

    static final int NUM_RUEDAS = 2;

    public Bici(String matricula, String color) {
        super(matricula, color);
    }

    @Override
    public void conducir() {
        System.out.println("Conduzco la bici");
    }

    /**
     * Obtiene el número de ruedas del vehículo.
     *
     * @return int
     */
    @Override
    public int getNumRuedas() {
        return NUM_RUEDAS;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Bici)) {
            return false;
        }
        Bici bici = (Bici) o;
        return Objects.equals(this, bici);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "{"
                +
                "}";
    }

}
