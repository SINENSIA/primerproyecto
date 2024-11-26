package com.sinensia.primerprograma.excepciones;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Test para verificar que efectivamente obtenemos un NullPointerException si
 * intentamos acceder a un String nulo.
 */
public class ExceptionDemoTest {
    @Test
    public void main1() {
        String[] args = null;
        assertThrows(java.lang.NullPointerException.class, () -> {
            ExceptionDemo.main(args);
        });
    }
}
