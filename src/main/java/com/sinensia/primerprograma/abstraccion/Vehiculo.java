package com.sinensia.primerprograma.abstraccion;

public abstract class Vehiculo {

    private String matricula;
    private String color;

    protected Vehiculo() {
        // Constructor predeterminado.
    }

    protected Vehiculo(String matricula, String color) {
        this.matricula = matricula;
        this.color = color;
    }

    public void arrancar() {
        System.out.println("Arrancando vehículo...");
    }

    public abstract int getNumRuedas();

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula != null && matricula.length() > 0) {
            this.matricula = matricula;
        } else {
            System.err.println("ERROR: Matrícula no válida");
        }
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if (color != null && color.length() > 0) {
            this.color = color;
        } else {
            System.err.println("ERROR: Color no válido");
        }
    }

    public final void soloLectura() {
        System.out.println("Este método no se sobreescribe");
    }

}
