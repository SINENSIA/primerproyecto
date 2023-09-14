package com.sinensia.primerprograma.excepciones;

import java.util.ArrayList;

class TestMyParticularException {

    public static void main(String[] args) {
        try {
            getMyElement(5);
        } catch (MyParticularException e) {
            e.printStackTrace();
        }
    }

    public static String getMyElement(int elementIndex) throws MyParticularException {

        ArrayList<String> myArrayList = new ArrayList<>();
        if (myArrayList.size() <= elementIndex) {
            throw new MyParticularException("El índice es mayor que el tamaño de la lista");
        }
        myArrayList.add("Carlos");
        myArrayList.add("Juan");
        myArrayList.add("Pedro");

        return myArrayList.get(elementIndex);
    }
}
