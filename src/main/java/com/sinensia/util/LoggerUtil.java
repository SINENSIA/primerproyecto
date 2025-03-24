package com.sinensia.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;

public class LoggerUtil {

    private static final String LOG_FILE = "app.log";
    private static final Level GLOBAL_LEVEL = Level.ALL;

    private LoggerUtil() {
        // Evitamos instanciación
    }
    /**
     * 
     * @param clazz
     * @return
     */
    public static Logger getLogger(Class<?> clazz) {
        Logger logger = Logger.getLogger(clazz.getName());
        logger.setUseParentHandlers(false); // Evitamos logs duplicados

        // Evitar añadir múltiples handlers si ya está configurado
        if (logger.getHandlers().length == 0) {
            try {
                // Handler de consola
                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler.setLevel(GLOBAL_LEVEL);
                consoleHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(consoleHandler);

                // Handler de archivo
                FileHandler fileHandler = new FileHandler(LOG_FILE, true); // true = append
                fileHandler.setLevel(GLOBAL_LEVEL);
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);

                logger.setLevel(GLOBAL_LEVEL);

            } catch (IOException e) {
                System.err.println("No se pudo inicializar el logger: " + e.getMessage());
            }
        }

        return logger;
    }
}
