package com.sinensia.primerprograma.funcional.lambdas;

import com.sinensia.primerprograma.colecciones.genericos.MyClass;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para demostrar los lambdas en java.
 * suprimimos el warning de codigo comentado
 * ya que es para ejemplos
 */
class LambdasDemo {
    @SuppressWarnings("java:S125")
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
