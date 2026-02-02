package com.sinensia.primerprograma.basico.dates;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * <b>ZonedDateTime: Fechas en contexto mundial</b>
 * <p>
 * Esta clase expande {@code LocalDateTime} añadiendo el contexto de una zona
 * horaria
 * ({@link java.time.ZoneId}). Es vital para aplicaciones internacionales que
 * gestionan
 * desfases horarios (Offsets) y cambios de hora (verano/invierno).
 * </p>
 * 
 * @author Sinensia
 * @see ManejoDeFechas
 */
public class ZonedDatetimeDemo {

        /**
         * Punto de entrada principal.
         * 
         * @param args No se utiliza.
         */
        public static void main(String[] args) {

                // 1. Crear fecha con zona horaria actual
                ZoneId madrid = ZoneId.of("Europe/Madrid");
                ZonedDateTime ahoraMadrid = ZonedDateTime.now(madrid);
                System.out.println("Madrid (Actual): " + ahoraMadrid);

                // 2. Convertir a otra zona horaria manteniendo el MISMO INSTANTE absoluto
                // (Si se está celebrando una reunión, ¿qué hora es en New York?)
                ZoneId newYork = ZoneId.of("America/New_York");
                ZonedDateTime ahoraNY = ahoraMadrid.withZoneSameInstant(newYork);
                System.out.println("NY (Mismo instante): " + ahoraNY);

                // 3. Convertir manteniendo la misma HORA LOCAL
                // (Si me voy a NY pero quiero que sigan siendo las 14:00)
                ZonedDateTime mismoLocalNY = ahoraMadrid.withZoneSameLocal(newYork);
                System.out.println("NY (Misma hora local): " + mismoLocalNY);

                // 4. Otras zonas famosas
                ZonedDateTime tokyo = ahoraMadrid.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
                System.out.println("\nTokio (Mismo instante):  " + tokyo);

                // 5. Operaciones temporales
                ZonedDateTime enDosSemanas = tokyo.plusWeeks(2);
                System.out.println("Tokio en dos semanas:   " + enDosSemanas);
        }
}
