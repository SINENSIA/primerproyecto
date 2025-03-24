package com.sinensia.primerprograma.excepciones;

/**
 * Autocloseable es lo que permite usarlo en un try-catch-with-resource.
 *
 */

public class MiRecursoWrapper implements AutoCloseable {

  private MiRecurso miRecurso;

  public MiRecursoWrapper(MiRecurso miRecurso) {
    this.miRecurso = miRecurso;
    System.out.println("Recurso inicializado en el wrapper.");
  }

  

  public MiRecurso getMiRecurso() {
    return miRecurso;
  }

  public void setMiRecurso(MiRecurso miRecurso) {
    this.miRecurso = miRecurso;
  }

  @Override
  public void close() {
    if (miRecurso != null) {
      System.out.println("Cerrando el recurso desde el wrapper...");
      miRecurso.cerrar(); // Suponiendo que MiRecurso tiene un método cerrar()
      miRecurso = null; // Liberar la referencia para evitar reutilización accidental
    }
  }
}
