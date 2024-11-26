package com.sinensia.primerprograma.noviembre;

/**
 * Ejercicio 2 contador.
 * 
 */

public class Contador {

    public static int totalContadores = 0;
    private int contadorLocal = 0;

    public Contador() {
        totalContadores++;
    }

    /**
     * Incrementa el contador. <-- ejemplo de comentario superfluo (semantica)
     */
    public int incrementarContador() {
        this.contadorLocal++;
        return contadorLocal;

    }

    public void mostrarValores() {
        System.out.println("Total Contadores: " + totalContadores);
        System.out.println("Contador: " + contadorLocal);
    }
}
