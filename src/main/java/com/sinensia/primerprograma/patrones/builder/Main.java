package com.sinensia.primerprograma.patrones.builder;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario.Builder("Ana")
                .edad(30)
                .email("ana@example.com")
                .telefono("123-456-789")
                .build();

        usuario.mostrar();
    }
}