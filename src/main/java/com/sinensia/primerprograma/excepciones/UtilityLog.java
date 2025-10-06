package com.sinensia.primerprograma.excepciones;

import java.util.logging.Logger;

public class UtilityLog {

    private static final Logger logger = Logger.getLogger(UtilityLog.class.getName());

    private UtilityLog() {
    }

    public static void logInfo(String msg) {
        logger.info(msg);
    }

    public static void logWarning(String msg) {
        logger.warning(msg);
    }

    public static void logSevere(String msg) {
        logger.severe(msg);
    }

    public static void logError(String msg) {
        logger.severe(msg);
    }

    public static void logSuccess(String msg) {
        logger.info("[SUCCESS] " + msg); // marcamos visualmente
    }
}
