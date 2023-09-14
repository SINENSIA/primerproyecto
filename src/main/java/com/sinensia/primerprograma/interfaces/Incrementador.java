package com.sinensia.primerprograma.interfaces;

/**
 * Esta interfaz es funcional porque tiene un único método abstracto
 * (incrementar)
 */
@FunctionalInterface
public interface Incrementador {
    int incrementar(int a);
}
