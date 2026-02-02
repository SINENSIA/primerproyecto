package com.sinensia.primerprograma.excepciones;

/**
 * Ejemplo de uso de try-catch.
 * 
 */
public class TryCatchDemo {

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
    public static void main(String[] args) {
        String str = null; // Declaramos una variable de tipo String y la inicializamos con null
        try {
            int length = str.length(); // Intentamos obtener la longitud de la cadena
            System.out.println(length);
        } catch (NullPointerException e) {
            System.out.print("Error: " + e.getMessage() + "\r" + System.lineSeparator());
        } catch (Exception e) {
            System.out.print("Error genérico: " + e.getMessage() + "\r" + System.lineSeparator());
        } finally {
            // Este bloque se ejecutará independientemente de si se lanzó una excepción o no
            System.out.print("Esto siempre se ejecuta");
        }
    }

}
