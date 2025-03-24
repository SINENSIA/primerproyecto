package com.sinensia.primerprograma.ejercicios.interfaces_funcionales;

import java.util.ArrayList;
import java.util.List;

public class FiltroProductos {
    public static List<Producto> filtrarProductos(List<Producto> productos, FiltroProducto filtro) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (filtro.filtrar(p)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}