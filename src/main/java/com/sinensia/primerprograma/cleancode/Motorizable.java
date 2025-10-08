package com.sinensia.primerprograma.cleancode;

interface Motorizable {
    Motor motor();

    default void arrancar() {
        motor().encender();
    }

    default void detener() {
        motor().encender();
    }
}
