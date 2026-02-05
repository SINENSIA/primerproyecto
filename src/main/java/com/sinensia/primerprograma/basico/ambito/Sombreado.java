package com.sinensia.primerprograma.basico.ambito;

public class Sombreado {
    public String nombre = "SOY LA VARIABLE DE CLASE"; // Scope: CLASE

    public void metodo(String nombre) { // Scope: MÉTODO (parámetro)
        System.out.println(nombre); // ¿A cuál se refiere?
        System.out.println(this.nombre);
    }

    public static void main(String[] args) {
        Sombreado obj = new Sombreado();
        obj.metodo("SOY EL PARÁMETRO");
    }
}
