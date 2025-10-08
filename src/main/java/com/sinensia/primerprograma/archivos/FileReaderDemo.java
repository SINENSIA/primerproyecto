package com.sinensia.primerprograma.archivos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejemplo de lectura de archivos con FileReader.
 *
 * @version 1.0
 * @since 2023
 * @see java.io.FileReader
 * @see java.io.IOException
 *
 */
public class FileReaderDemo {
    /**
     * Metodo main para probar la clase FileReader.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        // Especificar el directorio y el archivo

        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");

        try (FileReader reader = new FileReader(archivo)) { // O cadena con la ruta
            int charRead;

            while ((charRead = reader.read()) != -1) {
                System.out.println((char) charRead);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
