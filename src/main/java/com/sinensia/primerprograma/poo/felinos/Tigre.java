package com.sinensia.primerprograma.poo.felinos;

import java.util.logging.Logger;

import com.sinensia.primerprograma.poo.interfaces.Rugible;

/**
 * Clase Tigre hereda de Felino e implementa Rugible.
 * emiteSonido() llama a rugir()
 * implementa su propio getEspecie()
 *
 * @see com.sinensia.primerprograma.poo.felinos.Felino
 * @see com.sinensia.primerprograma.poo.interfaces.Rugible
 * @see com.sinensia.primerprograma.poo.interfaces.Maullable
 * @see com.sinensia.primerprograma.poo.felinos.Gato
 * @see com.sinensia.primerprograma.poo.felinos.Jaguar
 * 
 * @since 2023
 * @version 1.0
 */
final class Tigre extends Felino implements Rugible {
    private static final String NOMBRE_CIENTIFICO = "Panthera tigris";

    private static final Logger logger = Logger.getLogger(Tigre.class.getName());

    /**
     * Constructor de Tigre por defecto. Aumenta la cantidad de felinos.
     * NO está sobrecargado
     *
     * @see com.sinensia.primerprograma.poo.felinos.Felino#Felino()
     * @see com.sinensia.primerprograma.felinos.Felino#cantidadFelinos
     */
    public Tigre() {
        super(); // Llamo a super para contar el tigre
    }

    /**
     * implementación de getNombreCientifico() de Felino.
     *
     * @see com.sinensia.primerprograma.poo.felinos.Felino#getNombreCientifico()
     * @return nombre_cientifico (String)
     */
    @Override
    protected String getNombreCientifico() {
        return NOMBRE_CIENTIFICO;
    }

    /**
     * rugir() es un método del interfaz Rugible.
     *
     * @see com.sinensia.primerprograma.poo.interfaces.Rugible
     * @see com.sinensia.primerprograma.poo.felinos.Felino#emitirSonido()
     */
    @Override
    public void rugir() {
        logger.info("El tigre ruge");
    }

    /**
     * emitirSonido() llama a rugir()
     * Todos los Felinos emiten sonido, pero cada uno lo hace de una forma
     * diferente. Los Tigres rugen.
     *
     * @see com.sinensia.primerprograma.poo.felinos.Felino#emitirSonido()
     * @see com.sinensia.primerprograma.poo.felinos.Tigre#rugir()
     * @see com.sinensia.primerprograma.poo.interfaces.Rugible
     */
    @Override
    protected void emitirSonido() {
        rugir();
    }

    /**
     * getEspecie() es un método de Felino.
     * Todos los Felinos tienen especie, pero cada uno implementa su propio
     * getEspecie().
     *
     * @see com.sinensia.primerprograma.poo.felinos.Felino#getEspecie()
     * @return especie (String)
     * 
     */
    @Override
    public String getEspecie() {
        return "Tigre";
    }

    /**
     * override de comer() para el tigre.
     * todos los Felinos comen pero cada uno
     * a su manera. Los tigre comen antílopes.
     *
     * @see com.sinensia.primerprograma.poo.felinos.Felino#comer()
     * 
     */
    @Override
    public void comer() {
        logger.info("El tigre come antílopes");
    }
}
