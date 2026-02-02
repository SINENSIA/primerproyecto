package com.sinensia.primerprograma.io.serializacion;

public class MainMensajes {
    public static void main(String[] args) throws Exception {
        GestorMensajes<String> gestor = new GestorMensajes<>();

        gestor.agregarMensaje(new Mensaje<>("Hola mundo", "Alice", "abc123"));
        gestor.agregarMensaje(new Mensaje<>("Adiós mundo", "Bob", "def456"));

        gestor.guardarMensajes("mensajes.ser");

        System.out.println("Mensajes guardados. Limpiamos gestor...");

        gestor = new GestorMensajes<>();
        gestor.cargarMensajes("mensajes.ser");

        System.out.println("Mensajes cargados:");
        gestor.mostrarMensajes();
    }
}
