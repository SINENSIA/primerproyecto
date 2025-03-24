package com.sinensia.primerprograma;

/**
 * Operadores.
 *
 * @version 1.0
 */
public class Operadores {
    /**
     * Método main para probar la clase Operadores.
     * SupressWarining: java:S2589 y java:S106 ya
     * que son pruebas de concepto.
     *
     * @param args argumentos de la línea de comandos
     */
    @SuppressWarnings({ "unused", "java:S2589" })
    public static void main(String[] args) {

        // Operadores aritméticos
        int x = 5; // Asigna 5 a la variable x

        int suma = 5 + 3; // Suma: 8
        int resta = 10 - 4; // Resta: 6
        int multiplicacion = 4 * 6; // Multiplicación: 24
        int division = 12 / 3; // División: 4
        int modulo = 10 % 3; // Módulo: 1

        // Operadores unarios
        boolean igual = (x == 5); // Verdadero si x es igual a 5
        boolean mayorQue = (x > 3); // Verdadero si x es mayor que 3
        boolean menorQue = (x < 10); // Verdadero si x es menor que 10
        boolean mayorIgualQue = (x >= 5); // Verdadero si x es mayor o igual que 5
        boolean menorIgualQue = (x <= 5); // Verdadero si x es menor o igual que 5
        boolean distinto = (x != 5); // Verdadero si x es distinto de 5

        // Operadores lógicos
        boolean condicion1 = true;
        boolean condicion2 = false;

        // Falso, ya que ambas condiciones deben ser verdaderas
        boolean andLogico = (condicion1 && condicion2);

        // Verdadero, ya que al menos una condición es verdadera
        boolean orLogico = (condicion1 || condicion2);

        // Falso, ya que se invierte la condición
        boolean negacionLogica = !condicion1;

        // Operadores de asignación
        int num = 5;
        num++; // Incrementa en 1: resultado es 6
        num--; // Decrementa en 1: resultado es 5 nuevamente
        num += 3; // Equivalente a num = num + 3; ahora num es 8
        num -= 2; // Equivalente a num = num - 2; ahora num es 6
        num *= 4; // Equivalente a num = num * 4; ahora num es 24
        num /= 3; // Equivalente a num = num / 3; ahora num es 8
        num %= 5; // Equivalente a num = num % 5; ahora num es 3 (el residuo de la división por 5)

        // Operadores a nivel de bits
        int a = 5; // Representado en binario como 0101
        int b = 3; // Representado en binario como 0011

        int andBits = a & b; // AND a nivel de bits: 0001 (1 en decimal)
        int orBits = a | b; // OR a nivel de bits: 0111 (7 en decimal)
        int xorBits = a ^ b; // XOR a nivel de bits: 0110 (6 en decimal)

        // DEsplazamiento de bits
        num = 8; // Representado en binario como 1000

        int izquierda = num << 2; // Desplazamiento a la izquierda en 2 bits: 0010 (2 en decimal)
        int derecha = num >> 1; // Desplazamiento a la derecha en 1 bit: 0100 (4 en decimal)

        // Operador ternario
        int edad = 18;
        String mensaje = (edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad";

        // Operadores de concatenación
        String nombre = "Carlos";
        String apellido = "ApellidoFake";
        String nombreCompleto = nombre + " " + apellido; // "Carlos ApellidoFake"

        // Operador instanceof
        Object objeto = new Object();
        if (objeto instanceof Object) {
            // Hacer algo si el objeto es una instancia de Object
        }

    }

}
