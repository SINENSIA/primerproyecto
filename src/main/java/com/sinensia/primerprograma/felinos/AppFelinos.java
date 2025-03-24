package com.sinensia.primerprograma.felinos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * App para probar Felinos. Suprimimos warnings de tipo S1192.
 * Ya que repetimos cadenas para mejorar la visibilidad de los ejemplos.
 * Tambien hacemos una asignacion == con Wrappers para mostrar que
 * se puede pero no se debería. (java:S4973)
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
@SuppressWarnings({ "java:S1192", "java:S4973" })
public class AppFelinos {
    /**
     * Método main para probar Felinos.
     * Ejecutamos algunos métodos de Felino, Gato, Tigre y Jaguar.
     * Suprimimos warnings de tipo S125. Ya que el codigo está comentado
     * intencionadamente para explicar los ejemplos.
     */

    @SuppressWarnings("java:S125")
    public static void main(String[] args) {

        Felino gato = new Gato("Misifu", 3243521);
        Felino tigre = new Tigre();
        Felino jaguar = new Jaguar();
        // Cliente cliente = new Cliente("Juan", true);

        // Peluqueria<Cliente> peluqueriaClientes = new Peluqueria(cliente);

        // Y si queremos usar la peluquería sólo para un felino?
        // peluqueriaClientes.limpiarCortar();
        List<Felino> felinos = new ArrayList<>();
        //

        felinos.add(gato);
        felinos.add(tigre);
        felinos.add(jaguar);

        System.out.println(".....................");
        for (Felino felino : felinos) {
            Peluqueria<Felino> peluqueria = new Peluqueria<>(felino);
            peluqueria.limpiarCortar();
            felino.emitirSonido();
            felino.comer();
            System.out.println(felino.getNombreCientifico());
            Felino.getCantidadFelinos();

            if (felino instanceof Gato) {
                Gato gato2 = (Gato) felino;
                gato2.getNombre();

            }
            System.out.println(".....................");

            // Casting a LinkedList
            List<Felino> listaEnlazada = new LinkedList<>(felinos);
            listaEnlazada.add(gato); // para evitar unused warning
        }

        // Equals??

        Gato gato1 = new Gato("Misifu", 3243521);
        Gato gato2 = new Gato("Misifu", 3243521);

        System.out.println(".....................");
        System.out.println(".....................");
        System.out.println(".....................");
        System.out.println(gato1.toString());
        System.out.println(gato2.toString());
        System.out.println(".....................");
        System.out.println(".....................");
        System.out.println(".....................");
        System.out.println(".....................");
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
        System.out.println("Objetos se pueden comparar con equals (siempre)");
        System.out.println(c.equals(d)); // true

        System.out.println(".........Propietario............");
        System.out.println("................................");
        Propietario myself = new Propietario("Carlos", "Europa");
        Felino trasgo = new Gato("Trasgo", 234878554, myself);
        System.out.println(trasgo);


        // Uso de interfaces funcionales
        System.out.println(".........Interfaces funcionales............");
        Felino.procesarFelinos(felinos, felino -> {
            System.out.println("Especie: " + felino.getEspecie());
            felino.emitirSonido();
        });


        // Definimos estímulos como lambdas:
        Reaccionable reaccionSonidoFuerte = felino -> System.out.println(
                felino.getEspecie() + " huye del sonido.");

        System.out.println("** Estímulo: sonido fuerte **");
        Felino.simularReaccion(felinos, reaccionSonidoFuerte);

        Reaccionable reaccionComida = felino -> System.out
                .println(felino.getEspecie() + " se acerca sigilosamente a la comida.");

        System.out.println("\n** Estímulo: olor a comida **");
        Felino.simularReaccion(felinos, reaccionComida);
    }

    /**
     * Método para meter el mismo gato en una lista. El
     * resultado es una lista con dos gatos ya que ArrayList
     * permite duplicados.
     *
     * @param gato1 (Gato)
     * @param gato2 (Gato)
     * @return List Gato
     * 
     */
    public static List<Gato> meterElMismoGato(Gato gato1, Gato gato2) {
        List<Gato> gatos = new ArrayList<>();
        gatos.add(gato1);
        gatos.add(gato2);
        return gatos;
    }

    /**
     * Método para meter el mismo gato en un Set. El
     * resultado es un Set con un solo gato ya que Set
     * no permite duplicados. Dependemos de que Gato tenga
     * implementado equals() y hashCode() para que funcione.
     *
     * @param gato1 (Gato)
     * @param gato2 (Gato)
     * @return Set Gato
     */
    public static Set<Gato> meterElMismoGatoSinDuplicados(Gato gato1, Gato gato2) {
        Set<Gato> gatos = new HashSet<>();
        gatos.add(gato1);
        gatos.add(gato2);
        return gatos;
    }
}
