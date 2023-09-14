package com.sinensia.primerprograma.excepciones;

public class ThrowsDemo {

    public static void main(String[] args) {
        try {
            calculateStringLength();
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Causa: " + e.getCause());
            System.err.println("toString: " + e.toString());
        }
    }

    public static void calculateStringLength() throws NullPointerException {
        String str = null; // Declaramos una variable de tipo String y la inicializamos con null
        int length = str.length(); // Intentamos obtener la longitud de la cadena
        System.out.println(length);
    }
}
