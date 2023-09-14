package com.sinensia.primerprograma.redes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 4999)) {
            // Conectar al servidor en el puerto 12345
            System.out.println("Conexión establecida con el servidor.");
            // Flujo de entrada y salida
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Configurar el lector de consola
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Leer un mensaje desde la consola
                System.out.print("Tú: ");
                String message = scanner.nextLine();

                // Enviar el mensaje al servidor
                output.write(message.getBytes());

                // Leer la respuesta del servidor
                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                if (bytesRead == -1) {
                    break; // El servidor cerró la conexión
                }
                String response = new String(buffer, 0, bytesRead);
                System.out.println(response);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
