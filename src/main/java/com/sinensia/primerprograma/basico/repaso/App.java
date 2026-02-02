package com.sinensia.primerprograma.basico.repaso;

/**
 * <b>Clase Principal de Repaso (App)</b>
 * <p>
 * Sirve como orquestador para probar las clases creadas en este módulo
 * (Gafas, Contador, AmbitoVariable).
 * </p>
 * 
 * @author Sinensia
 */
public class App {

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        // 1. Instanciación y uso de métodos de objeto
        Gafas gafas = new Gafas("Cerca", "Redondas", 1.5f);
        gafas.ponerGafas();
        gafas.setColor("Morado"); // Provocará mensaje de error
        gafas.quitarGafas();

        // 2. Diferencia entre variables de Instancia vs Estáticas
        Contador miContador1 = new Contador();
        Contador miContador2 = new Contador();

        miContador1.contadorLocal = 20;
        miContador2.contadorLocal = 30;

        // Acceso a variable estática (a través de la CLASE)
        System.out.println("Total de contadores creados: " + Contador.totalContadores);

        // Acceso a variable estática de otra clase
        System.out.println("Variable global de AmbitoVariable: " + AmbitoVariable.variableGlobal);
    }
}
