package com.sinensia.primerprograma.optionals;

public class Usuario {
    private String dni; // ← Identificador del mundo real
    private String nombre;
    private String email;
    private boolean activo;

    // Constructor del dominio (SIN id)
    public Usuario(String dni, String nombre, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.activo = true;
    }

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{dni='" + dni + "', nombre='" + nombre +
                "', email='" + email + "', activo=" + activo + "}";
    }
}