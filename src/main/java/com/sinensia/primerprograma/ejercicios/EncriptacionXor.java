package com.sinensia.primerprograma.ejercicios;

public class EncriptacionXor {

    public static String encriptarDesencriptar(String texto, String clave) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            char claveChar = clave.charAt(i % clave.length()); // Asegura que la clave se repita si es más corta que
                                                               // el texto
            char caracterEncriptado = (char) (caracter ^ claveChar); // XOR
            resultado.append(caracterEncriptado);
        }
        return resultado.toString();
    }

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
