package com.sinensia.primerprograma.excepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        BufferedReader reader = null;

        // Es más reocmandable usar try-with-resources
        try {
            reader = new BufferedReader(new FileReader("sinensia.txt"));

            String line = reader.readLine();
            System.out.println(line);
        } catch (FileNotFoundException e) {
            System.out.println("sinensia.txt does not exist" + e.getMessage());
        } catch (IOException e) {
            // Vamos a capturar y manejar la excepción
            System.out.println("Se ha producido un error de I/O: " + e.getMessage());
        } finally {
            if (reader != null) {
                // se intenta cerrar el recurso, así que try-catch otra vez
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
