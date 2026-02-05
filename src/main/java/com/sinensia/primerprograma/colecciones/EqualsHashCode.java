package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

/**
 * Ejemplo de uso de ArrayList.
 * 
 */
public class EqualsHashCode {
    /**
     * Método principal.
     *
     * @param args parametros de consola
     */
    public static void main(String[] args) {

        // Creación de dos clientes
        Cliente cliente1 = new Cliente("Pepe", "Martin", "96848243B", "Calle Falsa 123", 22);
        Cliente cliente2 = new Cliente("Juan", "Garcia", "79539220A", "Calle Fake 87", 39);
        Cliente cliente3 = new Cliente("María", "López", "40204522Z", "Calle NonExistent 23", 23);
        Cliente clienteDuplicado = new Cliente(
                "Juan José", "García López", "79539220A", "Calle de Fake 87", 39);

        HashSet<Cliente> clientes = new HashSet<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(clienteDuplicado);

        // Ordenación de la lista. Convertimos a ArrayList para poder ordenar
        Comparator<Cliente> orderByEdad = new CompareEdad();

        ArrayList<Cliente> listToOrder = new ArrayList<>(clientes);
        System.out.println("Lista antes de ordenar: " + clientes);
        listToOrder.sort(null);
        System.out.println("Lista después de ordenar por dni: " + listToOrder);
        Collections.sort(listToOrder, orderByEdad);
        listToOrder.sort(orderByEdad);
        System.out.println("Lista después de ordenar por edad: " + listToOrder);

        // También podemos hacerlo con un lambda
        listToOrder.sort((a, b) -> b.getEdad() - a.getEdad());

        // Tambien con Collections.sort por otro campo
        Collections.sort(listToOrder, (a, b) -> b.getNombre().compareTo(a.getNombre()));

        System.out.println("Lista después de ordenar: " + listToOrder);

    }

    static class CompareEdad implements Comparator<Cliente> {
        public int compare(Cliente c1, Cliente c2) {
            return c1.getEdad() - c2.getEdad();
        }
    }

    static class Cliente implements Comparable<Cliente> {

        private String nombre;
        private String apellidos;
        private String dni;
        private String direccion;
        private int edad;

        protected Cliente(String nombre, String apellidos, String dni, String direccion, int edad) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.dni = dni;
            this.direccion = direccion;
            this.edad = edad;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return this.apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getDni() {
            return this.dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public int getEdad() {
            return this.edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getDireccion() {
            return this.direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String toString() {
            return getNombre()
                    + " "
                    + getApellidos()
                    + " "
                    + getDni()
                    + "\n";
        }

        @Override
        public int compareTo(Cliente cliente) {
            return this.dni.compareTo(cliente.dni);
        }

        /**
         * Método equals sobreescrito para comparar dos objetos de tipo Cliente
         * los clientes son iguales si tienen el mismo dni.
         *
         * @param o (Object)
         */

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Cliente)) {
                return false;
            }
            Cliente cliente = (Cliente) o;
            return Objects.equals(dni, cliente.dni);
        }

        public int hashCode() {
            return Objects.hashCode(dni);
        }

    }

}
