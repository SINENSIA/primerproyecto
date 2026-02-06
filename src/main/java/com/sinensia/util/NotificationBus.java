package com.sinensia.util;

import java.util.LinkedList;
import java.util.Queue;

public class NotificationBus {

    private final Queue<String> queue = new LinkedList<>();
    private final Thread worker;
    private boolean running = true;

    public NotificationBus() {
        worker = new Thread(new Worker(), "NotificationBus-Worker");
    }

    public void start() {
        worker.start();
    }

    public void stop() {
        synchronized (queue) {
            running = false;
            queue.notifyAll();
        }
    }

    public void publish(String message) {
        synchronized (queue) {
            queue.add(message);
            queue.notify(); // despierta al worker si estaba esperando
        }
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                String msg;

                synchronized (queue) {
                    while (queue.isEmpty() && running) {
                        try {
                            queue.wait(); // duerme hasta que haya mensajes
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (!running && queue.isEmpty()) {
                        return; // salida limpia
                    }

                    msg = queue.poll();
                }

                // Procesamiento fuera del synchronized
                System.out.println("[NOTIF] " + msg);

                try {
                    Thread.sleep(200); // simula trabajo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}
