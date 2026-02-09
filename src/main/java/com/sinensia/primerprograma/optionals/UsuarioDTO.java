package com.sinensia.primerprograma.optionals;

public record  UsuarioDTO(
        Long id, // ← ID técnico de la base de datos
        String nombre,
        String email,
        String dni // ← También guardamos el DNI
) {
    // Automáticamente genera: constructor, getters, equals, hashCode, toString
}