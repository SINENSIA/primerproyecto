package com.sinensia.primerprograma.redes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        // El cliente se conecta al servidor local en el puerto 4999.
        try (Socket socket = new Socket("localhost", 4999);
                // Lector de teclado para escribir desde consola.
                Scanner scanner = new Scanner(System.in)) {
            System.out.println("Conexión establecida con el servidor.");
            // Canal de entrada: mensajes que llegan del servidor.
            InputStream input = socket.getInputStream();
            // Canal de salida: mensajes que enviamos al servidor.
            OutputStream output = socket.getOutputStream();
            // Lock de consola para que no se mezclen impresiones de hilos distintos.
            Object consoleLock = new Object();

            // Hilo receptor: escucha continuamente lo que envía el servidor.
            Thread lectorServidor = new Thread(() -> {
                byte[] buffer = new byte[1024];
                try {
                    while (true) {
                        int bytesRead = input.read(buffer);
                        if (bytesRead == -1) {
                            synchronized (consoleLock) {
                                System.out.println("\nServidor desconectado.");
                            }
                            break;
                        }
                        String response = new String(buffer, 0, bytesRead);
                        synchronized (consoleLock) {
                            // Limpiamos visualmente la línea actual y reimprimimos el prompt.
                            System.out.print("\r");
                            System.out.println(response);
                            System.out.print("Tú: ");
                        }
                    }
                } catch (IOException e) {
                    synchronized (consoleLock) {
                        System.out.println("\nError leyendo del servidor: " + e.getMessage());
                    }
                }
            });
            lectorServidor.setDaemon(true);
            lectorServidor.start();

            // Bucle principal de escritura: envía lo que escriba el usuario.
            while (true) {
                synchronized (consoleLock) {
                    System.out.print("Tú: ");
                }
                String message = scanner.nextLine();
                // Comando local para salir del cliente.
                if ("/salir".equalsIgnoreCase(message.trim())) {
                    break;
                }

                output.write(message.getBytes());
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
