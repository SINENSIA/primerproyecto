package com.sinensia.primerprograma.io.archivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Ejemplo de escritura de un archivo de texto.
 *
 * @version 1.0
 * @since 2023
 * @see java.io.FileOutputStream
 * @see java.io.IOException
 * @author Sinensia
 */
public class FileOutputStreamDemo {
    /**
     * Metodo main para probar la clase FileOutputStream.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        // Especificar el directorio y el archivo
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");

        try (FileOutputStream fos = new FileOutputStream(archivo)) { // o Cadena con la ruta
            String texto = "Hola, esto es un ejemplo de escritura en Java desde FileOutputStream.";
            byte[] bytes = texto.getBytes();

            fos.write(bytes);

            System.out.println("Archivo creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
