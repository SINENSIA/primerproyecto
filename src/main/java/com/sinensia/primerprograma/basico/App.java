package com.sinensia.primerprograma.basico;

/**
 * <b>Punto de Entrada: Clase App</b>
 * <p>
 * Ejemplo simple de uso de la utilidad {@link java.lang.IO} nativa (Java 25)
 * para interactuar con el usuario.
 * </p>
 * 
 * @author Sinensia
 */
public class App {

    // Constructor privado para evitar instanciación de clase de utilidad
    private App() {
    }

    /**
     * Método principal que saluda al usuario tras preguntar su nombre.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        IO.println("Hola, bienvenido al programa.");
        String nombre = IO.readln("¿Cómo te llamas? ");
        IO.println("Encantado de conocerte, " + nombre);
    }
}
