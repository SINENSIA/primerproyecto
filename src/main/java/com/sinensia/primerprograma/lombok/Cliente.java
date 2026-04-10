package com.sinensia.primerprograma.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true, chain = true)
public class Cliente {

    private String nombre;
    private String email;
    private Boolean activo;

    // Este constructor parcial Lombok no puede generarlo — se queda manual
    public Cliente(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }
}
