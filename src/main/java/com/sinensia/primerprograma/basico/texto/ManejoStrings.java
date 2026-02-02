package com.sinensia.primerprograma.basico.texto;

/**
 * <b>Operaciones con la clase String</b>
 * <p>
 * Demuestra los métodos más comunes de la clase {@link java.lang.String}
 * utilizando {@link java.lang.IO} para la salida.
 * </p>
 * 
 * @author Sinensia
 */
public class ManejoStrings {

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        String miString = "  Java Avanzado  ";

        IO.println("Texto original: [" + miString + "]");

        // --- 1. Inspección ---
        IO.println("Longitud: " + miString.length());
        IO.println("Carácter en posición 2: " + miString.charAt(2));
        IO.println("¿Contiene 'Java'?: " + miString.contains("Java"));

        // --- 2. Transformación (devuelven nuevo String) ---
        IO.println("Mayúsculas: " + miString.toUpperCase());
        IO.println("Sin espacios extremos: [" + miString.trim() + "]");
        IO.println("Reemplazo: " + miString.replace("Avanzado", "Básico"));
        IO.println("Subcadena (0-4): " + miString.trim().substring(0, 4));

        // --- 3. Comparación ---
        String comparacion = "java avanzado";
        IO.println("\nComparación:");
        IO.println("- equals (exacto): " + miString.trim().equals(comparacion)); // false
        IO.println("- equalsIgnoreCase: " + miString.trim().equalsIgnoreCase(comparacion)); // true

        // --- 4. Mutabilidad con StringBuilder (No thread-safe) ---
        IO.println("\n--- StringBuilder (Recomendado para bucles) ---");
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" 21").insert(0, "Versión ").reverse();
        IO.println("Resultado StringBuilder reverse: " + sb);

        // --- 5. Mutabilidad con StringBuffer (Thread-safe / Sincronizado) ---
        IO.println("\n--- StringBuffer (Uso en entornos multi-hilo) ---");
        StringBuffer sbf = new StringBuffer("Log:");
        sbf.append(" Inicio de proceso");
        IO.println(sbf.toString());
    }
}
