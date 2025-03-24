package com.sinensia.primerprograma.ejercicios.cuentabancaria.helpers;

/**
 * Clase de utilidad para validaciones numéricas.
 */
public class ValidadorCantidad {

    private ValidadorCantidad() {
        // Constructor privado para evitar instanciación
    }

    /**
     * Valida que la cantidad sea un número positivo.
     *
     * @param cantidad Cantidad a validar.
     * @throws IllegalArgumentException Si la cantidad es negativa o NaN.
     */
    public static void validarCantidad(double cantidad) {
        if (Double.isNaN(cantidad) || cantidad < 0) {
            throw new IllegalArgumentException("Error: La cantidad debe ser un número positivo.");
        }
    }
}
