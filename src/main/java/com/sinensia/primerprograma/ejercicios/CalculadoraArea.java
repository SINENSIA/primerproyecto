package com.sinensia.primerprograma.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ejercicio 1: Calculadora de área.
 * Crea un programa que calcule el área de un rectángulo.
 * El programa solicitará al usuario el ancho y la altura del rectángulo.
 * El área se calculará multiplicando el ancho por la altura.
 * El programa mostrará el área calculada.
 *
 * @version 1.0
 * @since 2023
 */
public class CalculadoraArea {
    /**
     * Método main para probar la clase CalculadoraArea.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        // Crear un objeto Scanner para obtener la entrada del usuario
        try (Scanner scanner = new Scanner(System.in)) { // try-with-resources
            // Solicitar al usuario el ancho del rectángulo
            System.out.print("Indica el ancho del rectángulo: ");
            double width = leerDesdeScanner(scanner);

            // Solicitar al usuario la altura del rectángulo
            System.out.print("Ingresa la altura del rectángulo: ");
            double height = leerDesdeScanner(scanner);

            // Calcular el área del rectángulo
            double area = width * height;

            // Mostrar el área calculada
            System.out.println("El área del rectángulo es: " + area);

        } catch (InputMismatchException e) {
            System.out.println("Valor incorrecto.");
            e.printStackTrace(); // esto para el ejericio vale pero si no al logger interno.
        }
        //  lo demas es un bug
    }

    static double leerDesdeScanner(Scanner scanner) {
        // Aseguramos un locale consistente para números con punto decimal.
        return scanner.useLocale(java.util.Locale.US).nextDouble();
    }

}
