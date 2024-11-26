package com.sinensia.primerprograma.tipos;

public class Tipos {
    /**
     * Realiza una operación personalizada con valores float.
     * Demuestra el uso de diferentes tipos de datos y la inferencia de tipos con
     * 'var'.
     *
     * @param x Primer valor float
     * @param y Segundo valor float
     * @return El resultado de la operación personalizada
     */
    public double customOperation(float x, float y) {
        var i = getValueOperation();

        float a = 10f; // a se infiere como float
        double b = 10.0; // b se infiere como double
        double c = 10d; // c también se infiere como double
        long d = 10L; // d se infiere como long
        int e = 10; // e se infiere como int

        var j = a + b + c + d + e; // j se infiere como double
        return x + y + i + j;
    }

    /**
     * Realiza una operación personalizada con valores enteros.
     * Demuestra el uso problemático de 'var' y la conversión de tipos.
     *
     * @param x Primer valor entero
     * @param y Segundo valor entero
     * @return El resultado de la operación personalizada
     */
    public int customOperation(int x, int y) {
        var i = getValueOperation();

        return x + y + (int) i; // Fixed: Removed explicit casting
    }

    /**
     * Obtiene un valor de operación predefinido.
     *
     * @return Un valor float constante de 10
     */
    public float getValueOperation() {
        return 10;
    }

    /**
     * Demuestra una conversión de tipo de ampliación (widening) simple.
     * Convierte un int a double sin pérdida de precisión.
     *
     * @return El valor convertido a double
     */
    public double wideningSimple() {
        int i = 100;
        /*
         * i es inmutable pero su valor no lo es
         * por ejemplo
         * i = (double) i; // error de compilación Cannot convert from double to int
         */

        double d = (double) i; // 100.0
        // Tambien se puede hacer double d = i; Java maneja la conversión implícita
        return d;
    }

    /**
     * Demuestra una conversión de tipo de reducción (narrowing) simple.
     * Convierte un double a int, lo que puede resultar en pérdida de precisión.
     *
     * @return El valor convertido a int y luego a double
     */
    public double narrowingSimple() {
        double i = 100;
        /*
         * i es inmutable pero su valor no lo es
         * por ejemplo
         * i = (int) i; // OJO! aquí i seguirá siendo double, pero su valor será
         * convertido a int y luego de nuevo a double
         */

        int d = (int) i; // 100
        // En este caso no se puede hacer int d = i; Java no maneja la conversión
        // implícita
        return d;
    }

    /**
     * Demuestra una serie de conversiones de tipo de ampliación (widening).
     * Convierte un valor a través de tipos cada vez más grandes sin pérdida de
     * precisión.
     *
     * @return El valor final convertido a double
     */
    public double wideningDemo() {
        byte a = 4;
        short b = a;
        int c = b;
        long d = c;
        float e = d;
        double f = e;

        return f; // valdrá 4.0 no se pierde precisión
    }

    /**
     * Demuestra una serie de conversiones de tipo de reducción (narrowing).
     * Convierte un valor a través de tipos cada vez más pequeños,
     * potencialmente con pérdida de precisión.
     *
     * @return El valor final convertido a byte
     */
    public double narrowingDemo() {
        double a = 4;
        float b = (float) a;
        long c = (long) b;
        int d = (int) c;
        short e = (short) d;
        byte f = (byte) e;

        /**
         * valdrá 4 no se pierde precisión
         * /* gracias a que 4 es un valor posible en cada tipo
         * /* de dato, pero si el valor de a fuera 4.5, entonces
         * /* el valor de f sería 4, se perdería precisión
         */
        return f;
    }

    /**
     * Demuestra los posibles errores y la pérdida de precisión que pueden ocurrir
     * durante las conversiones de tipo de reducción (narrowing).
     * Este método comienza con el valor máximo de un double y lo reduce
     * sucesivamente a tipos de datos más pequeños, mostrando cómo cambia el valor y
     * se pierde
     * precisión en cada paso.
     * 
     * La cadena de conversión es la siguiente:
     * double -> float -> long -> int -> short -> byte
     *
     * @return Un valor byte, que es el resultado de todas las conversiones de
     *         reducción.
     *         Debido a las conversiones de valores extremos, siempre devolverá -1.
     *
     * @throws ArithmeticException Implícitamente, si alguna de las conversiones
     *                             causa un desbordamiento aritmético. Sin embargo,
     *                             en la
     *                             práctica, esta excepción no se lanza debido a
     *                             cómo Java
     *                             maneja estas conversiones.
     *
     * @see Double#MAX_VALUE
     * @see Float#MAX_VALUE
     * @see Long#MAX_VALUE
     */
    public double narrowingDemoError() {
        double a = Double.MAX_VALUE; // 1.7976931348623157E308
        System.out.println("Double: " + a);

        float b = (float) a; // Infinity
        System.out.println("Float: " + b);
        System.out.println("Float.MAX_VALUE: " + Float.MAX_VALUE);

        long c = (long) b; // 9223372036854775807
        System.out.println("Long: " + c);
        System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);

        int d = (int) c; // -1
        System.out.println("Int: " + d);

        short e = (short) d; // -1
        System.out.println("Short: " + e);

        byte f = (byte) e; // -1
        System.out.println("Byte: " + f); // valdrá -1, se pierde precisión

        return f;
    }
}


