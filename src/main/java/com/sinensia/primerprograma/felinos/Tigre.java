package com.sinensia.primerprograma.felinos;

import com.sinensia.primerprograma.interfaces.Rugible;

/**
 * Clase Tigre hereda de Felino e implementa Rugible.
 * emiteSonido() llama a rugir()
 * implementa su propio getEspecie()
 *
 * @see com.sinensia.primerprograma.felinos.Felino
 * @see com.sinensia.primerprograma.interfaces.Rugible
 * @see com.sinensia.primerprograma.interfaces.Maullable
 * @see com.sinensia.primerprograma.felinos.Gato
 * @see com.sinensia.primerprograma.felinos.Jaguar
 * 
 * @since 2023
 * @version 1.0
 */
final class Tigre extends Felino implements Rugible {
    private static final String NOMBRE_CIENTIFICO = "Panthera tigris";

    /**
     * Constructor de Tigre por defecto. Aumenta la cantidad de felinos.
     * NO está sobrecargado
     *
     * @see com.sinensia.primerprograma.felinos.Felino#Felino()
     * @see com.sinensia.primerprograma.felinos.Felino#cantidadFelinos
     */
    public Tigre() {
        super(); // Llamo a super para contar el jaguar
    }

    /**
     * implementación de getNombreCientifico() de Felino.
     *
     * @see com.sinensia.primerprograma.felinos.Felino#getNombreCientifico()
     * @return nombre_cientifico (String)
     */
    @Override
    protected String getNombreCientifico() {
        return NOMBRE_CIENTIFICO;
    }

    /**
     * rugir() es un método del interfaz Rugible.
     *
     * @see com.sinensia.primerprograma.interfaces.Rugible
     * @see com.sinensia.primerprograma.felinos.Felino#emitirSonido()
     */
    @Override
    public void rugir() {
        System.out.println("El tigre ruge");
    }

    /**
     * emitirSonido() llama a rugir()
     * Todos los Felinos emiten sonido, pero cada uno lo hace de una forma
     * diferente. Los Tigres rugen.
     *
     * @see com.sinensia.primerprograma.felinos.Felino#emitirSonido()
     * @see com.sinensia.primerprograma.felinos.Tigre#rugir()
     * @see com.sinensia.primerprograma.interfaces.Rugible
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
     * @see com.sinensia.primerprograma.felinos.Felino#getEspecie()
     * @return especie (String)
     * 
     */
    @Override
    public String getEspecie() {
        return "Tigre";
    }

    /**
     * override de comer() para el jaguar.
     * todos los Felinos comen pero cada uno
     * a su manera. Los gatos comen ratones
     *
     * @see com.sinensia.primerprograma.felinos.Felino#comer()
     * 
     */
    @Override
    public void comer() {
        System.out.println("El tigre come antílopes");
    }
}
