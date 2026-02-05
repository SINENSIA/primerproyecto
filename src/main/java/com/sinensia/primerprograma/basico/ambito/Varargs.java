package com.sinensia.primerprograma.basico.ambito;

public class Varargs {

    public void sumarVarios(int... numeros) {
        // numeros es un parámetro especial (variable local, tipo array)
        int suma = 0;
        for (int n : numeros) {
            suma += n;
        }
        System.out.println("Suma: " + suma);
    }

    public static void main(String[] args) {
        Varargs miOperacion = new Varargs();
        miOperacion.sumarVarios(2, 56, 45, 3);

    }
}
