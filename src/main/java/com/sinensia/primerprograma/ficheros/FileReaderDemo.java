package com.sinensia.primerprograma.ficheros;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class FileReaderDemo {

    void main() {
        // Especificar el directorio y el archivo
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");
        try (FileReader reader = new FileReader(archivo)) { // O cadena con la ruta
            int charRead;
            while ((charRead = reader.read()) != -1) {
                System.out.print((char) charRead);
            }
        } catch (IOException _) {

            IO.println("Ha ocurrido un error de acceso al sistema de archivos.");
        }

    }
}
