package com.sinensia.primerprograma.basico.sobrecarga;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    @Test
    public void suma2() {
        Calculadora c = new Calculadora(0, 0);
        int x = 1;
        int y = 2147483647; // EL valor máximo de un int
        /**
         * 
         * intentas sumar 1 a 2147483647, el resultado debería ser 2147483648. Sin
         * embargo, este valor excede el límite superior del tipo int en Java.
         * Cuando esto sucede, el valor se "desborda" y pasa al límite inferior, en este
         * caso, -2147483648. Este comportamiento es un ejemplo de
         * "aritmética modular" y es específico de cómo Java (y muchos otros lenguajes
         * de programación) manejan el desbordamiento de enteros.
         * Así que, en este caso de prueba, el valor expected está configurado para ser
         * -2147483648 porque se espera que ocurra un desbordamiento cuando sumas 1 y
         * 2147483647.
         * 
         */
        int expected = -2147483648;
        int actual = c.suma(x, y);

        assertEquals(expected, actual);
    }

    @Test
    public void devolverValorEntero() {
        Calculadora c = new Calculadora(0, 0);
        int x = 0;
        String actual = c.devolverValor(x);
        String expected = "Entero: 0";

        assertEquals(expected, actual);

    }

    @Test
    public void devolverValorDecimal() {
        Calculadora c = new Calculadora(0, 0);
        double x = 5.0;
        String actual = c.devolverValor(x);
        String expected = "Decimal: 5.0";

        assertEquals(expected, actual);

    }

    @Test
    public void devolverValorFloat() {

        // En este caso de prueba, el valor x está configurado para ser float
        // Debido a la promoción de tipos, el método devolverValor(float x) devolverá
        // un valord decimal
        Calculadora c = new Calculadora(0, 0);
        float x = 5.0f;
        String actual = c.devolverValor(x);
        String expected = "Decimal: 5.0";

        assertEquals(expected, actual);

    }

    @Test
    public void sumaNaN() {
        Calculadora c = new Calculadora(0, 0);
        double x = Double.NaN;
        double y = Double.NaN;
        double expected = Double.NaN;
        double actual = c.suma(x, y);

        assertEquals(expected, actual, 0.0000001D);
    }

}
