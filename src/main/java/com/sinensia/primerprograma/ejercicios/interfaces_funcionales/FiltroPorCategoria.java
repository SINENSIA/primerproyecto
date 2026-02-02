package com.sinensia.primerprograma.ejercicios.interfaces_funcionales;

public class FiltroPorCategoria implements FiltroProducto {
    @Override
    public boolean filtrar(Producto p) {
        return p.getCategoria().equals("Tecnología");
    }
}
