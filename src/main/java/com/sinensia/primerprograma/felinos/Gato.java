package com.sinensia.primerprograma.felinos;

import com.sinensia.primerprograma.interfaces.Maullable;
import java.util.Objects;

/**
 * Clase Gato hereda de Felino e implementa Maullable. emiteSonido() llama a
 * maullar() implementa su propio getEspecie()
 * No pretendemos que se pueda heredar, por eso es final
 *
 * @see com.sinensia.primerprograma.felinos.Felino
 * @see com.sinensia.primerprograma.interfaces.Rugible
 * @see com.sinensia.primerprograma.interfaces.Maullable
 * @see com.sinensia.primerprograma.Tigre
 * @see com.sinensia.primerprograma.Jaguar
 * 
 * @version 1.0
 * @since 2023
 * @author Sinensia
 * 
 */
final class Gato extends Felino implements Maullable, Comparable<Gato> {
    private int vidas;
    private String nombre;
    private static final String NOMBRE_CIENTIFICO = "Felis silvestris catus";
    private int placaDeIdentificacion;

    public int getPlacaDeIdentificacion() {
        return this.placaDeIdentificacion;
    }

    /**
     * setter de placaDeIdentificacion para el gato.
     * es privado porque no queremos que se pueda cambiar
     * salvo desde el constructor
     *
     * @param placaDeIdentificacion (int)
     */
    private void setPlacaDeIdentificacion(int placaDeIdentificacion) {
        // Aquí podríamos hacer validaciones entre las
        // posibles placas de identificación disponibles
        this.placaDeIdentificacion = placaDeIdentificacion;
    }

    /**
     * getter de nombre_cientifico para el gato.
     *
     * @return nombre_cientifico (String)
     */
    public String getNombreCientifico() {
        return NOMBRE_CIENTIFICO;
    }

    /**
     * Constructor de Gato por defecto. Aumenta la cantidad de felinos.
     * y establece las vidas a 7
     * está sobrecargado
     */
    public Gato(int placaDeIdentificacion) {
        super(); // Llamo a super para contar el gato
        this.vidas = 7;
        this.setPlacaDeIdentificacion(placaDeIdentificacion);
    }

    /**
     * Constructor de Gato por defecto. Aumenta la cantidad de felinos.
     * y establece las vidas a 7
     * está sobrecargado
     *
     * @param nombre                (String)
     * @param placaDeIdentificacion (int)
     * 
     */
    public Gato(String nombre, int placaDeIdentificacion) {
        super();
        this.vidas = 7; // Todos los gatos tienen 7 vidas
        this.setNombre(nombre);
        this.setPlacaDeIdentificacion(placaDeIdentificacion);
    }

    /**
     * getter de nombre para el gato.
     * sólo los gatos tienen nombre
     *
     * @return nombre (String)
     */

    public String getNombre() {
        return this.nombre;
    }

    /**
     * setter de nombre para el gato.
     * sólo los gatos tienen nombre
     *
     * @param nombre (String)
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * getter de vidas para el gato.
     *
     * @return vidas (int)
     * @see com.sinensia.primerprograma.felinos.Felino
     * 
     */
    public int getVidas() {
        return this.vidas;
    }

    /**
     * getter de Especie para el gato.
     * todos los Felinos están obligados a tener especie
     * pero cada uno implementa su propio getEspecie()
     *
     * @return especie (String)
     */
    @Override
    public String getEspecie() {
        return "Gato";
    }

    /**
     * override de emitirSonido() llama a maullar()
     * todos los Felinos emiten sonido pero cada uno
     * lo hace de una forma diferente.
     */
    @Override
    protected void emitirSonido() {
        maullar();
    }

    /**
     * setter de vidas para el gato.
     * Si necesitásemos hacer validaciones lo hemos encapsulado
     *
     * @param vidas (int)
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     * override de maullar() para el gato.
     * todos los Felinos emiten sonido pero cada uno
     * a su manera. Los gatos maullan y por eso implementan
     * Maullable.
     *
     * @see com.sinensia.primerprograma.interfaces.Maullable
     * @see com.sinensia.primerprograma.felinos.Felino#emitirSonido()
     * 
     */
    @Override
    public void maullar() {
        System.out.println("El gato maulla");
    }

    /**
     * override de comer() para el gato.
     * todos los Felinos comen pero cada uno
     * a su manera. Los gatos comen ratones
     *
     * @see com.sinensia.primerprograma.felinos.Felino#comer()
     * 
     */
    @Override
    public void comer() {
        System.out.println("El gato come ratones");
    }

    /**
     * override de equals() para el gato.
     * Dos gatos son iguales si tienen la misma placa de identificación
     *
     * @see com.sinensia.primerprograma.felinos.AppFelinos
     * @return boolean
     * 
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Gato)) {
            return false;
        }
        Gato gato = (Gato) o;
        return Objects.equals(placaDeIdentificacion, gato.getPlacaDeIdentificacion());
    }

    /**
     * override de hashCode() para el gato.
     * Dos gatos son iguales si tienen la misma placa de identificación
     * 
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(placaDeIdentificacion);
    }

    /**
     * override de toString() para el gato.
     * Nos permite imprimir el gato como un String
     *
     * @return String
     */
    @Override
    public String toString() {
        return "{"
                + " vidas='"
                + getVidas()
                + "'"
                + ", nombre='"
                + getNombre() + "'"
                + ", placaDeIdentificacion='"
                + getPlacaDeIdentificacion()
                + "'"
                + "}";
    }

    /**
     * override de compareTo() para el gato.
     * Nos permite comparar dos gatos por su placa de identificación
     * y así ordenarlos
     *
     * @param o (Gato )
     * @return int
     */
    @Override
    public int compareTo(Gato o) {
        return this.getPlacaDeIdentificacion() - o.getPlacaDeIdentificacion();
    }
}
