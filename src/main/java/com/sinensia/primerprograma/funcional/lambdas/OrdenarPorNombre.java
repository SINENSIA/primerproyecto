package com.sinensia.primerprograma.funcional.lambdas;

import com.sinensia.primerprograma.poo.Cliente;
import java.util.Arrays;
import java.util.List;

/**
 * Receta para ordenar una lista de clientes por Nombre con lambdas.
 */
public class OrdenarPorNombre {
    /**
     * Método principal para probar la receta.
     *
     * @param args Argumentos de entrada
     */
    public static void main(String[] args) {
        List<Cliente> clientes = Arrays.asList(
                new Cliente("Juan López", true),
                new Cliente("Ana Márquez", false),
                new Cliente("Luis Gonzalo", true));

        // Ordenar clientes por nombre en descendente
        clientes.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        clientes.sort((p1, p2) -> p2.getNombre().compareTo(p1.getNombre()));
        // Breakpoit
    }

}
