package com.sinensia.primerprograma.polimorfismo;

class SillaDeMontar {
    void ajustar(Caballo caballo) {
        if (caballo instanceof Caballo) {
            caballo.montar();
        } else {
            System.out.println("No puedes montar a un animal que no sea un caballo");
        }
    }
}
