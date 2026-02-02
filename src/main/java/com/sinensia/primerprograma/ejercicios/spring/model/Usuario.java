package com.sinensia.primerprograma.ejercicios.spring.model;

import com.sinensia.primerprograma.ejercicios.spring.validation.PasswordsMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@PasswordsMatch
public class Usuario {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Introduce un email válido")
    private String email;

    @NotNull(message = "La edad es obligatoria")
    @Min(value = 18, message = "Debes ser mayor de edad")
    private Integer edad;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @NotBlank(message = "Confirma la contraseña")
    private String passwordConfirm;

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String toString() {
        return "Usuario{" +
            "nombre='" + nombre + '\'' +
            ", email='" + email + '\'' +
            ", edad=" + edad +
            '}';
    }
}
