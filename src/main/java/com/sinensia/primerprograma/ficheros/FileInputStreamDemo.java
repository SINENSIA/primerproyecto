package com.sinensia.primerprograma.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    void main() {

        // Especificar el directorio y el archivo
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");
        // Comprobar si existe el directorio
        if (directorio.exists()) {
            // Comprobar si existe el archivo usando try-with-resources
            try (FileInputStream myFileInputStream = new FileInputStream(archivo)) {
                // Variable para almacenar el byte leido
                int byteLectura;
                // Bucle para leer el archivo hasta que fis.read() devuelva -1
                while ((byteLectura = myFileInputStream.read()) != -1) {
                    // Vamos imprimiendo el byte leido como caracter uno tras otro
                    System.out.print((char) byteLectura);
                }
                // Capturar las excepciones
            } catch (FileNotFoundException _) {
                System.out.println("No se encontró el archivo");
            } catch (IOException _) {
                System.out.println("Error de lectura");
            }
            // lo demás es un bug registramos en log

        } else {
            // Si no existe el directorio, lo decimos
            System.out.println("El directorio no existe");
        }

    }
}
