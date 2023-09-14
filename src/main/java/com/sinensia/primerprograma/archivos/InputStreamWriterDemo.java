package com.sinensia.primerprograma.archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Ejemplo de lectura de ficheros de texto con InputStream
 *
 * @version 1.0
 * @since 2023
 * @see InputStreamWriter
 */
public class InputStreamWriterDemo {

    /**
     * Metodo main para probar la clase InputStreamWriter.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");
        try (
                FileOutputStream myFileOutputStream = new FileOutputStream(archivo);
                OutputStreamWriter myOutputStreamWriter = new OutputStreamWriter(myFileOutputStream,
                        StandardCharsets.UTF_8); // Maneja la codificación de caracteres
                BufferedWriter br = new BufferedWriter(myOutputStreamWriter);) {
            String linea = """
                    Hola, esto es un ejemplo de
                    escritura en Java desde OutputStreamWriter.
                    """;
            br.write(linea);
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }
}