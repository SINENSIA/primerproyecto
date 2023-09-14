package com.sinensia.primerprograma.colecciones;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * Ejemplo de HashMap en Java.
 * Eficiente pero sin orden
 *
 * @version 1.0.0
 */
public class MiHashMap {
    /**
     * Ejemplo de HashMap en Java.
     *
     * @param args Argumentos de la aplicación.
     */
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MiHashMap");

        logger.info("**************** Incio del programa ****************");
        // instanciamos un objeto Map que es un HashMap
        Map<Integer, String> nombres = new HashMap<>();
        // Lllenamos el HashMap con datos
        nombres.put(1, "Rivendel");
        nombres.put(2, "Amon Hen");
        nombres.put(3, "Rohan");
        nombres.put(4, "Mordor");

        // Si intentamos añadir un elemento con una clave que ya existe, se reemplaza
        String valorAnterior = nombres.put(2, "Gondor"); // Indice ya existe. Reemplazado

        // En valor anterior obtenemos el valor que tenía la clave 2 antes de ser
        // reemplazado
        logger.info("Valor anterior" + valorAnterior); // Resultado: Amon Hen

        // Para obtener un elemento por clave, usamos el método get
        logger.info(nombres.get(3)); // Resultado: clave 3 = Rohan

        // ToStrnig devuelve una cadena con el contenido del HashMap
        logger.info("----------toString-----------");
        logger.info(nombres.toString()); // Resultado: 1=Rivendel, 2=Gondor, 3=Rohan, 4=Amon Hen

        // Contains nos devuelve true si el HashMap contiene la clave o el valor
        logger.info("----------containsKey//containsValue-----------");
        logger.info("Contiene Mordor? " + nombres.containsKey(4)); // Resultado: true
        logger.info("Contiene Mordor? " + nombres.containsValue("Mordor")); // Resultado: true

        // entrySet devuelve un Set con las entradas del HashMap
        logger.info("----------Map.Entry-----------");
        Map.Entry<Integer, String> entrada = nombres.entrySet().iterator().next();
        logger.info("Clave: " + entrada.getKey() + " Valor: " + entrada.getValue());
        // Resultado: Clave: 1 Valor:
        // Rivendel

        // el set resultante es un conjunto de objetos Map.Entry y está vinculado al
        // HashMap, si se modifica uno, se modifica el otro (más delante veremos
        // ejemplos)

        // ELiminar un elemento por clave
        logger.info("----------remove-----------");
        boolean mordorDestruido = nombres.remove(4, "Mordor"); // Resultado: true
        logger.info("Mordor destruido? " + mordorDestruido);

        // ITerar un HashMap con un for each
        logger.info("----------forEach-----------");
        nombres.forEach((k, v) -> logger.info("Clave: " + k + " Valor: " + v));
        // Resultado:
        // Clave: 1 Valor: Rivendel
        // Clave: 2 Valor: Gondor
        // Clave: 3 Valor: Rohan
        // Clave: 4 Valor: Amon Hen

        // esta vacío?
        logger.info("----------isEmpty-----------");
        logger.info("Está vacío? " + nombres.isEmpty()); // Resultado: true
        logger.info("----------size-----------");
        logger.info("Tamaño: " + nombres.size()); // Resultado: 0

        // values devuelve una colección con los valores del HashMap
        logger.info("----------values-----------");
        logger.info("Valores: " + nombres.values()); // Resultado: []
        logger.info("----------keySet-----------");
        // keyset devuelve una colección con las claves del HashMap
        logger.info("Claves: " + nombres.keySet()); // Resultado: []

        logger.info("----------entrySet-------------------------------------------------------");
        Set<Entry<Integer, String>> nombresSet = nombres.entrySet();
        logger.info("Entradas antes: " + nombresSet); // Resultado: []
        nombres.put(5, "La Comarca");

        logger.info("Entradas después: " + nombresSet); // Resultado:
        // [1=Rivendel, 2=Gondor, 3=Rohan, 4=Amon Hen, 5=La Comarca]
        // Están vinculados. Si se modifica uno, se modifica el otro
        Map.Entry<Integer, String> lacomarcaEntry = new AbstractMap.SimpleEntry<>(5, "La Comarca");
        nombresSet.remove(lacomarcaEntry);
        logger.info("Entradas después en HashMap: " + nombres); // Resultado:

        // cómo acceder al primer elemento?
        logger.info("----------first key-----------");
        logger.info("Primera clave: " + nombres.keySet().iterator().next()); // Resultado: 1

        // cómo acceder al primer valor?
        logger.info("----------first value-----------");
        logger.info("Primer valor: " + nombres.values().iterator().next()); // Resultado: 1

        logger.info("----------last-----------");
        // Iterar para encontrar la última clave
        Integer ultimaClave = null;
        for (Integer clave : nombres.keySet()) {
            ultimaClave = clave;
        }
        logger.info("Última clave: " + ultimaClave); // Resultado: 3
        logger.info("----------ultimo valor-----------");
        // Iterar para encontrar el último valor
        String ultimoValor = null;
        for (String valor : nombres.values()) {
            ultimoValor = valor;
        }
        logger.info("Último valor: " + ultimoValor); // Resultado: Rohan

        logger.info("----------putIfAbsent-----------");
        nombres.putIfAbsent(3, "Rohan"); // No se añade porque la clave ya existe
        logger.info("----------replace-----------");
        nombres.replace(6, "Mordor"); // No se reemplaza porque la clave no existe
        logger.info("----------replace-----------");
        nombres.replace(3, "Rohan", "Mordor"); // Reemplazado
        logger.info("----------Mordor ha vuelto y ha destruido Rohan-----------");
        logger.info(nombres.toString());
        // Resultado: 1=Rivendel, 2=Gondor, 3=Mordor
        logger.info("----------clear-----------");
        nombres.clear();
    }
}
