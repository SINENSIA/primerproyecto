package com.sinensia.primerprograma.io.serializacion;

import java.io.Serializable;

public class Mensaje<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T contenido;
    private String emisor;
    private transient String tokenAutenticacion; // No se serializa

    public Mensaje(T contenido, String emisor, String tokenAutenticacion) {
        this.contenido = contenido;
        this.emisor = emisor;
        this.tokenAutenticacion = tokenAutenticacion;
    }

    public T getContenido() {
        return contenido;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getTokenAutenticacion() {
        return tokenAutenticacion;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "contenido=" + contenido +
                ", emisor='" + emisor + '\'' +
                ", tokenAutenticacion='" + tokenAutenticacion + '\'' +
                '}';
    }
}
