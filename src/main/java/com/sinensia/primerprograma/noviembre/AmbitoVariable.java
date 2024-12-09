package com.sinensia.primerprograma.noviembre;

/**
 * Clase que muestra el uso de variables en Java con ámbito.
 *
 * @author Carlos
 * @version 1.0
 * @see java.lang.System
 * @since 2024
 */

public class AmbitoVariable {

    static int variableGlobal = 10;
    int prueba = 12;

    public static int metodoAmbito() {
        int variableLocalMetodo = 7;

        return variableLocalMetodo;
    }
 
    /**
     * Main method. Utiliza variables locales, globales, y métodos.
     *
     * @param args no se usa
     */

    public static void main(String[] args) {

        int variableLocal = 20;

        if (true) {
            int variableInterna = 30;
            System.out.println(variableInterna); // Se puede acceder a la variable
            // interna dentro del bloque if
        }

        System.out.println(variableLocal); // Se puede acceder a la variable local del método main
        System.out.println(variableGlobal); // Se puede acceder a la variable global
        System.out.println(metodoAmbito()); // Se puede acceder al método
    }

}
