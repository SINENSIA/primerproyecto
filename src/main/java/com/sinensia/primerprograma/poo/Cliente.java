package com.sinensia.primerprograma.poo;

import java.util.Objects;

public class Cliente {
    private String nombre;
    private String email;
    private Boolean activo;

    public Cliente(String nombre, String email, Boolean activo) {
        this.nombre = nombre;
        this.email = email;
        this.activo = activo;
    }

    public Cliente(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Cliente() {
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isActivo() {
        return this.activo;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Cliente nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public Cliente email(String email) {
        setEmail(email);
        return this;
    }

    public Cliente activo(Boolean activo) {
        setActivo(activo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(email, cliente.email)
                && Objects.equals(activo, cliente.activo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, email, activo);
    }

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() + "'" +
                ", email='" + getEmail() + "'" +
                ", activo='" + isActivo() + "'" +
                "}";
    }

}
