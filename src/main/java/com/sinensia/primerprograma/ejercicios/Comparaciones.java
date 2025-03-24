package com.sinensia.primerprograma.ejercicios;

public class Comparaciones {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 10;
        System.out.println(num1 == num2);
        System.out.println(System.identityHashCode(num1) + " vs " + System.identityHashCode(num2));
        String miNombre = "Carlos";
        String tuNombre = "Carlos";

        System.out.println(System.identityHashCode(miNombre) + " vs " + System.identityHashCode(tuNombre));
        
        System.out.println(miNombre == tuNombre);
        System.out.println(miNombre.equals(tuNombre));

        Factura miFactura = new Factura(1224, 10);
        System.out.println(miFactura);
        Factura tuFactura = new Factura(1224, 10);
        System.out.println(tuFactura);

        System.out.println(miFactura == tuFactura);
        System.out.println(miFactura.equals(tuFactura));
    }

    private static class Factura {
        private int total;
        private int id;

        public Factura(int id, int total) {
            this.id = id;
            this.total = total;
        }

        @Override
        public String toString() {
            return "Factura{id=" + id + ", total=" + total + "}";
        }
    }
}
