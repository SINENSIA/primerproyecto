package com.sinensia.primerprograma.noviembre;

public class App {

    public static void main(String[] args) {

        Gafas gafas = new Gafas("Cerca", "Redondas", 1.5f);
        gafas.ponerGafas();
        gafas.setColor("Morado");
        gafas.quitarGafas();

        Contador miContador1 = new Contador();
        Contador miContador2 = new Contador();

        miContador1.contadorLocal = 20;
        miContador2.contadorLocal = 30;
        System.out.println(Contador.totalContadores);
        System.out.println(AmbitoVariable.variableGlobal);
    }

}
