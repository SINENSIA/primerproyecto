package com.sinensia.primerprograma.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputStreamReaderDemo {
    void main() {
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
        } catch (FileNotFoundException _) {
            System.out.println("No se encontró el archivo");
        } catch (IOException _) {
            System.out.println("Error de lectura");
        }

    }
}
