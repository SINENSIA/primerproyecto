package com.sinensia.primerprograma.basico.texto;

/**
 * <b>StringBuilder: API Completa</b>
 * <p>
 * Ejemplos detallados de todos los métodos de manipulación que ofrece
 * {@link java.lang.StringBuilder}, incluyendo {@code insert}, {@code delete},
 * {@code replace} y {@code reverse}.
 * </p>
 * 
 * @author Sinensia
 */
public class StringBuilderExample {

    /**
     * Punto de entrada principal.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        // 1. Inicialización
        StringBuilder b = new StringBuilder("Hola");
        System.out.println("Base: " + b);

        // 2. Insertar en cualquier posición
        b.insert(2, "-X-"); // Ho-X-la
        System.out.println("Tras insert(2, '-X-'): " + b);

        // 3. Reemplazar rangos
        b.replace(0, 2, "Ch"); // Cho-X-la
        System.out.println("Tras replace(0, 2, 'Ch'): " + b);

        // 4. Eliminar rangos (índice final exclusivo)
        b.delete(3, 6); // Chola
        System.out.println("Tras delete(3, 6): " + b);

        // 5. Inversión rápida
        b.reverse(); // alohC
        System.out.println("Invertido: " + b);

        // 6. Extracción de subcadenas (devuelve un String inmutable)
        String sub = b.substring(1, 3);
        System.out.println("Subcadena(1,3): " + sub);

        // 7. Ejemplo en entorno multi-hilo (Uso de StringBuffer)
        System.out.println("\n--- Ejemplo con hilos (StringBuffer) ---");
        new Thread(() -> {
            StringBuffer bufferSeguro = new StringBuffer("Threaded");
            bufferSeguro.append(" OK");
            System.out.println("Desde hilo: " + bufferSeguro);
        }).start();
    }
}
