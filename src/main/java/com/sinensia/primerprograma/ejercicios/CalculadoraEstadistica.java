package com.sinensia.primerprograma.ejercicios;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Calculadora de estadística.
 * Permite calcular la media, la desviación típica y la moda de un conjunto de
 * notas.
 *
 * @version 1.0
 * @since 2023
 * @see CalculadoraEstadisticaTest
 * @author Sinensia
 * @see <a href="https://www.sinensia.com">Sinensia</a>
 * 
 *
 */
public class CalculadoraEstadistica {
    private List<Double> valores;

    /**
     * Constructor de la clase. Va a recibir un ArrayList de notas.
     *
     * @param valores ArrayList de notas (List Float)
     */
    public CalculadoraEstadistica(List<Double> valores) {
        if (!(valores instanceof List<Double>)) {
            throw new IllegalArgumentException("El argumento debe ser un List.");
        }
        this.valores = valores;
    }

    /**
     * Calcula la media de un conjunto de notas.
     *
     * @return media (Float)
     */
    public double calcularMedia() {
        // Calcular la media
        double media = valores.stream()
                .mapToDouble(Double::valueOf)
                .average()
                .orElse(0.0);

        // Valor predeterminado si no hay elementos
        return Math.round(media * 100d) / 100d;
    }

    /**
     * Calcula la desviación típica de un conjunto de notas.
     *
     * @return la desviación estándar (Float)
     */

    public double calcularDesviacionEstandar() {
        double media = calcularMedia();

        double sumaDeCuadrados = valores.stream()
                .mapToDouble(Double::doubleValue)
                .map(d -> Math.pow(d - media, 2))
                .sum();

        // Calcula la desviación estándar aplicando la fórmula
        return Math.sqrt(sumaDeCuadrados / valores.size());

        // Verificamos si hay una moda
    }

    /**
     * Calcula la moda de un conjunto de notas.
     *
     * @return la moda (Float)
     */
    public double[] calcularModa() {

        // Calcular la s frecuencias
        Map<Double, Long> frecuencias = valores.stream()
                .collect(Collectors.groupingBy(Double::valueOf, Collectors.counting()));

        System.out.println(frecuencias);
        // Utilizamos Streams para encontrar el valor máximo
        Collection<Long> maxFrequency = frecuencias.entrySet()
                .stream()
                .map(Entry::getValue)
                // .collect(Collectors.groupingBy((entry) -> entry.getValue(),
                // Collectors.counting()))
                .max(Comparator.naturalOrder())
                .stream()
                .toList();

        System.out.println(maxFrequency);

        return frecuencias.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2L)
                .map(Map.Entry::getKey)
                .mapToDouble(Double::doubleValue)
                .toArray();

    }
}
