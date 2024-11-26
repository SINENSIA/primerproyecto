package com.sinensia.primerprograma.noviembre;

/**
 * Clase para evaluar las diferencias entre un tipo primitivo y un tipo basado
 * en objeto.
 */
public class PrimitivosReferencia {

    public static void modificar(int numero, StringBuilder cadena) {
        numero++;
        cadena.append("###");
    }

    public static void main(String[] args) {

        StringBuilder cadena = new StringBuilder("Test");

        modificar(5, cadena);

    }

}
