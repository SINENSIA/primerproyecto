package com.sinensia.primerprograma.basico.repaso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test para la clase Contador.
 * 
 */
public class ContadorTest {
    @BeforeEach
    public void resetearContadores() {
        Contador.totalContadores = 0; // Reiniciar el contador estático antes de cada test
    }

    @Test
    @SuppressWarnings("unused")
    public void totalContadoresTest() {
        Contador contador1 = new Contador();
        Contador contador2 = new Contador();
        final int expected = 2;
        int actual = Contador.totalContadores;

        assertEquals(expected, actual);
    }

    @Test
    public void contadorLocalTest() {
        Contador contador = new Contador();
        contador.incrementarContador();
        contador.incrementarContador();
        int actual = contador.incrementarContador();

        final int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void mostrarValoresTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Contador contador1 = new Contador();
        contador1.incrementarContador();
        contador1.incrementarContador();
        contador1.incrementarContador();
        contador1.mostrarValores();

        Contador contador2 = new Contador();
        contador2.incrementarContador();
        contador2.incrementarContador();
        contador2.mostrarValores();
        // Verificar la salida esperada
        String expectedOutput = """
                Total Contadores: 1
                Contador: 3
                Total Contadores: 2
                Contador: 2
                """;

        String actualOutput = outContent.toString().replace("\r\n", "\n").trim();

        // Verificar
        assertEquals(expectedOutput.trim(), actualOutput);

        // Restaurar System.out después del test
        System.setOut(System.out);
    }
}
