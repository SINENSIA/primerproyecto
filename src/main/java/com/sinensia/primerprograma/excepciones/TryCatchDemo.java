package com.sinensia.primerprograma.excepciones;

public class TryCatchDemo {

    public static void main(String[] args) {
        String str = null; // Declaramos una variable de tipo String y la inicializamos con null
        try {
            int length = str.length(); // Intentamos obtener la longitud de la cadena
            System.out.println(length);
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error genérico: " + e.getMessage());
        } finally {
            // Este bloque se ejecutará independientemente de si se lanzó una excepción o no
            System.out.println("Esto siempre se ejecuta");
        }
    }

}
