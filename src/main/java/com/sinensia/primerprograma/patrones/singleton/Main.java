package com.sinensia.primerprograma.patrones.singleton;

public class Main {
    public static void main(String[] args) {
        ConfiguracionSistema config = ConfiguracionSistema.getInstancia();
        config.setEntorno("desarrollo");
        config.setModoDebug(true);

        // En otra parte del código...
        ConfiguracionSistema otraReferencia = ConfiguracionSistema.getInstancia();
        System.out.println("Entorno: " + otraReferencia.getEntorno());
        System.out.println("Modo debug: " + otraReferencia.esModoDebug());
    }
}
