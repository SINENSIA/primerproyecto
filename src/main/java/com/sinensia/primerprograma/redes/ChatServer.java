package com.sinensia.primerprograma.redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        System.out.println("Servidor de chat manual");
        System.out.println("Escribe /salir en servidor para cerrar la conexión.");
        // Abrimos un ServerSocket que escucha en el puerto 4999.
        // Este objeto representa "el servidor" esperando clientes.
        try (ServerSocket serverSocket = new ServerSocket(4999)) {
            System.out.println("Servidor en espera de conexiones...");
            // accept() bloquea la ejecución hasta que un cliente se conecta.
            // Cuando llega un cliente, obtenemos el Socket de esa conversación.
            try (Socket clientSocket = serverSocket.accept();
                    // input: canal para leer lo que envía el cliente.
                    InputStream input = clientSocket.getInputStream();
                    // output: canal para enviar mensajes al cliente.
                    OutputStream output = clientSocket.getOutputStream();
                    // consola: permite escribir mensajes manuales desde el servidor.
                    BufferedReader consola = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress());

                // Hilo 1: escucha continuamente al cliente.
                // Lo separamos en un hilo para no bloquear la escritura por consola.
                Thread lectorCliente = new Thread(() -> {
                    byte[] buffer = new byte[1024];
                    try {
                        while (true) {
                            int bytesRead = input.read(buffer);
                            if (bytesRead == -1) {
                                System.out.println("Cliente desconectado.");
                                break;
                            }
                            String message = new String(buffer, 0, bytesRead).trim();
                            System.out.println("Cliente: " + message);
                        }
                    } catch (IOException e) {
                        // Si el cliente se cae o hay error de red, salimos del hilo.
                        System.out.println("Error leyendo del cliente: " + e.getMessage());
                    }
                });

                // Hilo 2: lee texto desde la consola del servidor y lo envía al cliente.
                Thread escritorServidor = new Thread(() -> {
                    try {
                        String linea;
                        while ((linea = consola.readLine()) != null) {
                            // Comando local para cerrar la sesión desde el servidor.
                            if ("/salir".equalsIgnoreCase(linea.trim())) {
                                clientSocket.close();
                                break;
                            }
                            // Enviamos cada línea prefijada para identificar el origen.
                            output.write(("Servidor: " + linea).getBytes());
                            output.flush();
                        }
                    } catch (IOException e) {
                        System.out.println("Error escribiendo al cliente: " + e.getMessage());
                    }
                });

                lectorCliente.start();
                escritorServidor.start();
                // join() mantiene el main vivo hasta que ambos hilos terminan.
                lectorCliente.join();
                escritorServidor.join();
            }
        } catch (IOException | InterruptedException e) {
            // Capturamos errores de red y de sincronización de hilos.
            e.printStackTrace();
        }
    }

}
