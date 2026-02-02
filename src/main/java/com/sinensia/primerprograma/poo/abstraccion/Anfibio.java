package com.sinensia.primerprograma.poo.abstraccion;

import com.sinensia.primerprograma.poo.interfaces.Conducible;
import com.sinensia.primerprograma.poo.interfaces.Navegable;

/*
 * Clase Anfibio que hereda de Vehiculo e implementa las interfaces Navegable y Conducible
 * @author Sinensia IT Solutions
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

    /**
     *
     * No se puede sobreescribir ya que soloLectura es final en la clase padre.
     * 
     * @Override
     *           public void soloLectura() {
     *
     *           }
     **/

}
