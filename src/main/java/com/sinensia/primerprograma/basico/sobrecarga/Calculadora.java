package com.sinensia.primerprograma.basico.sobrecarga;

/**
 * <b>Concepto: Sobrecarga de Métodos (Overloading)</b>
 * <p>
 * Clase que muestra cómo definir varios métodos con el mismo nombre pero
 * con diferentes parámetros (número o tipo). Java determina cuál ejecutar
 * según los argumentos pasados en tiempo de compilación.
 * </p>
 * 
 * @author Sinensia
 */
public class Calculadora {

    private int operando1;
    private int operando2;

    /**
     * Constructor vacío.
     */
    public Calculadora() {
        // Constructor sin parámetros
    }

    /**
     * Constructor sobrecargado con operandos iniciales.
     * 
     * @param operando1 Primer operando
     * @param operando2 Segundo operando
     */
    public Calculadora(int operando1, int operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    /**
     * <b>Sobrecarga: Método sin parámetros.</b>
     * <p>
     * Suma los valores de los atributos internos (operando1 y operando2).
     * </p>
     * 
     * @return suma de los operandos internos
     */
    public int suma() {
        return operando1 + operando2;
    }

    /**
     * <b>Sobrecarga: Método con parámetros enteros.</b>
     * <p>
     * Al pasar dos int, Java elige esta versión del método.
     * </p>
     * 
     * @param sumando1 Primer sumando
     * @param sumando2 Segundo sumando
     * @return suma entera
     */
    public int suma(int sumando1, int sumando2) {
        return sumando1 + sumando2;
    }

    /**
     * <b>Sobrecarga: Método con parámetros decimales.</b>
     * <p>
     * Al pasar tipos double (o float), Java invoca esta implementación.
     * </p>
     * 
     * @param sumando1 Primer sumando
     * @param sumando2 Segundo sumando
     * @return suma decimal (double)
     */
    public double suma(double sumando1, double sumando2) {
        return sumando1 + sumando2;
    }

    /**
     * Ejemplo de ambigüedad en sobrecarga.
     * 
     * @param valor Valor entero
     * @return Etiqueta para entero
     */
    public String devolverValor(int valor) {
        return "Entero: " + valor;
    }

    /**
     * Ejemplo de ambigüedad en sobrecarga.
     * 
     * @param valor Valor decimal
     * @return Etiqueta para decimal
     */
    public String devolverValor(double valor) {
        return "Decimal: " + valor;
    }
}
