package com.sinensia.primerprograma.basico.repaso;

import com.sinensia.primerprograma.ejercicios.CalculadoraEstadistica;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b>Laboratorio de Pruebas (SandBox)</b>
 * <p>
 * Clase abstracta utilizada para ejecutar fragmentos de código variados
 * y probar funcionalidades de otras clases del proyecto (como Estadísticas o
 * Fechas).
 * </p>
 * 
 * @author Sinensia
 */
abstract class MisTests {

    /**
     * Ejecuta pruebas sobre la CalculadoraEstadistica.
     * 
     * @param args No se utiliza.
     */
    public static void main(String[] args) {

        List<Double> notas = new ArrayList<>(
                Arrays.asList(85.5, 90.0, 75.5, 85.5, 90.0, 88.5, 75.5, 92.0, 43.0, 64.0));

        CalculadoraEstadistica calculadora = new CalculadoraEstadistica(notas);

        System.out.println("--- RESULTADOS ESTADÍSTICOS ---");
        System.out.println("Media: " + calculadora.calcularMedia());
        System.out.println("Moda:  " + Arrays.toString(calculadora.calcularModa()));
        System.out.println("Desviación: " + calculadora.calcularDesviacionEstandar());
    }

    /**
     * Contenedor de otras pruebas lógicas (Switch, Ternarios, Enums).
     */
    public void otrasPruebas() {

        // 1. Operadores y prioridad
        int meal = 5, tip = 2;
        var total = meal + (meal > 6 ? tip++ : tip--);
        System.out.println("Total con postincremento: " + total); // 7

        // 2. Uso de Switch-Case tradicional
        int control = 1;
        switch (control) {
            case 1 -> System.out.println("Opción 1");
            case 2 -> System.out.println("Opción 2");
            default -> System.out.println("Default");
        }

        // 3. Manejo de Enums de tiempo
        Month marzo = Month.MARCH;
        System.out.println("Mes: " + marzo.name() + " (Valor: " + marzo.getValue() + ")");

        // 4. Bloques de texto (Java 15+)
        String html = """
                <html>
                    <body>
                        <p>Hola Mundo</p>
                    </body>
                </html>
                """;
        System.out.println(html);
    }
}
