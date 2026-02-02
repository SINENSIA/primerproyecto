package com.sinensia.primerprograma.ejercicios;

class Calculadora {
    public static int sumar(int... valores) {
        
        int suma = 0;
        for (int b : valores) {
            suma += b;

        }
        return suma;

    }
    public static void main(String[] args) {
        IO.println(sumar(8,5));
    }
}
