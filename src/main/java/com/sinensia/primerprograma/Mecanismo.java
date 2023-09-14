package com.sinensia.primerprograma;

public class Mecanismo {

    private int piezasDelicadas; // Variable privada que no se puede tocar directamente

    // Getter: Permite ver el valor de piezasDelicadas sin cambiarlo
    public int getPiezasDelicadas() {
        return piezasDelicadas;
    }

    // Setter: Permite cambiar el valor de piezasDelicadas de manera controlada
    public void setPiezasDelicadas(int piezas) {
        if (piezas >= 0) { // Solo permite valores positivos
            this.piezasDelicadas = piezas;
        }
    }
}
