package com.sinensia.primerprograma.ejercicios.abril;

import java.math.BigDecimal;

public class CuentaPremium extends CuentaBancaria {

    private final BigDecimal limiteDescubierto;

    public CuentaPremium(String titular, String numeroCuenta, BigDecimal limiteDescubierto) {
        super(titular, numeroCuenta);
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    public void retirar(BigDecimal cantidad) {
        if (cantidad.compareTo(getSaldo().add(limiteDescubierto)) > 0) {
            System.out.println("Límite de descubierto superado.");
        } else {
            setSaldo(getSaldo().subtract(cantidad));
        }
    }

    public String getEstado() {
        return getSaldo().compareTo(BigDecimal.ZERO) < 0 ? "en descubierto" : "al corriente";
    }
}
