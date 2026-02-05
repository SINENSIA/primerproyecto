package com.sinensia.primerprograma.basico.ambito;

public class Ambito {

    public int x = 6;

    public void modificarPrimitivo(int numero) {
        
        numero = 100; // Modifica la copia LOCAL
        System.out.println("Dentro: " + numero); // 100
        
    }

    public void prueba() {
        int x = 5;
        modificarPrimitivo(x);
        IO.println("Fuera: " + x); // 5 - NO cambió
    }

    public static void main(String[] args) {
        Ambito myAmbito = new Ambito();
        myAmbito.prueba();
        IO.println(myAmbito.x);
    }
}
