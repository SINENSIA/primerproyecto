package com.sinensia.primerprograma.archivos;

import java.io.File;

/**
 * Ejemplo de uso de la clase File.
 *
 * @version 1.0
 * @since 2023
 * @see File
 * 
 */
public class FileDemo {
    /**
     * Metodo main para probar la clase File.
     *
     * @param args argumentos de la linea de comandos
     */
    // es un ejemplo quitamos la advertencia de complejidad ciclomática
    @SuppressWarnings("java:S3776")
    public static void main(String[] args) {
        File archivo = new File("sinensia.txt");

        String directorioActual = System.getProperty("user.dir");
        System.out.println("\r\nDirectorio actual: " + directorioActual);
        // debes situar el fichero sinensia.txt en el directorio actual

        if (archivo.exists()) {
            System.out.println("El fichero existe.");
        } else {
            System.out.println("El fichero no existe.");
        }

        // Vamos a crear un nuevo directorio
        // Primero nos aseguramos que no existe
        // Crear un nuevo directorio

        File directory = new File("DirectorioSinensia");
        if (directory.exists()) {
            System.out.println("El directorio ya existe.");
        } else {
            if (directory.mkdirs()) {
                System.out.println("Directorio creado con éxito.");
            } else {
                System.out.println("No se pudo crear el directorio.");
            }
        }

        // crear un archivo dentro del directorio
        File archivo2 = new File(directory, "sinensia2.txt");
        if (archivo2.exists()) {
            System.out.println("El fichero ya existe.");
        } else {
            try {
                if (archivo2.createNewFile()) {
                    System.out.println("Fichero creado con éxito.");
                } else {
                    System.out.println("No se pudo crear el fichero.");
                }
            } catch (Exception e) {
                System.out.println("Error al crear el fichero.");
            }
        }

        // Listar archivos en un directorio
        File[] files = directory.listFiles();

        // Si el directorio no está vacío, mostrar los archivos
        if (files != null && files.length > 0) {
            for (File file : files) {
                // Mostrar el nombre de cada archivo con file.getName()
                System.out.println("Nombre del archivo: " + file.getName());
            }
            // Mostrar el número de archivos
            System.out.println("Número de archivos: " + files.length);
        } else { // Si el directorio está vacío, mostrar un mensaje
            if (directory.exists()) {
                System.out.println("El directorio está vacío.");
            } else { // Si el directorio no existe, mostrar un mensaje
                System.out.println("El directorio no existe.");
            }

        }

    }

}
