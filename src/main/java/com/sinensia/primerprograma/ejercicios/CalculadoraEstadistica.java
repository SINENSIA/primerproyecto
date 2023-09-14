package com.sinensia.primerprograma.ejercicios;

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
    private double[] notas;

    public CalculadoraEstadistica(double[] notas) {
        if (!(notas instanceof double[])) {
            throw new IllegalArgumentException("El argumento debe ser un entero.");
        }
        this.notas = notas;
    }

    /**
     * Calcula la media de un conjunto de notas.
     *
     * @return media (double)
     */
    public double calcularMedia() {
        try {
            double suma = 0;
            for (double nota : notas) {
                suma += nota;
            }
            return suma / notas.length;
        } catch (NullPointerException e) {
            throw new NullPointerException("El array de notas no puede ser nulo");

        }
    }

    /**
     * Calcula la desviación típica de un conjunto de notas.
     *
     * @return la desviación estándar (double)
     */

    public double calcularDesviacionEstandar() {
        double media = calcularMedia();
        double sumaDeDiferenciasAlCuadrado = 0;

        for (double nota : notas) {
            sumaDeDiferenciasAlCuadrado += Math.pow(nota - media, 2); // elevado a 2
        }

        double varianza = sumaDeDiferenciasAlCuadrado / notas.length;
        return Math.sqrt(varianza);
    }

    /**
     * Calcula la moda de un conjunto de notas.
     *
     * @return la moda (double)
     */
    public double calcularModa() {
        int maxFrecuencia = 0;
        double moda = 0;

        for (int i = 0; i < notas.length; i++) {
            int frecuencia = 0;
            for (int j = 0; j < notas.length; j++) {
                if (notas[i] == notas[j]) {
                    frecuencia++;
                }
            }
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                moda = notas[i];
            }
        }

        return moda;
    }
}
