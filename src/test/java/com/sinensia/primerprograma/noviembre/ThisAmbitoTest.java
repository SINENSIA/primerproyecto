package com.sinensia.primerprograma.noviembre;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la clase ThisAmbito.
 */
public class ThisAmbitoTest {
    @Test
    public void asignarValor() {
        ThisAmbito t = new ThisAmbito();
        int valor = 123;
        int expected = 123;
        int actual = t.asignarValor(valor);

        assertEquals(expected, actual);
    }
}
