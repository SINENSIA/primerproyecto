package com.sinensia.primerprograma.tipos;



public class OperacionableImpl implements Operacionable {

    @Override
    public int realizarSuma(Object a, Object b) {
        // autoboxing aunque pasemos un int, lo convierte a Integer
        try {
            if (a instanceof Integer && b instanceof Integer) {
                System.out.println((int) a + (int) b);
                return (int) a + (int) b;
            } else if (a instanceof String && b instanceof String) {
                return Integer.parseInt((String) a) + Integer.parseInt((String) b);
            } else {
                throw new UnsupportedOperationException("Tipo no soportado para operaciones");
            }
        } catch (NumberFormatException e) {
            // Devolvemos una excepción más acorde para que se propague
            throw new IllegalArgumentException("Error: Alguno de los valores no es un número", e);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error: Alguno de los valores no es un número");
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

    @Override
    public int realizarDivision(Object a, Object b) throws ArithmeticException, UnsupportedOperationException {

        if (a instanceof Integer && b instanceof Integer) {
            if ((int) b == 0) {
                throw new ArithmeticException("Tipo no soportado para operaciones");
            }
            return (int) a / (int) b;
        } else if (a instanceof String && b instanceof String) {
            return Integer.parseInt((String) a) / Integer.parseInt((String) b);
        } else {
            throw new UnsupportedOperationException("Tipo no soportado para operaciones");
        }
    }
}
