package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.*;

public class EjercicioColecciones {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        int minum = 10;
        int minum1 = 10;
        IO.print(minum == minum1);

        Alumno miAlumnoSecretaria = new Alumno("Carlos", "4399432Z");

        Alumno miAlumnoDireccion = new Alumno("Carlos", "4399432Z");
        Integer myInt = 10;
        IO.println("¿Son iguales? : " + miAlumnoSecretaria.equals(miAlumnoDireccion));
        IO.println(miAlumnoSecretaria.hashCode());
        IO.println(miAlumnoDireccion.hashCode());

        IO.println("====================================");

        // Paso 1 y 2: Array nativo y manejo de excepciones
        Alumno[] alumnos = new Alumno[3];
        try {
            alumnos[0] = new Alumno("Ana", "123A");
            alumnos[1] = new Alumno("Luis", "456B");
            alumnos[2] = new Alumno("María", "789C");
            alumnos[3] = new Alumno("Extra", "000Z"); // Generará excepción
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: fuera de rango en el array de alumnos.");
        }

        // Paso 3: Convertimos a listas
        System.out.println("Convertimos a List: " + Arrays.asList(alumnos).toString());
        List<Alumno> listaArray = new ArrayList<>(Arrays.asList(alumnos));
        List<Alumno> listaLinked = new LinkedList<>(Arrays.asList(alumnos));

        // Eliminamos por índice
        listaArray.remove(1);

        // Eliminamos por objeto (sin equals no funcionará)
        Alumno alumnoEliminar = new Alumno("Ana", "123A");
        listaLinked.remove(alumnoEliminar);

        System.out.println("\nLista ArrayList después de eliminar índice 1:");
        listaArray.forEach(System.out::println);

        System.out.println("\nLista LinkedList después de eliminar por objeto:");
        listaLinked.forEach(System.out::println);

        // Paso 4: Comparar rendimiento
        compararRendimientoListas();

        // Paso 5: Uso de HashSet y duplicados
        Set<Alumno> conjunto = new HashSet<>();
        Alumno a1 = new Alumno("Pepe", "111X");
        Alumno a2 = new Alumno("Pepe", "111X"); // Mismo DNI
        System.out.println("ALumno1 (Pepe): " + a1);
        System.out.println("ALumno2 (Pepe): " + a2);

        conjunto.add(a1);
        conjunto.add(a2);

        System.out.println("\nContenido del HashSet:");
        conjunto.forEach(System.out::println);
        System.out.println("Tamaño del conjunto: " + conjunto.size());
    }

    private static void compararRendimientoListas() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long t1 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, i);
        }
        long t2 = System.nanoTime();
        System.out.println("\nArrayList inserción al inicio: " + (t2 - t1) / 2048 + " ns");

        t1 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, i);
        }
        t2 = System.nanoTime();
        System.out.println("LinkedList inserción al inicio: " + (t2 - t1) / 2048 + " ns");
    }

}
