package com.sinensia.primerprograma.serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorMensajes<T> {
    private List<Mensaje<T>> mensajes = new ArrayList<>();

    public void agregarMensaje(Mensaje<T> mensaje) {
        mensajes.add(mensaje);
    }

    public void guardarMensajes(String archivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(mensajes);
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarMensajes(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            mensajes = (List<Mensaje<T>>) in.readObject();
        }
    }

    public void mostrarMensajes() {
        for (Mensaje<T> m : mensajes) {
            System.out.println(m);
        }
    }
}
