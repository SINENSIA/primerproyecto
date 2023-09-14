package com.sinensia.primerprograma;

/**
 * Clase abstracta Felino con contador de felinos.
 *
 * @see com.sinensia.primerprograma.interfaces.Rugible
 * @see com.sinensia.primerprograma.interfaces.Maullable
 * @see com.sinensia.primerprograma.Gato
 * @see com.sinensia.primerprograma.Tigre
 * @see com.sinensia.primerprograma.Jaguar
 * 
 * @version 1.0
 * @since 2023
 * @author Sinensia
 */
abstract sealed class Felino permits Gato, Tigre, Jaguar {

    // private static pertenece a la clase
    private static int cantidadFelinos = 0;

    // private, que se cambie con el setter
    // por si tenemos que hacer validaciones

    /**
     * getter de nombre para el felino.
     * Encapsulamos el nombre para que no se pueda
     * modificar desde fuera de la clase.
     *
     * @return nombre (String)
     */
    protected abstract String getNombreCientifico();

    /**
     * Todos los felinos tienen especie.
     * Pero obligamos a que las clases hijas
     * implementen su propio getEspecie()
     *
     * @return especie (String)
     */
    protected abstract String getEspecie();

    /**
     * Constructor de Felino por defecto.
     * Aumenta la cantidad de felinos.
     * 
     */
    protected Felino() {
        cantidadFelinos++;
    }

    /**
     * getter de cantidadFelinos que es static
     * para llevar la cuenta de felinos.
     *
     * @return cantidadFelinos (int)
     */
    public static int getCantidadFelinos() {
        return cantidadFelinos;
    }

    /**
     * Todos los felinos comen. Ahora dejamos
     * que las clases hijas implementen su propio
     * comportamiento.
     */
    protected void comer() {
        System.out.println("El felino come");
    }

    /**
     * Metodo abstracto emitirSonido() que sera implementado por las clases hijas
     * obligatoriamente.
     */
    protected abstract void emitirSonido();

}
