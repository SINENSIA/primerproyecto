package com.sinensia.primerprograma.colecciones.copy;

import java.util.ArrayList;
import java.util.List;

public class Cursos {

    void main() {
        List<String> cursoJavaInmutable = List.of("Pepe", "Juan", "Roberto");
        // cursoJavaInmutable.set(0, "Luis");

        List<String> cursoJava = new ArrayList<>(List.of("Pepe", "Juan", "Roberto"));
        cursoJava.set(0, "Luis");

        // IO.println(cursoJavaInmutable);
        IO.println(cursoJava);

        List<String> cursoPython = cursoJava;
        IO.println(cursoPython);
        cursoPython.add("Sarah");
        cursoPython.add("Ana");
        cursoJava.set(1, "Pedro");
        IO.println("Asistentes Curso Python" + cursoPython);

        IO.println("----------------------------");

        IO.println("Asistentes Curso Java" + cursoJava);
        IO.println("----------------------------");

        cursoPython.set(0, "Carlos");
        IO.println(cursoPython);
        IO.println(cursoJava);


        IO.println("----------------------------");
        // Copia shallow
        List<String> original = new ArrayList<>();
        original.add("Pepe");
        original.add("Juan");
        original.add("Roberto");

        List<String> copia = new ArrayList<>(original);

        copia.set(0, "Pedro");
        IO.println(copia); // [Pedro, Juan, Roberto]
        IO.println(original); // [Pepe, Juan, Roberto]
    }
}
