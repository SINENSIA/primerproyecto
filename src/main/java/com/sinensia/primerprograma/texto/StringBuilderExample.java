package com.sinensia.primerprograma.texto;

public class StringBuilderExample {

    public static void main(String[] args) {

        String saludo = "Hola";
        saludo += " "; // No estoy modificando el String, estoy creando uno nuevo
        System.out.println(saludo);

        // StringBuilder es una clase que permite modificar el String
        // sin crear uno nuevo
        StringBuilder stringBuilderSaludo = new StringBuilder();
        stringBuilderSaludo.append("Hola");
        stringBuilderSaludo.append(" ");
        System.out.println(stringBuilderSaludo.toString());

        StringBuilder s = new StringBuilder("test");
        // lo mismo que append pero usando el constructor con String implícito
        System.out.println(s.toString());

        StringBuilder builder = new StringBuilder();
        builder.append("Hola");

        // insertar en una posición
        builder.insert(1, "ey H");
        System.out.println(builder.toString()); // Hey Hola

        // length de Hey Hola
        System.out.println(builder.length()); // 8

        // reemplazar
        builder.replace(4, builder.length(), "Hi");
        System.out.println(builder.toString()); // Hey Hi

        // borrar Hey
        builder.delete(0, 4);
        System.out.println(builder.toString()); // Hi

        // Insertar en una posición
        builder.insert(2, " World!"); // Hi Mundo!
        System.out.println(builder.toString());

        // Devuelve la porción de la cadena desde el índice 3 hasta el final
        String subcadena = builder.substring(3);
        System.out.println(subcadena); // World!

        // Devuelve la porción de la cadena desde el índice 3 hasta el 5
        subcadena = builder.substring(3, 5);
        System.out.println(subcadena); // Wo

        // Devuelve la posición de la primera ocurrencia de la cadena
        // o -1 si no se encuentra
        int pos = builder.indexOf("World");
        System.out.println(pos); // 3ç

        // Devuelve la posición de la última ocurrencia de la cadena
        // o -1 si no se encuentra
        pos = builder.lastIndexOf("World");
        System.out.println(pos); // 3

        // reverse
        builder.reverse();
        System.out.println(builder.toString()); // !dlroW iH

        Thread thread = new Thread(() -> {
            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("Hola");
            }
            System.out.println(stringBuffer.reverse().toString());
        });
        thread.start();
    }

}
