package com.sinensia.primerprograma.excepciones;

/**
 * Ejemplo de uso de throws.
 * 
 */
public class ThrowsDemo {
    /**
     * Ejemplo de uso de throws.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        try {
            calculateStringLength();
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Causa: " + e.getCause());
            System.err.println("toString: " + e.toString());
        }
    }

    /**
     * Calcula la longitud de una cadena.
     * Ejemplo de uso de throws.
     * Desactivamos el tratamiento de la excepción para que se propague.
     * SuppressWarnings("null") para evitar el warning de NullPointerException
     * ya que es para demostración
     *
     * @throws NullPointerException si la cadena es null
     * 
     */
    @SuppressWarnings("null")
    public static void calculateStringLength() throws NullPointerException {
        String str = null; // Declaramos una variable de tipo String y la inicializamos con null
        int length = str.length(); // Intentamos obtener la longitud de la cadena
        System.out.println(length);
    }
}
