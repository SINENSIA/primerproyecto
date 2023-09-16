package com.sinensia.primerprograma.ejercicios;

/**
 * Encriptación XOR.
 * Ejemplo sólo propósito de demostración. No usar en producción.
 *
 */
public class EncriptacionXor {
    /**
     * Encripta y desencripta un texto usando el algoritmo XOR.
     * Ejemplo sólo propçósito de demostración. No usar en producción.
     * Sin revisión de seguridad.
     *
     * @param texto texto a encriptar o desencriptar
     * @param clave clave para encriptar o desencriptar
     * @return texto encriptado o desencriptado
     */
    public static String encriptarDesencriptar(String texto, String clave) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            // Asegura que la clave se repita si es más corta que el texto
            char claveChar = clave.charAt(i % clave.length());
            // el texto
            char caracterEncriptado = (char) (caracter ^ claveChar); // XOR
            resultado.append(caracterEncriptado);
        }
        return resultado.toString();
    }

    /**
     * Método main. Ejemplo de uso de encriptación XOR.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        String textoOriginal = "Hola, mundo!";
        String clave = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        // Encriptar el texto
        String textoEncriptado = encriptarDesencriptar(textoOriginal, clave);
        System.out.println("Texto encriptado: " + textoEncriptado);

        // Desencriptar el texto
        String textoDesencriptado = encriptarDesencriptar(textoEncriptado, clave);
        System.out.println("Texto desencriptado: " + textoDesencriptado);
    }
}
