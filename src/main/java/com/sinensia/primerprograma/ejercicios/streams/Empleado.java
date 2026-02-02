package com.sinensia.primerprograma.ejercicios.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Empleado {

    private String nombre;
    private String departamento;
    private int salario;
    private List<Reunion> reuniones;

    /**
     * Constructor de la clase Empleado.
     *
     * @param nombre       nombre del empleado con apellidos
     * @param departamento nombre del departamento
     * @param salario      salario anual del empleado
     */
    public Empleado(String nombre, String departamento, int salario) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.reuniones = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getSalario() {
        return salario;
    }

    /**
     * Agrega una reunión al empleado.
     * Si está ya asignado a la reunión, no lo añade y muestra un mensaje.
     */
    public boolean agregarReunion(Reunion reunion) {

        if (reuniones.contains(reunion)) {
            System.out.println(
                    "El empleado "
                            + nombre
                            + " ya está asignado a la reunión con ID: "
                            + reunion.getId());
            return false;
        }
        reuniones.add(reunion);
        return true;
    }

    public List<Reunion> getReuniones() {
        return reuniones;
    }

    @Override
    public String toString() {
        return nombre + " - " + departamento + " - " + salario + "€";
    }

    /**
     * Usamos el main en la clase aunque no es una buena práctica.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        // Paso 1: Crear lista de empleados
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Ana", "IT", 32000),
                new Empleado("Luis", "Marketing", 28000),
                new Empleado("Sofía", "IT", 45000),
                new Empleado("Carlos", "Finanzas", 27000),
                new Empleado("Marta", "Marketing", 30000));

        // Paso 2: Filtrar empleados con salario < 30000 €
        List<Empleado> salarioBajo = empleados.stream()
                .filter(empleado -> empleado.getSalario() < 30_000)
                .toList();

        System.out.println("Empleados con salario inferior a 30000€:");
        salarioBajo.forEach(System.out::println);

        // Paso 3: Obtener nombres de empleados del departamento IT
        List<String> nombresTech = empleados.stream()
                .filter(e -> e.getDepartamento().equals("IT"))
                .map(Empleado::getNombre)
                .toList();

        System.out.println("\nNombres de empleados del departamento IT:");
        nombresTech.forEach(System.out::println);

        // Paso 4: Calcular el salario total de la empresa
        int salarioTotal = empleados.stream()
                .mapToInt(Empleado::getSalario)
                .sum();

        System.out.println("\nSalario total de la empresa: " + salarioTotal + "€");
    }
}
