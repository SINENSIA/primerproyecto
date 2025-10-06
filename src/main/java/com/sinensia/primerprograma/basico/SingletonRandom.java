package com.sinensia.primerprograma.basico;

import java.util.Random;

public class SingletonRandom {
    private static final Random INSTANCE = new Random();

    private SingletonRandom() {
    }

    public static Random getInstance() {
        return INSTANCE;
    }

}
