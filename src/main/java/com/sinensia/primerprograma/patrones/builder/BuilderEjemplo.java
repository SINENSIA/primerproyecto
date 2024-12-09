package com.sinensia.primerprograma.patrones.builder;

// PRODUCTO
class Auto {
    private String marca;
    private String modelo;
    private String color;

    // Constructor privado para usar Builder
    private Auto(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto: " + marca + " " + modelo + " de color " + color;
    }

    // BUILDER
    public static class AutoBuilder {
        private String marca;
        private String modelo;
        private String color;

        public AutoBuilder setMarca(String marca) {
            this.marca = marca;
            return this; // Retorna el Builder para encadenar llamadas
        }

        public AutoBuilder setModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public AutoBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Auto build() {
            return new Auto(marca, modelo, color);
        }
    }
}

// PROGRAMA PRINCIPAL
public class BuilderEjemplo {
    public static void main(String[] args) {
        // Crear un auto usando el Builder

        Auto auto = new Auto.AutoBuilder()
                .setMarca("Toyota")
                .setModelo("Corolla")
                .setColor("Rojo")
                .build();

        // Mostrar el auto
        System.out.println(auto);
    }
}
