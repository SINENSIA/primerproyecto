package com.sinensia.primerprograma.ejercicios;

/**
 * Clase Contador que demuestra el uso de variables globales y locales.
 * Permite incrementar contadores individuales y rastrear el total de contadores
 * creados.
 * 
 */
public class Contador {
    /** Variable estática para contar el número total de instancias creadas. */
    private static int totalContadores = 0;

    /** Variable local para rastrear el valor individual del contador. */
    private int valor;

    /**
     * Constructor que incrementa el contador global al crear una nueva instancia.
     */
    public Contador() {
        totalContadores++;
    }

    /**
     * Incrementa el valor del contador individual.
     */
    public void incrementar() {
        valor++;
    }

    /**
     * Muestra el número total de contadores y el valor actual del contador
     * individual.
     */
    public void mostrarValores() {
        System.out.println("Total contadores: " + totalContadores);
        System.out.println("Contador actual: " + valor);
    }

    /**
     * Método principal para probar la clase Contador.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        Contador contador1 = new Contador();
        Contador contador2 = new Contador();

        for (int i = 0; i < 5; i++) {
            contador1.incrementar();
        }
        for (int i = 0; i < 3; i++) {
            contador2.incrementar();
        }

        contador1.mostrarValores();
        contador2.mostrarValores();
    }
}
