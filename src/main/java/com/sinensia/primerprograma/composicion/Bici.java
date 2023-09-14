package com.sinensia.primerprograma.composicion;

import com.sinensia.primerprograma.interfaces.Conducible;

public class Bici implements Conducible {

    static final int NUM_RUEDAS = 2;
    private String color;

    public Bici(String color) {
        this.color = color;
    }

    public void conducir() {
        System.out.println("Conduzco la bici");
    }

    public int getNumRuedas() {
        return NUM_RUEDAS;
    }

    public String getColor() {
        return color;
    }

}
