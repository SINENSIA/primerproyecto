package com.sinensia.primerprograma.ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    void main() {

        // Especificar el directorio y el archivo
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba_writer.txt");
        try (FileWriter writer = new FileWriter(archivo)) {
            String texto = "Hola, este es un ejemplo de escritura en Java desde FileWriter.";
            writer.write(texto);
        } catch (IOException _) {
            IO.println("Ha ocurrido un error de acceso al sistema de archivos.");
        }

    }
}
