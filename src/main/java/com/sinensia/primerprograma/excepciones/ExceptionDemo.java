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
     * Ejemplo de excepciones en Java. Suprimimos la advertencia de SonarLint
     * ya que es para mostrar un ejemplo de NullPointerException.
     *
     * @param args Argumentos de la aplicación.
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String str = null; // Declaramos una variable de tipo String y la inicializamos con null
        try {
            int length = str.length(); // Intentamos obtener la longitud de la cadena
            System.out.println(length);
        } catch (NullPointerException e) {
            System.out.println("El texto no puede estar vacío");
        }
    }

}
