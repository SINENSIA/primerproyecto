package com.sinensia.primerprograma.redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import com.sinensia.primerprograma.redes.services.OpenaiService;

public class ChatServerConIA {

    public static void main(String[] args) {
        // Para demo, la API key está hardcodeada.
        // En un entorno real, debería venir de variable de entorno o gestor de
        // secretos.
        String apiKey = "openai-api-key";
        OpenaiService aiService = new OpenaiService(apiKey);
        // Lock para serializar escritura al socket desde varios hilos.
        final Object sendLock = new Object();
        // Flag compartido entre hilos para activar/desactivar respuestas con IA.
        AtomicBoolean iaActiva = new AtomicBoolean(false);

        System.out.println("Servidor con IA (manual + IA)");
        System.out.println("Comandos servidor: /ia on, /ia off, /salir");

        // Socket servidor en puerto 4999.
        try (ServerSocket serverSocket = new ServerSocket(4999)) {
            System.out.println("Esperando cliente en puerto 4999...");
            // accept() bloquea hasta que llega un cliente.
            try (Socket clientSocket = serverSocket.accept();
                    InputStream input = clientSocket.getInputStream();
                    OutputStream output = clientSocket.getOutputStream();
                    BufferedReader consola = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress());

                // Hilo 1: recibe mensajes del cliente.
                Thread lectorCliente = new Thread(() -> {
                    byte[] buffer = new byte[1024];
                    try {
                        while (true) {
                            int bytesRead = input.read(buffer);
                            if (bytesRead == -1) {
                                System.out.println("Cliente desconectado.");
                                break;
                            }

                            String mensajeCliente = new String(buffer, 0, bytesRead).trim();
                            System.out.println("Cliente: " + mensajeCliente);

                            // Permite activar/desactivar IA desde el cliente.
                            if ("/ia on".equalsIgnoreCase(mensajeCliente)) {
                                iaActiva.set(true);
                                synchronized (sendLock) {
                                    output.write("Servidor: IA activada.".getBytes());
                                    output.flush();
                                }
                                continue;
                            }
                            if ("/ia off".equalsIgnoreCase(mensajeCliente)) {
                                iaActiva.set(false);
                                synchronized (sendLock) {
                                    output.write("Servidor: IA desactivada.".getBytes());
                                    output.flush();
                                }
                                continue;
                            }

                            // Si IA está activa, respondemos automáticamente.
                            // Si no, queda en modo chat manual.
                            if (iaActiva.get()) {
                                String respuestaIa = aiService.enviarMensaje(mensajeCliente);
                                String payload = "OpenAI: " + respuestaIa;
                                synchronized (sendLock) {
                                    output.write(payload.getBytes());
                                    output.flush();
                                }
                            } else {
                                System.out.println("IA desactivada. Responde manualmente desde consola.");
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error leyendo del cliente: " + e.getMessage());
                    }
                });

                // Hilo 2: permite al operador del servidor responder manualmente.
                Thread escritorServidor = new Thread(() -> {
                    try {
                        String linea;
                        while ((linea = consola.readLine()) != null) {
                            String comando = linea.trim();
                            if ("/ia on".equalsIgnoreCase(comando)) {
                                iaActiva.set(true);
                                System.out.println("IA activada.");
                                continue;
                            }
                            if ("/ia off".equalsIgnoreCase(comando)) {
                                iaActiva.set(false);
                                System.out.println("IA desactivada.");
                                continue;
                            }
                            if ("/salir".equalsIgnoreCase(comando)) {
                                clientSocket.close();
                                break;
                            }

                            String payload = "Servidor: " + linea;
                            synchronized (sendLock) {
                                output.write(payload.getBytes());
                                output.flush();
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error escribiendo al cliente: " + e.getMessage());
                    }
                });

                lectorCliente.start();
                escritorServidor.start();
                // El hilo principal espera a que ambos terminen.
                lectorCliente.join();
                escritorServidor.join();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
