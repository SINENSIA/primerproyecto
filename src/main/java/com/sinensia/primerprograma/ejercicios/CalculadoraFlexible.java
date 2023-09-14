package com.sinensia.primerprograma.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 2: Calculadora flexible.
 * Crea un programa que calcule el área de un rectángulo o un triángulo.
 */
public class CalculadoraFlexible {

    /**
     * Método main para probar la clase CalculadoraFlexible.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        // Crear un objeto Scanner para obtener la entrada del usuario
        try (Scanner scanner = new Scanner(System.in)) {

            // Solicitar al usuario que seleccione una forma
            System.out.println("Selecciona una forma geométrica:");
            System.out.println("1. Rectángulo");
            System.out.println("2. Triángulo");
            int choice = scanner.nextInt();

            double area = 0.0; // Inicializar el área

            // Comprobar la elección del usuario y calcular el área correspondiente
            switch (choice) {
                case 1:
                    // Calcular el área de un rectángulo
                    System.out.print("Indica el ancho del rectángulo: ");
                    double width = scanner.nextDouble();
                    System.out.print("Indica la altura del rectángulo: ");
                    double height = scanner.nextDouble();
                    area = width * height;
                    break;
                case 2:
                    // Calcular el área de un triángulo
                    System.out.print("Indica la base del triángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Indica la altura del triángulo: ");
                    double triangleHeight = scanner.nextDouble();
                    area = 0.5 * base * triangleHeight;
                    break;
                default:
                    System.out.println("Selección no válida.");
                    break;
            }

            // Mostrar el área calculada
            System.out.println("El área es: " + area);

        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Argumento no válido.");
            // e.printStackTrace();
        }
    }
}
