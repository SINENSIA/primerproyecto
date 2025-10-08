package com.sinensia.primerprograma.patrones.abstract_factory;

/*
 * Objetivo del patrón Abstract Factory:
 *  - Crear "familias" de objetos relacionados (Animal + Habitat) sin acoplar el código cliente
 *    a clases concretas.
 *  - Garantizar compatibilidad entre productos de la misma familia.
 *
 * Cuándo usar:
 *  - Cuando necesitas crear múltiples productos que deben trabajar juntos y quieres poder
 *    intercambiar familias completas (p.ej., "Granja" vs "Salvaje") sin cambiar el cliente.
 *
 * Beneficios:
 *  - Desacopla el cliente de implementaciones concretas.
 *  - Facilita añadir nuevas familias sin tocar el cliente (OCP).
 *
 * Coste:
 *  - Más clases y capas de indirección.
 */

/* =========================
 *      INTERFACES COMUNES
 * =========================
 * Contratos que definen la "familia" de productos. El cliente programa contra estas
 * interfaces y no conoce implementaciones concretas.
 */
interface Animal {
    void hacerSonido();
}

interface Habitat {
    void mostrarHabitat();
}

/*
 * =========================
 * FACTORÍA ABSTRACTA
 * =========================
 * Declara métodos de creación para cada tipo de producto de la familia.
 * Cada fábrica concreta debe producir implementaciones "compatibles" entre sí.
 */
interface AnimalFactory {
    Animal crearAnimal(); // Producto A

    Habitat crearHabitat(); // Producto B
}

/*
 * ======================================================
 * IMPLEMENTACIONES CONCRETAS — Familia: Animales de Granja
 * ======================================================
 * Regla: los productos de una misma familia están diseñados para "encajar"
 * entre sí.
 */
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

/*
 * ===================================================
 * IMPLEMENTACIONES CONCRETAS — Familia: Animales Salvajes
 * ===================================================
 */
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

/*
 * ==========================================
 * FACTORÍAS CONCRETAS (Familias)
 * ==========================================
 * Cada factoría concreta devuelve productos compatibles de su familia.
 * Si mañana agregas un nuevo producto (p.ej., Comida), aquí añadirías el método
 * y en cada factoría concreta su implementación específica.
 */
class GranjaFactory implements AnimalFactory {
    @Override
    public Animal crearAnimal() {
        // Decisión de instanciación encapsulada: el cliente no ve "new Perro()"
        return new Perro();
    }

    @Override
    public Habitat crearHabitat() {
        return new Establo();
    }
}

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

/*
 * =========================
 * PROGRAMA PRINCIPAL
 * =========================
 * Demuestra cómo el cliente opera sólo con la interfaz AnimalFactory y los
 * contratos Animal/Habitat. Cambiar de familia = cambiar la fábrica.
 *
 * Extensión guiada:
 * 1) Añadir nuevo producto a la familia:
 * - Crear interface p.ej. interface Comida { void describir(); }
 * - Añadir método en AnimalFactory: Comida crearComida();
 * - Implementar Comida en cada familia (Pension/Carne, etc.).
 * - Actualizar cada factoría concreta.
 *
 * 2) Añadir nueva familia:
 * - Crear nuevas clases concretas para cada producto (p.ej., Pingüino, Hielo).
 * - Crear NuevaFamiliaFactory implementando AnimalFactory.
 * - En main, sustituir la fábrica.
 *
 * Buenas prácticas:
 * - Interfaces y clases en archivos separados en producción.
 * - Inyectar la factoría (DI) para facilitar pruebas y conmutación en runtime.
 */
public class AbstractFactoryEjemplo {
    public static void main(String[] args) {
        // 1) Cliente elige una FAMILIA: aquí "Granja". Podría venir por config o
        // inyección.
        AnimalFactory granjaFactory = new GranjaFactory();

        // 2) El cliente crea productos mediante la factoría, sin conocer clases
        // concretas.
        Animal perro = granjaFactory.crearAnimal();
        Habitat establo = granjaFactory.crearHabitat();

        // 3) Usa los productos vía sus interfaces.
        perro.hacerSonido(); // Guau guau
        establo.mostrarHabitat(); // Vivo en un establo

        // 4) Conmutar de familia no requiere cambiar el resto del código cliente:
        AnimalFactory salvajeFactory = new SalvajeFactory();
        Animal leon = salvajeFactory.crearAnimal();
        Habitat sabana = salvajeFactory.crearHabitat();
        leon.hacerSonido(); // Rooarrr
        sabana.mostrarHabitat(); // Vivo en la sabana
    }
}
