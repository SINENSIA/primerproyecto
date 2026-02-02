package com.sinensia.primerprograma.basico.tipos;

import java.util.ArrayList;

/**
 * <b>Concepto: Autoboxing y Unboxing</b>
 * <p>
 * El Autoboxing es la conversión automática que realiza el compilador de Java
 * entre tipos primitivos y sus clases envolventes (Wrapper classes)
 * correspondientes.
 * Por ejemplo, de {@code int} a {@code Integer}.
 * </p>
 * <p>
 * El Unboxing es el proceso inverso: convertir un objeto de una clase
 * envolvente
 * a su tipo primitivo correspondiente.
 * </p>
 * 
 * @author Sinensia
 * @see java.lang.Integer
 */
public class AutoboxingDemo {

    /**
     * Punto de entrada principal para la demostración.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Autoboxing: el literal 10 (int) se "envuelve" automáticamente en un objeto
        // Integer
        Integer numero = 10;

        // Las colecciones de Java (Generics) solo aceptan objetos, no tipos primitivos.
        // Gracias al autoboxing, podemos trabajar con listas de forma sencilla.
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(5); // Autoboxing: int 5 -> Integer.valueOf(5)

        // Unboxing: al asignar un objeto Integer a una variable int, Java extrae su
        // valor primitivo.
        int valor = lista.get(0); // Unboxing: lista.get(0).intValue() -> int

        System.out.println("Número (Integer): " + numero);
        System.out.println("Valor extraído de lista (int): " + valor);

        peligroEnvolventes();
    }

    /**
     * Muestra comportamientos curiosos y peligrosos al comparar objetos
     * envolventes.
     * <p>
     * <b>IMPORTANTE:</b> Nunca uses {@code ==} para comparar el contenido de
     * objetos.
     * Para objetos, {@code ==} compara referencias de memoria, no valores.
     * </p>
     */
    public static void peligroEnvolventes() {

        Integer a = 128;
        int b = 128;

        // Comparación mixta: Objeto vs Primitivo.
        // Java realiza un unboxing de 'a' para poder comparar dos ints.
        System.out.println("Comparación objeto vs primitivo (a == b): " + (a == b)); // true

        // Uso de equals: El método correcto para comparar valores de objetos.
        System.out.println("Comparación con equals (a.equals(b)): " + a.equals(b)); // true

        Integer c = 128;
        Integer d = 128;
        System.out.println("\n-- Peligro: Comparando dos objetos Integer fuera del rango de caché (-128 a 127) --");
        // Aquí 'c' y 'd' son dos objetos distintos en memoria.
        System.out.println("¿c == d? " + (c == d)); // false -> ¡Diferentes instancias!
        System.out.println("¿c.equals(d)? " + c.equals(d)); // true -> ¡Mismo valor!

        Integer e = 127;
        Integer f = 127;
        System.out.println("\n-- Curiosidad: Integer Caching (rango -128 a 127) --");
        // Java reutiliza objetos Integer pequeños para ahorrar memoria.
        // Por eso 'e' y 'f' apuntan a la misma dirección de memoria.
        System.out.println("¿e == f? " + (e == f)); // true -> ¡Misma instancia compartida!
        System.out.println("¿e.equals(f)? " + e.equals(f)); // true
    }
}
