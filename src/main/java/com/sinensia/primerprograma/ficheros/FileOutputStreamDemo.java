package com.sinensia.primerprograma.ficheros;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    void main() {
        // Especificar el directorio y el archivo
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba_escritura.txt");
        try (FileOutputStream fos = new FileOutputStream(archivo)) {

            String texto = "Hola, esto es un ejemplo de escritura en Java.";

            byte[] bytes = texto.getBytes();
            fos.write(bytes);

            System.out.println("Archivo creado con éxito.");

        } catch (IOException _) {

            IO.println("Ha ocurrido un error de acceso al sistema de archivos.");
        }

    }
}
