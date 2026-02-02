package com.sinensia.primerprograma.basico.repaso;

/**
 * <b>Modelado de Objetos: Gafas</b>
 * <p>
 * Ejemplo simple de una clase POJO (Plain Old Java Object) con atributos,
 * constructor y validación básica en un setter.
 * </p>
 * 
 * @author Sinensia
 */
public class Gafas {

    private String lentes;
    private String estilo;
    private Float diotrias;
    private String color;

    /**
     * Constructor principal.
     * 
     * @param lentes   Tipo de lentes (Cerca, Sol, etc.)
     * @param estilo   Forma de la montura
     * @param diotrias Graduación
     */
    public Gafas(String lentes, String estilo, float diotrias) {
        this.lentes = lentes;
        this.estilo = estilo;
        this.diotrias = diotrias;
    }

    public String getLentes() {
        return lentes;
    }

    public void setLentes(String lentes) {
        this.lentes = lentes;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Float getDiotrias() {
        return diotrias;
    }

    public void setDiotrias(Float diotrias) {
        this.diotrias = diotrias;
    }

    public void ponerGafas() {
        System.out.println("Me pongo las gafas de " + lentes + ".");
    }

    public void quitarGafas() {
        System.out.println("Me quito las gafas.");
    }

    /**
     * Establece el color de la montura si está disponible en stock.
     * 
     * @param color El color deseado.
     */
    public void setColor(String color) {
        if (color.equalsIgnoreCase("rojo")
                || color.equalsIgnoreCase("azul")
                || color.equalsIgnoreCase("verde")) {
            this.color = color;
        } else {
            System.err.println("ERROR: El color '" + color + "' no está disponible en fábrica.");
        }
    }

    public String getColor() {
        return color;
    }
}
