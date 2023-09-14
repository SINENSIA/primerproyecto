package com.sinensia.primerprograma.redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Clase para probar la clase URLConnection.
 *
 * @version 1.0.0
 * @since 2023
 * @see URLConnection
 */
public class URLConnectionDemo {
    /**
     * Metodo main para probar la clase URLConnection.
     *
     * @param args argumentos de la linea de comandos
     */
    // No cerrar el reader en el try-with-resources ya que URLConnection no
    // implementa AutoCloseable
    @SuppressWarnings("java:S2093")
    public static void main(String[] args) {
        // Definir un BufferedReader a nivel de método para poder cerrarlo en el finally
        BufferedReader reader = null;

        try {
            URL url = new URL("https://www.ipinfo.io/ip");
            URLConnection connection = url.openConnection();

            reader = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Tu dirección IP pública es: " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cerrar el reader, esto también cierra el stream y la conexión
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
