package com.sinensia.primerprograma.basico.texto;

import java.util.Scanner;

/**
 * <b>StringBuilder: Uso práctico y dinámico</b>
 * <p>
 * Esta clase demuestra cómo usar {@link java.lang.StringBuilder} para acumular
 * texto de forma eficiente, permitiendo inserciones, eliminaciones y reemplazos
 * sin penalización de rendimiento.
 * </p>
 * 
 * @author Sinensia
 */
public class EjemploStringBuilder {

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        // Uso de try-with-resources para asegurar el cierre del Scanner
        try (Scanner entrada = new Scanner(System.in)) {
            StringBuilder buffer = new StringBuilder();

            System.out.println("Escribe varias frases (escribe 'FIN' para terminar):");

            while (true) {
                String linea = entrada.nextLine();
                if (linea.equalsIgnoreCase("FIN")) {
                    break;
                }
                // append es mucho más eficiente que += en un bucle
                buffer.append(linea).append("\n");
            }

            System.out.println("\n--- Resumen del texto acumulado ---");
            System.out.println(buffer.toString());

            // 1. Inserción en una posición específica
            buffer.insert(0, "INICIO DEL TEXTO:\n");

            // 2. Búsqueda y reemplazo
            int index = buffer.indexOf("\n");
            if (index != -1) {
                buffer.replace(index, index + 1, " [Línea 1 Termina] ");
            }

            // 3. Inversión (útil para algoritmos específicos como palíndromos)
            String invertido = new StringBuilder(buffer).reverse().toString();

            System.out.println("\n--- Texto modificado ---");
            System.out.println(buffer);

            System.out.println("\n--- Texto invertido ---");
            System.out.println(invertido);
        }
    }
}
