package com.sinensia.primerprograma.basico.tipos;

/**
 * <b>Concepto: Operaciones con Tipos No Primitivos (Objetos)</b>
 * <p>
 * Esta clase actúa como un wrapper para demostrar cómo delegar operaciones
 * lógicas a implementaciones específicas, trabajando con el tipo base
 * {@code Object}.
 * </p>
 * 
 * @author Sinensia
 */
public class NoPrimitivos {

    private Object valorA;
    private Object valorB;

    /**
     * Construye una instancia con dos operandos de tipo Object.
     * 
     * @param valorA Primer operando (puede ser String, Integer, etc.)
     * @param valorB Segundo operando
     */
    public NoPrimitivos(Object valorA, Object valorB) {
        this.valorA = valorA;
        this.valorB = valorB;
    }

    /**
     * Delega la suma a la implementación de Operacionable.
     * 
     * @return El resultado entero de la suma.
     */
    public int realizarSuma() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarSuma(valorA, valorB);
    }

    /**
     * Delega la resta.
     * 
     * @return El resultado entero de la resta.
     */
    public int realizarResta() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarResta(valorA, valorB);
    }

    /**
     * Delega la multiplicación.
     * 
     * @return El resultado entero de la multiplicación.
     */
    public int realizarMultiplicacion() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarMultiplicacion(valorA, valorB);
    }

    /**
     * Delega la división, manejando casos de error internamente.
     * 
     * @return El resultado entero de la división.
     */
    public int realizarDivision() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarDivision(valorA, valorB);
    }

    /**
     * Demostración de uso con Strings que contienen números.
     *
     * @param args No se utiliza.
     */
    public static void main(String[] args) {
        // Ejemplo pasando Strings: la lógica interna deberá convertirlos a números.
        NoPrimitivos noPrimitivos = new NoPrimitivos("10", "2");
        System.out.println("División de '10' / '2' = " + noPrimitivos.realizarDivision());
    }
}
