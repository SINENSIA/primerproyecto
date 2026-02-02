package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Interfaz Operacionable</b>
 * <p>
 * Define un contrato para realizar operaciones aritméticas básicas
 * sobre tipos {@code Object}. Esta interfaz es útil para practicar
 * el uso de {@code Polimorfismo} y {@code Casting}.
 * </p>
 * 
 * @author Sinensia
 */
public interface Operacionable {

    /**
     * Realiza la suma de dos objetos.
     * 
     * @param a Primer operando
     * @param b Segundo operando
     * @return Resultado de la suma como int
     */
    int realizarSuma(Object a, Object b);

    /**
     * Realiza la resta de dos objetos.
     * 
     * @param a Primer operando
     * @param b Segundo operando
     * @return Resultado de la resta como int
     */
    int realizarResta(Object a, Object b);

    /**
     * Realiza la multiplicación de dos objetos.
     * 
     * @param a Primer operando
     * @param b Segundo operando
     * @return Resultado de la multiplicación como int
     */
    int realizarMultiplicacion(Object a, Object b);

    /**
     * Realiza la división de dos objetos.
     * 
     * @param a Primer operando
     * @param b Segundo operando
     * @return Resultado de la división como int
     * @throws ArithmeticException Si el divisor es cero
     */
    int realizarDivision(Object a, Object b);
}
