package com.sinensia.primerprograma;

// Sin lista de permisos o permits, clases hijas en el mismo fichero
abstract sealed class Animal {
    public void desplazarse() {
        System.out.println("El animal se desplaza");
    }

}

final class Reptil extends Animal {
    @Override
    public void desplazarse() {
        System.out.println("El reptil se desplaza");
    }

}

// Esta está sellada pero permite que Perro herede de ella
sealed class Canino
        extends Animal permits Perro {

    @Override
    public void desplazarse() {
        System.out.println("El canino se desplaza");
    }

}