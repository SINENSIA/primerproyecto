package com.sinensia.primerprograma.ejercicios.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Ejemplo de uso de streams con productos.
 * Ejercicio 1: Filtrar productos baratos (precio < 100 €).
 * Ejercicio 2: Obtener nombres de productos de la categoría “Tecnología”.
 * Ejercicio 3: Calcular el precio total del inventario.
 * Ejercicio 4: Cambiar la clase Producto por Empleado
 */
public class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    /**
     * Constructor de la clase Producto.
     *
     * @param nombre    nombre del producto
     * @param precio    precio del producto
     * @param categoria categoría del producto
     * 
     */
    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return nombre + " - " + categoria + " - " + precio + "€";
    }

    /**
     * Usamos el main en la clase aunque no es una buena práctica.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Paso 1: Crear lista de productos
        List<Producto> productos = Arrays.asList(
                new Producto("Portátil", 899.99, "Tecnología"),
                new Producto("Libro", 19.99, "Educación"),
                new Producto("Auriculares", 49.99, "Tecnología"),
                new Producto("Mesa", 129.99, "Hogar"),
                new Producto("Lámpara", 29.99, "Hogar"));

        // Paso 2: Filtrar productos baratos (precio < 100 €)
        List<Producto> baratos = productos.stream()
                .filter(p -> p.getPrecio() < 100)
                .collect(Collectors.toList());

        System.out.println("Productos baratos:");
        baratos.forEach(System.out::println);

        // Paso 3: Obtener nombres de productos de la categoría “Tecnología”
        List<String> nombresTecnologia = productos.stream()
                .filter(p -> p.getCategoria().equals("Tecnología"))
                .map(Producto::getNombre)
                .collect(Collectors.toList());

        System.out.println("\nNombres de productos de Tecnología:");
        nombresTecnologia.forEach(System.out::println);

        // Paso 4: Calcular el precio total del inventario
        double precioTotal = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();

        System.out.println("\nPrecio total del inventario: " + precioTotal + "€");
    }
}
