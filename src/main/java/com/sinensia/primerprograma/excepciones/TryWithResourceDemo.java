package com.sinensia.primerprograma.excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TryWithResourceDemo {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("TryWithResourceDemo");
        // Configurar un manejador de registros para escribir en un archivo

        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("sinensia.txt");
        } catch (SecurityException | IOException e) {
            System.out.println("Se ha producido un error de I/O con el Fichero de log: "
                    + e.getMessage());
            e.printStackTrace();
        }

        logger.addHandler(fileHandler);
        // Emitir un registro
        logger.log(Level.INFO, "Este es un mensaje de registro.");
        try (BufferedReader reader = new BufferedReader(new FileReader("sinensia.txt"))) {
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            // Vamos a capturar y manejar la excepción
            // System.out.println("Se ha producido un error de I/O: " + e.getMessage());
            logger.severe("Se ha producido un error de I/O: " + e.getMessage());
            logger.log(Level.SEVERE, "Se ha producido un error de I/O", e);
            e.printStackTrace();
        }
    }
}
