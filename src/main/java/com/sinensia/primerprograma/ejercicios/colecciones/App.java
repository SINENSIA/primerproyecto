package com.sinensia.primerprograma.ejercicios.colecciones;

public class App {
    public static void main(String[] args) {

        Alumno carlos = new Alumno("Carlos", "343433322Z");
        Alumno carlos2 = new Alumno("Carlos", "343433322Z");
        Integer myInt = 10;
        Integer tuInt = 10;
        System.out.println(myInt.equals(tuInt));
        System.out.println(carlos.equals(carlos2));
        System.out.println(carlos2.toString());

    }
}
