package com.sinensia.primerprograma.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListDemo {
    public static void main(String[] args) {
        // Crear una lista ArrayList
        List<Integer> arrayList = new ArrayList<>();

        // Crear una lista sincronizada basada en ArrayList
        List<Integer> synchronizedList = Collections.synchronizedList(arrayList);

        // Crear hilos para agregar elementos
        Thread addThread1 = new Thread(new AddElementTask(synchronizedList));
        Thread addThread2 = new Thread(new AddElementTask(synchronizedList));

        // Crear hilos para recorrer la lista
        Thread iterateThread1 = new Thread(new IterateListTask(synchronizedList));
        Thread iterateThread2 = new Thread(new IterateListTask(synchronizedList));

        // Iniciar los hilos
        addThread1.start();
        addThread2.start();
        iterateThread1.start();
        iterateThread2.start();
    }

}

class AddElementTask implements Runnable {
    private final List<Integer> list;

    public AddElementTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (list) {
            for (int i = 0; i < 5; i++) {

                list.add(i);
                System.out.println("Agregado: " + i + " " + threadName);
            }
        }
    }
}

class IterateListTask implements Runnable {
    private final List<Integer> list;

    public IterateListTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (list) {
            for (Integer num : list) {
                System.out.println("Elemento: " + num + " " + threadName);
            }
        }

    }
}
