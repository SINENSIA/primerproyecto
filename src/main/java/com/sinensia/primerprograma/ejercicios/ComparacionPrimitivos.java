package com.sinensia.primerprograma.ejercicios;

import java.util.Scanner;

/**
 * Clase Comparacion que compara dos números de punto flotante.
 */
public class ComparacionPrimitivos {
    /**
     * Método principal que lee dos números de punto flotante e informa su relación.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble(); // EL problema es que al comparar double con float la 
        //precisión no es la misma y por tanto no ees

        System.out.print("Ingrese el segundo número: ");
        float num2 = scanner.nextFloat();
        if (num1 == num2) {
            System.out.println(num1);
            System.out.println(num2);
            System.out.println("Parecen iguales");
        } else {
            System.out.println(num1);
            System.out.println(num2);
            System.out.println("No Parecen iguales");
        }
        if (Math.abs(num1 - num2) < 0.0001) {
            System.out.println("Son iguales.");
        } else if (num1 > num2) {
            System.out.println("El primer número es mayor.");
        } else {
            System.out.println("El segundo número es mayor.");
        }

        scanner.close();
    }
}
