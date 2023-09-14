package com.sinensia.primerprograma.ejercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        // Crear una instancia de la clase que deseas probar
        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(
                new double[] { 3.0, 4.0, 5.0, 6.0, 7.0 });

        // Calcular la media
        double mediaCalculada = calculadora.calcularMedia();

        // Valor esperado de la media
        double mediaEsperada = 5.0;

        // Verificar si la media calculada es igual a la media esperada
        assertEquals(mediaEsperada, mediaCalculada, 0.001);
        // Tolerancia de 0.001 para comparaciones de punto flotante
    }

    @Test
    @Disabled
    public void noSepuedeInstanciarSinNotasTest() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            // new CalculadoraEstadistica();
        });
    }

    @Test
    @Disabled
    void noSePuedeInstanciarSinDoubleArrayTest() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            // new CalculadoraEstadistica(new int[] { 1, 2, 3, 4 });
        });
    }

    @Test
    @Disabled
    public void noSePuedeInstanciarConNullTest() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> {
            new CalculadoraEstadistica(null);
        });
    }

    @Test
    public void calcularMediaNuloTest() {
        CalculadoraEstadistica c = new CalculadoraEstadistica(null);
        assertThrows(java.lang.NullPointerException.class, () -> {
            c.calcularMedia();
        });
    }

    @Test
    public void calcularModaTest() {
        // Crear una instancia de la clase que deseas probar
        double[] datos = { 3.0, 4.0, 4.0, 5.0, 6.0, 7.0 };
        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(datos);

        // Calcular la moda
        double modaCalculada = calculadora.calcularModa();

        // Valor esperado de la moda
        double modaEsperada = 4.0;

        // Verificar si la moda calculada es igual a la moda esperada
        assertEquals(modaEsperada, modaCalculada, 0.001);
        // Tolerancia de 0.001 para comparaciones de punto flotante
    }

    @Test
    public void calcularDesviacionEstandarTest() {
        // Crear una instancia de la clase que deseas probar
        double[] datos = { 3.0, 4.0, 5.0, 6.0, 7.0 };
        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(datos);

        // Calcular la desviación estándar
        double desviacionCalculada = calculadora.calcularDesviacionEstandar();

        // Valor esperado de la desviación estándar
        double desviacionEsperada = 1.414;

        // Verificar si la desviación calculada es igual a la desviación esperada
        assertEquals(desviacionEsperada, desviacionCalculada, 0.001);
        // Tolerancia de 0.001 para comparaciones de punto

        // flotante
    }
}
