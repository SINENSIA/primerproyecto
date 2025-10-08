package com.sinensia.primerprograma.felinos;

/**
 * Clase Propietario representa al dueño de un gato.
 *
 * @version 1.1
 * @since 2023
 */
public class Propietario {
    private final String nombre;
    private String direccion;

    /**
     * Constructor para la clase Propietario.
     *
     * @param nombre    Nombre del propietario.
     * @param direccion Dirección del propietario.
     */
    public Propietario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre del propietario.
     *
     * @return Nombre del propietario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la dirección del propietario.
     *
     * @return Dirección del propietario.
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format("Propietario[nombre='%s', direccion='%s']", nombre, direccion);
    }

}