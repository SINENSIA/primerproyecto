package com.sinensia.primerprograma.excepciones;

public class MyParticularException extends Exception {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;

    public MyParticularException(String message) {
        super(message);
    }

    public MyParticularException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyParticularException(Throwable cause) {
        super(cause);
    }
}
