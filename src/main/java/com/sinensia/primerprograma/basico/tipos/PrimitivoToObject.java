package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Conversión de Primitivos a Objetos (Classes Wrapper)</b>
 * <p>
 * Muestra el uso explícito de los métodos {@code valueOf} y los métodos
 * de extracción de valor (como {@code intValue}, {@code doubleValue}, etc.).
 * </p>
 * 
 * @author Sinensia
 */
public class PrimitivoToObject {

    /**
     * Demostración de wrappers.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Conversión manual: valueOf es preferible a usar 'new' (deprecated en
        // versiones modernas)
        boolean valorBoolean = true;
        Boolean booleanObjeto = Boolean.valueOf(valorBoolean);

        int valorInt = 64;
        Integer integerObjeto = Integer.valueOf(valorInt);
              
        
        short valorShort = 64;
        Short shortObjeto = Short.valueOf(valorShort);

        long valorLong = 64L;
        Long longObjeto = Long.valueOf(valorLong);

        float valorFloat = 64.0f;
        Float floatObjeto = Float.valueOf(valorFloat);

        double valorDouble = 64.0;
        Double doubleObjeto = Double.valueOf(valorDouble);

        byte valorByte = 64;
        Byte byteObjeto = Byte.valueOf(valorByte);

        // Extracción manual del valor primitivo (Unboxing manual)
        System.out.println("Clases Envolventes y sus valores:");
        System.out.println("- Byte:    " + byteObjeto.byteValue());
        System.out.println("- Boolean: " + booleanObjeto.booleanValue());
        System.out.println("- Integer: " + integerObjeto.intValue());
        System.out.println("- Short:   " + shortObjeto.shortValue());
        System.out.println("- Long:    " + longObjeto.longValue());
        System.out.println("- Float:   " + floatObjeto.floatValue());
        System.out.println("- Double:  " + doubleObjeto.doubleValue());

        // Conversión desde String (Parsing)
        String valorString = "64";
        // parseByte devuelve un primitivo, valueOf devuelve un Objeto
        byte primitivoByte = Byte.parseByte(valorString);
        Byte objetoByte = Byte.valueOf(valorString);

        System.out.println("\nConversión desde String:");
        System.out.println("- Primitivo byte desde String: " + primitivoByte);
        System.out.println("- Objeto Byte desde String:    " + objetoByte);
    }
}
