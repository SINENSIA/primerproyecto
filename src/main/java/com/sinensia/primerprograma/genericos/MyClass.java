package com.sinensia.primerprograma.genericos;

/**
 * Simple clase de ejemplo.
 */

public class MyClass {
    /**
     * Prevents instantiation of this utility class.
     */
    private MyClass() {
        // Contructor privado para que no se pueda instanciar
    }

    /**
     * Prints the provided value using its string representation.
     *
     * @param value element to print
     */
    public static <T> void myPrint(T value) {
        System.out.println(value);
    }

    /**
     * Entry point that demonstrates generic printing examples.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Perro miperro = new Perro("Lassie");

        System.out.println("-----------------------------------");
        myPrint(miperro);
        myPrint("Hola Mundo");
        myPrint(42);
        myPrint(3.14159);
        System.out.println("-----------------------------------");
    }

}

