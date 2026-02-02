package com.sinensia.primerprograma.io.archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Ejemplo de lectura de un archivo con FileInputStream.
 *
 * @version 1.0
 * @since 2023
 * @see java.io.FileInputStream
 * @see java.io.File
 * @see java.io.IOException
 * @see java.io.FileNotFoundException
 * @author Sinensia
 */
public class FileInputStreamDemo {
    /**
     * Metodo main para probar la clase FileInputStream.
     *
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        // Especificar el directorio y el archivo
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");
        // Comprobar si existe el directorio
        if (directorio.exists()) {
            // Comprobar si existe el archivo usando try-with-resources
            // Tambíen se puede pasar una cadena con la ruta del archivo
            try (FileInputStream myFileInputStream = new FileInputStream(archivo)) { // o String
                // Variable para almacenar el byte leido
                int byteLectura;
                // Bucle para leer el archivo hasta que fis.read() devuelva -1
                while ((byteLectura = myFileInputStream.read()) != -1) {
                    // Vamos imprimiendo el byte leido como caracter uno tras otro
                    System.out.print((char) byteLectura);
                }
                // Capturar las excepciones
            } catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
            } catch (IOException e) {
                System.out.println("Error de lectura");
            }

        } else { // Si no existe el directorio, lo decimos
            System.out.println("El directorio no existe");

        }
    }
}
