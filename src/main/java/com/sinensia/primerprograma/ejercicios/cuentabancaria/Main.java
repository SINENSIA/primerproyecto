package com.sinensia.primerprograma.ejercicios.cuentabancaria;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.sinensia.primerprograma.ejercicios.cuentabancaria.helpers.TextDecorator;
import com.sinensia.primerprograma.ejercicios.cuentabancaria.models.CuentaBancaria;

/**
 * Main para ceunta bancaria.
 */
public class Main {
  /**
   * main entrada.
   */
  public static void main(String[] args) {
    CuentaBancaria cuenta = new CuentaBancaria(100, "Carlos");
    Scanner scanner = new Scanner(System.in);

    int choice;
    do {
      mostrarMenu();
      choice = obtenerEntradaEntero(scanner);

      try {
        switch (choice) {
          case 1 -> { // Depositar
            System.out.print("Cantidad a depositar: ");
            double cantidad = obtenerEntradaDouble(scanner);
            cuenta.depositar(cantidad);
          }
          case 2 -> { // Cambiar titular
            scanner.nextLine(); // Consume newline
            System.out.print("Nuevo titular: ");
            String nuevoTitular = scanner.nextLine();
            cuenta.setTitular(nuevoTitular);
          }
          case 3 -> cuenta.mostrarInformacion(); // Mostrar información
          case 4 -> { // Retirar dinero
            System.out.print("Cantidad a retirar: ");
            double cantidad = obtenerEntradaDouble(scanner);
            cuenta.retirarConSaldoMinimo(cantidad);
          }
          case 0 -> System.out.println(TextDecorator.info("Saliendo del sistema..."));
          default -> System.out.println(TextDecorator.warning("Opción no válida."));
        }
      } catch (IllegalArgumentException e) {
        System.out.println(TextDecorator.error("Error: " + e.getMessage()));
      }
    } while (choice != 0);

    scanner.close();
  }

  private static void mostrarMenu() {
    System.out.println(TextDecorator.info("""
        Selecciona una operación bancaria:
        1. Depositar
        2. Cambiar titular
        3. Mostrar información
        4. Retirar efectivo
        0. Salir
        """));
  }

  private static int obtenerEntradaEntero(Scanner scanner) {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      scanner.nextLine(); // Limpiar entrada inválida
      System.out.println(TextDecorator.error("Entrada inválida. Ingresa un número."));
      return -1;
    }
  }

  private static double obtenerEntradaDouble(Scanner scanner) {
    while (!scanner.hasNextDouble()) {
      System.out.println(TextDecorator.error("Entrada inválida. Ingresa un número válido."));
      scanner.nextLine();
    }
    double valor = scanner.nextDouble();
    scanner.nextLine(); // Consumir salto de línea
    return valor;
  }
}
