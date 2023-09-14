package com.sinensia.primerprograma;

import com.sinensia.primerprograma.ejercicios.CalculadoraEstadistica;
import java.time.LocalDate;
import java.time.Month;


/**
 * Clase para pruebas
 */
abstract class MisTests {
    /**
     * Método main para hacer pruebas.
     */
    public static void main(String[] args) {

    }

    /**
     * Método para hacer pruebas. y copy paste
     */
    public void otrasPruebas() {

        CalculadoraEstadistica calculadora1 = new CalculadoraEstadistica(null);
        calculadora1.calcularMedia();

        double[] notas = { 85.5, 90.0, 75.5, 92.0, 85.5, 90.0, 88.5, 75.5, 92.0, 43.0, 64.0 };
        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(notas);

        System.out.println("Media: " + calculadora.calcularMedia());
        System.out.println("Desviación Estándar: " + calculadora.calcularDesviacionEstandar());
        System.out.println("Moda: " + calculadora.calcularModa());
        int meal = 5;
        int tip = 2;
        var total = meal + (meal > 6 ? tip++ : tip--);
        // Dado que es postincremento, tip++ se evalúa a 2 y luego se incrementa a 3. O
        // bien tip-- se evalúa a 2 y luego se decrementa a 1.
        System.out.println(total); // 7

        var total2 = meal + (meal > 6 ? ++tip : --tip);
        // Dado que es preincremento, tip++ se evalúa a 3 y luego se incrementa a 4. O
        // bien tip-- se evalúa a 1 y luego se decrementa a 0.
        System.out.println(total2); // 5

        int mayor = total2 > 5 ? 1 : 2;

        switch (mayor) {
            case 1:
                System.out.println("Es mayor");
                break;
            case 2:
                System.out.println("Es menor");
                break;
            default:
                System.out.println("Es igual");
        }
        /*
         * Month
         */
        // Obtener el valor del mes (en este caso, marzo)
        int monthValue = Month.MARCH.getValue();
        String monthName = Month.MARCH.name();
        System.out.println("Valor del mes: " + monthValue);
        System.out.println("Nombre del mes: " + monthName);
        Enum<Month> enumMonth = Month.MARCH;
        System.out.println("Enum del mes: " + enumMonth);

        // Crear una fecha en ese mes
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), monthValue, 1);

        System.out.println("Fecha en marzo: " + date);
        System.out.println("---------------------");
        var block = """
                green
                yellow
                """;
        System.out.println(block);
        System.out.println("---------------------");
    }
}
