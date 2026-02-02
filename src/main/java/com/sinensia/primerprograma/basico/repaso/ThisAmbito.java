package com.sinensia.primerprograma.basico.repaso;

/**
 * <b>Palabra reservada: this</b>
 * <p>
 * Muestra el uso de {@code this} para resolver la ambigüedad (Shadowing) entre
 * parámetros de un método y atributos de la clase.
 * </p>
 * 
 * @author Sinensia
 */
public class ThisAmbito {

    // Atributo de la clase
    private int valor;

    /**
     * Asigna un valor al atributo de la instancia.
     * 
     * @param valor Parámetro que oculta al atributo 'valor'
     * @return El valor asignado a la instancia.
     */
    public int asignarValor(int valor) {
        // this.valor hace referencia al atributo private
        // valor (a la derecha) hace referencia al parámetro del método
        this.valor = valor;
        return this.valor;
    }

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        ThisAmbito obj = new ThisAmbito();
        System.out.println("Valor asignado: " + obj.asignarValor(42));
    }
}
