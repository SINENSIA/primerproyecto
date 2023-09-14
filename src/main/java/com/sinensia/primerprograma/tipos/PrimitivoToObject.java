package com.sinensia.primerprograma.tipos;

public class PrimitivoToObject {

    public static void main(String[] args) {
        // Crear un objeto Byte a partir de un valor byte
        boolean valorBoolean = true;
        Boolean booleanObjeto = Boolean.valueOf(valorBoolean);
        int valorInt = 64;
        Integer integerObjeto = Integer.valueOf(valorInt);
        short valorShort = 64;
        Short shortObjeto = Short.valueOf(valorShort);
        long valorLong = 64;
        Long longObjeto = Long.valueOf(valorLong);
        float valorFloat = 64;
        Float floatObjeto = Float.valueOf(valorFloat);
        double valorDouble = 64;
        Double doubleObjeto = Double.valueOf(valorDouble);

        byte valorByte = 64;
        Byte byteObjeto = Byte.valueOf(valorByte);

        // Mostrar el valor almacenado en el objeto Byte
        System.out.println("Valor byte almacenado en el objeto Byte: " + byteObjeto.byteValue());
        System.out.println("Valor boolean almacenado en el objeto Boolean: " + booleanObjeto.booleanValue());
        System.out.println("Valor int almacenado en el objeto Integer: " + integerObjeto.intValue());
        System.out.println("Valor short almacenado en el objeto Short: " + shortObjeto.shortValue());
        System.out.println("Valor long almacenado en el objeto Long: " + longObjeto.longValue());
        System.out.println("Valor float almacenado en el objeto Float: " + floatObjeto.floatValue());
        System.out.println("Valor double almacenado en el objeto Double: " + doubleObjeto.doubleValue());

        // Crear un objeto Byte a partir de un String
        String valorString = "64";
        Byte byteObjeto2 = Byte.parseByte(valorString);
        System.out.println("Valor byte almacenado en el objeto Byte: " + byteObjeto2.byteValue());

    }

}
