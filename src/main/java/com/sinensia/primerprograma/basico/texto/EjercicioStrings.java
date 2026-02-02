package com.sinensia.primerprograma.basico.texto;

import java.util.Scanner;

/**
 * <b>Ejercicio: Procesamiento de Cadenas</b>
 * <p>
 * Pequeño programa interactivo para practicar operaciones básicas de
 * {@code String}
 * y {@code StringBuilder}, incluyendo conteo de vocales e inversión de texto.
 * </p>
 * 
 * @author Sinensia
 */
public class EjercicioStrings {

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Introduce una frase para analizar: ");
            String frase = scanner.nextLine();

            System.out.println("\n--- Análisis de la frase ---");
            System.out.println("- Longitud total: " + frase.length());
            System.out.println("- En mayúsculas:  " + frase.toUpperCase());
            System.out.println("- ¿Contiene 'Hola'?: " + frase.toLowerCase().contains("hola"));

            int nVocales = contarVocales(frase);
            System.out.println("- Número de vocales: " + nVocales);

            // Inversión rápida usando StringBuilder
            String invertida = new StringBuilder(frase).reverse().toString();
            System.out.println("- Frase invertida:   " + invertida);
        }
    }

    /**
     * Cuenta cuántas vocales (independientemente de si son mayúsculas o minúsculas)
     * existen en el texto proporcionado.
     * 
     * @param texto Cadena a analizar
     * @return El número de vocales encontradas
     */
    private static int contarVocales(String texto) {
        int contador = 0;
        String vocales = "aeiouáéíóúü";
        for (char c : texto.toLowerCase().toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }
}
