package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.HashSet;
import java.util.Set;

public class SolucionHashSetA {
    public static void main(String[] args) {

        Set<String> emails = new HashSet<>();

        emails.add("ana@mail.com");
        emails.add("luis@mail.com");
        emails.add("marta@mail.com");
        emails.add("ana@mail.com"); // duplicado, no se añade

        IO.println(emails);
        IO.println("Total: " + emails.size());
        IO.println("Existe luis@mail.com: " + emails.contains("luis@mail.com"));
    }
}