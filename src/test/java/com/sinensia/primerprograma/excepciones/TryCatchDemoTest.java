package com.sinensia.primerprograma.excepciones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

/**
 * Ejemplo try-catch.
 */
public class TryCatchDemoTest {
    @Test
    public void mainTest() {

        // Redirigir la salida estándar a un ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el método main
            TryCatchDemo.main(null);

            // Verificar la salida esperada
            String expectedOutput = String.join(System.lineSeparator(),
                    "Error: Cannot invoke \"String.length()\" because \"str\" is null",
                    "Esto siempre se ejecuta");

            String actualOutput = outContent.toString().replace("\r\n", "\n").trim();

            // Verificar
            assertEquals(expectedOutput, actualOutput);
        } finally {
            // Restaurar System.out después del test
            System.setOut(originalOut);
        }

    }
}
