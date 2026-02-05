package com.sinensia.primerprograma.ejercicios.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Ejercicio con ArrayList: operaciones básicas de gestión de una lista de
 * tareas.
 *
 * <p>
 * <b>Descripción:</b> Se practica agregar, insertar, buscar, eliminar
 * duplicados
 * sin usar estructuras avanzadas, reemplazar por índice y ordenar con
 * {@link Collections#sort(java.util.List)}.
 * </p>
 *
 * <p>
 * <b>Analogía:</b> Piensa en una libreta donde apuntas tareas una a una. Puedes
 * añadir al final, insertar entre líneas, tachar repetidas y ordenar
 * alfabéticamente.
 * </p>
 *
 * <p>
 * <b>Objetivos:</b>
 * <ul>
 * <li>Crear y modificar un ArrayList de cadenas</li>
 * <li>Eliminar duplicados preservando el orden</li>
 * <li>Buscar con contains</li>
 * <li>Reemplazar por índice</li>
 * <li>Ordenar con Collections.sort</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Pasos:</b>
 * <ol>
 * <li>Inicializar la lista con valores</li>
 * <li>Añadir e insertar elementos</li>
 * <li>Eliminar duplicados construyendo una lista limpia</li>
 * <li>Consultar contains y hacer un reemplazo por índice</li>
 * <li>Ordenar y mostrar el resultado</li>
 * </ol>
 * </p>
 */
public class ArrayListEjercicio {
    public static void main(String[] args) {
        ArrayList<String> tareas = new ArrayList<>();
        tareas.add("pagar facturas");
        tareas.add("estudiar");
        tareas.add("comprar pan");
        tareas.add("estudiar"); // duplicada

        // 1) Añadir al final
        tareas.add("hacer ejercicio");

        // 2) Insertar en posición 1
        tareas.add(1, "revisar correo");

        // 3) Eliminar duplicados preservando el orden original
        ArrayList<String> sinDuplicados = eliminarDuplicadosPreservandoOrden(tareas);
        System.out.println(sinDuplicados);

        ArrayList<String> ordenSinDuplicados = eliminarDuplicadosPreservandoOrdenLinkedHashSet(tareas);
        System.out.println(ordenSinDuplicados);

        List<String> ordenSinDuplicados2 = eliminarDuplicadosPreservandoOrdenHashset(tareas);
        System.out.println(ordenSinDuplicados2);
        // 4) Comprobar si contiene "estudiar"
        boolean contieneEstudiar = sinDuplicados.contains("estudiar");
        System.out.println("¿Contiene 'estudiar'? " + contieneEstudiar);

        // 5) Reemplazar el elemento en índice 0
        sinDuplicados.set(0, "pagar impuestos");

        // 6) Si queremos Ordenar alfabéticamente
        Collections.sort(sinDuplicados);

        // 7) Mostrar resultado
        System.out.println("Lista final:");
        for (int i = 0; i < sinDuplicados.size(); i++) {
            System.out.println(" - " + sinDuplicados.get(i));
        }

    }

    /**
     * Elimina duplicados de una lista preservando el orden de primera aparición,
     * sin usar colecciones avanzadas ni APIs modernas.
     *
     * <p>
     * <b>Idea:</b> Crear una lista resultado e ir añadiendo elementos solo si
     * aún no están presentes, consultando con contains.
     * </p>
     *
     * <p>
     * <b>Complejidad:</b> O(n^2) en el peor caso por el uso de contains en
     * ArrayList,
     * lo cual es aceptable para tamaños pequeños en ejercicios introductorios.
     * </p>
     *
     * @param original lista original con posibles duplicados
     * @return nueva lista sin duplicados y con el mismo orden relativo
     */
    public static ArrayList<String> eliminarDuplicadosPreservandoOrden(ArrayList<String> original) {
        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < original.size(); i++) {
            String elemento = original.get(i);
            if (!resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    /**
     * Elimina duplicados de una lista preservando el orden de aparición.
     *
     * <p>
     * <b>Idea:</b> Un LinkedHashSet mantiene el orden de inserción y descarta
     * duplicados automáticamente.
     * </p>
     *
     * <p>
     * <b>Complejidad:</b> O(n), ya que las operaciones de inserción y búsqueda en
     * un HashSet
     * son O(1) promedio.
     * </p>
     *
     * @param original lista original con posibles duplicados
     * @return nueva lista sin duplicados y con el mismo orden relativo
     */
    public static ArrayList<String> eliminarDuplicadosPreservandoOrdenLinkedHashSet(ArrayList<String> original) {
        // 1. original ArrayList
        // 2. crear un linkedHashSet a partir de tareas (ArraList original)
        // 3. devolver un nuevo ArrayList construyéndolo a partir del LinkedHashSet (que
        // no contine duplicados)
        return new ArrayList<>(new LinkedHashSet<>(original));
    }

    /**
     * Elimina duplicados de una lista preservando el orden de aparición.
     *
     * <p>
     * <b>Idea:</b> Usar un Set auxiliar para registrar qué elementos ya se han
     * visto.
     * Solo se añaden al resultado los elementos nuevos.
     * </p>
     *
     * @param original lista original con posibles duplicados
     * @return nueva lista sin duplicados y con el mismo orden relativo
     */
    public static List<String> eliminarDuplicadosPreservandoOrdenHashset(ArrayList<String> original) {
        List<String> resultado = new ArrayList<>();
        HashSet<String> vistos = new HashSet<>();

        for (String elemento : original) {
            if (vistos.add(elemento)) { // add() devuelve false si ya existía
                resultado.add(elemento);
            }
        }
        return resultado;
    }
}
