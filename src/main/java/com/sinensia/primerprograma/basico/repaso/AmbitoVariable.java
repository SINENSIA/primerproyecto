package com.sinensia.primerprograma.basico.repaso;

/**
 * <b>Concepto: Ámbito de Variables (Scope)</b>
 * <p>
 * Demuestra la visibilidad de las variables en Java según donde sean
 * declaradas:
 * <ul>
 * <li><b>Variables de Clase (Clase/Estáticas):</b> Accesibles desde cualquier
 * parte de la clase.</li>
 * <li><b>Variables de Instancia (Atributos):</b> Pertenecen al objeto.</li>
 * <li><b>Variables Locales:</b> Existen solo dentro del método donde se
 * definen.</li>
 * <li><b>Variables de Bloque:</b> Existen solo dentro de un bloque específico
 * (ej. if, for).</li>
 * </ul>
 * </p>
 * 
 * @author Sinensia
 */
public class AmbitoVariable {

    // Variable de clase (estática): Comparte el mismo valor para todos los objetos
    static int variableGlobal = 10;

    // Variable de instancia: Cada objeto tiene su propia copia
    int prueba = 12;

    /**
     * Ejemplo de variable local al método.
     * 
     * @return un valor calculado
     */
    public static int metodoAmbito() {
        int variableLocalMetodo = 7;
        return variableLocalMetodo;
    }

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        int variableLocal = 20; // Local al main

        if (true) {
            int variableInterna = 30; // Local al bloque IF
            System.out.println("Variable de bloque (if): " + variableInterna);
        }
        // System.out.println(variableInterna); // ERROR: No es accesible aquí

        System.out.println("Variable local (main):  " + variableLocal);
        System.out.println("Variable global (clase): " + variableGlobal);
        System.out.println("Resultado de método:     " + metodoAmbito());
    }
}
