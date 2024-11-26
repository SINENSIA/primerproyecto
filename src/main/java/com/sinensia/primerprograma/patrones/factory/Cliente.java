package com.sinensia.primerprograma.patrones.factory;

/**
 * Clase Cliente que demuestra el uso del patrón Factory.
 * Esta clase contiene el punto de entrada principal de la aplicación.
 */
public class Cliente {
    /**
     * El punto de entrada principal de la aplicación.
     * Este método demuestra el uso del patrón Factory creando
     * diferentes tipos de concesionarios y procesando ventas.
     *
     * @param args Un array de argumentos de línea de comandos pasados al programa.
     *             Este programa no utiliza ningún argumento de línea de comandos.
     */
    public static void main(String[] args) {
        Concesionario concesionario = new ConcesionarioCoches();
        concesionario.procesarVenta(); // "Este es un coche."

        concesionario = new ConcesionarioBarcos();
        concesionario.procesarVenta(); // "Este es un barco."
    }
}
