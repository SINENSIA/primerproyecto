package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProgrParaInterfaz {

    public static void main(String[] args) {
        List<String> newArrayList = new ArrayList<>();
        newArrayList.add("Hola");
        newArrayList.add("Que");
        newArrayList.add("Tal");

        newArrayList = new LinkedList<>(newArrayList);

        System.out.println(newArrayList);
    }
}
