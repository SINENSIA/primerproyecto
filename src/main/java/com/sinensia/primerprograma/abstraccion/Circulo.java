package com.sinensia.primerprograma.abstraccion;

import java.util.logging.Logger;

public class Circulo extends Forma {
    private double radio; // caja fuerte en el salón de la clase
    double radioMinimo = 0.1; // Sin modificador de acceso, es package (urbanización)
    private static final Logger LOGGER = Logger.getLogger(Forma.class
            .getClass().getName());

    public Circulo(double radio) {
        String mensaje = "Creando círculo de radio " + radio; // Caja fuerte en la habitación
        LOGGER.info(mensaje);
        this.radio = radio;
    }

    // Implementación del método abstracto
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

}