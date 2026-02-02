package com.sinensia.primerprograma.poo.felinos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests.
 */
class PeluqueriaTest {
        @Test
        void testLimpiarCortar() {
                Gato felino = new Gato(2848284);
                Peluqueria<Felino> peluqueria = new Peluqueria<>(felino);

                assertEquals(Gato.class, felino.getClass(),
                                "El felino no es de la clase esperada (Gato).");
                assertTrue(felino instanceof Gato,
                                "El felino no es instancia de Gato.");
                assertDoesNotThrow(peluqueria::limpiarCortar,
                                "El método limpiarCortar lanzó una excepción inesperada.");
        }

}
