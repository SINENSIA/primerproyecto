package com.sinensia.primerprograma.noviembre;

/**
 * Clase para mostrar el uso del ámbito "this" en Java.
 */
public class ThisAmbito {
    private int valor;

    public int asignarValor(int valor) {
        
        this.valor = valor;
        return this.valor;
    }

    public static void main(String[] args) {
        ThisAmbito obj = new ThisAmbito();
        System.out.println(obj.asignarValor(10));
    }
}
