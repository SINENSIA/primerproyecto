package com.sinensia.primerprograma;

/**
 * Hello world!.
 *
 */
public class App {
    // Private constructor to prevent instantiation
    private App() {
    }

    /**
     * Método main para probar la clase App.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        IO.println("Hi");
        String resp = IO.readln("Como te llamas\n");
        IO.println(String.format("Hola %s", resp));
    }

}
