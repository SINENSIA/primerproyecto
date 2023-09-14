package com.sinensia.primerprograma.tipos;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class NoPrimitivosTest {
    @Test
    public void realizarDivisionDecimal() {
        Integer a = 10;
        Integer b = 20;

        NoPrimitivos n = new NoPrimitivos(a, b);
        int expected = 0;
        int actual = n.realizarDivision();

        assertEquals(expected, actual);
    }

    @Test
    public void realizarSumaNoNumerica() {
        String a = "10T"; // No es numérico
        String b = "20";

        NoPrimitivos n = new NoPrimitivos(a, b);
        assertThrows(IllegalArgumentException.class, () -> {
            n.realizarSuma();
        });
    }

    @Test
    public void realizarDivisionPorCero() {
        Integer a = 10;
        Integer b = 0;

        NoPrimitivos n = new NoPrimitivos(a, b);
        assertThrows(ArithmeticException.class, () -> {
            n.realizarDivision();
        });

    }

    @Test
    public void integerOutOfRange() {
        int a = Integer.MAX_VALUE + 1;
        int b = Integer.MAX_VALUE - 1;

        int expected = -2; // desbordamiento silencioso
        NoPrimitivos n = new NoPrimitivos(a, b);
        int actual = n.realizarSuma();
        assertEquals(expected, actual);

    }

    @Test
    public void sumar() {
        int a = 12;
        int b = 27;

        int expected = 39;

        NoPrimitivos n = new NoPrimitivos(a, b);
        int actual = n.realizarSuma();

        assertEquals(expected, actual);
    }
}
