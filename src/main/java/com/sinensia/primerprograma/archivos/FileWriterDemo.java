package com.sinensia.primerprograma.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo de escritura de archivos con FileWriter.
 *
 * @version 1.0
 * @since 2023
 * @see FileWriter
 */
public class FileWriterDemo {
    /**
     * Metodo main para probar la clase FileWriter.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        // Especificar el directorio y el archivo
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");
        try (FileWriter writer = new FileWriter(archivo)) {
            String texto = "Hola, este es un ejemplo de escritura en Java desde FileWriter.";
            writer.write(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
