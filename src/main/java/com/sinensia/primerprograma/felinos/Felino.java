package com.sinensia.primerprograma.felinos;

import java.util.List;
import java.util.logging.Logger;

/**
 * Clase abstracta Felino con contador de felinos.
 *
 * @see com.sinensia.primerprograma.interfaces.Rugible
 * @see com.sinensia.primerprograma.interfaces.Maullable
 * @see com.sinensia.primerprograma.Gato
 * @see com.sinensia.primerprograma.Tigre
 * @see com.sinensia.primerprograma.Jaguar
 * 
 * @version 1.1
 * @since 2023
 * @author Sinensia
 */
abstract sealed class Felino permits Gato, Tigre, Jaguar {

    // Variable estática para contar cada instancia de felino.
    private static int cantidadFelinos = 0;

    // Logger para registrar actividades.
    private static final Logger logger = Logger.getLogger(Felino.class.getName());

    /**
     * Constructor de Felino.
     * Incrementa el contador de felinos.
     */
    protected Felino() {
        synchronized (Felino.class) {
            cantidadFelinos++;
        }
        logger.info("Nuevo felino creado. Cantidad total: " + cantidadFelinos);

    }

    /**
     * Obtiene el nombre científico del felino.
     * Método abstracto obligatorio para clases derivadas.
     *
     * @return Nombre científico del felino.
     */
    protected abstract String getNombreCientifico();

    /**
     * Obtiene la especie del felino.
     * Método abstracto obligatorio para clases derivadas.
     *
     * @return Especie del felino.
     */
    protected abstract String getEspecie();

    /**
     * Método para emitir el sonido del felino.
     * Método abstracto obligatorio para clases derivadas.
     */
    protected abstract void emitirSonido();

    /**
     * Método concreto para simular que el felino come.
     * Puede ser sobrescrito por clases derivadas.
     */
    protected void comer() {
        logger.info("El felino está comiendo.");
    }

    /**
     * Obtiene la cantidad total de felinos creados.
     *
     * @return Cantidad de felinos.
     */
    public static int getCantidadFelinos() {
        return cantidadFelinos;
    }

    /**
     * Finaliza la vida de un felino, decrementando el contador.
     * Este método es opcional, pero útil para ilustrar ciclos de vida.
     */
    public static synchronized void eliminarFelino() {
        if (cantidadFelinos > 0) {
            cantidadFelinos--;
            logger.info("Un felino ha sido eliminado. Cantidad actual: " + cantidadFelinos);
        } else {
            logger.warning("No hay felinos que eliminar.");
        }
    }

    public static void procesarFelinos(List<? extends Felino> felinos, Accionable accion) {
        for (Felino felino : felinos) {
            accion.aplicar(felino);
        }
    }

    public static void simularReaccion(List<? extends Felino> felinos, Reaccionable reaccion) {
        for (Felino felino : felinos) {
            reaccion.reaccionar(felino);
        }
    }
}