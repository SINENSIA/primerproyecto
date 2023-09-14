package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;

public class MyTEsts {

    public static void main(String[] args) {

        ArrayList<String> myArrayList = new ArrayList<>();

        myArrayList.add("Hola");
        myArrayList.add("Que");
        myArrayList.add("Tal");

        String[] myNativeArray = { "Hola", "Que", "Tal" };

        for (String elemento : myArrayList) {
            System.out.println(elemento);
        }
        for (String elemento : myNativeArray) {
            System.out.println(elemento);
        }
    }
}
