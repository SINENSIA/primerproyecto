package com.sinensia.primerprograma.noviembre;

public class Gafas {

    private String lentes;
    private String estilo;
    private Float diotrias;
    private String color;

    public Gafas(String lentes, String estilo, float diotrias) {

        this.lentes = lentes;
        this.estilo = estilo;
        this.diotrias = diotrias;
        
    }

    public void ponerGafas() {

        System.out.println("Me pongo las gafas " + lentes
                + " de estilo " + estilo
                + " con " + diotrias + " diótrias.");

    }

    public void quitarGafas() {

        System.out.println("Me quito las gafas " + lentes
                + " de estilo " + estilo
                + " con " + diotrias + " diótrias.");
    }

    public void setColor(String color) {
        if (color.equalsIgnoreCase("rojo")
                || color.equalsIgnoreCase("azul")
                || color.equalsIgnoreCase("verde")) {
            this.color = color;
        } else {
            System.out.println("Ese color no lo tienen en fábrica.");
        }
    }

    public String getColor() {
        return color;
    }

}
