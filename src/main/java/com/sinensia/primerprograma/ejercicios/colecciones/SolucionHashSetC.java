package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolucionHashSetC {
    public static void main(String[] args) {

        Set<String> emails = new HashSet<>();
        emails.add("ana@mail.com");
        emails.add("luis@mail.com");
        emails.add("marta@mail.com");
        emails.add("pepe@gmail.com");

        long totalMail = emails.stream()
                .filter(e -> e.endsWith("@mail.com"))
                .count();

        IO.println("Emails @mail.com: " + totalMail);

        List<String> listaEmails = new ArrayList<>(emails);
        IO.println(listaEmails);
    }
}
