package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.HashSet;
import java.util.Set;

public class SolucionHashSetB {
    public static void main(String[] args) {

        Set<String> emails = new HashSet<>();
        emails.add("ana@mail.com");
        emails.add("luis@mail.com");
        emails.add("marta@mail.com");

        emails.remove("marta@mail.com");

        emails.forEach(IO::println);
    }
}