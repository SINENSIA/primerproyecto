package com.sinensia.primerprograma.ejercicios;

import java.util.Scanner;

/**
 * Clase Operaciones que realiza cálculos básicos con números enteros.
 */
public class OperacionesPrimitivos {
    /**
     * Método principal para leer dos números y realizar operaciones básicas.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int b = scanner.nextInt();

        System.out.println("Suma: " + (a + b));
        System.out.println("Diferencia: " + (a - b));
        System.out.println("Producto: " + (a * b));
        System.out.println("División: " + (a / b));
        System.out.println("Resto: " + (a % b));

        scanner.close();
    }
}
