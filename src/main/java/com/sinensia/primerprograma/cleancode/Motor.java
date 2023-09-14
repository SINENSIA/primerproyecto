package com.sinensia.primerprograma.cleancode;

import java.util.logging.Logger;

class Motor {
    private static final Logger logger = Logger.getLogger(Motor.class.getName());

    public void encender() {
        logger.info("Motor encendido");
        
    }

    public void apagar() {
        logger.info("Motor apagado.");
        
    }
}
