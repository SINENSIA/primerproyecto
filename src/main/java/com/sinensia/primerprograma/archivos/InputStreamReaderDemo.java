package com.sinensia.primerprograma.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Ejemplo de lectura de archivos con InputStreamReader.
 *
 * @version 1.0
 * @since 2023
 * @see java.io.InputStreamReader
 *
 */
public class InputStreamReaderDemo {
    /**
     * Metodo main para probar la clase InputStreamReader.
     *
     * @version 1.0
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");

        try (
                FileInputStream myFileInputStream = new FileInputStream(archivo);
                InputStreamReader myInputStreamReader = new InputStreamReader(myFileInputStream,
                        StandardCharsets.UTF_8); // Maneja la codificación de caracteres
                BufferedReader br = new BufferedReader(myInputStreamReader);) {

            String linea; // Variable para almacenar la línea leída
            while ((linea = br.readLine()) != null) { // Mientras haya líneas que leer
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }
}
