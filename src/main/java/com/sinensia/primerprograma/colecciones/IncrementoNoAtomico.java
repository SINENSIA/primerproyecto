package com.sinensia.primerprograma.colecciones;

/**
 * Ejemplo: Incrementos no atómicos en concurrencia.
 *
 * <p>
 * <b>Problema:</b> En entornos concurrentes, operaciones como valor++ no son
 * atómicas.
 * Cada incremento implica tres pasos: leer el valor, incrementarlo y escribirlo
 * de nuevo.
 * Si dos hilos ejecutan valor++ al mismo tiempo, ambos podrían leer el mismo
 * valor antes
 * de que ninguno escriba, perdiendo así una actualización.
 *
 * <p>
 * <b>Solución:</b>
 * <ul>
 * <li>Usar <code>AtomicInteger.incrementAndGet()</code> para garantizar
 * atomicidad sin bloqueo.</li>
 * <li>Usar un bloque <code>synchronized</code> para proteger la sección
 * crítica.</li>
 * <li>Usar <code>LongAdder</code> para escenarios de alta contención (mejor
 * rendimiento que AtomicInteger).</li>
 * </ul>
 *
 * <p>
 * <b>Discusión:</b> La elección depende del contexto:
 * <ul>
 * <li><b>AtomicInteger:</b> Ligero, ideal cuando la contención es baja.</li>
 * <li><b>Synchronized:</b> Simple, pero introduce bloqueo explícito.</li>
 * <li><b>LongAdder:</b> Más eficiente con muchos hilos, usa celdas internas
 * para distribuir la carga.</li>
 * </ul>
 */
public class IncrementoNoAtomico {

    private static int contadorNoAtomico = 0;
    private static final java.util.concurrent.atomic.AtomicInteger contadorAtomico = new java.util.concurrent.atomic.AtomicInteger(
            0);
    private static final java.util.concurrent.atomic.LongAdder contadorAdder = new java.util.concurrent.atomic.LongAdder();

    public static void main(String[] args) throws InterruptedException {
        int numHilos = 1000;
        Thread[] hilos = new Thread[numHilos];

        // --- Ejemplo 1: incremento no atómico (valor++)
        for (int i = 0; i < numHilos; i++) {
            hilos[i] = new Thread(() -> contadorNoAtomico++);
            hilos[i].start();
        }
        for (Thread hilo : hilos)
            hilo.join();
        System.out.println("Contador no atómico: " + contadorNoAtomico); // < numHilos (pierde actualizaciones)

        // --- Ejemplo 2: AtomicInteger
        for (int i = 0; i < numHilos; i++) {
            hilos[i] = new Thread(() -> contadorAtomico.incrementAndGet());
            hilos[i].start();
        }
        for (Thread hilo : hilos)
            hilo.join();
        System.out.println("Contador AtomicInteger: " + contadorAtomico.get()); // = numHilos

        // --- Ejemplo 3: synchronized
        contadorNoAtomico = 0;
        Object lock = new Object();
        for (int i = 0; i < numHilos; i++) {
            hilos[i] = new Thread(() -> {
                synchronized (lock) {
                    contadorNoAtomico++;
                }
            });
            hilos[i].start();
        }
        for (Thread hilo : hilos)
            hilo.join();
        System.out.println("Contador synchronized: " + contadorNoAtomico); // = numHilos

        // --- Ejemplo 4: LongAdder
        for (int i = 0; i < numHilos; i++) {
            hilos[i] = new Thread(() -> contadorAdder.increment());
            hilos[i].start();
        }
        for (Thread hilo : hilos)
            hilo.join();
        System.out.println("Contador LongAdder: " + contadorAdder.sum()); // = numHilos
    }
}
