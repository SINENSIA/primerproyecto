package com.sinensia.primerprograma.noviembre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase AmbitoVariable.java
 */
public class AmbitoVariableTest {
    @Test
    public void metodoAmbito() {
        int expected = 7;
        int actual = AmbitoVariable.metodoAmbito();

        assertEquals(expected, actual);
    }

    @Test
    public void variableGlobalTest() {
        int expected = 10;
        int actual = AmbitoVariable.variableGlobal;

        assertEquals(expected, actual);
    }

    @Test
    public void main() {

        // Redirigir la salida estándar a un ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutar el método main
        AmbitoVariable.main(null);

        // Restaurar System.out después del test
        System.setOut(System.out);

        // Verificar la salida esperada
        String expectedOutput = """
                30
                20
                10
                7
                """;

        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();

        // Verificar
        assertEquals(expectedOutput.trim(), actualOutput);
    }

}
