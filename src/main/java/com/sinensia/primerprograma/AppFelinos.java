package com.sinensia.primerprograma;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * App para probar Felinos.
 *
 * @see com.sinensia.primerprograma.Felino
 * @see com.sinensia.primerprograma.Gato
 * @see com.sinensia.primerprograma.Tigre
 * @see com.sinensia.primerprograma.Jaguar
 * @since 2023
 * @version 1.0
 * @author Sinensia
 * 
 */
public class AppFelinos {
    /**
     * Método main para probar Felinos.
     * Ejecutamos algunos métodos de Felino, Gato, Tigre y Jaguar.
     */
    public static void main(String[] args) {

        Felino gato = new Gato("Misifu", 3243521);
        Felino tigre = new Tigre();
        Felino jaguar = new Jaguar();

        List<Felino> felinos = new ArrayList<>();

        felinos.add(gato);
        felinos.add(tigre);
        felinos.add(jaguar);

        System.out.println(".....................");
        for (Felino felino : felinos) {
            felino.emitirSonido();
            felino.comer();
            System.out.println(felino.getNombreCientifico());
            Felino.getCantidadFelinos();
            if (felino instanceof Gato) {
                Gato gato2 = (Gato) felino;
                gato2.getNombre();

            }
            System.out.println(".....................");

            LinkedList<Felino> listaEnlazada = new LinkedList<>(felinos);
        }

        // Equals??
        Gato gato1 = new Gato("Misifu", 3243521);
        Gato gato2 = new Gato("Misifu", 3243521);
        System.out.println("Si hacemos override de equals() en Gato, podemos comparar objetos");
        System.out.println(gato1.equals(gato2)); // true
        System.out.println(".....................");
        System.out.println("Los objetos Gato no se pueden comparar con ==");
        System.out.println(gato1 == gato2); // false
        System.out.println(meterElMismoGato(gato1, gato2));
        System.out.println(meterElMismoGatoSinDuplicados(gato1, gato2));
        int a = 5; // Primitivos
        int b = 5; // Primitivos
        System.out.println(".....................");
        System.out.println("Primitivos se pueden comparar con ==");
        System.out.println(a == b); // true
        System.out.println("Primitivos no tienen equals pero se pueden convertir a objetos");
        System.out.println(Integer.valueOf(a).equals(Integer.valueOf(b))); // true
        System.out.println(".....................");

        Integer c = 5; // Objetos
        Integer d = 5; // Objetos
        System.out.println("Los wrappers se pueden comparar con == pero no se debería");
        System.out.println(c == d); // true
        System.out.println(".....................");
        System.out.println("Objetos se pueden comparar con equals");
        System.out.println(c.equals(d)); // true
    }

    public static List<Gato> meterElMismoGato(Gato gato1, Gato gato2) {
        List<Gato> gatos = new ArrayList<>();
        gatos.add(gato1);
        gatos.add(gato2);
        return gatos;
    }

    public static Set<Gato> meterElMismoGatoSinDuplicados(Gato gato1, Gato gato2) {
        Set<Gato> gatos = new HashSet<>();
        gatos.add(gato1);
        gatos.add(gato2);
        return gatos;
    }
}
