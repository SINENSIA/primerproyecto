package com.sinensia.primerprograma.concurrencia;

import com.sinensia.util.NotificationBus;

public class DemoNotificationBus {

    public static void main(String[] args) {
        System.out.println("Hola mundo desde el Primer Proyecto Java");

        NotificationBus bus = new NotificationBus();
        bus.start();

        bus.publish("Usuario registrado");
        bus.publish("Préstamo creado");
        bus.publish("Animal alimentado");
        bus.publish("Gol minuto 32");

        try {
            Thread.sleep(1000);
            bus.stop();
        } catch (InterruptedException _) {
            IO.println("Se ha producido una exception");
        }
    }
}
