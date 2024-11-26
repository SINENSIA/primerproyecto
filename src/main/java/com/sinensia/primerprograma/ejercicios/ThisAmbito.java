package com.sinensia.primerprograma.ejercicios;

/**
 * Clase Ambito que demuestra cómo una variable local puede ocultar una variable
 * de instancia.
 */
public class ThisAmbito {
    /** Variable de instancia para almacenar un valor. */
    private int valor;

    /**
     * Asigna un nuevo valor a la variable de instancia usando this.
     *
     * @param valor Nuevo valor a asignar.
     */
    public void asignarValor(int valor) {
        System.out.println("Valor antes: " + this.valor);
        this.valor = valor;
        System.out.println("Valor después: " + this.valor);
    }

    /**
     * Método principal para probar el ámbito de las variables.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        ThisAmbito obj = new ThisAmbito();
        obj.asignarValor(100);
    }
}