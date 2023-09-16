package com.sinensia.primerprograma.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * /* Clase para demostrar los lambdas en java
 * /*
 **/
class LambdasDemo {

    public static void main(String[] args) {

        List<Integer> myEnteros = Arrays.asList(1, 2, 3, 4);

        // myEnteros.forEach((Integer value) -> System.out.println(value));
        // myEnteros.forEach(value -> System.out.println(value));
        // myEnteros.forEach(System.out::println);

        myEnteros.forEach(MyClass::myPrint);

        Double resultado = (double) myEnteros.stream().reduce(1, (a, b) -> a * b);
        System.out.println(resultado);

    }

}

class MyClass {
    public static <T> void myPrint(T value) {
        System.out.println(value);
    }
}

@FunctionalInterface
interface MyInterface {
    void myPrint(String value);
}
