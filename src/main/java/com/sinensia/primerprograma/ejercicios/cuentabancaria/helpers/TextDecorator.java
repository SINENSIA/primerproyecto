package com.sinensia.primerprograma.ejercicios.cuentabancaria.helpers;

import java.util.Arrays;

/**
 * Clase de utilidad para estilizar y formatear texto.
 */
public class TextDecorator {
    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m"; // Éxito
    public static final String RED = "\u001B[31m"; // Error
    public static final String YELLOW = "\u001B[33m"; // Advertencia
    public static final String BLUE = "\u001B[34m"; // Información

    // Constructor privado para evitar instanciación
    private TextDecorator() {
    }

    public static String success(String mensaje) {
        return GREEN + "[✔] " + mensaje + RESET;
    }

    public static String error(String mensaje) {
        return RED + "[✖] " + mensaje + RESET;
    }

    public static String warning(String mensaje) {
        return YELLOW + "[⚠] " + mensaje + RESET;
    }

    public static String info(String mensaje) {
        return BLUE + "[ℹ] " + mensaje + RESET;
    }

    /**
     *
     * <p>
     * SE encarga de formatead una caja descriptiva.
     * </p>
     *
     * @param titulo    título del box.
     * @param contenido contenido del box.
     * @return String
     */
    public static String formatBox(String titulo, String contenido) {
        // Split content into multiple lines
        String[] lines = contenido.split("\n");

        // Find the longest line to determine box width
        int maxWidth = Math.max(
                titulo.length(),
                Arrays.stream(lines)
                        .mapToInt(String::length)
                        .max()
                        .orElse(0));

        // Construct the box
        StringBuilder box = new StringBuilder();
        box.append(GREEN).append("╔").append("═".repeat(maxWidth + 4)).append("╗\n");
        box.append("║ ").append(centerText(titulo, maxWidth)).append("   ║\n");
        box.append("╠").append("═".repeat(maxWidth + 4)).append("╣\n");

        for (String line : lines) {
            box.append("║ ").append(padRight(line, maxWidth)).append("   ║\n");
        }

        box.append("╚").append("═".repeat(maxWidth + 4)).append("╝\n").append(RESET);

        return box.toString();
    }

    /**
     * Centers a given text within a given width.
     */
    private static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }

    /**
     * Pads a string to the right to fit within the given width.
     */
    private static String padRight(String text, int width) {
        return text + " ".repeat(width - text.length());
    }

}
