package com.sinensia.primerprograma.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.junit.jupiter.api.*;

/**
 * Pruebas unitarias para la clase CalculadoraArea.
 *
 * @version 1.0
 * @since 2023
 * @see com.sinensia.primerprograma.ejercicios.CalculadoraArea
 */
class CalculadoraAreaTest {
    @Test
    void pruebaManejoDeExcepcion() {
        // Simular una entrada no numérica en el Scanner
        String entradaNoNumerica = "Hola, no es un número\n5\n";

        // Redirigir la entrada estándar para simular la entrada del usuario
        System.setIn(new ByteArrayInputStream(entradaNoNumerica.getBytes()));

        Scanner scanner = new Scanner(System.in);

        // Intenta leer un número, debería generar una excepción InputMismatchException
        assertThrows(InputMismatchException.class, () -> {
            CalculadoraArea.leerDesdeScanner(scanner);
        });

        // Restablece la entrada estándar
        System.setIn(System.in);
    }

    @Test
    void simularEntradaNumerica() {
        String entrada = "5.0\n10.0\n";
        InputStream inputStream = new ByteArrayInputStream(entrada.getBytes());
        System.setIn(inputStream);

        Scanner scanner = new Scanner(System.in);
        CalculadoraArea.leerDesdeScanner(scanner);

    }
}
