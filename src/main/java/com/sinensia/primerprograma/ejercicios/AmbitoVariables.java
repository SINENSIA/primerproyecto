package com.sinensia.primerprograma.ejercicios;

/**
 * Ejemplo de variables en Java con ámbito.
 * Clase que contiene variables con ámbito
 * La variable globalVar puede ser accedida y modificada desde cualquier lugar
 * de la clase
 * La variable localVar solo puede ser accedida y modificada dentro del método
 * main
 * La variable blockVar puede ser accedida y modificada dentro del if
 * y el bloque de código que lo contiene.
 *
 * @author Sinensia
 **/

public class AmbitoVariables {
    // Variable de clase (global)
    static int globalVar = 10;

    /**
     * Main method.
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // Variable local (dentro del método main)
        int localVar = 20;

        if (localVar == 20) {
            // Variable de bloque (dentro del if)
            int blockVar = 30;
            System.out.println("Valor de blockVar: " + blockVar);
        }
                
        System.out.println("Valor de localVar: " + localVar);
        System.out.println("Valor de globalVar: " + globalVar);
    }
}
