package com.sinensia.primerprograma.basico.repaso;

/**
 * <b>Paso por Valor vs Paso por Referencia</b>
 * <p>
 * En Java, T,ODO es paso por valor. Sin embargo, para los objetos, el "valor"
 * que se pasa es la referencia (dirección de memoria).
 * </p>
 * 
 * @author Sinensia
 */
public class PrimitivosReferencia {

    /**
     * Intenta modificar un primitivo y un objeto.
     * 
     * @param numero El valor primitivo se COPIA (no afecta al original).
     * @param cadena La referencia al objeto se COPIA (apunta al mismo objeto
     *               original).
     */
    public static void modificar(int numero, StringBuilder cadena) {
        numero++; // Solo cambia en el ámbito local de este método
        cadena.append(" [Modificado]"); // Afecta al objeto original en el Heap
    }

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        int miNumero = 10;
        StringBuilder miTexto = new StringBuilder("Texto Base");

        System.out.println("Antes:  " + miNumero + " | " + miTexto);

        modificar(miNumero, miTexto);

        System.out.println("Después: " + miNumero + " | " + miTexto);
        // Resultado: miNumero sigue siendo 10, miTexto ha cambiado.
    }
}
