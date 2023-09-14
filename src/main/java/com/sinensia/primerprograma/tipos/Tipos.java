package com.sinensia.primerprograma.tipos;

public class Tipos {
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

    /* Uso problematico de var qué tipo es i?? */
    public int customOperation(int x, int y) {
        var i = getValueOperation();

        return x + y + (int) i; // tengo que hacer casting exlicito
    }

    public float getValueOperation() {

        return 10;
    }

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

    public double wideningDemo() {
        byte a = 4;
        short b = a;
        int c = b;
        long d = c;
        float e = d;
        double f = e;

        return f; // valdrá 4.0 no se pierde precisión
    }

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
        System.out.println("Byte: " + f);

        /**
         * valdrá -1, se pierde precisión
         */
        return f;
    }
}
