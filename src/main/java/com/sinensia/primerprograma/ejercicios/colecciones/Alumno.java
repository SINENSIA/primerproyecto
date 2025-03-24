package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


// Clase Alumno interna
public class Alumno {
    private String nombre;
    private String dni;
    private List<String> cursos;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.cursos = new ArrayList<>();
    }

    public void inscribirCurso(String curso) {
        cursos.add(curso);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ") - Cursos: " + cursos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Alumno alumno = (Alumno) obj;
        return Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
