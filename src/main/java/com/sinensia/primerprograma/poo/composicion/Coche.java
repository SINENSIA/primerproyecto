package com.sinensia.primerprograma.poo.composicion;

import com.sinensia.primerprograma.poo.interfaces.Conducible;

public class Coche implements Conducible {

    private Motor motor;

    private static final int NUM_RUEDAS = 4;
    private String matricula;
    private String color;

    public Coche(String matricula, String color, Motor motor) {
        this.matricula = matricula;
        this.color = color;
        this.motor = motor;
    }

    public void arrancar() {
        this.motor.arrancar();
    }

    public void conducir() {
        System.out.println("Conduzco el coche");
    }

    public int getNumRuedas() {
        return NUM_RUEDAS;
    }

    public String getColor() {
        return this.color;
    }

    public String getMatricula() {
        return this.matricula;
    }

}
