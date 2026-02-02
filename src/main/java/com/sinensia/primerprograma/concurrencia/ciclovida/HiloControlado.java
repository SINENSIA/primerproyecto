package com.sinensia.primerprograma.concurrencia.ciclovida;

public class HiloControlado extends Thread {
    private boolean enEjecucion = true;
    private boolean pausado = false;

    public void pausar() {
        pausado = true;
    }

    public void reanudar() {
        pausado = false;
        synchronized (this) {
            notify(); // Reactiva el hilo si estaba en espera
        }
    }

    public void detener() {
        enEjecucion = false;
        this.interrupt(); // Por si estaba en sleep o wait
    }

    @Override
    public void run() {
        try {
            System.out.println("[INICIO] Hilo en ejecución: " + getName());

            int i = 0;
            while (enEjecucion) {
                synchronized (this) {
                    while (pausado) {
                        System.out.println("[PAUSA] Hilo en pausa: " + getName());
                        wait(); // Espera hasta que se llame a `notify()`
                    }
                }

                System.out.println("[TRABAJO] Iteración " + i + " en hilo " + getName());
                Thread.sleep(500); // Simula trabajo

                if (i == 4) {
                    throw new RuntimeException("Error simulado en el hilo");
                }

                i++;
            }

        } catch (InterruptedException e) {
            System.out.println("[INTERRUPCIÓN] El hilo fue interrumpido.");
        } catch (RuntimeException ex) {
            System.out.println("[ERROR] Excepción en hilo: " + ex.getMessage());
        } finally {
            System.out.println("[FIN] El hilo ha terminado: " + getName());
        }
    }
}
