package com.sinensia.primerprograma.threads;

/**
 * Ejemplos de manejo de Threads.
 */
public class ThreadDemo {
    /**
     * Ejemplos de manejo de Threads. Metodo main.
     * Suprimimos el warning de S1604 ya que es para demostración
     * Como se puede instanciar de diferentes formas, se suprime el warning de S1604
     *
     * @param args argumentos de la linea de comandos
     */
    @SuppressWarnings("java:S1604")
    public static void main(String[] args) {

        // Crear un hilo
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                // Código del hilo
                System.out.println("Hola desde el hilo "
                        + Thread.currentThread().getName());
                // Hola desde el hilo Thread-0
            }
        });
        Thread hilo2 = new Thread(() -> System.out.println("Hola desde el hilo 2 "
                + Thread.currentThread().getName()));
        // Hola desde el hilo Thread-1

        // Iniciar el hilo
        hilo2.start();
        hilo.start();

        // ejmeplo con mi clase ContadorRunnable
        // 100 milisegundos, 100 vueltas
        ContadorRunnable contador = new ContadorRunnable(1000, 100);
        Thread hiloContador = new Thread(contador);
        hiloContador.start();
        hiloContador.interrupt();

        // 100 milisegundos, 100 vueltas
        ContadorRunnable contador2 = new ContadorRunnable(100, 100);
        Thread hiloContador2 = new Thread(contador2);
        hiloContador2.start();
        hiloContador2.interrupt();

    }
}
