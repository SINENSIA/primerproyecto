package com.sinensia.primerprograma.ejercicios.abril;

import java.math.BigDecimal;

public class AppCuentaBancaria {
    void main() {
        CuentaBancaria cuenta1 = new CuentaBancaria("Ana García", "ES001");
        cuenta1.ingresar(new BigDecimal("500.00"));
        cuenta1.retirar(new BigDecimal("200.00"));
        IO.println(cuenta1.getSaldo()); // 300.00

        CuentaPremium vip = new CuentaPremium("Elena Ruiz", "ES003", new BigDecimal("500.00"));
        vip.ingresar(new BigDecimal("100.00"));
        vip.retirar(new BigDecimal("400.00"));
        IO.println(vip.getEstado()); // en descubierto
    }
}
