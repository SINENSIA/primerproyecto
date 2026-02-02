package com.sinensia.primerprograma.basico.operadores;

/**
 * <b>Guía de Operadores en Java</b>
 * <p>
 * Esta clase sirve como una "chuleta" interactiva de los diversos operadores
 * que ofrece el lenguaje Java, desde los aritméticos básicos hasta los
 * operadores a nivel de bits y el operador ternario.
 * </p>
 * 
 * @author Sinensia
 * @version 1.1
 */
public class Operadores {

    /**
     * Punto de entrada para demostrar el uso de operadores.
     *
     * @param args Argumentos de la línea de comandos.
     */
    @SuppressWarnings({ "unused", "java:S2589" })
    public static void main(String[] args) {

        // --- 1. Operadores Aritméticos ---
        int x = 10;
        int y = 3;

        int suma = x + y; // Suma: 13
        int resta = x - y; // Resta: 7
        int multiplicacion = x * y; // Multiplicación: 30
        int division = x / y; // División entera: 3 (el resto se ignora)
        int modulo = x % y; // Módulo (resto de la división): 1

        // --- 2. Operadores de Comparación (Relacionales) ---
        // Devuelven siempre un valor booleano (true/false)
        boolean igual = (x == 10); // true
        boolean mayorQue = (x > 15); // false
        boolean menorQue = (y < 5); // true
        boolean mayorIgualQue = (x >= 10); // true
        boolean distinto = (x != y); // true

        // --- 3. Operadores Lógicos ---
        // Se usan para combinar expresiones booleanas
        boolean condicion1 = (x > 5); // true
        boolean condicion2 = (y > 5); // false

        boolean andLogico = condicion1 && condicion2; // AND: false (ambas deben ser true)
        boolean orLogico = condicion1 || condicion2; // OR: true (una de ellas es true)
        boolean negacion = !condicion1; // NOT: false (invierte el valor)

        // --- 4. Operadores de Asignación Compuesta ---
        int n = 5;
        n += 10; // Equivalente a n = n + 10; (n es 15)
        n *= 2; // Equivalente a n = n * 2; (n es 30)
        n /= 3; // Equivalente a n = n / 3; (n es 10)

        // --- 5. Incremento y Decremento ---
        int i = 0;
        i++; // Post-incremento: aumenta i en 1 después de evaluar (i es 1)
        ++i; // Pre-incremento: aumenta i en 1 antes de evaluar (i es 2)

        // --- 6. Operador Ternario (Condicional corto) ---
        // Sintaxis: (condicion) ? valor_si_true : valor_si_false;
        String resultado = (x > 5) ? "X es mayor que 5" : "X es menor o igual a 5";

        // --- 7. Concatenación de Strings ---
        String saludo = "Hola" + " " + "Mundo"; // "Hola Mundo"

        // --- 8. Operadores a nivel de Bits (Avanzado) ---
        int a = 5; // 0101 en binario
        int b = 3; // 0011 en binario

        int andBits = a & b; // 0001 (1)
        int orBits = a | b; // 0111 (7)
        int xorBits = a ^ b; // 0110 (6)

        // Desplazamientos
        int izq = 2 << 1; // 10 desplaza a 100 (4). Multiplica por 2 por cada posición.
        int der = 4 >> 1; // 100 desplaza a 10 (2). Divide por 2 por cada posición.

        // --- 9. Operador Instanceof ---
        // Verifica si un objeto pertenece a un tipo o clase
        Object obj = "Soy un String";
        if (obj instanceof String) {
            System.out.println("El objeto es de tipo String");
        }
    }
}
