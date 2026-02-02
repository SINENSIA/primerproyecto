package com.sinensia.primerprograma.basico;

/**
 * <b>Concepto: Clase Singleton para Generación Aleatoria</b>
 * <p>
 * Implementa el patrón Singleton para asegurar que solo exista una instancia
 * de {@link java.util.Random} en todo el paquete básico, optimizando recursos.
 * </p>
 * 
 * @author Sinensia
 */
public class SingletonRandom {

    // Instancia única (Eager initialization)
    private static final java.util.Random INSTANCE = new java.util.Random();

    /**
     * Constructor privado para prohibir la creación de objetos externos.
     */
    private SingletonRandom() {
    }

    /**
     * Obtiene la instancia compartida de Random.
     * 
     * @return La única instancia de Random.
     */
    public static java.util.Random getInstance() {
        return INSTANCE;
    }
}
