package com.sinensia.primerprograma.excepciones;

/**
 * 
 * <p>
 * Esta clase sirve para demostrar las excepciones en Java.
 * </p>
 *
 * @author Sinensia
 */

public class ExceptionDemo2 {
    public static void main(String[] args) {
        String str = "Hola";
        try {

            int length = str.length();
            System.out.println(length);

        } catch (NullPointerException e) {
            System.out.println("La cadena de texto está vacía");

        } finally {

            System.out.println("Esto siempre se ejecuta");
        }
    }
}
