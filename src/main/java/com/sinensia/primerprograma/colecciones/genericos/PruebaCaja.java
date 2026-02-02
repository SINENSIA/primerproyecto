package com.sinensia.primerprograma.colecciones.genericos;

/**
 * Clase de prueba para la clase Caja.
 */
public class PruebaCaja {
    /**
     * Método principal de la clase.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        System.out.println("-----------------------------------");
        Caja<String> cajaTexto = new Caja<>("Hola Mundo"); // String
        cajaTexto.imprimirTipo();

        Caja<Integer> cajaNumero = new Caja<>(42); // Integer
        cajaNumero.imprimirTipo();

        Caja<Perro> cajaPerro = new Caja<>(new Perro("Lassie")); // Perro
        cajaPerro.imprimirTipo();

        System.out.println("Contenido de cajaTexto: " + cajaTexto.getContenido());
        System.out.println("Contenido de cajaNumero: " + cajaNumero.getContenido());
        System.out.println("Contenido de cajaPerro: " + cajaPerro.getContenido());
    }
}
