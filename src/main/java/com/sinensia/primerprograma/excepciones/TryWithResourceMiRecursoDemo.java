package com.sinensia.primerprograma.excepciones;

public class TryWithResourceMiRecursoDemo {
    public static void main(String[] args) {
        try (MiRecursoWrapper miRecursoWrapper = new MiRecursoWrapper(new MiRecurso())) {
            // Lógica para usar miRecurso
        } catch (Exception e) {
            // Lógica para tratar la excepción
        }
    }
}
