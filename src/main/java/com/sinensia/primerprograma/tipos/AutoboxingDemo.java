package com.sinensia.primerprograma.tipos;

import java.util.ArrayList;

/**
 *
 * Ejemplo de autoboxing y unboxing en Java.
 */
public class AutoboxingDemo {

    /**
     * Método principal para demostrar el uso de autoboxing y unboxing en Java.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Autoboxing: el valor 10 (primitivo) se convierte automáticamente en un objeto
        // Integer
        Integer numero = 10;

        // Uso de colecciones (requieren objetos, no primitivos)
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5); // Autoboxing: el int 5 se convierte en Integer

        // Acceso al elemento (unboxing implícito)
        int valor = lista.get(0); // Unboxing: Integer -> int

        System.out.println("Número: " + numero); // Salida: Número: 10
        System.out.println("Valor de la lista: " + valor); // Salida: Valor de la lista: 5

        peligroEnvolventes();
    }

    public static void peligroEnvolventes() {

        Integer a = 128;
        int b = 128;
        System.out.println(a == b); // Salida: true. al comparar,
        // se produce un unboxing implícito de a a int. Por eso == devuelve true
        System.out.println(a.equals(b)); // Salida: true
        // En este caso se produce un autoboxing implícito de b a Integer.
        // NO Compila: System.out.println(b.equals(a)); // Sb es un primitivo y no tiene
        // equals()

        Integer c = 128;
        Integer d = 128;
        System.out.println("-- Ojo! 128 vs 128 fuera de la cache --");
        System.out.println(c == d); // Salida: false <------- !!!!!
        System.out.println("----Pero equals es la forma correcta:----");
        System.out.println(c.equals(d)); // Salida: true
        // En el segundo caso, el valor de a y d es el mismo, pero el objeto Integer
        // se crea en dos puntos distintos en la memoria, lo que provoca que la
        // comparación devuelve false.

        Integer e = 127;
        Integer f = 127;
        System.out.println("-- 127 es igual a 127? --");
        System.out.println(e == f); // Salida: true
        System.out.println(e.equals(f)); // Salida: true
        // En el primer caso, el valor de e y f es el mismo, pero el objeto Integer
        // debido a que el valor está dentro del rango de valores que puede ser
        // almacenado en un byte, se crea en el mismo punto en la memoria (caching), lo
        // que
        // provoca que la comparación devuelve true.

    }
}