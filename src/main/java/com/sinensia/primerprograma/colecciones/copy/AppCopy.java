package com.sinensia.primerprograma.colecciones.copy;

import java.util.ArrayList;
import java.util.List;

public class AppCopy {

    void main() {
        List<Persona> lista1 = new ArrayList<>();
        lista1.add(new Persona("Ana"));

        List<Persona> lista2 = new ArrayList<>(lista1); // copia superficial

        lista2.add(new Persona("Juan"));

        IO.println(lista1); // [Persona{nombre='Ana'}]
        IO.println(lista2); // [Persona{nombre='Ana'}, Persona{nombre='Juan'}]

        lista2.get(0).nombre = "Luis";

        IO.println("------------------------------");
        // Se cambia en los dos!
        IO.println(lista1); // [Persona{nombre='Luis'}]
        IO.println(lista2); // [Persona{nombre='Luis'}, Persona{nombre='Juan'}]
    }

}
