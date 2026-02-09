package com.sinensia.primerprograma.ficheros;

import java.io.File;
import java.io.IOException;

public class DemoAccesoFicheros {

    void main() {

        File archivo = new File("sinensia.txt");
        String directorioActual = System.getProperty("user.dir");
        IO.println("Directorio actual: " + directorioActual);
        // debes situar el fichero sinensia.txt en el directorio actual
        if (archivo.exists()) {
            IO.println("El fichero sinensia.txt existe.");
        } else {
            IO.println("El fichero sinensia.txt no existe.");
        }

        File directory = new File("DirectorioSinensia");
        createDirectory(directory);

        File file = new File(directory, "sinensia2.txt");
        createFile(file);

        listFiles(directory);

    }

    public static void listFiles(File directory) {
        // Listar archivos en un directorio
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println("Nombre del archivo: " + file.getName());
            }
            System.out.println("Número de archivos: " + files.length);
        } else {
            if (directory.exists()) {
                System.out.println("El directorio está vacío.");
            } else {
                System.out.println("El directorio no existe.");
            }
        }
    }

    public static void createFile(File file) {
        if (file.exists()) {
            System.out.println("El fichero sinensia2.txt ya existe.");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println("Fichero creado con éxito.");
                } else {
                    System.out.println("No se pudo crear el fichero.");
                }
            } catch (IOException _) {
                System.out.println("Error al crear el fichero."); // REgistramos
            }
        }
    }

    public static void createDirectory(File directory) {

        if (directory.exists()) {
            System.out.println("El directorio ya existe.");
        } else {
            if (directory.mkdirs()) {
                System.out.println("Directorio DirectorioSinensia creado con éxito.");
            } else {
                System.out.println("No se pudo crear el directorio DirectorioSinensia.");
            }
        }

    }
}
