package com.sinensia.primerprograma.basico.dates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * <b>Formateo y Parsing de Fechas</b>
 * <p>
 * Muestra el uso de {@link java.time.format.DateTimeFormatter} para convertir
 * objetos de fecha en texto legible y viceversa, soportando patrones
 * personalizados,
 * localizaciones (Locale) y zonas horarias.
 * </p>
 * 
 * @author Sinensia
 * @see ManejoDeFechas
 */
public class FormateoFechas {

        /**
         * Punto de entrada principal.
         *
         * @param args No se utiliza.
         */
        public static void main(String[] args) {

                // --- 1. Definición de Patrones ---
                // Símbolos comunes: dd (día), MM (mes), yyyy (año), HH (hora 24h), mm (min), ss
                // (seg)
                DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                System.out.println("--- Formateo (Objeto -> Texto) ---");
                LocalDateTime ahora = LocalDateTime.now();
                String fechaTexto = formateador.format(ahora);
                System.out.println("Fecha formateada (España): " + fechaTexto);

                // --- 2. Parsing (Texto -> Objeto) ---
                System.out.println("\n--- Parsing (Texto -> Objeto) ---");
                String entrada = "15/09/2023 14:30:00";
                LocalDateTime fechaParseada = LocalDateTime.parse(entrada, formateador);
                System.out.println("Objeto obtenido: " + fechaParseada);

                // --- 3. Uso de Locales (Internacionalización) ---
                // Útil para nombres de meses o días de la semana en diferentes idiomas
                DateTimeFormatter formateadorEs = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy")
                                .withLocale(Locale.forLanguageTag("es-ES"));
                System.out.println("\nFormato largo con Locale ES: " + formateadorEs.format(ahora));

                // --- 4. Formateo con Zonas Horarias ---
                ZoneId madrid = ZoneId.of("Europe/Madrid");
                DateTimeFormatter formateadorConZona = formateador.withZone(madrid);
                System.out.println("\nFecha con zona horaria: " + formateadorConZona.format(ahora));
        }
}
