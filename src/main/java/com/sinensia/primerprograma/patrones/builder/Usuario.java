package com.sinensia.primerprograma.patrones.builder;

public class Usuario {
    private String nombre;
    private int edad;
    private String email;
    private String telefono;

    // Constructor privado
    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.edad = builder.edad;
        this.email = builder.email;
        this.telefono = builder.telefono;
    }

    // Builder estático interno
    public static class Builder {
        private String nombre;
        private int edad;
        private String email;
        private String telefono;

        public Builder(String nombre) {
            this.nombre = nombre; // Campo obligatorio
        }

        public Builder edad(int edad) {
            this.edad = edad;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

    // Método para mostrar información
    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + telefono);
    }
}
