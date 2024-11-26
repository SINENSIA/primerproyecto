package com.sinensia.primerprograma.ejercicios;

/**
 * Clase Tipos que demuestra la diferencia entre tipos primitivos y objetos.
 */
public class PrimitivosReferencia {
    /**
     * Modifica un número entero y un objeto StringBuilder.
     *
     * @param numero Número entero a modificar.
     * @param texto  StringBuilder cuyo contenido será modificado.
     */
    public static void modificar(int numero, StringBuilder texto) {
        numero += 5;
        texto.append(" mundo!");
    }

    /**
     * Método principal para demostrar cómo los primitivos y objetos se comportan en
     * métodos.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        int numero = 10;
        StringBuilder texto = new StringBuilder("Hola,");

        modificar(numero, texto);

        System.out.println("Número después del método: " + numero);
        System.out.println("Texto después del método: " + texto);
    }
}