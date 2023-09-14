package com.sinensia.primerprograma.abstraccion;

public class Casa {

    public static final int MAX_NUMERO_PLANTAS = 3;
    // La referencia catastral es final, lo que significa que una vez que se le
    // asigna un valor, no puede ser cambiada.
    private final String referenciaCatastral;
    private String direccion;
    private int numeroPlantas;

    // Constructor de la clase Casa. La referencia catastral se asigna al crear una
    // nueva instancia de Casa.
    public Casa(String referenciaCatastral, String direccion, int numeroPlantas) {
        this.referenciaCatastral = referenciaCatastral;
        this.setDireccion(direccion);
        this.setNumeroPlantas(numeroPlantas);

    }

    // Método para obtener la referencia catastral.
    public String getReferenciaCatastral() {
        return referenciaCatastral;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroPlantas() {
        return this.numeroPlantas;
    }

    public void setNumeroPlantas(int numeroPlantas) {
        if (numeroPlantas > MAX_NUMERO_PLANTAS) {
            System.err.println("No se puede asignar un número de plantas mayor que " + MAX_NUMERO_PLANTAS);
            throw new IllegalArgumentException("Número de plantas excede el máximo permitido.");
        }
        this.numeroPlantas = numeroPlantas;
    }

}