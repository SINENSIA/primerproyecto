package com.sinensia.primerprograma.excepciones;

public class MiRecursoWrapper implements AutoCloseable {

    private MiRecurso miRecurso;

    public MiRecursoWrapper(MiRecurso miRecurso) {
        this.setMiRecurso(miRecurso);
    }

    @Override
    public void close() {
        // Lógica para cerrar miRecurso
    }

    public MiRecurso getMiRecurso() {
      return miRecurso;
    }

    public void setMiRecurso(MiRecurso miRecurso) {
      this.miRecurso = miRecurso;
    }
}
