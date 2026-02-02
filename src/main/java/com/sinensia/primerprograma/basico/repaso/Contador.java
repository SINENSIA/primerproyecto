package com.sinensia.primerprograma.basico.repaso;

/**
 * <b>Concepto: Miembros Estáticos vs de Instancia</b>
 * <p>
 * Esta clase muestra cómo una variable {@code static} es compartida por todas
 * las instancias, mientras que una variable normal pertenece exclusivamente a
 * cada objeto.
 * </p>
 * 
 * @author Sinensia
 */
public class Contador {

    /** Variable compartida por todos los objetos Contador */
    public static int totalContadores = 0;

    /** Variable única para cada objeto Contador */
    public int contadorLocal = 0;

    /**
     * Constructor por defecto. Incrementa el contador global cada vez que
     * se crea una nueva instancia.
     */
    public Contador() {
        totalContadores++;
    }

    /**
     * Incrementa solo el contador de la instancia actual.
     * 
     * @return El nuevo valor del contador local.
     */
    public int incrementarContador() {
        this.contadorLocal++;
        return contadorLocal;
    }

    /**
     * Muestra por consola el estado actual de ambos contadores.
     */
    public void mostrarValores() {
        System.out.println("Global (Static): " + totalContadores);
        System.out.println("Local (Instancia): " + contadorLocal);
    }
}
