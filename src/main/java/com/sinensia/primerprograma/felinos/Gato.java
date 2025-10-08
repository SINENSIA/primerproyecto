package com.sinensia.primerprograma.felinos;

import com.sinensia.primerprograma.interfaces.Maullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Clase Gato hereda de Felino e implementa Maullable.
 * Representa a un gato con características específicas.
 *
 * @version 1.1
 * @since 2024
 * @see com.sinensia.primerprograma.felinos.Felino
 * @see com.sinensia.primerprograma.interfaces.Maullable
 *
 */
public final class Gato extends Felino implements Maullable, Comparable<Gato> {
    private static final int VIDAS_INICIALES = 7;

    // La vidas por defecto son 7 y se reducen cuando se llama al método
    // perderVida().
    private int vidas = VIDAS_INICIALES;

    private String nombre;

    private Propietario propietario; // Composición, cada Gato tiene un propietario
    // Historial de propietarios
    private final List<Propietario> historialPropietarios = new ArrayList<>();
    // NOMBRE_CIENTIFICO Es una constante independiente de la instancia
    // siempre podemos conocer el NOMBRE_CIENTIFICO de un Gato
    // sin necesidad de crear un nuevo Gato
    private static final String NOMBRE_CIENTIFICO = "Felis silvestris catus";
    private final int placaDeIdentificacion; // La placa de identificación no se puede modificar

    private static final Logger logger = Logger.getLogger(Gato.class.getName());

    /**
     * Constructor para un gato sin nombre aún ni propietario.
     * La clínica le poner un chip pero hasta que no sea adoptado
     * no tendrá nombre ni propietario.
     *
     * @param placaDeIdentificacion Identificación del gato.
     */
    public Gato(int placaDeIdentificacion) {
        // Inicializa las características comunes de un Felino
        super(); // como el contador de instancias
        this.placaDeIdentificacion = placaDeIdentificacion;
    }

    /**
     * Constructor para un Gato con nombre, identificación pero sin propietario.
     *
     * @param nombre                Nombre del gato.
     * @param placaDeIdentificacion Identificación del gato.
     */

    public Gato(String nombre, int placaDeIdentificacion) {
        // llamamos al constructor de Felino para inicializar las características
        // comunes como el contador de instancias. No es necesario, pero lo hacemos
        // explícito para indicar que la superclase realiza tareas comunes
        super();

        this.nombre = nombre;
        this.placaDeIdentificacion = placaDeIdentificacion;

    }

    /**
     * Constructor para un Gato con nombre, identificación y propietario.
     *
     * @param nombre                Nombre del gato.
     * @param placaDeIdentificacion Identificación del gato.
     * @param propietario           Propietario del gato.
     */

    public Gato(String nombre, int placaDeIdentificacion, Propietario propietario) {
        // llamamos al constructor de Felino para inicializar las características
        // comunes como el contador de instancias. No es necesario, pero lo hacemos
        // explícito para indicar que la superclase realiza tareas comunes
        super();
        this.placaDeIdentificacion = validarPlaca(placaDeIdentificacion);
        this.nombre = nombre;
        this.propietario = propietario;

        agregarPropietarioAlHistorial(propietario);

    }

    /**
     * Obtiene el nombre científico del gato.
     *
     * @return Nombre científico (String).
     */
    @Override
    protected String getNombreCientifico() {
        return NOMBRE_CIENTIFICO;
    }

    /**
     * Obtiene la especie del gato.
     *
     * @return Nombre de la especie (String).
     */
    @Override
    public String getEspecie() {
        return "Gato";
    }

    /**
     * El gato emite un sonido (maúlla).
     * El gato implementa obligatoriamente (abstracto) el método emitirSonido de
     * Felino
     * pero llama maullar() (iimplementación de interfaz Maullable).
     *
     * @see com.sinensia.primerprograma.interfaces.Maullable#maullar()
     * @see com.sinensia.primerprograma.felinos.Felino#emitirSonido()
     */
    @Override
    protected synchronized void emitirSonido() {
        maullar();
    }

    /**
     * Implementación de maullar para la interfaz Maullable.
     *
     * @see com.sinensia.primerprograma.interfaces.Maullable#maullar()
     * 
     */
    @Override
    public void maullar() {
        logger.info("El gato maúlla: ¡Miau!");
    }

    /**
     * El gato come ratones. Cada felino come cosas diferentes, pero todos comen.
     * Si olvidamos implementar estemétodo, se usa la implementación por defecto
     * de comer() de Felino.
     *
     * @see com.sinensia.primerprograma.felinos.Felino#comer()
     */
    @Override
    public synchronized void comer() {
        logger.info("El gato come ratones.");
    }

    /**
     * Reduce las vidas del gato. No permite valores negativos (validación)
     */
    public synchronized void perderVida() {
        if (vidas > 0) {
            vidas--;
            logger.info("El gato ha perdido una vida. Vidas restantes: " + vidas);
        } else {
            logger.warning("El gato ya no tiene vidas restantes.");
        }
    }

    /**
     * Obtiene el número de vidas restantes.
     *
     * @return Número de vidas (int).
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Obtiene el propietario del gato.
     *
     * @return Propietario (Propietario).
     * @see com.sinensia.primerprograma.felinos.Propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Establece el propietario del gato.
     *
     * @param propietario Nuevo propietario (Propietario).
     * @see com.sinensia.primerprograma.felinos.Propietario
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
        agregarPropietarioAlHistorial(propietario);
    }

    /**
     * Método privado para añadir un propietario al historial si no es nulo.
     *
     * @param propietario Propietario que se intenta añadir al historial.
     */

    private void agregarPropietarioAlHistorial(Propietario propietario) {

        try {
            historialPropietarios.add(propietario); // Puede lanzar NullPointerException
        } catch (NullPointerException e) {
            logger.warning("No se pudo añadir un propietario al historial porque es nulo.");
        } catch (Exception e) {
            // Bugs
            logger.warning(String.format("Ha ocurrido una excepción inesperada. %s",
                    e.getMessage()));
        }
    }

    public List<Propietario> getHistorialPropietarios() {
        return Collections.unmodifiableList(historialPropietarios); // Devuelve una lista inmutable
    }

    /**
     * Representación en cadena del Gato.
     *
     * @return Descripción del gato (String).
     */
    @Override
    public String toString() {
        return String.format("{nombre='%s', vidas=%d, propietario=%s, placa=%d}",
                nombre, vidas, propietario, placaDeIdentificacion);
    }

    /**
     * Compara este gato con otro gato por su placa de identificación.
     *
     * @param otroGato Otro gato.
     * @return Resultado de la comparación (int).
     */
    @Override
    public int compareTo(Gato otroGato) {
        return Integer.compare(this.placaDeIdentificacion, otroGato.placaDeIdentificacion);
    }

    // gato1.equals(gato2);

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Gato gato = (Gato) obj;

        return Objects.equals(placaDeIdentificacion, gato.placaDeIdentificacion);
    }

    /**
     * Obtiene el nombre del gato.
     *
     * @return Nombre del gato (String).
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del gato.
     *
     * @param nombre Nombre del gato (String).
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private int validarPlaca(int placa) {
        if (placa <= 0) {
            throw new IllegalArgumentException("La placa debe ser un número positivo.");
        }
        return placa;
    }

}