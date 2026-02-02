package com.sinensia.primerprograma.poo.interfaces;

public interface Navegable {

    // Constante para la conversión: 1 nudo es aproximadamente 1,85 km/h
    double FACTOR_CONVERSION_NUDOS_A_KMH = 1.852;

    // Método estático para convertir nudos a km/h
    static double nudosToKmh(double nudos) {
        return nudos * FACTOR_CONVERSION_NUDOS_A_KMH;
    }

    void navegar();
}
