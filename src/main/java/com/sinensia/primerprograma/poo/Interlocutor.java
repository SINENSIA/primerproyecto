package com.sinensia.primerprograma.poo;

import java.util.ArrayList;
import java.util.List;

public class Interlocutor {

    public String saludar(String nombre) {
        return "Hola " + nombre;
    }

    public void sumar() {

        List<String> meses = new ArrayList<>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");

        // Utilizando el método forEach para iterar sobre los elementos
        meses.forEach(mes -> System.out.println("Mes: " + mes));
    }
}
