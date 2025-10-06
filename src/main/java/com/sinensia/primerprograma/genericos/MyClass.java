package com.sinensia.primerprograma.genericos;

/**
 * Simple clase de ejemplo.
 */

public class MyClass {
    private MyClass() {
        // Contructor privado para que no se pueda instanciar
    }

    public static <T> void myPrint(T value) {
        System.out.println(value);
    }

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
