package com.sinensia.primerprograma.excepciones;

/**
 * Ejemplo de excepciones en Java.
 * Las excepciones son objetos que se lanzan cuando ocurre un error en tiempo de
 * ejecución.
 *
 * @version 1.0.0
 */
public class ExceptionDemo {
    /**
     * Ejemplo de excepciones en Java.
     *
     * @param args Argumentos de la aplicación.
     */
    public static void main(String[] args) {
        String str = null; // Declaramos una variable de tipo String y la inicializamos con null
        int length = str.length(); // Intentamos obtener la longitud de la cadena
        System.out.println(length);
    }

}
