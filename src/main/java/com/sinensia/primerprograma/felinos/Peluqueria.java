package com.sinensia.primerprograma.felinos;

import java.util.logging.Logger;

/**
 * Clase para para peluquería de felinos.
 */
public class Peluqueria<T extends Felino> {

    private static final Logger logger = Logger.getLogger(Peluqueria.class.getName());

    private final T felino;

    /**
     * Crea una instancia de Peluqueria para un felino específico.
     *
     * @param felino El felino al que se le realizará
     *               el servicio de peluquería.
     */
    public Peluqueria(T felino) {
        this.felino = felino;
    }

    /**
     * Método para cortar el pelo a un felino.
     *
     */
    public void limpiarCortar() {
        // hay que hacer el casting explícito a Gato para usar getNombre
        String mensaje = "Cortando el pelo a "
                + (felino instanceof Gato
                        ? felino.getEspecie() + " " + ((Gato) felino).getNombre()
                        : felino.getEspecie());

        logger.info(mensaje);
    }

}
