package com.sinensia.primerprograma.patrones.factory;

// INTERFAZ COMÚN
interface Animal {
    void hacerSonido();
}

// IMPLEMENTACIONES CONCRETAS
class Perro implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau guau");
    }
}

class Gato implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}

// FACTORÍA
class AnimalFactory {
    public static Animal crearAnimal(String tipo) {
        if ("Perro".equalsIgnoreCase(tipo)) {
            return new Perro();
        } else if ("Gato".equalsIgnoreCase(tipo)) {
            return new Gato();
        } else {
            throw new IllegalArgumentException("Tipo de animal no soportado: " + tipo);
        }
    }
}

// PROGRAMA PRINCIPAL
public class FactoryEjemplo {
    public static void main(String[] args) {
        // Crear animales usando la fábrica
        Animal perro = AnimalFactory.crearAnimal("Perro");
        Animal gato = AnimalFactory.crearAnimal("Gato");

        // Usar los animales
        perro.hacerSonido(); // Salida: Guau guau
        gato.hacerSonido(); // Salida: Miau
    }
}
