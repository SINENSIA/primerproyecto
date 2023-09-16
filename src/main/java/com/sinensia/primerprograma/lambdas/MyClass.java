package com.sinensia.primerprograma.lambdas;

/**
 * Simple clase de ejemplo.
 */
class MyClass {
    private MyClass() {
        // Contructor privado para que no se pueda instanciar
    }

    public static <T> void myPrint(T value) {
        System.out.println(value);
    }
}
