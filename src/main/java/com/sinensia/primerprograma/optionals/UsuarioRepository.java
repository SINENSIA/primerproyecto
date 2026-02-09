package com.sinensia.primerprograma.optionals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsuarioRepository {
    // Base de datos simulada (usa ID técnico)
    private final Map<Long, UsuarioDTO> database = new HashMap<>();
    private Long siguienteId = 1L;

    // 💾 GUARDAR: Dominio → Persistencia
    public Usuario guardar(Usuario usuario) {
        // Buscar si ya existe por DNI
        Optional<UsuarioDTO> existente = buscarDtoPorDni(usuario.getDni());

        UsuarioDTO dto;
        if (existente.isPresent()) {
            // Actualizar existente
            dto = existente.get();
            dto = new UsuarioDTO(
                    dto.id(),
                    usuario.getNombre(),
                    usuario.getEmail(),
                    usuario.getDni());
        } else {
            // Crear nuevo (asignar ID técnico)
            dto = new UsuarioDTO(
                    siguienteId++,
                    usuario.getNombre(),
                    usuario.getEmail(),
                    usuario.getDni());
        }

        database.put(dto.id(), dto);
        System.out.println("✅ Usuario guardado - DNI: " + dto.dni() + " → ID: " + dto.id());
        return usuario;
    }

    // 🔍 BUSCAR POR DNI (identificador del dominio)
    public Optional<Usuario> buscarPorDni(String dni) {
        return database.values().stream()
                .filter(dto -> dto.dni().equals(dni))
                .findFirst()
                .map(this::dtoAUsuario);
    }

    // 🔍 BUSCAR POR ID (identificador técnico) - menos común en el dominio
    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.ofNullable(database.get(id))
                .map(this::dtoAUsuario);
    }

    // 🔍 BUSCAR POR EMAIL
    public Optional<Usuario> buscarPorEmail(String email) {
        return database.values().stream()
                .filter(dto -> dto.email().equals(email))
                .findFirst()
                .map(this::dtoAUsuario);
    }

    public List<Usuario> buscarTodos() {
        return database.values().stream()
                .map(this::dtoAUsuario)
                .toList();
    }

    // ✏️ ACTUALIZAR por DNI
    public Optional<Usuario> actualizar(String dni, Usuario datosNuevos) {
        return buscarDtoPorDni(dni).map(dtoViejo -> {
            UsuarioDTO dtoNuevo = new UsuarioDTO(
                    dtoViejo.id(), // Mantiene el mismo ID técnico
                    datosNuevos.getNombre(),
                    datosNuevos.getEmail(),
                    dni);
            database.put(dtoNuevo.id(), dtoNuevo);
            return datosNuevos;
        });
    }

    // 🗑️ ELIMINAR por DNI
    public boolean eliminarPorDni(String dni) {
        Optional<UsuarioDTO> dto = buscarDtoPorDni(dni);
        dto.ifPresent(d -> database.remove(d.id()));
        return dto.isPresent();
    }

    // 🔄 MÉTODOS PRIVADOS DE CONVERSIÓN
    private Optional<UsuarioDTO> buscarDtoPorDni(String dni) {
        return database.values().stream()
                .filter(dto -> dto.dni().equals(dni))
                .findFirst();
    }

    private Usuario dtoAUsuario(UsuarioDTO dto) {
        return new Usuario(dto.dni(), dto.nombre(), dto.email());
    }

    // Método auxiliar para debugging
    public void mostrarBaseDatos() {
        System.out.println("\n📊 ESTADO DE LA BASE DE DATOS:");
        database.values().forEach(
                dto -> System.out.println("  ID: " + dto.id() + " | DNI: " + dto.dni() + " | " + dto.nombre()));
    }
}