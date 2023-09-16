package com.sinensia.primerprograma.threads;

/**
 * Clase que implementa la interfaz Runnable.
 *
 * @see java.lang.Runnable
 * @see java.lang.Thread
 * @since 2023
 * @version 1.0.0
 * @author Sinensia
 */
public class ContadorRunnable implements Runnable {

    private int contador;
    private int retardo;
    private int valor;

    /**
     * Constructor de la clase ContadorRunnable.
     *
     * @param retardo tiempo de retardo
     * @param valor   valor máximo del contador
     */
    public ContadorRunnable(int retardo, int valor) {
        this.contador = 0;
        this.retardo = retardo;
        this.valor = valor;
    }

    @Override
    public void run() {
        while (contador < valor) {
            contador++;
            System.out.println("Contador: " + Thread.currentThread().getName() + " " + contador);
            try {
                Thread.sleep(retardo);
            } catch (InterruptedException ex) {
                System.out.println("Exception HILO" + Thread.currentThread().getName());
                System.err.println("Error al parar el hilo");
                Thread.currentThread().interrupt(); // Buena práctica reinterrumpir el hilo
            } finally {
                System.out.println("Estoy en el HILO: ---------------" + Thread.currentThread().getName()
                        + " ------------------" + contador);
                Thread.currentThread().getName();
            }
            // Todo lo demás es un bug
        }
    }

}
