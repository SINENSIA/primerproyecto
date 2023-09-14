package com.sinensia.primerprograma.felinos;

import com.sinensia.primerprograma.interfaces.Rugible;

/**
 * Clase Jaguar implementa rugible. emiteSonido() llama a rugir()
 * implementa su propio getEspecie()
 *
 * @see com.sinensia.primerprograma.felinos.Felino
 * @see com.sinensia.primerprograma.interfaces.Rugible
 * @see com.sinensia.primerprograma.interfaces.Maullable
 * @see com.sinensia.primerprograma.felinos.Gato
 *
 * @version 1.0
 * @since 2023
 **/
final class Jaguar extends Felino implements Rugible {
    private static final String NOMBRE_CIENTIFICO = "Panthera onca";

    /**
     * Constructor de Jaguar por defecto. Aumenta la cantidad de felinos.
     * NO está sobrecargado
     */
    public Jaguar() {
        super(); // Llamo a super para contar el jaguar
    }

    /**
     * emitirSonido() es un método de Felino y llama a rugir()
     * todos los Felinos emiten sonido, pero cada uno lo hace de una forma.
     * diferente. Los Jaguares rugen.
     *
     * @see com.sinensia.primerprograma.felinos.Felino#emitirSonido()
     * @see com.sinensia.primerprograma.felinos.Jaguar#rugir()
     * @see com.sinensia.primerprograma.interfaces.Rugible
     * 
     */
    @Override
    protected void emitirSonido() {
        rugir();
    }

    /**
     * rugir() es un método del interfaz Rugible.
     * Se llama desde emitirSonido()
     *
     * @see com.sinensia.primerprograma.interfaces.Rugible
     * @see com.sinensia.primerprograma.felinos.Felino#emitirSonido()
     * @see com.sinensia.primerprograma.felinos.Jaguar#emitirSonido()
     * 
     */
    @Override
    public void rugir() {
        System.out.println("El jaguar ruge");
    }

    /**
     * getEspecie() es un método de Felino.
     * Todos los Felinos tienen especie, pero cada uno implementa su propio
     * getEspecie().
     *
     * @see com.sinensia.primerprograma.felinos.Felino#getEspecie()
     * @return especie (String)
     */
    @Override
    public String getEspecie() {
        return "Jaguar";
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
        System.out.println("El jaguar come capibaras");
    }

    /**
     * override de getNombreCientifico() para el jaguar.
     * todos los Felinos tienen nombre científico pero cada uno
     * tiene uno diferente
     */
    public String getNombreCientifico() {
        return NOMBRE_CIENTIFICO;
    }

}
