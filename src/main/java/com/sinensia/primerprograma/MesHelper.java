package com.sinensia.primerprograma;

import java.util.ArrayList;
import java.util.List;

public class MesHelper {
    public void imprimirCuatrimestre() {

        List<String> meses = new ArrayList<>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");

        // Utilizando el método forEach para iterar sobre los elementos
        meses.forEach(mes -> System.out.println("Mes: " + mes));
    }
}
