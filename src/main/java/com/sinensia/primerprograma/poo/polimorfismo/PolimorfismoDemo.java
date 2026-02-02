package com.sinensia.primerprograma.poo.polimorfismo;

import java.util.ArrayList;
import java.util.List;

public class PolimorfismoDemo {
    public static void main(String[] args) {
        // Crear una lista de Felinos
        List<Felino> felinos = new ArrayList<>();

        // Agregar instancias de Gato y Tigre a la lista
        felinos.add(new Gato("Mittens"));
        felinos.add(new Tigre("Simba"));

        // Iterar sobre la lista y hacer que cada felino haga sonido
        for (Felino felino : felinos) {
            felino.hacerSonido();
        }
    }
}

abstract class Felino {
    private final String nombre;

    public Felino(String nombre) {
        this.nombre = nombre;
    }

    public abstract void hacerSonido();

    public String getNombre() {
      return nombre;
    }
}

class Gato extends Felino {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El gato hace ruido de gato.");
    }
}

class Tigre extends Felino {
    public Tigre(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El tigre hace rugido de tigre.");
    }
}
