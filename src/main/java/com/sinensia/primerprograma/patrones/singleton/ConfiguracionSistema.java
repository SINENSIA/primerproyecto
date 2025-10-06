package com.sinensia.primerprograma.patrones.singleton;

public class ConfiguracionSistema {
    private static ConfiguracionSistema instancia;
    private String entorno;
    private boolean modoDebug;

    // Constructor privado
    private ConfiguracionSistema() {
        this.entorno = "producción";
        this.modoDebug = false;
    }

    // Método de acceso estático
    public static ConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    // Métodos para modificar la configuración
    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }

    public void setModoDebug(boolean modoDebug) {
        this.modoDebug = modoDebug;
    }

    public String getEntorno() {
        return entorno;
    }

    public boolean esModoDebug() {
        return modoDebug;
    }
}
