package com.sinensia.primerprograma.tipos;

public class NoPrimitivos {
    private Object valorA;
    private Object valorB;

    public NoPrimitivos(Object valorA, Object valorB) {
        this.valorA = valorA;
        this.valorB = valorB;

    }

    public int realizarSuma() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarSuma(valorA, valorB);
    }

    public int realizarResta() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarResta(valorA, valorB);
    }

    public int realizarMultiplicacion() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarMultiplicacion(valorA, valorB);
    }

    public int realizarDivision() {
        OperacionableImpl operacionable = new OperacionableImpl();
        return operacionable.realizarDivision(valorA, valorB);
    }

    public static void main(String[] args) {
        NoPrimitivos noPrimitivos = new NoPrimitivos("10", "0");
        System.out.println(noPrimitivos.realizarDivision());
    }

}
