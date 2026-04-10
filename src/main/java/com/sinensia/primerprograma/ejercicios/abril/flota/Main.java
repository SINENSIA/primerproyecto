package com.sinensia.primerprograma.ejercicios.abril.flota;

public class Main {

    public static void main() {

        Propietario p1 = new Propietario("Carlos", "12345678A");
        Propietario p2 = new Propietario("Ana", "87654321B");

        Turismo turismo1 = new Turismo("1234ABC", "Toyota", p1, 4);
        Motocicleta moto = new Motocicleta("5678DEF", "Honda", p2, 650);
        Furgoneta furgo = new Furgoneta("9999XYZ", "Mercedes", p1, 4200.0);

        // Mismo turismo: misma matricula, distinta marca y propietario
        Turismo turismo2 = new Turismo("1234ABC", "Honda", p2, 4);

        System.out.println(turismo1.informeInspeccion());
        System.out.println(moto.informeInspeccion());
        System.out.println(furgo.informeInspeccion());

        System.out.println("turismo1.equals(turismo2) -> " + turismo1.equals(turismo2));
        System.out.println("turismo1.equals(moto)     -> " + turismo1.equals(moto));
    }
}
