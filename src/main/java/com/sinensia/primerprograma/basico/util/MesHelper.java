package com.sinensia.primerprograma.basico.util;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Clase de Utilidad para Meses</b>
 * <p>
 * Clase auxiliar que demuestra el uso de listas de Strings y la iteración
 * moderna mediante expresiones lambda con el método {@code forEach}.
 * </p>
 * 
 * @author Sinensia
 */
public class MesHelper {

    /**
     * Crea una lista con los meses del primer cuatrimestre y los imprime
     * por consola usando una expresión lambda.
     */
    public void imprimirCuatrimestre() {

        List<String> meses = new ArrayList<>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");

        // Uso de forEach con lambda: 'mes' es el parámetro, seguido del cuerpo
        meses.forEach(mes -> System.out.println("Mes del Cuatrimestre: " + mes));
    }
}
