package com.sinensia.primerprograma.patrones.mvc;

// MODELO
class PersonaModel {
    private String nombre;
    private int anioNacimiento;

    public PersonaModel(String nombre, int anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public int calcularEdad(int anioActual) {
        return anioActual - anioNacimiento;
    }
}

// VISTA
class PersonaView {
    public void mostrarDatos(String nombre, int edad) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad actual: " + edad + " años");
    }
}

// CONTROLADOR
class PersonaController {
    private PersonaModel modelo;
    private PersonaView vista;

    public PersonaController(PersonaModel modelo, PersonaView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void actualizarVista(int anioActual) {
        int edad = modelo.calcularEdad(anioActual);
        vista.mostrarDatos(modelo.getNombre(), edad);
    }
}

// PROGRAMA PRINCIPAL
public class MVCEjemplo {
    public static void main(String[] args) {
        // Crear el modelo (datos)
        PersonaModel modelo = new PersonaModel("Juan", 1990);

        // Crear la vista (interfaz de usuario)
        PersonaView vista = new PersonaView();

        // Crear el controlador (intermediario)
        PersonaController controlador = new PersonaController(modelo, vista);

        // Actualizar la vista con el año actual
        controlador.actualizarVista(2024);
    }
}
