package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Implementación de Operacionable</b>
 * <p>
 * Esta clase implementa la lógica para realizar operaciones matemáticas
 * sobre objetos de tipo {@code Integer} o {@code String}.
 * Demuestra el uso de {@code instanceof} y el manejo de excepciones.
 * </p>
 * 
 * @author Sinensia
 */
public class OperacionableImpl implements Operacionable {

    /**
     * Suma dos objetos. Si son Strings, intenta convertirlos a enteros.
     * 
     * @param a Primer operando
     * @param b Segundo operando
     * @return La suma de a y b
     * @throws IllegalArgumentException si los objetos no son numéricos
     */
    @Override
    public int realizarSuma(Object a, Object b) {
        // Gracias al Autoboxing, Java convierte automáticamente primitives a Objects
        try {
            if (a instanceof Integer && b instanceof Integer) {
                return (int) a + (int) b;
            } else if (a instanceof String && b instanceof String) {
                return Integer.parseInt((String) a) + Integer.parseInt((String) b);
            } else {
                throw new UnsupportedOperationException("Tipo no soportado para operaciones");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Alguno de los valores no es un número", e);
        }
    }

    @Override
    public int realizarResta(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (int) a - (int) b;
        } else if (a instanceof String && b instanceof String) {
            return Integer.parseInt((String) a) - Integer.parseInt((String) b);
        } else {
            throw new UnsupportedOperationException("Tipo no soportado para operaciones");
        }
    }

    @Override
    public int realizarMultiplicacion(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return (int) a * (int) b;
        } else if (a instanceof String && b instanceof String) {
            return Integer.parseInt((String) a) * Integer.parseInt((String) b);
        } else {
            throw new UnsupportedOperationException("Tipo no soportado para operaciones");
        }
    }

    /**
     * Realiza la división manejando la división por cero.
     * 
     * @throws ArithmeticException si el divisor es 0
     */
    @Override
    public int realizarDivision(Object a, Object b) throws ArithmeticException, UnsupportedOperationException {
        if (a instanceof Integer && b instanceof Integer) {
            if ((int) b == 0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }
            return (int) a / (int) b;
        } else if (a instanceof String && b instanceof String) {
            int valB = Integer.parseInt((String) b);
            if (valB == 0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }
            return Integer.parseInt((String) a) / valB;
        } else {
            throw new UnsupportedOperationException("Tipo no soportado para operaciones");
        }
    }
}
