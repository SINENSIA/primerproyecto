package com.sinensia.primerprograma.ejercicios;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * clase para controlar una cuenta bancaria
 * admite depositos, retiros y cambio de titular.
 *
 * @version 1.0
 * @since 2023
 * 
 */

public class CuentaBancaria {
    private double saldo;
    private String titular;
    private static final double SALDO_MINIMO = 100.0; // Variable final y estática
    String greenColor = "\u001B[32m";
    String resetColor = "\u001B[0m";
    String redColor = "\u001B[31m";
    String blueColor = "\u001B[34m";

    // Constructor para inicializar la cuenta con saldo y titular
    public CuentaBancaria(double saldoInicial, String titular) {
        this.saldo = saldoInicial;
        this.titular = titular;
    }

    // Resto de métodos (depositar, retirar, obtenerSaldo, mostrarInformacion) ...

    // Método para verificar si la cuenta tiene saldo suficiente
    private boolean tieneSaldoSuficiente(double cantidad) {
        return saldo >= cantidad;
    }

    /**
     * Método para realizar un retiro con verificación de saldo mínimo.
     * Si el saldo es suficiente y el saldo mínimo no se alcanza, se realiza el
     * retiro.
     *
     * @param cantidad cantidad a retirar
     */

    public void retirarConSaldoMinimo(double cantidad) {
        if (tieneSaldoSuficiente(cantidad) && (saldo - cantidad) >= SALDO_MINIMO) {
            saldo -= cantidad;
            System.out.println("Retiro de " + cantidad + " realizado.");
        } else {
            System.out.println(
                    redColor + "--- Saldo insuficiente o saldo mínimo alcanzado. ---" + resetColor);
        }
    }

    /**
     * Método para depositar una cantidad en la cuenta.
     *
     * @param cantidad cantidad a depositar (double)
     */
    public void depositar(double cantidad) {

        saldo += cantidad;
        System.out.println(greenColor);
        System.out.println("Depósito de " + cantidad + " realizado.");
        System.out.println(resetColor);
    }

    /**
     * Método para mostrar la información de la cuenta.
     * Muestra el titular y el saldo.
     */
    public void mostrarInformacion() {

        System.out.println(greenColor);
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║   Información de la Cuenta    ║");
        System.out.println("╠═══════════════════════════════╣");
        System.out.println("║  Titular: " + titular + "      ");
        System.out.println("║  Saldo: " + saldo + " EUR      ");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println(resetColor);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        System.out.println("Cambiando titular de " + this.titular + " a " + titular);
        this.titular = titular;
    }

    /**
     * Método main para probar la clase CuentaBancaria.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Crear una instancia de CuentaBancaria
        CuentaBancaria cuenta = new CuentaBancaria(100, "Carlos");

        try (Scanner scanner = new Scanner(System.in)) { // try-with-resources
            // Realizar operaciones en la cuenta
            cuenta.mostrarInformacion();
            int choice = 0;
            do {
                // Solicitar al usuario que seleccione una forma
                System.out.println("Selecciona una operación bancaria:");
                System.out.println("1. Depositar");
                System.out.println("2. Cambiar titular");
                System.out.println("3. Mostrar información");
                System.out.println("4. Retirar efectivo");
                System.out.println("0. Salir");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir el carácter de nueva línea

                // Comprobar la elección del usuario y calcular el área correspondiente
                switch (choice) {
                    case 1:
                        // CDepositar en la cuenta
                        System.out.print("Cuánto desde depositar?: ");
                        double cantidad = scanner.nextDouble();
                        cuenta.depositar(cantidad);
                        break;
                    case 2:
                        // Cambiar titular
                        System.out.print("Indica el nuevo titular: ");
                        String nuevoTitular = scanner.nextLine();
                        cuenta.setTitular(nuevoTitular);
                        break;
                    case 3:
                        // Mostrar información
                        cuenta.mostrarInformacion();
                        break;
                    case 4:
                        // Retirar efectivo
                        System.out.print("Cuánto desde retirar?: ");
                        double cantidadRetirar = scanner.nextDouble();
                        cuenta.retirarConSaldoMinimo(cantidadRetirar);
                        break;
                    default:
                        System.out.println("Selección no válida.");
                        break;
                }
            } while (choice != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un valor válido.");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.out.println("Error: Fin de entrada inesperado.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error general.");
            e.printStackTrace();
        }
        // Cerrar el objeto Scanner

    }
}
