package com.sinensia.primerprograma.patrones.abstract_factory;

// INTERFACES COMUNES
interface Animal {
    void hacerSonido();
}

interface Habitat {
    void mostrarHabitat();
}

// FACTORÍA ABSTRACTA
interface AnimalFactory {
    Animal crearAnimal();

    Habitat crearHabitat();
}

// IMPLEMENTACIONES CONCRETAS (Familia de Animales de Granja)
class Perro implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau guau");
    }
}

class Establo implements Habitat {
    @Override
    public void mostrarHabitat() {
        System.out.println("Vivo en un establo");
    }
}

// IMPLEMENTACIONES CONCRETAS (Familia de Animales Salvajes)
class Leon implements Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Rooarrr");
    }
}

class Sabana implements Habitat {
    @Override
    public void mostrarHabitat() {
        System.out.println("Vivo en la sabana");
    }
}

// FACTORÍA CONCRETA (Animales de Granja)
class GranjaFactory implements AnimalFactory {
    @Override
    public Animal crearAnimal() {
        return new Perro();
    }

    @Override
    public Habitat crearHabitat() {
        return new Establo();
    }
}

// FACTORÍA CONCRETA (Animales Salvajes)
class SalvajeFactory implements AnimalFactory {
    @Override
    public Animal crearAnimal() {
        return new Leon();
    }

    @Override
    public Habitat crearHabitat() {
        return new Sabana();
    }
}

// PROGRAMA PRINCIPAL
public class AbstractFactoryEjemplo {
    public static void main(String[] args) {
        // Crear una fábrica para animales de granja
        AnimalFactory granjaFactory = new GranjaFactory();
        Animal perro = granjaFactory.crearAnimal();
        Habitat establo = granjaFactory.crearHabitat();
        perro.hacerSonido(); // Salida: Guau guau
        establo.mostrarHabitat(); // Salida: Vivo en un establo

        // Crear una fábrica para animales salvajes
        AnimalFactory salvajeFactory = new SalvajeFactory();
        Animal leon = salvajeFactory.crearAnimal();
        Habitat sabana = salvajeFactory.crearHabitat();
        leon.hacerSonido(); // Salida: Rooarrr
        sabana.mostrarHabitat(); // Salida: Vivo en la sabana
    }
}
