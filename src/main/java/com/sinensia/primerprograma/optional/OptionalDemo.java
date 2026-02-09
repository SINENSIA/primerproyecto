package com.sinensia.primerprograma.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {

    void main() {

        UsuarioRepository repo = new UsuarioRepository();

        IO.println("=== BUSQUEDA TRADICIONAL ===");
        Usuario user1 = repo.buscarTradicional("111A");
        if (user1 != null) {
            IO.println("Encontrado: " + user1.getNombre());
        } else {
            IO.println("No encontrado");
        }

        IO.println("\n=== BUSQUEDA CON OPTIONAL ===");
        repo.buscar("222B")
                .ifPresent(usuario -> IO.println("Encontrado: " + usuario.getNombre()));

        IO.println("\n=== VALOR POR DEFECTO ===");
        Usuario user2 = repo.buscar("999X")
                .orElse(new Usuario("Desconocido", "0000"));
        IO.println(user2.getNombre());

        IO.println("\n=== TRANSFORMAR CON MAP ===");
        String nombre = repo.buscar("111A")
                .map(Usuario::getNombre)
                .orElse("Sin nombre");
        IO.println(nombre);

        IO.println("\n=== FILTRAR ===");
        repo.buscar("333C")
                .filter(u -> u.getEdad() >= 18)
                .ifPresent(u -> IO.println("Adulto: " + u.getNombre()));

        IO.println("\n=== OR ELSE GET ===");
        Usuario user3 = repo.buscar("999X")
                .orElseGet(() -> crearUsuarioPorDefecto());
        IO.println(user3.getNombre());

        IO.println("\n=== OR ELSE THROW ===");
        try {
            Usuario user4 = repo.buscar("999X")
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            IO.println(user4.getNombre());
        } catch (Exception e) {
            IO.println(e.getMessage());
        }
    }

    private static Usuario crearUsuarioPorDefecto() {
        IO.println("Creando usuario por defecto...");
        return new Usuario("Invitado", "0000");
    }
}

/*
 * ============================
 * REPOSITORIO SIMULADO
 * ============================
 */

class UsuarioRepository {

    private final Map<String, Usuario> usuarios = new HashMap<>();

    public UsuarioRepository() {
        usuarios.put("111A", new Usuario("Ana", "111A", 25));
        usuarios.put("222B", new Usuario("Luis", "222B", 17));
        usuarios.put("333C", new Usuario("Marta", "333C", 32));
    }

    // Forma clásica
    public Usuario buscarTradicional(String dni) {
        return usuarios.get(dni); // puede devolver null
    }

    // Forma moderna
    public Optional<Usuario> buscar(String dni) {
        return Optional.ofNullable(usuarios.get(dni));
    }
}

/*
 * ============================
 * MODELO DE DOMINIO
 * ============================
 */

class Usuario {

    private final String nombre;
    private final String dni;
    private final int edad;

    public Usuario(String nombre, String dni) {
        this(nombre, dni, 0);
    }

    public Usuario(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }
}
