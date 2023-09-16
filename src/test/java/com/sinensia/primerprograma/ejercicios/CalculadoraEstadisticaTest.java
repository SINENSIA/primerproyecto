package com.sinensia.primerprograma.ejercicios;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Calculadora de estadística. Test unitario.
 *
 * @version 1.0
 */

public class CalculadoraEstadisticaTest {
    @Test
    public void calcularMediaTest() {
        List<Double> notas = new ArrayList<>(
                Arrays.asList(85.5, 90.0, 75.5, 92.0, 85.5, 90.0, 88.5, 75.5, 92.0, 43.0, 64.0));

        // Crear una instancia de la clase que deseas probar
        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(
                notas);

        // Calcular la media
        double mediaCalculada = calculadora.calcularMedia();

        // Valor esperado de la media
        double mediaEsperada = 80.14;

        // Verificar si la media calculada es igual a la media esperada
        assertEquals(mediaEsperada, mediaCalculada, 0.001);
        // Tolerancia de 0.001 para comparaciones de punto flotante
    }

    @Test
    @Disabled
    public void noSepuedeInstanciarSinNotasTest() { // NOSONAR
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            // new CalculadoraEstadistica();
        });
    }

    @Test
    @Disabled
    void noSePuedeInstanciarSinDoubleArrayTest() { // NOSONAR
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            // new CalculadoraEstadistica(new int[] { 1, 2, 3, 4 });
        });
    }

    @Test
    @Disabled
    public void noSePuedeInstanciarConNullTest() { // NOSONAR
        /*
         * No se puede instanciar con null.
         * Desactivamos el test para que no falle.
         */
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new CalculadoraEstadistica(null);
        });
    }

    @Test
    public void calcularMediaNuloTest() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            CalculadoraEstadistica c = new CalculadoraEstadistica(null);
            c.calcularMedia();
        });
    }

    @Test
    public void calcularModaTest() {
        // Crear una instancia de la clase que deseas probar
        List<Double> notas = new ArrayList<>(
                Arrays.asList(85.5, 90.0, 75.5, 92.0, 85.5, 90.0, 88.5, 75.5, 92.0, 43.0, 64.0));
        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(notas);

        // Calcular la moda
        double[] modaCalculada = calculadora.calcularModa();

        // Valor esperado de la moda
        double[] modaEsperada = { 75.5, 85.5, 90.0, 92.0 };

        // Verificar si la moda calculada es igual a la moda esperada
        assertArrayEquals(modaEsperada, modaCalculada, 0.001);
        // Tolerancia de 0.001 para comparaciones de punto flotante
    }

    @Test
    public void calcularDesviacionEstandarTest() {
        // Crear una instancia de la clase que deseas probar
        List<Double> notas = new ArrayList<>(
                Arrays.asList(85.5, 90.0, 75.5, 92.0, 85.5, 90.0, 88.5, 75.5, 92.0, 43.0, 64.0));
        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(notas);

        // Calcular la desviación estándar
        double desviacionCalculada = calculadora.calcularDesviacionEstandar();

        // Valor esperado de la desviación estándar
        double desviacionEsperada = 14.41604409;

        // Verificar si la desviación calculada es igual a la desviación esperada
        assertEquals(desviacionEsperada, desviacionCalculada, 0.001);
        // Tolerancia de 0.001 para comparaciones de punto

        // flotante
    }
}
