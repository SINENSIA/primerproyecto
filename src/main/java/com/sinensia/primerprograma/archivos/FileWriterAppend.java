package com.sinensia.primerprograma.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterAppend {
    public static void main(String[] args) {
        File directorio = new File("DirectorioSinensia");
        File archivo = new File(directorio, "prueba.txt");
        try (FileWriter writer = new FileWriter(archivo, true)) {
            String texto = "Hola, este es un ejemplo de escritura en Java desde FileWriter con append.";
            writer.write(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
