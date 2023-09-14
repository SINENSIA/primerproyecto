package com.sinensia.primerprograma.serializacion;

import java.io.Serializable;

// Clase Person implementando Serializable
class Person implements Serializable {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
