package com.sinensia.primerprograma.ejercicios.interfaces_funcionales;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
                new Producto("Portátil", 899.99, "Tecnología"),
                new Producto("Libro", 19.99, "Educación"),
                new Producto("Auriculares", 49.99, "Tecnología"));

        System.out.println("Método más tradicional - Productos de la categoría 'Tecnología':");
        List<Producto> resultado = FiltroProductos.filtrarProductos(productos, new FiltroPorCategoria());
        resultado.forEach(System.out::println);

        System.out.println("Método con lambda - Productos de la categoría 'Tecnología':");
        List<Producto> resultado_lambda = FiltroProductos.filtrarProductos(productos,
                p -> p.getCategoria().equals("Tecnología"));
        resultado_lambda.forEach(System.out::println);

        System.out.println("Productos con precio menor o igual a 20 EUR:");
        List<Producto> resultado_precios = FiltroProductos.filtrarProductos(productos,
                p -> p.getPrecio() <= 20);
        resultado_precios.forEach(System.out::println);
    }
}
