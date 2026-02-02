package com.sinensia.primerprograma.poo.interfaces;

/**
 * Interfaz Maullable lo ponemos publico ya que lo necesitamos en otros
 * paquetes.
 *
 * @version 1.0
 * @since 2023
 * @see com.sinensia.primerprograma.poo.interfaces.Rugible
 * @see com.sinensia.primerprograma.poo.felinos.Felino
 * @see com.sinensia.primerprograma.poo.felinos.Gato
 * @see com.sinensia.primerprograma.poo.felinos.Tigre
 * @see com.sinensia.primerprograma.poo.felinos.Jaguar
 */
public interface Maullable { // package abstract por defecto pero lo ponemos publico
    void maullar();
}
