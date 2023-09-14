package com.sinensia.primerprograma;

import com.sinensia.primerprograma.interfaces.Incrementador;
import com.sinensia.primerprograma.interfaces.Multiplicador;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;


/**
 * Ejemplos de uso de lambdas.
 *
 * @author Sinensia
 * @since 2023
 * @version 1.0
 * 
 */
public class Lambdas {
    /**
     * Método principal de la clase.
     *
     * @param args argumentos de la línea de comandos
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // Método tradicional
        int a = 5;
        System.out.println(sumarUno(a));

        // Uso de expresiones lambda e interfaces funcionales
        Incrementador incrementador = incrementar -> a + 1;
        int c = incrementador.incrementar(a);

        Multiplicador multiplicador = (x, y) -> x * y;
        int d = multiplicador.multiplicar(2, 3);

        System.out.println(d);

        // Uso de expresiones lambda y referencias a métodos
        List<String> nombres = Arrays.asList("Ana", "Carlos", "David", "Beatriz", "Armando");
        nombres.sort(Comparable::compareTo);
        nombres.sort((nombre1, nombre2) -> nombre1.compareTo(nombre2));
        System.out.println(nombres);
        // Uso de referencias a métodos y expresiones lambda
        IntBinaryOperator multiplicacion = Math::multiplyExact;

        int resultado = multiplicacion.applyAsInt(5, 10);
        System.out.println(resultado);

        // Definir un Predicate para verificar si un número es par
        IntPredicate esPar = num -> num % 2 == 0;

        // Usar el Predicate para filtrar elementos
        System.out.println(esPar.test(4)); // Devuelve true, ya que 4 es par
        System.out.println(esPar.test(7)); // Devuelve false, ya que 7 no es par

    }

    public static int sumarUno(int numero) {
        return numero + 1;
    }

}
